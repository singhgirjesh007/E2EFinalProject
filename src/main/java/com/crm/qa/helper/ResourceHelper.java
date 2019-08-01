package com.crm.qa.helper;

public class ResourceHelper {
	
	public static String resourceHelper(String path) {
		String basePath =System.getProperty("user.dir");
		String completePath=basePath+path;
		return completePath;
	}
	

}
