package com.nobsratings.nobs;

/**
 * Created by Dan on 20/04/2016.
 */
public class BusinessItem {

    public int businessId;
    public String businessName;

    //Environmental
    public String r1;
    //Local Community Engagement
    public String r2;
    //Fair trade
    public String r3;
    //Labour conditions
    public String r4;
    //Pro Consumer Behaviour
    public String r5;
    //Final Rating
    public String rf;

    //constructor
    public BusinessItem(int businessId, String businessName, String r1, String r2, String r3, String r4, String r5, String rf) {
        this.businessId = businessId;
        this.businessName = businessName;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.r5 = r5;
        this.rf = rf;
    }
}
