package com.example.vaspra555.List;

public class Item {

    private String donationItem;
    private String donationAmount;
    private String donationTotal;

    public Item(){}

    public Item(String donationItem,String donationAmount, String donationTotal) {
        this.donationItem = donationItem;
        this.donationAmount = donationAmount;
        this.donationTotal = donationTotal;
    }

    public String getDonationItem() { return donationItem; }

    public String getDonationAmount() { return donationAmount; }

    public String getDonationTotal() {
        return donationTotal;
    }


    public void setDonationItem(String donationItem) {
        this.donationItem = donationItem;
    }

    public void setDonationAmount(String donationAmount) {
        this.donationAmount = donationAmount;
    }

    public void setDonationTotal(String donationTotal) {
        this.donationTotal = donationTotal;
    }

}
