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
	//数据池
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
		System.out.println("浏览器启动成功~");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("执行结束，title：" + driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void Add_groupbuy() {
		try {
			String imgPath = ClassLoader.getSystemResource("image/") + groupdata.get(6, 3);
			imgPath = imgPath.replace("file:/", "");
			// 泛型团购数据
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
			//浏览器获取登录地址
			driver.get(baseUrl + userdata.get(5, 3));
			//登录
			wlogin.AdminLogin(driver, map);
			//浏览器输入团购地址
			driver.get(baseUrl + groupdata.get(11, 3));
			//添加团购
			groupbuy.AddGroupBuy(driver, map);
			String date1 = "AddGroupBuy开始启动.\r\n";
			testlog.AppendTestLog(date1);
		} catch (Exception e) {
			String date2 = "AddGroupBuy用例执行过程发生异常，请查看日志分析失败原因.\r\n" + e.toString()
					+ "\r\n";
			testlog.AppendTestLog(date2);
			e.printStackTrace();
		}finally{
			String date3 = "AddGroupBuy用例执行结束.\r\n";
			testlog.AppendTestLog(date3);
		}
	}
}
