package com.xiezl.ExcelTest;

import java.io.File;
import jxl.*;

public class ExcelData {

	private Workbook book = null;
	private Sheet sheet = null;

	/**
	 * 
	 * @param Excel路径
	 * @param Excel页名
	 */
	public ExcelData(String filepath, String casename) {
		try {
			
/*			 String ss = "test.resources."; 
			 book = Workbook.getWorkbook(new File(directory.getCanonicalPath() + "\\src\\" +
			 ss.replaceAll("\\.", Matcher.quoteReplacement("\\")) + filepath +
			 ".xls"));
			 */
			filepath = ClassLoader.getSystemResource("").toString()
					.replace("file:/", "")
					+ filepath;
			System.out.println(filepath);
			book = Workbook.getWorkbook(new File(filepath));
			sheet = book.getSheet(casename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param 读取Excel哪行
	 * @param 读取Excel哪列
	 */
	public String get(int row, int col) {
		return sheet.getCell(col - 1, row - 1).getContents();
	}

}