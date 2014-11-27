package edu.bupt.spiderForByr;

import java.util.ArrayList;
import java.util.Scanner;

public class InputTools {
	private static ArrayList<String> keyWords;
	private static int pageRange;
	private static String board;
	private static boolean useManualInput;
	{
		useManualInput = false;
	}
	public static ArrayList<String> getKeyWords() {
		return keyWords;
	}
	public static void setKeyWords(ArrayList<String> keyWords) {
		InputTools.keyWords = keyWords;
	}
	public static int getPageRange() {
		return pageRange;
	}
	public static void setPageRange(int pageRange) {
		InputTools.pageRange = pageRange;
	}
	public static String getBoard() {
		return board;
	}
	public static void setBoard(String board) {
		InputTools.board = board;
	}
	
	private void initBoard(){
		board = "ParttimeJob";
	}
	private void initPageRange(){
		pageRange = 10;
	}
	private void initKeyWords(){
		keyWords = new ArrayList<>();
		keyWords.add("java");
		keyWords.add("android");
		keyWords.add("安卓");
		keyWords.add("研发");
		keyWords.add("开发");
	}
	public void init(){
		if(!useManualInput){
			initKeyWords();
			initPageRange();
			initBoard();
		}else{

			Scanner sc = new Scanner(System.in);
			System.out.println("请输入想要搜索的板块：");
			if(sc.hasNext()){
				board = sc.next();
			}else{
				initBoard();
			}
			System.out.println("请输入你想搜索的页数，为了保护服务器，最多搜50页哦~：");
			if(sc.hasNext()){
				int pr = Integer.parseInt(sc.next());
				pageRange = pr>50?50:pr;
			}else{
				initPageRange();
			}
			System.out.println("请输入想要搜索的关键词，关键词之间请用空格分隔：");
			if(sc.hasNext()){
				while(sc.hasNext()){
					keyWords.add(sc.next());
				}
			}else{
				initKeyWords();
			}
			
		
		}
	}

}
