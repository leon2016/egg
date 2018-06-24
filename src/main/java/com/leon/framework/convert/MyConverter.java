package com.leon.framework.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			// 转成直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {

			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return simpleDateFormat.parse(source);
			} catch (ParseException e1) {

				System.out.println("日期转换失败->" + this.getClass().getName());
			}
		}
		// 如果参数绑定失败返回null
		return null;
	}

}