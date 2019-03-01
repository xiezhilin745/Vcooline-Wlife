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
import com.xiezl.GroupPurchase.GroupBuy;

public class AddGroupBuy {
	//���ݳ�
	ExcelData groupdata = new ExcelData("Excel/ExcelTest.xls", "GroupBuy");
	ExcelData userdata = new ExcelData("Excel/ExcelTest.xls", "User");
	WlifeDriver wdriver = new WlifeDriver();
	WlifeLogin wlogin = new WlifeLogin();
	TestLog testlog = new TestLog();
	GroupBuy groupbuy = new GroupBuy();
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

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("ִ�н�����title��" + driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void Add_groupbuy() {
		try {
			String imgPath = ClassLoader.getSystemResource("image/") + groupdata.get(6, 3);
			imgPath = imgPath.replace("file:/", "");
			// �����Ź�����
			Map<String, String> map = new HashMap<String, String>();
			map.put("username", userdata.get(2, 3));
			map.put("password", userdata.get(3, 3));
			map.put("groupName", groupdata.get(3, 3));
			map.put("price", groupdata.get(4, 3));
			map.put("originPrice", groupdata.get(5, 3));
			map.put("imgPath", imgPath);
			map.put("stockCount", groupdata.get(7, 3));
			map.put("daterange", "document.getElementById(\"daterange\").value='"+groupdata.get(8, 3)+"';");
			map.put("content", groupdata.get(9, 3));
			map.put("regulations", groupdata.get(10, 3));
			//�������ȡ��¼��ַ
			driver.get(baseUrl + userdata.get(5, 3));
			//��¼
			wlogin.AdminLogin(driver, map);
			//����������Ź���ַ
			driver.get(baseUrl + groupdata.get(11, 3));
			//����Ź�
			groupbuy.AddGroupBuy(driver, map);
			String date1 = "AddGroupBuy��ʼ����.\r\n";
			testlog.AppendTestLog(date1);
		} catch (Exception e) {
			String date2 = "AddGroupBuy����ִ�й��̷����쳣����鿴��־����ʧ��ԭ��.\r\n" + e.toString()
					+ "\r\n";
			testlog.AppendTestLog(date2);
			e.printStackTrace();
		}finally{
			String date3 = "AddGroupBuy����ִ�н���.\r\n";
			testlog.AppendTestLog(date3);
		}
	}
}
