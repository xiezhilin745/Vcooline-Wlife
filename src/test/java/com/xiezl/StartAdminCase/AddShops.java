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
 * @author xiezhilin 执行商圈管理员的平台用例
 */
// @RunWith(Parameterized.class)
public class AddShops {
	// 数据池
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
		System.out.println("浏览器启动成功~");
	}

	/**
	 * 添加店铺
	 */
	@Test
	public void addshops() {
		//店铺logo
		String imgPath = ClassLoader.getSystemResource("image/")
				+ shops.get(6, 3);
		imgPath = imgPath.replace("file:/", "");
		// 遍历图片
		String[] upload = {
				ClassLoader.getSystemResource("image/") + shops.get(8, 3),
				ClassLoader.getSystemResource("image/") + shops.get(8, 4),
				ClassLoader.getSystemResource("image/") + shops.get(8, 5),
				ClassLoader.getSystemResource("image/") + shops.get(8, 6),
				ClassLoader.getSystemResource("image/") + shops.get(8, 7) };

		// 范型
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", userdata.get(2, 3));
		map.put("password", userdata.get(3, 3));
		map.put("shopsname", shops.get(2, 3));
		map.put("weighVal", shops.get(5, 3));
		map.put("shopslogo", imgPath);
		map.put("description", shops.get(7, 3));
		//环境图片
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
			// 登录admin
			wlogin.AdminLogin(driver, map);
			
			// 添加店铺
			String date1 = "Addshop开始启动.\r\n";
			testlog.AppendTestLog(date1);
			afrom.Addshop(baseUrl, driver, map);
		} catch (Exception e) {
			String date2 = "Addshop用例执行过程发生异常，请查看日志分析失败原因.\r\n" + e.toString()
					+ "\r\n";
			testlog.AppendTestLog(date2);
		} finally {
			String date3 = "Addshop用例执行结束.\r\n";
			testlog.AppendTestLog(date3);
		}
		System.out.println("开始执行脚本~");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("执行结束，title：" + driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}
}
