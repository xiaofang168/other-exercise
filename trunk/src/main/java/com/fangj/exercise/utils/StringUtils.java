
package com.fangj.exercise.utils;

import jodd.util.StringUtil;


public final class StringUtils{
	
	/**
	 * 首字母大写
	 * 
	 * @param input
	 *            输入字符串
	 * @return
	 * @since 0.1
	 */
	public static String toFirstUpperCase(String input) {
		return StringUtil.isBlank(input) ? input : input.substring(0, 1).toUpperCase() + input.substring(1);
	}
	
	/**
	 * 转换数据库列名，分隔符(_)后的首字母大写其他字母小写，删除分隔符
	 * 
	 * @param column
	 *            列名
	 * @return 属性名
	 * @since 0.1
	 */
	public static String convertColumn2Field(String column) {
		String[] fields = column.toLowerCase().split("_");
		StringBuffer sfield = new StringBuffer();
		int i = 0;
		for (String field : fields) {
			if (i > 0) {
				sfield.append(StringUtils.toFirstUpperCase(field));
			} else {
				sfield.append(field);
			}
			i++;
		}
		return sfield.toString();
	}

	/**
	 * 转换数据库表名，首字母及分隔符(_)后的首字母大写其他字母小写，删除分隔符
	 * 
	 * @param column
	 *            列名
	 * @return 属性名
	 * @since 0.1
	 */
	public static String convertField2Column(String column) {
		String[] fields = column.toLowerCase().split("_");
		StringBuffer sfield = new StringBuffer();
		for (String field : fields) {
			sfield.append(StringUtils.toFirstUpperCase(field));
		}
		return sfield.toString();
	}


}