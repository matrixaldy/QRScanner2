package com.uas.test.qrscanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultActivity extends AppCompatActivity {
    TextView textViewResult, textViewFrom, textViewTo;
    TextView textViewClaim, textViewMaskapai, textViewClaimTime;
    TextView textViewFlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Intent i = getIntent();
        String UniqueID = i.getStringExtra(MainActivity.CODE);

        int result = Integer.parseInt(UniqueID);

        //textViewResult = (TextView) findViewById(R.id.text_view_result);
        textViewFlight = (TextView) findViewById(R.id.text_view_flight);
        textViewFrom = (TextView) findViewById(R.id.text_view_from);
        textViewTo = (TextView) findViewById(R.id.text_view_to);
        textViewClaim = (TextView) findViewById(R.id.text_view_claim_number);
        textViewMaskapai = (TextView) findViewById(R.id.text_view_maskapai);
        textViewClaimTime = (TextView) findViewById(R.id.text_view_first_claim);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://uastest.000webhostapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Fri> friCall = jsonPlaceHolderApi.showFri(result);

        friCall.enqueue(new Callback<Fri>() {
            @Override
            public void onResponse(Call<Fri> call, Response<Fri> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText(("code: " + response.code()));
                    return;
                }

                Fri fri = response.body();
                String content = "";
                /*
                content += fri.getMaskapai() + "\n\n";
                content += "Flight \n" + fri.getAirlineCode() + fri.getFlightNum() + "\n\n";
                content += "Gate \n" + fri.getDepartGate() + "\n\n";
                content += "Boarding Time \n" + fri.getStaTime() + "\n\n";
                content += "FROM \n" + fri.getBerangkat() + "\n\n";
                content += "TO \n" + fri.getDatang() + "\n\n";
                */

                textViewTo.setText(fri.getDatang() + " - " + fri.getArrivalStation());
                textViewFrom.setText(fri.getBerangkat() + " - " + fri.getDepartStation());
                textViewClaim.setText(fri.getActualClaim().replaceAll("[^0-9]", ""));
                textViewFlight.setText(fri.getAirlineCode() + fri.getFlightNum());
                textViewMaskapai.setText(fri.getMaskapai());
                textViewClaimTime.setText(fri.getReclaim());
                //textViewResult.append(content);

            }

            @Override
            public void onFailure(Call<Fri> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
