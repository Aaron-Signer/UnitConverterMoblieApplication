package com.bignerdranch.android.homework4converter;

import org.junit.Test;
import java.util.regex.Pattern;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by Owner on 3/14/2018.
 */
public class ConvertTest {

    @Test
    public void Convert_value_returns_correct_value_for_legth_units() {
        Convert c = new Convert();
        assertThat(c.value(1.5).from("yd").to("in"), is(54.0));
        assertThat(c.value(36).from("in").to("yd"), is(1.0));
        assertThat(c.value(342).from("in").to("m"), is(8.6868));
        UnitRepository.printUnits();
//        assertThat(c.value(4532).from("mi").to("yd"), is(7976320.0));
    }

    @Test
    public void  UnitRepository_getUnit_Test()
    {
        UnitRepository u = UnitRepository.getInstance();
        assertThat(u.getUnit("yd").abrv, is("yd"));

    }
}