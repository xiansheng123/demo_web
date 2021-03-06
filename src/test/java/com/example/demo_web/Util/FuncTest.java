package com.example.demo_web.Util;

import com.example.demo_web.Entity.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Pattern;

import static com.example.demo_web.Util.Func.convertTimeStamp;
import static org.junit.Assert.assertEquals;

public class FuncTest {
    @Test
    public void convertTimeStampTest() throws Exception {
        String date = "1991-11-14 09:35:44:123+08:00";
        Timestamp myTimestamp = convertTimeStamp (date);
        // System.out.println(ConvertLongDate(myTimestamp));
    }

    @Test
    public void regularExpressionDate() {
        //2009-01-01
        String reg = "^\\d{4}-(0[1-9]|1[1-2])-(0[1-9]|[1-2]\\d|3[0-1])$";
        String date = "2009-11-31";
        if (Pattern.matches (reg, date)) {
            System.out.print ("this format is right");
        } else {
            System.out.print ("this format is wrong");
        }
        assertEquals (true, Pattern.matches (reg, date));
    }

    @Test
    public void hashmapTest() {
        HashMap<String, String> map1 = new HashMap<String, String> () {
            {
                put ("name", "test");
                put ("age", "20");
                put ("age", "21");
                put ("age1", "21");
                put ("c", null);
                put (null, null);
                put (null, "11");
            }
        };
        System.out.println (map1.containsKey ("job"));
        System.out.println (map1.get ("work"));
        System.out.println (map1);
    }

    @Test
    public void hashSetTest() {
        HashSet<String> map1 = new HashSet<String> () {
            {
                add ("123");
                add ("456");
                add ("789");
                add ("123");
                add (null);
            }
        };
        String aa = "cc";
        String bb = "cc";
        String cc = "cc";

        System.out.println (map1);
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void hashTableTest() {
        Hashtable<String, String> map1 = new Hashtable<String, String> () {
            {
                put ("name", "test");
                put ("age", "20");
                put ("age", "21");
                put ("age1", "21");
                put ("work", "IT");
                put ("job", "aa");
            }
        };
        System.out.println (map1);
    }

    @Test
    public void listtest() {
        List<Person> list = new ArrayList<Person> () {
            {
                add (new Person ("1", "lu1", "xuda", 12));
                add (new Person ("2", "lu2", "xuda", 22));
                add (new Person ("3", "lu3", "xuda", 33));
                add (new Person ("4", "lu4", "xuda", 55));
            }
        };
        Person max = list.stream ().max (Comparator.comparing (Person -> Person.getAge ())).get ();
        System.out.println (list);
        System.out.println (max);
    }

    @Test
    public void judgementDataTypeIsInt() {
        List<String> str = Arrays.asList ("123", "44", "6", "5t", "@","1.81", "890");
        int min =0;
        for (String x : str) {
            if (StringUtils.isNumeric (x)) {
                int a = Integer.valueOf (x);
                if (a < min||min==0) {
                    min = a;
                }
            }
        }
        System.out.println (min);
    }
}