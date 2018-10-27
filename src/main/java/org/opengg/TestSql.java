package org.opengg;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.opengg.pack.BeanTest;

import java.util.List;

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
}
