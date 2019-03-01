package com.xiezl.Basic;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 此方法包括
 * 生活圈登录、admin、user
 * @author xiezhilin
 */
public class WlifeLogin {
	/**
	 * 商圈管理员登录
	 */
	//@Parameters({ "life-urls"})
	public void AdminLogin(ChromeDriver driver,Map<String, String> userinfo) {
		driver.findElement(By.id("business_shop_admin_username"))
				.sendKeys(userinfo.get("username"));
		driver.findElement(By.cssSelector("#business_shop_admin_password")).sendKeys(
				userinfo.get("password"));
		driver.findElement(By.linkText("登录")).click();
	}
	
	/**
	 * 商圈商户登录
	 */
	public void UserLogin(String baseUrl,ChromeDriver driver, String name,
			String password) {
		driver.get(baseUrl + "/account/login");
		driver.findElement(By.id("business_shop_admin_username"))
				.sendKeys(name);
		driver.findElement(By.cssSelector("#business_shop_admin_password")).sendKeys(
				password);
		driver.findElement(By.linkText("登录")).click();
	}
}
