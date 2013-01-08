/*		
 * Copyright 2012 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,2012-12-3 cognos Exp $
 * created at:下午04:10:28
 */
package com.fangj.exercise;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import jodd.io.FileUtil;
import jodd.io.findfile.FindFile;
import jodd.io.findfile.WildcardFindFile;
import jodd.jerry.Jerry;
import jodd.jerry.JerryFunction;
import jodd.typeconverter.Convert;
import jodd.util.StringUtil;
import jodd.util.SystemUtil;

/**
 * @author cognos
 * 
 */
public class PomList {
	public static void main(String[] args) throws Exception {
		(new PomList()).start();
	}

	Set<String> nodes = new HashSet<String>();
	Set<String[]> edges = new HashSet<String[]>();

	public void start() throws Exception {
		
//		String prjRoot = SystemUtil.getWorkingFolder() + "/jodd";		
//		FindFile ff = new WildcardFindFile("*/jodd-*/pom.xml")		
//		.setMatchType(FindFile.Match.RELATIVE_PATH)			
//		.setRecursive(true)				
//		.searchPath(prjRoot);
		String prjRoot = SystemUtil.getWorkingFolder();
		FindFile ff = new WildcardFindFile("*/pom.xml").setMatchType(FindFile.Match.RELATIVE_PATH).setRecursive(true).searchPath(prjRoot);
		File f;
		while ((f = ff.nextFile()) != null) {
			processPomFile(f);
		}
	}

	/** * Process single POM file. */
	public void processPomFile(File pomFile) throws IOException {
		Jerry.JerryParser jerryParser = new Jerry.JerryParser();
		jerryParser.enableXmlMode();
		Jerry doc = jerryParser.parse(FileUtil.readString(pomFile));
		final String moduleName = doc.$("artifactId").get(1).getTextContent();
		System.out.println("\n<p><var>" + moduleName + "</var>");
		nodes.add(moduleName);
		Jerry dependencies = doc.$("dependencies dependency");
		dependencies.each(new JerryFunction() {
			public boolean onNode(Jerry $this, int index) {
				// skip test dependencies
				if ($this.$("scope").text().equals("test")) {
					return true;
				}
				String artifactId = $this.$("artifactId").text();
				String optionalStr = $this.$("optional").text();
				boolean optional = false;
				if (StringUtil.isNotEmpty(optionalStr)) {
					optional = Convert.toBooleanValue(optionalStr);
				}
				String className;
				if (artifactId.startsWith("jodd-")) {
					className = "dep";
				} else {
					className = "lib";
				}
				if (optional) {
					className += "-opt";
				}
				System.out.println("\t<var class='" + className + "'>"
						+ artifactId + "</var>");
				nodes.add(artifactId);
				edges.add(new String[] { moduleName, artifactId });
				return true;
			}
		});
		System.out.println("</p>");
	}

}