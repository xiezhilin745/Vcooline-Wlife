package com.xiezl.StartUserCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xiezl.Basic.WlifeDriver;
import com.xiezl.Basic.WlifeLogin;

/**
 * @author xiezhilin
 * ִ����Ȧ�̻�ƽ̨������
 */
public class AddShops {
	WlifeDriver wdriver = new WlifeDriver();
	WlifeLogin wlogin = new WlifeLogin();
	public String baseUrl;
	ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception {
		//�������
		try {		
		wdriver.open();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "http://vcoolife.vcooline.com";
		System.out.println("����������ɹ�~");
		} catch (Exception e) {
			System.out.println("�쳣��"+e.toString());
		}
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("ִ�н�����title��" + driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void test1() {
//		����ִ��		
//		fail("Not yet implemented");
		// ��¼user
		wlogin.UserLogin(baseUrl, driver, "taobao", "1");
		wlogin.UserLogin(baseUrl, driver, "pl", "1");
		wlogin.UserLogin(baseUrl, driver, "yi", "1");
		System.out.println("��ʼִ�нű�~");
	}

}
