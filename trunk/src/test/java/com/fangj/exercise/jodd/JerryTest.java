/*		
 * Copyright 2012 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,2012-11-30 cognos Exp $
 * created at:下午08:52:56
 */
package com.fangj.exercise.jodd;

import java.io.File;
import java.io.IOException;

import jodd.io.FileUtil;
import jodd.io.NetUtil;
import jodd.jerry.Jerry;
import jodd.util.SystemUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class JerryTest {

	Log log = LogFactory.getLog(JerryTest.class);

	@Test
	public void testParsePage() {

		// download the page super-efficiently
		File file = new File(SystemUtil.getTempDir(), "google.html");
		try {
			NetUtil.downloadFile("http://www.google.com.tw", file);
			// create Jerry, i.e. document context
			Jerry doc = Jerry.jerry(FileUtil.readString(file));
			// remove div for toolbar
			doc.$("div#mngb").detach();
			// replace logo with html content

			doc.$("div#lga").html("<b>Google</b>");
			// produce clean html...
			String newHtml = doc.html();
			// ...and save it to file system
			FileUtil.writeString(new File(SystemUtil.getTempDir(),"google2.html"), newHtml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}