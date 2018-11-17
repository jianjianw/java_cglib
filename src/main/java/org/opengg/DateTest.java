package org.opengg;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    @Test
    public void test001(){
        //秒值转化为时间
        Integer seconds = 1529650765;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(Long.valueOf(seconds + "000")));
        System.out.println(format);
    }

    @Test
    public void test002(){
        // 字符串改为毫秒值
        String dateStr01 = "2018-11-15 10:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date01 = null;
        try {
            date01 = sdf.parse(dateStr01);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time01 = date01.getTime()/1000;
        System.out.println(time01);

    }
}
