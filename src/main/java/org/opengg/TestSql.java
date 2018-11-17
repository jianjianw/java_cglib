package org.opengg;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.opengg.pack.BeanTest;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestSql {


    @Test
    public void test(){
       String str = "总计";
        boolean b = StringUtils.equals(str, "总计");
        System.out.println(b);
        System.out.println(str);
    }


    @Test
    public void test001(){
        BeanTest  bean = new BeanTest();
        Long value= 1L;
        String s = value.toString();
        Long decode = Long.decode(s);
        System.out.println(decode);
    }
    @Test
    public void test002(){
        JSONObject jsonObject = JSONObject.parseObject("");
        System.out.println(jsonObject);
    }

    @Test
    public void test003(){

        String str01 = "";
        String str02 = " ";
        boolean empty01 = StringUtils.isEmpty(str01);
        boolean empty02 = StringUtils.isEmpty(str02);
        System.out.println(empty01);  //true
        System.out.println(empty02);  //false

        boolean blank01 = StringUtils.isBlank(str01);
        boolean blank02 = StringUtils.isBlank(str02);
        System.out.println(blank01);//true
        System.out.println(blank02);//true

    }

    @Test
    public void test004(){

        Venue venue =new Venue();
        venue.setId(1);
        venue.setCompanyId(2);
        venue.setAddress("hehe");

        VenueDTO venueDTO = new VenueDTO();
        try {
            BeanUtils.copyProperties(venueDTO, venue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @Test
    public void test005(){

        String str = "";
        String trim = str.trim();
        System.out.println(str.length());
        System.out.println(trim.length());
        boolean equals = str.equals(trim);
        System.out.println(equals);


    }

    @Test
    public void test006(){

        Integer seconds = 1529650765;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(Long.valueOf(seconds + "000")));
        System.out.println(format);
    }

    @Test
    public void test007(){
        String dateStr01 = "2018-11-15 10:00";
        String dateStr02 = "2018-11-15 10:30";
        String dateStr03 = "2018-11-15 11:00";
        String dateStr04 = "2018-11-15 11:30";
        String dateStr05 = "2018-11-15 12:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date01 = null;
        Date date02 = null;
        Date date03 = null;
        Date date04 = null;
        Date date05 = null;
        try {
            date01 = sdf.parse(dateStr01);
            date02 = sdf.parse(dateStr02);
            date03 = sdf.parse(dateStr03);
            date04 = sdf.parse(dateStr04);
            date05 = sdf.parse(dateStr05);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time01 = date01.getTime()/1000;
        long time02 = date02.getTime()/1000;
        long time03 = date03.getTime()/1000;
        long time04 = date04.getTime()/1000;
        long time05 = date05.getTime()/1000;

        System.out.println(time01);
        System.out.println(time02);
        System.out.println(time03);
        System.out.println(time04);
        System.out.println(time05);

    }

    @Test
    public void test008(){
        Long seconds = 1529650765L * 1000;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds);//传递进来的参数
        Date time1 = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = sdf1.format(time1);
        String[] split = format1.split("-");
        calendar.set(Integer.valueOf(split[0]),Integer.valueOf(split[1])-1,Integer.valueOf(split[2]),9,0);
        Integer begin=9;
        Integer end = 18;
        List<Long> times = new ArrayList<>();
        for(int i = 0;i < end; i++){
            Date time2 = calendar.getTime();
            //long time3 = time2.getTime()/1000;
            long time3 = time2.getTime();
            times.add(time3);
            calendar.add(Calendar.MINUTE,30);
        }

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<String> ll = new ArrayList<>();
        for(Long value : times){
            Date date = new Date(value);
            String format = s.format(date);
            ll.add(format);
        }








      /*  StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append(format);
        List<String> list = new ArrayList<>();

        Integer begin=9;
        Integer end = 18;
        for(int i = begin;i < end; i++){
            String s = String.valueOf(i);
            String value01 = s+":00";
            String value02 = s+":30";
            list.add(value01);
            list.add(value02);
        }
        for (String str: list){
            System.out.println(str);
        }*/






    }

    public void datePrintlnStr(Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);


    }

    public void intPrintlnStr(Integer seconds){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(Long.valueOf(seconds + "000")));
        System.out.println(format);
    }

    @Test
    public void test009(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        long seconds = time.getTime();


        //Long seconds = dateTime * 1000L;

        calendar.setTimeInMillis(seconds);//传递进来的参数
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Date startTime = calendar.getTime();

        System.out.println(sdf.format(startTime));


        calendar.set(Calendar.HOUR_OF_DAY,11);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        Date endTime = calendar.getTime();
        System.out.println(sdf.format(endTime));


    }

    @Test
    public void test010(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = sdf.parse("2018-11-10");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        int sunday = Calendar.SUNDAY;
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(i);

    }

    @Test
    public void test011(){
        Calendar calendar =Calendar.getInstance();
        calendar.setTimeInMillis(1541815200*1000L);//  start 1541779200 end 1541822399
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(time));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);


        /*
        *
        * 时间间隔长  拍摄时间长
        * */



    }
    @Test
    public void test012(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse("2018-11-10 19:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = parse.getTime()/1000;
        System.out.println(time);

        //1541836800    16:00
        //1541847600    19:00


    }

    @Test
    public void test13(){
        String str = "A";
        String strLevel01 = "A++";
        String strLevel02 = "A是的";

        boolean value01 = StringUtils.equalsIgnoreCase(str, strLevel01);
        System.out.println(value01);

        boolean value02 = StringUtils.equalsIgnoreCase(str, strLevel02);
        System.out.println(value02);



    }

    public List<User> getList(){
        User user = new User();
        user.setName("aa");

        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }
    @Test
    public void test14(){

        List<User> list = getList();
        User user = list.get(0);
        List<User> users01 = new ArrayList<>();
        users01.add(user);

        System.out.println();

        list.remove(0);


        System.out.println();






    }

    @Test
    public void test15(){
       // List<Long> timeList = getTimeList(1541836800);
        getTimeMap(1541836800);
        System.out.println();
    }

    //获取开始时间集合
    public Map<Integer,Integer> getTimeMap(Integer second){
        Long seconds = second * 1000L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds);//传递进来的参数
        Date time1 = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = sdf1.format(time1);
        String[] split = format1.split("-");
        calendar.set(Integer.valueOf(split[0]),Integer.valueOf(split[1])-1,Integer.valueOf(split[2]),9,0);
        Integer end = 24;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,String> timeStr = new LinkedHashMap<>();
        Map<Integer,Integer> times = new LinkedHashMap<>();
        for(int i = 0;i < end; i++){
            Date time2 = calendar.getTime();
            Integer startTime = Integer.valueOf(String.valueOf(time2.getTime()/1000));
            calendar.add(Calendar.MINUTE,30);

            Date time3 = calendar.getTime();
            Integer endTime = Integer.valueOf(String.valueOf(time3.getTime() / 1000));
            times.put(startTime,endTime);

            String startStr = sdf.format(time2);
            String endStr = sdf.format(time3);
            timeStr.put(startStr,endStr);
        }

        return times;
    }

    //获取开始时间集合
    public List<Long> getTimeList(Integer second){
        Long seconds = second * 1000L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds);//传递进来的参数
        Date time1 = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = sdf1.format(time1);
        String[] split = format1.split("-");
        calendar.set(Integer.valueOf(split[0]),Integer.valueOf(split[1])-1,Integer.valueOf(split[2]),9,0);
        Date time = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(time);
        System.out.println(format);

        List<String> list = new ArrayList<>();

        //Integer begin=9;
        Integer end = 24;
        List<Long> times = new ArrayList<>();
        for(int i = 0;i < end; i++){
            Date time2 = calendar.getTime();
            //封装string
            String format2 = sdf.format(time2);
            list.add(format2);

            //封装long
            long time3 = time2.getTime()/1000;
            times.add(time3);

            calendar.add(Calendar.MINUTE,30);

        }

        return times;
    }


}
