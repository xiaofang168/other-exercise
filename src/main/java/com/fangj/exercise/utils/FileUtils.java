/*		
 * Copyright 2012 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,2012-12-1 cognos Exp $
 * created at:下午06:19:18
 */
package com.fangj.exercise.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jodd.io.FileUtil;

/**
 * @author cognos
 *
 */
public class FileUtils {
	
	public  static void changeJavaFileEnCode(String filePath,String encoding) throws IOException{
		List<String> fileList= FindUtils.findJavaFilesByPath(new ArrayList<String>(),filePath);
		for (String path : fileList) {
			String fileString=FileUtil.readString(new File(path));
			FileUtil.writeString(new File(path), fileString, encoding);
		}
	}

}
