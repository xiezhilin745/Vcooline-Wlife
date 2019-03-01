package com.xiezl.StartUserCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xiezl.Basic.WlifeDriver;
import com.xiezl.Basic.WlifeLogin;

/**
 * @author xiezhilin
 * 执行商圈商户平台的用例
 */
public class AddShops {
	WlifeDriver wdriver = new WlifeDriver();
	WlifeLogin wlogin = new WlifeLogin();
	public String baseUrl;
	ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception {
		//打开浏览器
		try {		
		wdriver.open();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "http://vcoolife.vcooline.com";
		System.out.println("浏览器启动成功~");
		} catch (Exception e) {
			System.out.println("异常："+e.toString());
		}
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("执行结束，title：" + driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void test1() {
//		舍弃执行		
//		fail("Not yet implemented");
		// 登录user
		wlogin.UserLogin(baseUrl, driver, "taobao", "1");
		wlogin.UserLogin(baseUrl, driver, "pl", "1");
		wlogin.UserLogin(baseUrl, driver, "yi", "1");
		System.out.println("开始执行脚本~");
	}

}
