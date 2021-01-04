package com.example.vaspra555.app;

import java.io.Serializable;

public class DataHolder implements Serializable {

    private String User_ID,Donation_ID,amount,DonationType,TempleID;

    public DataHolder() {
        this.User_ID = User_ID;
        this.Donation_ID = Donation_ID;
        this.amount = amount;
        this.DonationType = DonationType;
        this.TempleID = TempleID;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String User_ID) {
        this.User_ID = User_ID;
    }

    public String getDonation_ID() {
        return Donation_ID;
    }

    public void setDonation_ID(String Donation_ID) {
        this.Donation_ID = Donation_ID;
    }
    public String getamount() {
        return amount;
    }

    public void setamount(String amount) {
        this.amount = amount;
    }

    public String getDonationType() {
        return DonationType;
    }

    public void setDonationType(String DonationType) {
        this.DonationType = DonationType;
    }
    public String getTempleID() {
        return TempleID;
    }

    public void setTempleID(String Construction_Running_ID) {
        this.TempleID = TempleID;
    }
}