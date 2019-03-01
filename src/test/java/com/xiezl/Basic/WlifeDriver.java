package com.xiezl.Basic;


/**
 * 加载Chrome驱动（打开浏览器前的准备）
 * @author xiezhilin
 *
 */
public class WlifeDriver {
	
	public void open() {
		String driverurl = ClassLoader.getSystemResource("selenium/") + "chromedriver.exe"; 
		driverurl = driverurl.replace("file:/", "");
		System.out.println(driverurl);
		//System.setProperty("webdriver.chrome.driver",driverurl);
	}
	
	public static void main(String[] args) {
		WlifeDriver wd = new WlifeDriver();
		wd.open();
	}
	
}
	