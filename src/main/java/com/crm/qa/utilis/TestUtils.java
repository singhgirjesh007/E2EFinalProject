package com.crm.qa.utilis;

import com.crm.qa.base.TestBase;

public class TestUtils extends TestBase {
	
	public static long PAGE_TIMEOUT=30;
	public static long IMPLICIT_TIMEOUT=20;
	public static long TEST_TIME_OUT=40;
	
	public static void switchFame() {
		driver.switchTo().frame("mainpanel");
	}
}
