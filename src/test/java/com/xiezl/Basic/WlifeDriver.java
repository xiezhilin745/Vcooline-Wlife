package com.xiezl.Basic;


/**
 * ����Chrome�������������ǰ��׼����
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
	