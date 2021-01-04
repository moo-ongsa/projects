package com.example.vaspra555.List;

public class HistoProject {
    private String HSdonate;
    private String HStype;
    private String HSdate;
    private String HSsequence;

    public HistoProject(){}

    public HistoProject(String HSsequence,String HSdonate, String HStype, String HSdate) {
        this.HSsequence = HSsequence;
        this.HSdonate = HSdonate;
        this.HStype = HStype;
        this.HSdate = HSdate;
    }

    public String getHSsequence() {
        return HSsequence;
    }

    public String getHSDonate() {
        return HSdonate;
    }

    public String getHSType() {
        return HStype;
    }

    public String getHSDate() {
        return HSdate;
    }

    public void setHSsequence(String HSsequence) {
        this.HSdonate = HSsequence;
    }

    public void setHSDonate(String HSdonate) {
        this.HSdonate = HSdonate;
    }

    public void setHSType(String HStype) {
        this.HStype = HStype;
    }

    public void setHSDate(String HSdate) {
        this.HSdate = HSdate;
    }

}

