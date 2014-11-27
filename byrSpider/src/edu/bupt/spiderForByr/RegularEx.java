package edu.bupt.spiderForByr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx {
	public int processRegex(String url,String host,FileWriter fileWriter,Pattern pattern,int count,int total) throws IOException{
		String sep = System.getProperty("line.separator");
		String inputString = HttpTool.parseHttp(url);
		Matcher matcher = pattern.matcher(inputString);
		
		while(matcher.find()){
			System.out.println(total+" "+matcher.group());
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			total++;
			String title = matcher.group(2);
			System.out.println("title:"+title);
			if((new ParseTitle().parseTitle(title))){
				fileWriter.write(count+sep+host+matcher.group(1)+sep+matcher.group(2)+sep+sep);
				count++;
				}
		}
		return count;
	}
	
	
}
