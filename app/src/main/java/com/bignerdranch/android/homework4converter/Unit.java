package com.bignerdranch.android.homework4converter;

/**
 * Created by Owner on 4/1/2018.
 */

public class Unit {

    public String name, abrv, type;
    public boolean isMetric;
    public double convFact;

    public Unit(String a, String n, String t, double c, boolean isM)
    {
        name = n;
        abrv = a;
        type = t;
        convFact = c;
        isMetric = isM;
    }

}
