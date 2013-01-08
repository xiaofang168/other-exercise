/*		
 * Copyright 2012 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,2012-11-30 cognos Exp $
 * created at:下午08:52:56
 */
package com.fangj.exercise.jodd.bean;

import jodd.bean.BeanUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.fangj.exercise.models.Person;

/**
 * @author cognos
 * 
 */
public class BeanUtilTest {
	
	Log log = LogFactory.getLog(BeanUtilTest.class);

	@Test
	public void testProperty() {
		Person person = new Person();
		BeanUtil.setProperty(person, "readwrite", "data");
		BeanUtil.setDeclaredProperty(person, "readonly", "data");
		log.debug("readwrite："+person.getReadonly());
		log.debug("readonly："+person.getReadonly());
	}
}
