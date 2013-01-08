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
 * @author fangj
 *
 */
public class FileUtils {
	
	public static void getFiles(String path,String tableName) {
		int i = 0;
		File file = new File(path);
		File[] ppList = file.listFiles();
		for (File pp : ppList) {
			File[] pics = pp.listFiles();
			if (pics!=null) {
				for (File xh : pics) {
					if (xh.getName().endsWith(".jpg")) {
						// logger.debug("品牌="+pp.getName()+"; 型号="+xh.getName()+"----"+pic.getName());
						BlobUtils.insertBlob(xh,tableName, pp.getName(), xh.getName().replaceAll(".jpg", ""));
						i = i + 1;
					}
				}
			} else {
				// logger.debug("品牌="+pp.getName()+"; 型号="+pic.getName());
			}
		}
		System.out.println("图片保存成功,共插入图片张数=" + i);
	}

	public  static void changeJavaFileEnCode(String filePath,String encoding) throws IOException{
		List<String> fileList= FindUtils.findJavaFilesByPath(new ArrayList<String>(),filePath);
		for (String path : fileList) {
			String fileString=FileUtil.readString(new File(path));
			FileUtil.writeString(new File(path), fileString, encoding);
		}
	}
	
	public static void main(String[] args) {
		//FileUtils.getFiles("D:/相机/MP3","MP3");
		//FileUtils.getFiles("D:/相机/摄像机", "VIDICON");
		//FileUtils.getFiles("D:/相机/MP4&MP5", "MP4_MP5");
		FileUtils.getFiles("D:/相机/照相机", "CAMERA");
	}
}
