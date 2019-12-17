package com.uas.test.qrscanner;


import com.google.gson.annotations.SerializedName;


public class Fri {
    @SerializedName("UniqueID")
    private int UniqueId;

    @SerializedName("AIRLINE_CODE")
    private String AirlineCode;

    @SerializedName("FLIGHT_NUM")
    private String FlightNum;

    @SerializedName("STA_TIME_STAMP")
    private String StaTime;

    @SerializedName("DGATE")
    private String DepartGate;

    @SerializedName("UPLINE_CITY1")
    private String DepartStation;

//    @SerializedName("STD_TIME_STAMP")
//    private Timestamp StdTime;

    @SerializedName("AGATE")
    private String ArrivalGate;

    @SerializedName("DNLINE_CITY1")
    private  String ArrivalStation;

    @SerializedName("TERMINAL")
    private String  Terminal;

    @SerializedName("INT_OR_DOM")
    private String  FlightType;

    @SerializedName("maskapai")
    private String Maskapai;

    @SerializedName("keberangkatan")
    private String Berangkat;

    @SerializedName("kedatangan")
    private String Datang;

    @SerializedName("ACTUAL_CLAIM")
    private String Claim;

    @SerializedName("RECLAIM_FIRST_BAG_TIME")
    private String ReclaimBag;

    public int getUniqueId() {
        return UniqueId;
    }

    public String getAirlineCode() {
        return AirlineCode;
    }

    public String getFlightNum() {
        return FlightNum;
    }


    public String getDepartGate() {
        return DepartGate;
    }

    public String getStaTime() {
        return StaTime;
    }

    public String getDepartStation() {
        return DepartStation;
    }

    public String getArrivalGate() {
        return ArrivalGate;
    }

    public String getArrivalStation() {
        return ArrivalStation;
    }

    public String getTerminal() {
        return Terminal;
    }

    public String getMaskapai() {
        return Maskapai;
    }

    public String getDatang() {
        return Datang;
    }

    public String getBerangkat() {
        return Berangkat;
    }

    public String getActualClaim() {
        return Claim;
    }

    public String getReclaim() {
        return ReclaimBag;
    }
}
