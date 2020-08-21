package net.webset;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import net.webset.entity.SchoolData;
import net.webset.wapper.SchoolDataWapper;
import net.webset.wapper.UserWapper;
import net.webset.wapper.api.conditions.UserApi;

public class Test {

	public static void main(String[] args) throws Exception {

		/*
		 * UserApi userApi = new UserApi(); userApi.setEnable("启用"); userApi.setId(5);
		 * userApi.setMail("jy02360032@hotmail.com"); userApi.setStarttime(new Date());
		 * UserWapper userWapper = new UserWapper();
		 * 
		 * BeanUtils.copyProperties(userApi, userWapper);
		 * System.out.println(userWapper.getStarttime());
		 */
		String[] fild = getFiledName(new SchoolData());
		for(String f : fild) {
			if(f.equals("schoolName".toUpperCase())) {
				System.out.println(getFieldValueByName(f,SchoolData.class));
			}
			
		}
		
	}
	
	 public static Object getFieldValueByName(String fieldName,Class<?> clazz){
		          Field[] fields = clazz.getDeclaredFields();
		          for(Field field:fields){
		              String name = field.getName();
		              if(fieldName.equals(name)){
		                  try {
							return field.get(clazz);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		              }
		          }
		          return null;
		      }   
	     
	   /** 
	    * 获取属性名数组 
	    * */  
	   private static String[] getFiledName(Object o){  
	    Field[] fields=o.getClass().getDeclaredFields();  
	        String[] fieldNames=new String[fields.length];  
	    for(int i=0;i<fields.length;i++){  
	        System.out.println(fields[i].getType());  
	        fieldNames[i]=fields[i].getName();  
	    }  
	    return fieldNames;  
	   }  

}
