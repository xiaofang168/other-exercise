/*		
 * Copyright 2012 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,2012-11-30 cognos Exp $
 * created at:下午09:05:24
 */
package com.fangj.exercise.reflect;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import jodd.util.ReflectUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.fangj.exercise.models.Person;
import com.fangj.exercise.utils.FindUtils;
import com.fangj.exercise.utils.StringUtils;

/**
 * @author cognos
 * 
 */
public class ReflectutilTest {
	Log logger = LogFactory.getLog(ReflectutilTest.class);

	@Test
	public void testGetAllColumns() {
		ReflectUtil ru = new ReflectUtil();
		Field[] fields = ru.getAccessibleFields(Person.class);
		for (Field field : fields) {
			logger.debug("Field Name："+ StringUtils.convertField2Column(field.getName()).toUpperCase());
		}
	}

	@Test
	public void testGetPackagesClass() {
		try {
			List<Class>	classes= FindUtils.getClassesByPackageName("com.fangj.exercise.models");
			for (Class class1 : classes) {
				logger.debug(class1.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
