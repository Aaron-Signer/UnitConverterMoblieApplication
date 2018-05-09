package com.bignerdranch.android.homework4converter;

/**
 * Created by Owner on 3/16/2018.
 */

public class ValueWithUnit {

    public double val, fromVal, toVal, centralVal, result;
    public String from, to;


    public ValueWithUnit(String f, double d)
    {
        val = d;
        from = f;
        fromVal = UnitRepository.getInstance().getUnit(from).convFact;
    }

    public double to(String t) //throws IncompatibleUnitsException
    {
//        if(!UnitRepository.getInstance().getUnit(from).type.equals(UnitRepository.getInstance().getUnit(to).type))
//            throw new IncompatibleUnitsException("Incompatible units");

        to = t;
        toVal = UnitRepository.getInstance().getUnit(to).convFact;
        centralVal = val*fromVal;
        result = centralVal*(1/toVal);
        return result;
    }


}
