/*		
 * Copyright 2012 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,2012-12-1 cognos Exp $
 * created at:下午01:00:36
 */
package com.fangj.exercise.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author cognos
 *
 */
public class FindUtils {

	
	public static List<String> findJavaFilesByPath(List<String> fileList,String directoryPath){
		File directory=new File(directoryPath);
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				if(!file.getName().contains(".")){
					findJavaFilesByPath(fileList,directoryPath + "/"+ file.getName());
				}
			} else if (file.getName().endsWith(".java")) {
				fileList.add(directoryPath+ "/"+ file.getName());
			}
		}
		return fileList;
	}
	
	/**
	 *  从一个包中查找出所有类,在jar包中不能查找
	 * @param packageName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static List<Class> getClassesByPackageName(String packageName) throws IOException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		ArrayList<Class> classes = new ArrayList<Class>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			findClasses(classes,new File(resource.getFile()), packageName);
		}
		return classes;
	}

	private static List<Class> findClasses(List<Class> classes,File directory, String packageName)throws ClassNotFoundException {
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				if(!file.getName().contains("."))
				classes.addAll(findClasses(classes,file, packageName + '.'+ file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName+ "."+ file.getName().substring(0,file.getName().length() - 6)));
			}
		}
		return classes;
	}
}
