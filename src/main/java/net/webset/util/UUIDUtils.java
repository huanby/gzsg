package net.webset.util;

import java.util.UUID;

/**
 * UUID工具类
 * @author hby
 * create date: 2020-08-19
 */
public class UUIDUtils {


    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    //生成数字id
    public static Integer getUUIDId(){
        Integer orderId=UUID.randomUUID().toString().hashCode();
        orderId = orderId < 0 ? -orderId : orderId; //String.hashCode() 值会为空
        return orderId;
    }

    public static void main(String[] args){
        for (int i = 0; i<10; i++)
//            System.out.println(UUIDUtils.getUUID());
            System.out.println(UUIDUtils.getUUIDId());
    }



}
