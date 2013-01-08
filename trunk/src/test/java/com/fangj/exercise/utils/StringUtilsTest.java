/*		
 * Copyright 2012 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,2012-11-30 cognos Exp $
 * created at:下午09:34:51
 */
package com.fangj.exercise.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author cognos
 *
 */
public class StringUtilsTest {
	
	Log logger=LogFactory.getLog(StringUtilsTest.class);

	/**
	 * Test method for {@link com.fangj.exercise.utils.StringUtils#convertColumn2Field(java.lang.String)}.
	 */
	@Test
	public void testConvertColumn2Field() {
		String column="user_name";
		logger.debug(StringUtils.convertColumn2Field(column));
	}

	/**
	 * Test method for {@link com.fangj.exercise.utils.StringUtils#convertTable2Class(java.lang.String)}.
	 */
	@Test
	public void convertField2Column() {
		String field="user_name";
		String column=StringUtils.convertField2Column(field);
		logger.debug(column);
		Assert.assertEquals(column, "UserName");
	}

}
