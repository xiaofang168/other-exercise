/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,v 1.1 2010/02/03 07:49:58 fangjie Exp $
 * created at:2013-7-1
 */
package com.fangj.exercise.utils;

/**
 * @author fangj
 * @version $Revision: 1.1 $
 * @since 0.1
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class JavaCommand extends Object {
	private static void copyStream(InputStream inputStream, OutputStream outStream, String type) throws IOException {
		byte[] bytes = new byte[1024];
		int len = 0;
		System.out.println("========" + type + "========");
		while ((len = inputStream.read(bytes)) != -1) {
			System.out.println(new String(bytes, 0, len));
			outStream.write(bytes, 0, len);
		}
	}
	public static void exec(String cmd) {
		try {
			Process pc = Runtime.getRuntime().exec(cmd);
			copyStream(pc.getInputStream(), System.out, "InputStream()");
			copyStream(pc.getErrorStream(), System.out, "ErrorStream()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JavaCommand.exec("cmd /c copy c:\\tzh.txt d:\\aa.txt");
	}
}