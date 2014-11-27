package edu.bupt.spiderForByr;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class SpiderForBYR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new InputTools().init();
		String host = "http://bbs.byr.cn";
		// String board = "ParttimeJob";
		String board = InputTools.getBoard();
		int pageRange = InputTools.getPageRange();
		System.out.println("board:" + board);
		System.out.println("pageRange:" + pageRange);
		int recordCount = 1;
		int totalCount = 1;

		// 正则表达式注意用非贪婪模式
		// String patternString =
		// "<a[SPACE]*href[SPACE]*=\"(/article/ParttimeJob/[0-9]*)\">(.*?)</a>";
		String patternString = "<a href=\"(/article/ParttimeJob/[0-9]*)\">(.*?)</a>";
		Pattern pattern = Pattern.compile(patternString);
		String sep = System.getProperty("line.separator");
		FileWriter fileWriter = null;
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		String fileName = year + "_" + month + "_" + day + "_" + hour + "_"
				+ minute + "_" + second;
		System.out.println("fileName:" + fileName);
		try {
			fileWriter = new FileWriter(fileName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int page = 1; page <= pageRange; page++) {
			String url = host + "/board/" + board + "?p=" + page;
			System.out.println("url" + page + ":" + url);
			try {
				recordCount = new RegularEx().processRegex(url, host,
						fileWriter, pattern, recordCount, totalCount);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
