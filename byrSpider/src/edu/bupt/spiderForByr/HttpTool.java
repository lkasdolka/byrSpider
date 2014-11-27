package edu.bupt.spiderForByr;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpTool {
	public static String parseHttp(String url){
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:33.0) Gecko/20100101 Firefox/33.0");
		httpPost.setHeader("Accept", "*/*");
		httpPost.setHeader("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
		httpPost.setHeader("X-Requested-With", "XMLHttpRequest");
		httpPost.setHeader("Connection","keep-alive");
		// guest cookie
//				httpPost.setHeader("Cookie",
//				"__utma=217424581.1686366337.1411289281.1416828882.1416824449.20; __utmz=217424581.1415869663.10.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); login-user=lkasdolka2; left-index=000001000; nforum[BMODE]=2; __utmc=217424581; __utmb=217424581.66.10.1416824449; nforum[XWJOKE]=hoho; __utmt=1; nforum[UTMPUSERID]=guest; nforum[UTMPKEY]=8856712; nforum[UTMPNUM]=2502");
		
		// lkasdolka2 cookie
//				httpPost.setHeader("Cookie",
//						"__utma=217424581.1686366337.1411289281.1416824449.1416840460.21; __utmz=217424581.1415869663.10.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); login-user=lkasdolka2; left-index=000001000; nforum[BMODE]=2; __utmc=217424581; nforum[XWJOKE]=hoho; nforum[UTMPUSERID]=lkasdolka2; nforum[UTMPKEY]=12868438; nforum[UTMPNUM]=3554; __utmb=217424581.2.10.1416840460; __utmt=1; nforum[PASSWORD]=sexUrYY9sye5LofuOSGzmw%3D%3D");

				
		httpPost.setHeader("Host","bbs.byr.cn");
		httpPost.setHeader("Referer","http://bbs.byr.cn/");
		
		//not neccesary here , only browser can extract the content from gzip
		//		httpPost.setHeader("Accept-Encoding", "gzip, deflate"); 
		
		try {
			HttpResponse response = httpClient.execute(httpPost);
			if(response.getEntity() != null){
				
				return EntityUtils.toString(response.getEntity());
//				System.out.println(contentString);
			}else{
				System.out.println(400);
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally{
			httpClient.getConnectionManager().shutdown();
		}
	}

}
