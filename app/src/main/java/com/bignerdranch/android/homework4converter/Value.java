package com.bignerdranch.android.homework4converter;

/**
 * Created by Owner on 4/1/2018.
 */

public class Value {

    private double val;

    public Value(double v)
    {
        val = v;
    }

    public ValueWithUnit from(String from)
    {
        return new ValueWithUnit(from, val);
    }

}
