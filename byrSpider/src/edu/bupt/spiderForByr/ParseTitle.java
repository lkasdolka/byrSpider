package edu.bupt.spiderForByr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CORBA.PRIVATE_MEMBER;

public class ParseTitle {
	private List<String> searchWords;
	private List<Pattern> searchPatterns;
	{
		searchWords = new ArrayList<>();
		searchPatterns = new ArrayList<>();
		init();
	}
	public void init(){
//		searchWords.add("java");
//		searchWords.add("android");
//		searchWords.add("安卓");
//		searchWords.add("研发");
//		searchWords.add("开发");
		searchWords = InputTools.getKeyWords();
		for(int i = 0; i < searchWords.size(); i++){
			Pattern pattern1 = Pattern.compile(searchWords.get(i));
			searchPatterns.add(pattern1);
		}
	}
	public  boolean parseTitle(String title){
		
		for(int j = 0; j< searchPatterns.size();++j){
			Matcher matcher2 = searchPatterns.get(j).matcher(title);
			if(matcher2.find()){
				return true;
			}else{
				continue;
			}
		}
		return false;
	}
}
