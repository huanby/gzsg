package net.webset.util;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * 工具类
 * 
 * @author 梁雪峰
 *
 */
public class Utils {

	/**
	 * 获取错误信息，并且按照一定格式返回给客户端
	 * 
	 * @param bs
	 * @return
	 */
	public static ResponseEntity<?> getErrors(Set<BindingResult> bs) {
		// 初始化错误信息返回类
		Set<String> errors = new HashSet<>();
		if (!bs.isEmpty()) {
			for (BindingResult bind : bs) {
				if (bind.hasErrors()) {
					for (ObjectError oe : bind.getAllErrors()) {
						errors.add(oe.getDefaultMessage());
					}
				}
			}
		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	public static Object getFieldValueByName(String fieldName, Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (fieldName.equals(name)) {
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
	 */
	public static String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getType());
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

}
