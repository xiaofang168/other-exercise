/*		
 * Copyright 2012 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,2012-12-1 cognos Exp $
 * created at:下午06:28:14
 */
package com.fangj.exercise.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import jodd.io.FileUtil;
import jodd.util.ReflectUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.fangj.exercise.models.Person;

/**
 * @author cognos
 *
 */
public class FileUtilsTest {

	Log logger=LogFactory.getLog(FileUtilsTest.class);
	/**
	 * Test method for {@link com.fangj.exercise.utils.FileUtils#checkJavaFileEnCode(java.lang.String)}.
	 */
	@Test
	public void testCheckJavaFileEnCode() {
		try {
			FileUtils.changeJavaFileEnCode("D:/fangj/workspace/exercise/src/main/java/com/fangj/exercise/models","UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAddFileContent(){
		try {
			String filePath="D:/fangj/workspace/exercise/src/main/java/com/fangj/exercise/models/person.java";
			
			String[] lines=FileUtil.readLines(new File(filePath));
			FileUtil.writeString(filePath, "");
			for (int i = 0; i < lines.length; i++) {
				if(i<lines.length-1){
					FileUtil.appendString(filePath, lines[i]);
					FileUtil.appendString(filePath, "\n");
				}
			}
			FileUtil.appendString(new File(filePath), "/* bean properties begin */");
			FileUtil.appendString(new File(filePath), "\n");
			
			ReflectUtil ru = new ReflectUtil();
			Field[] fields = ru.getAccessibleFields(Person.class);
			for (Field field : fields) {
				FileUtil.appendString(new File(filePath), "public static final String "+StringUtils.convertField2Column(field.getName()).toUpperCase()+"PRO_NAME=\""+field.getName()+"\";");
				FileUtil.appendString(new File(filePath), "\n");
			}
			FileUtil.appendString(new File(filePath), "/* bean properties end */");
			FileUtil.appendString(new File(filePath), "\n");
			FileUtil.appendString(new File(filePath), "}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
