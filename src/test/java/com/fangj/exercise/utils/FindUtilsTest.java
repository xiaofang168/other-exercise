/*		
 * Copyright 2012 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,2012-12-1 cognos Exp $
 * created at:下午01:26:14
 */
package com.fangj.exercise.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jodd.io.StreamUtil;
import jodd.io.findfile.ClassScanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @author cognos
 * 
 */
public class FindUtilsTest {
	Log logger = LogFactory.getLog(FindUtils.class);

	/**
	 * Test method for
	 * {@link com.fangj.exercise.utils.FindUtils#findJavaFilesByPath(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindJavaFilesByPath() {
		List<String> fileList = FindUtils.findJavaFilesByPath(new ArrayList<String>(),"D:/fangj/workspace/qingbao-entities/src/main/java/com/egf/qingbao");
		for (String file : fileList) {
			logger.debug(file);
		}
	}

	@Test
	public void testFindClass() {
		ClassScanner cs = new ClassScanner() {
			@Override
			protected void onEntry(EntryData entryData) throws Exception {
				InputStream inputStream = entryData.openInputStream();
				byte[] bytes = StreamUtil.readAvailableBytes(inputStream);
				System.out.println("---> " + entryData.getName() + ':'
						+ entryData.getArchiveName() + "\t\t" + bytes.length);

			}
		};
		cs.setIncludeResources(true);
		cs.setIncludedJars("");
		cs.scan("D:/fangj/workspace/exercise/src/test/java/com/fangj/exercise/jodd/bean");

	}

}
