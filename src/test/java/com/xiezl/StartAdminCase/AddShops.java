package com.xiezl.StartAdminCase;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xiezl.Basic.TestLog;
import com.xiezl.Basic.WlifeDriver;
import com.xiezl.Basic.WlifeLogin;
import com.xiezl.ExcelTest.ExcelData;
import com.xiezl.ShopManagement.AdminFrom;

/**
 * @author xiezhilin ִ����Ȧ����Ա��ƽ̨����
 */
// @RunWith(Parameterized.class)
public class AddShops {
	// ���ݳ�
	ExcelData shops = new ExcelData("Excel/ExcelTest.xls", "Shops");
	ExcelData userdata = new ExcelData("Excel/ExcelTest.xls", "User");
	TestLog testlog = new TestLog();
	WlifeDriver wdriver = new WlifeDriver();
	WlifeLogin wlogin = new WlifeLogin();
	AdminFrom afrom = new AdminFrom();
	public String baseUrl;
	ChromeDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		wdriver.open();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = userdata.get(4, 3);
		System.out.println("����������ɹ�~");
	}

	/**
	 * ��ӵ���
	 */
	@Test
	public void addshops() {
		//����logo
		String imgPath = ClassLoader.getSystemResource("image/")
				+ shops.get(6, 3);
		imgPath = imgPath.replace("file:/", "");
		// ����ͼƬ
		String[] upload = {
				ClassLoader.getSystemResource("image/") + shops.get(8, 3),
				ClassLoader.getSystemResource("image/") + shops.get(8, 4),
				ClassLoader.getSystemResource("image/") + shops.get(8, 5),
				ClassLoader.getSystemResource("image/") + shops.get(8, 6),
				ClassLoader.getSystemResource("image/") + shops.get(8, 7) };

		// ����
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", userdata.get(2, 3));
		map.put("password", userdata.get(3, 3));
		map.put("shopsname", shops.get(2, 3));
		map.put("weighVal", shops.get(5, 3));
		map.put("shopslogo", imgPath);
		map.put("description", shops.get(7, 3));
		//����ͼƬ
		map.put("upload1", upload[0].replace("file:/", ""));
		map.put("upload2", upload[1].replace("file:/", ""));
		map.put("upload3", upload[2].replace("file:/", ""));
		map.put("upload4", upload[3].replace("file:/", ""));
		map.put("upload5", upload[4].replace("file:/", ""));
		map.put("phone", shops.get(9, 3));
		map.put("address", shops.get(10, 3));
		map.put("verifyurl", shops.get(15, 3));


		
		try {
			driver.get(baseUrl + userdata.get(5, 3));
			// ��¼admin
			wlogin.AdminLogin(driver, map);
			
			// ��ӵ���
			String date1 = "Addshop��ʼ����.\r\n";
			testlog.AppendTestLog(date1);
			afrom.Addshop(baseUrl, driver, map);
		} catch (Exception e) {
			String date2 = "Addshop����ִ�й��̷����쳣����鿴��־����ʧ��ԭ��.\r\n" + e.toString()
					+ "\r\n";
			testlog.AppendTestLog(date2);
		} finally {
			String date3 = "Addshop����ִ�н���.\r\n";
			testlog.AppendTestLog(date3);
		}
		System.out.println("��ʼִ�нű�~");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("ִ�н�����title��" + driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}
}
