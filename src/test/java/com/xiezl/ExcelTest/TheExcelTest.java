package com.xiezl.ExcelTest;

import jxl.Sheet;

import org.testng.annotations.Test;  

public class TheExcelTest {  
	
	static Sheet sheet = null;
      
    @Test
    public void test(){
    	//��ʼ��ExcelĿ¼�µ�Excel�ļ�,ҳ
    	ExcelData userdata = new ExcelData("Excel/ExcelTest.xls", "User");
    	System.out.println("�˺ţ�"+userdata.get(1, 2));
    	
    }  
      
     
      
    
  
  
}  
