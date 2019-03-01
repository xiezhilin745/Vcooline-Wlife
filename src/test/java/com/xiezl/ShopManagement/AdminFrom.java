package com.xiezl.ShopManagement;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 此类调用管理员操作的各种方法用例
 * 
 * @author xiezhilin
 */
public class AdminFrom {
	/**
	 * 添加商铺
	 * 
	 * @author xiezhilin
	 */
	public void Addshop(String baseUrl, ChromeDriver driver,
			Map<String, String> map) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//a[@onclick='toAdd()']")).click();
		driver.findElement(By.id("name")).sendKeys(map.get("shopsname"));
		// new
		// Select(driver.findElement(By.xpath(".//*[@id='tag1']"))).selectByVisibleText("服装");
		// new
		// Select(driver.findElement(By.xpath(".//*[@id='tag2']"))).selectByVisibleText("下装");
		// new
		// Select(driver.findElement(By.xpath(".//*[@id='tagArea1']"))).selectByVisibleText("北京");
		// new
		// Select(driver.findElement(By.xpath(".//*[@id='tagArea2']"))).selectByVisibleText("朝阳区");
		try {
		driver.findElement(By.xpath(".//*[@id='tag1']")).click();
		sleep(1);
		if (driver.findElements(By.xpath(".//*[@id='tag1']/option")).size() >= 2) {
			driver.findElement(By.xpath(".//*[@id='tag1']/option[2]")).click();
		}else {
			System.out.println("商铺分类，下拉框无数据……");
			driver.findElement(By.xpath(".//*[@id='tag1']/option[1]")).click();
		}
		
		sleep(1);
		System.out.println("数量："
				+ driver.findElements(By.xpath(".//*[@id='tag2']/option"))
						.size());
		// 如果下拉框数据大于2个，就点击第二条数据
		if (driver.findElements(By.xpath(".//*[@id='tag2']/option")).size() >= 2) {
			driver.findElement(By.xpath(".//*[@id='tag2']/option[2]")).click();
		}else {
			System.out.println("商铺分类，子下拉框无数据……");
		}
		sleep(1);
		if (driver.findElements(By.xpath(".//*[@id='tagArea1']/option")).size() >= 2){
			driver.findElement(By.xpath(".//*[@id='tagArea1']/option[2]")).click();
		}else {
			System.out.println("区域分类，下拉框无数据……");
			driver.findElement(By.xpath(".//*[@id='tagArea1']/option[1]")).click();
		}
					
			sleep(1);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		// driver.findElement(By.xpath(".//*[@id='tagArea2']/option[2]")).click();
		//sleep(1);
		
		driver.findElement(By.xpath(".//*[@id='weighVal']")).clear();
		driver.findElement(By.xpath(".//*[@id='weighVal']")).sendKeys(
				map.get("weighVal"));

		driver.findElement(
				By.xpath(".//*[@id='logo-cieldon-file']/div/div/input[1]"))
				.sendKeys(map.get("shopslogo"));
		// 点击用户名称
		driver.findElement(By.xpath(".//*[@class='user-info']")).click();
		sleep(1);
		driver.findElement(By.xpath(".//textarea[@name='description']"))
				.sendKeys(map.get("description"));

		// 获取上传控件元素
		WebElement uploadButton = driver.findElement(By
				.xpath(".//*[@id='shop-cieldon-file']/div/div/input[1]"));
		// 构建上传文件路径，将需要上传的文件添加到 CharSequence 数组
		CharSequence[] files = new CharSequence[5];
		files[0] = map.get("upload1");
		files[1] = map.get("upload2");
		files[2] = map.get("upload3");
		files[3] = map.get("upload4");
		files[4] = map.get("upload5");
		// 循环列出每支需要上传的文件路径，做单一上传动作
		for (CharSequence file : files) {
			uploadButton.sendKeys(file);
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e1) {
			System.out.println(e1.toString());
		}
		System.out.println("环境图片upload end");

		driver.findElement(By.xpath(".//*[@id='phone']")).sendKeys(
				map.get("phone"));
		driver.findElement(By.xpath(".//*[@id='location_address']")).sendKeys(
				map.get("address"));
		// driver.findElement(By.xpath(".//*[@id='location_x']")).sendKeys(
		// "121.647858");
		// driver.findElement(By.xpath(".//*[@id='location_y']")).sendKeys(
		// "31.183478");
		sleep(2);

		driver.findElement(By.xpath(".//input[@type='submit']")).click();

		String str = driver.getCurrentUrl();
		if (!str.contains(map.get("verifyurl"))) {
			System.out.println("跳转失败了！！！");

		} else {
			System.out.println("验证点成功保存！！！");
		}
	}

	/**
	 * 睡眠方法sleep(秒)
	 * 
	 * @param mins
	 */
	public static void sleep(int mins) {
		try {
			Thread.sleep(mins * 1000);
		} catch (Exception e) {
			System.out.println("睡觉：" + e.toString());
		}
	}
}
