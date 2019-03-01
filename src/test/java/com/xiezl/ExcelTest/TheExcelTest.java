package com.xiezl.ExcelTest;

import jxl.Sheet;

import org.testng.annotations.Test;  

public class TheExcelTest {  
	
	static Sheet sheet = null;
      
    @Test
    public void test(){
    	//初始化Excel目录下的Excel文件,页
    	ExcelData userdata = new ExcelData("Excel/ExcelTest.xls", "User");
    	System.out.println("账号："+userdata.get(1, 2));
    	
    }  
      
     
      
    
  
  
}  
