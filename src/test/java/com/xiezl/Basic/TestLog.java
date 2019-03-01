package com.xiezl.Basic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestLog {

	// »’÷æ
	public void AppendTestLog(String content) {
		BufferedWriter bufferWritter = null;
		try {

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(new Date());
			String filePath = ClassLoader.getSystemResource("").toString()
					.replace("file:/", "")
					.replace("target/test-classes/", "src/test/resources/log/")
					+ date + ".log";

			File f = new File(filePath);
			if (!f.exists()) {
				f.createNewFile();
			}
			// true = append file
			FileWriter fileWritter = new FileWriter(f, true);
			bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.append(content);

			bufferWritter.flush();
			fileWritter.flush();

		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			if (bufferWritter != null) {
				try {
					bufferWritter.close();
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
		}

	}

}
