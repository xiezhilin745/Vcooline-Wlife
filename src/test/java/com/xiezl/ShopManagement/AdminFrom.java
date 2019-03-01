package com.xiezl.ShopManagement;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ������ù���Ա�����ĸ��ַ�������
 * 
 * @author xiezhilin
 */
public class AdminFrom {
	/**
	 * �������
	 * 
	 * @author xiezhilin
	 */
	public void Addshop(String baseUrl, ChromeDriver driver,
			Map<String, String> map) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//a[@onclick='toAdd()']")).click();
		driver.findElement(By.id("name")).sendKeys(map.get("shopsname"));
		// new
		// Select(driver.findElement(By.xpath(".//*[@id='tag1']"))).selectByVisibleText("��װ");
		// new
		// Select(driver.findElement(By.xpath(".//*[@id='tag2']"))).selectByVisibleText("��װ");
		// new
		// Select(driver.findElement(By.xpath(".//*[@id='tagArea1']"))).selectByVisibleText("����");
		// new
		// Select(driver.findElement(By.xpath(".//*[@id='tagArea2']"))).selectByVisibleText("������");
		try {
		driver.findElement(By.xpath(".//*[@id='tag1']")).click();
		sleep(1);
		if (driver.findElements(By.xpath(".//*[@id='tag1']/option")).size() >= 2) {
			driver.findElement(By.xpath(".//*[@id='tag1']/option[2]")).click();
		}else {
			System.out.println("���̷��࣬�����������ݡ���");
			driver.findElement(By.xpath(".//*[@id='tag1']/option[1]")).click();
		}
		
		sleep(1);
		System.out.println("������"
				+ driver.findElements(By.xpath(".//*[@id='tag2']/option"))
						.size());
		// ������������ݴ���2�����͵���ڶ�������
		if (driver.findElements(By.xpath(".//*[@id='tag2']/option")).size() >= 2) {
			driver.findElement(By.xpath(".//*[@id='tag2']/option[2]")).click();
		}else {
			System.out.println("���̷��࣬�������������ݡ���");
		}
		sleep(1);
		if (driver.findElements(By.xpath(".//*[@id='tagArea1']/option")).size() >= 2){
			driver.findElement(By.xpath(".//*[@id='tagArea1']/option[2]")).click();
		}else {
			System.out.println("������࣬�����������ݡ���");
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
		// ����û�����
		driver.findElement(By.xpath(".//*[@class='user-info']")).click();
		sleep(1);
		driver.findElement(By.xpath(".//textarea[@name='description']"))
				.sendKeys(map.get("description"));

		// ��ȡ�ϴ��ؼ�Ԫ��
		WebElement uploadButton = driver.findElement(By
				.xpath(".//*[@id='shop-cieldon-file']/div/div/input[1]"));
		// �����ϴ��ļ�·��������Ҫ�ϴ����ļ���ӵ� CharSequence ����
		CharSequence[] files = new CharSequence[5];
		files[0] = map.get("upload1");
		files[1] = map.get("upload2");
		files[2] = map.get("upload3");
		files[3] = map.get("upload4");
		files[4] = map.get("upload5");
		// ѭ���г�ÿ֧��Ҫ�ϴ����ļ�·��������һ�ϴ�����
		for (CharSequence file : files) {
			uploadButton.sendKeys(file);
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e1) {
			System.out.println(e1.toString());
		}
		System.out.println("����ͼƬupload end");

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
			System.out.println("��תʧ���ˣ�����");

		} else {
			System.out.println("��֤��ɹ����棡����");
		}
	}

	/**
	 * ˯�߷���sleep(��)
	 * 
	 * @param mins
	 */
	public static void sleep(int mins) {
		try {
			Thread.sleep(mins * 1000);
		} catch (Exception e) {
			System.out.println("˯����" + e.toString());
		}
	}
}
