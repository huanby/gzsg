package net.webset;

import java.lang.reflect.Field;

import com.baomidou.mybatisplus.annotation.TableField;

import net.webset.entity.SrBm;

public class Test {

	    public static void main(String args[]) throws Exception {
	        Class<SrBm> clazz = SrBm.class;
	         // 获取 "属性变量" 上的注解的值
	        Field[] fields = clazz.getDeclaredFields();
	        for(Field field: fields){
	            if(field.isAnnotationPresent(TableField.class)){
	            	TableField bananaAnnotation = field.getAnnotation(TableField.class);
	                System.out.println("\"属性变量\"上的注解值获取到第一个 ："
	                        + bananaAnnotation.value());
	            }
	        }
	    }
	

}
