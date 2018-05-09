package com.bignerdranch.android.homework4converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Owner on 4/1/2018.
 */

public class UnitRepository {

    private static HashMap<String, Unit> dims;
    private static UnitRepository instance;
    private static final String l = "LENGTH",
                                t = "TIME",
                                e = "ENERGY",
                                p = "POWER",
                                m = "MASS",
                                f = "FORCE",
                                v = "VOLUME",
                                a = "AREA";
    private String prefixeNames [] = {"p","n","u","m","c","d","da","h","k","M","G"};
    private double prefixValues [] = {0.000000000001,0.000000001 , 0.000001, 0.001, .01, 0.1, 10, 100, 1000, 1000000, 1000000000};

    private UnitRepository() {
        dims = new HashMap<>();
        dims.put("m", new Unit("m", "meters", l, 1, true));
        dims.put("in", new Unit("in", "inches", l, 0.0254, false));
        dims.put("ft", new Unit("ft", "feet", l, 0.3048, false));
        dims.put("yd", new Unit("yd", "yards", l, 0.9144, false));
        dims.put("mi", new Unit("mi", "miles", l, 1609.344, false));
        dims.put("ly", new Unit("ly", "lightyears", l, 9460730777119560.0, false));

        dims.put("s", new Unit("s", "second", t, 1, true));
        dims.put("min", new Unit("min", "minute", t, 60, false));
        dims.put("hr", new Unit("hr", "hour", t, 3600, false));
        dims.put("day", new Unit("day", "day", t, 86400, false));
        dims.put("fortnight", new Unit("fortnight", "fortnight", t, 1209600, false));

        dims.put("j", new Unit("j", "joule", e, 1, true));
        dims.put("eV", new Unit("eV", "electron volt", e, .0000000000000000001602176565, true));
        dims.put("btu", new Unit("btu", "british thermal unit", e, 1055.06, false));
        dims.put("boe", new Unit("boe", "barrel of oil", e, 6120000000.0, false));

        dims.put("w", new Unit("w", "watt", p, 1, true));
        dims.put("hp", new Unit("hp", "horsepower", p, 745.6998715823, false));
        dims.put("j/s", new Unit("j/s", "horsepower", p, 1, true));

        dims.put("g", new Unit("g", "gram", m, 1, true));
        dims.put("slug", new Unit("slug", "slug", m, 14593.903, false));

        dims.put("N", new Unit("N", "newton", f, 1, true));
        dims.put("lb", new Unit("lb", "pound", f, 4.448221615, false));
        dims.put("oz", new Unit("oz", "ounce", f, 3.596943079091, true));

        dims.put("m^3", new Unit("m^3", "cubic meter", v, 1, true));
        dims.put("li", new Unit("li", "liter", v, .001, true));
        dims.put("gal", new Unit("gal", "gallon", v, 0.00378541, false));
        dims.put("pt", new Unit("pt", "pint", v, 0.000473176, false));
        dims.put("hop", new Unit("hop", "hoppus", v, 0.03605, false));

        dims.put("ft^2", new Unit("ft^2", "square foot", a, 1, true));
        dims.put("m^2", new Unit("m^2", "square meter", a, 10.7639, true));
        dims.put("acre", new Unit("acre", "acre", a, 43560, false));
        dims.put("are", new Unit("are", "are", a, 1076.39, false));
        dims.put("hectare", new Unit("hectare", "hectare", a, 107639, false));

        Set<String> s = dims.keySet();
        Object ss[] = s.toArray();
//        System.out.println(dims.size());
        int p = dims.size();
        for (int i = 0; i < p; i++)
        {
//            System.out.println("Size " + dims.size());
//            System.out.println(dims.get(ss[i]).abrv);
            if (dims.get(ss[i]).isMetric)
            {
//                System.out.println("IsMetric");
                for(int j = 0; j < prefixeNames.length; j++) {
                    dims.put(prefixeNames[j] + dims.get(ss[i]).abrv, new Unit(prefixeNames[j] + dims.get(ss[i]).abrv, "fake", l, dims.get(ss[i]).convFact * prefixValues[j], true));
//                    System.out.println("New Unit");
                }
            }
        }
    }

    public static UnitRepository getInstance()
    {
        if(instance == null) {
//            System.out.println("Creating");
            return new UnitRepository();
        }
        else
            return instance;
    }

    public Unit getUnit(String unit)
    {
        return dims.get(unit);
    }

    public static void printUnits()
    {
        Set<String> s = dims.keySet();
        Object ss [] = s.toArray();
        for(int i = 0; i < dims.size(); i++)
            System.out.print(dims.get(ss[i]).abrv + " ");
    }

}
