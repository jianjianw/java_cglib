package org.opengg;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    @Test
    public void test001(){
        //秒值转化为时间
        Integer seconds = 1541079000;//1540396800
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(Long.valueOf(seconds + "000")));
        System.out.println(format);
        //81   1540396800   1542038400            82 1543420800   1543334400
    }

    @Test
    public void test002(){
        // 字符串改为毫秒值
        String test = "2018-11-19 00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date01 = null;
        try {
            date01 = sdf.parse(test);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time01 = date01.getTime()/1000;
        System.out.println(time01);

    }
}
