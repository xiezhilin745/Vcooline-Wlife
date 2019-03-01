package com.xiezl.GroupPurchase;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class GroupBuy {
	/**
	 * 添加团购
	 * @param baseUrl
	 * @param driver
	 */
	public void AddGroupBuy(ChromeDriver driver,Map<String, String> map){
		driver.findElement(By.linkText("新增")).click();
		driver.findElement(By.xpath(".//*[@id='form_field_select_3_chosen']/a")).click();
		sleep(1);
		driver.findElement(By.xpath(".//*[@id='form_field_select_3_chosen']/div/ul/li[2]")).click();
	    driver.findElement(By.name("groupName")).sendKeys(map.get("groupName"));
	    driver.findElement(By.name("price")).clear();
	    driver.findElement(By.name("price")).sendKeys(map.get("price"));
	    driver.findElement(By.name("originPrice")).clear();
	    driver.findElement(By.name("originPrice")).sendKeys(map.get("originPrice"));
	    driver.findElement(By.cssSelector("input[type=\"file\"]")).sendKeys(map.get("imgPath"));
	    driver.findElement(By.name("stockCount")).clear();
	    driver.findElement(By.name("stockCount")).sendKeys(map.get("stockCount"));
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript(map.get("daterange"));
		sleep(1);
	    driver.findElement(By.xpath
	    	("html/body/div[2]/div/div[2]/div[2]/div/div/div/form/div[2]/div[1]/div/div/div[2]"))
	    	.sendKeys(map.get("content"));
	    sleep(1);
	    driver.findElement(By.xpath
	    	("html/body/div[2]/div/div[2]/div[2]/div/div/div/form/div[2]/div[2]/div/div/div[2]"))
    		.sendKeys(map.get("regulations"));
	    sleep(1);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    String url = driver.getCurrentUrl();
	  //判断截取的URL是否存在toShowShopsList
	  if(!url.contains("groupbuy/goods")){
	  	System.out.println("跳转失败了！！！");
	  }else{
	  	System.out.println("成功保存！！！");
	  }
	}
	
	public static void sleep(int mins){
		try {
			Thread.sleep(mins * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
