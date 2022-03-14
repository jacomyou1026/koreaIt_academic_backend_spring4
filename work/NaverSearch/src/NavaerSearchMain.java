import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

public class NavaerSearchMain {
	
	/**
	 * @param Text검색어
	 * @return 검색결과 title link description
	 * @throws IOException 
	 * 
	 * 
	 */
	
	public static String search(String text) throws IOException {
		String result = null;   
		
		//네이버 블로그 검색 결과를 받음
    	String ClientId= "MWT2ZigEC3jso2N7Q4Uf";
		String ClientSecret= "GuVS0hLBld";
		String apiUrl="https://openapi.naver.com/v1/search/blog.json";
		String msg = null;//변역 결과
		HttpURLConnection con = null;//연결
		DataOutputStream dos=null;
		BufferedReader br = null; //받을때
		
		
		try {
			text = URLEncoder.encode(text,"UTF-8");
			URL url = new URL(apiUrl+"?query=" + text);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", ClientId);
			con.setRequestProperty("X-Naver-Client-Secret", ClientSecret);
			
			int response = con.getResponseCode();
			if(response == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
			}else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			result = new String();
			while(true) {
				String str = br.readLine();
				if(str ==null) {
					break;
				}else {
					result +=str;
				}
			}
			JSONObject json =new JSONObject(result);
			JSONArray arr= json.getJSONArray("items");
			result ="";
			for (int i = 0; i < arr.length(); i++) {
				JSONObject obj = (JSONObject)arr.get(i);
				result += obj.getString("title")+"\n"+obj.getString("bloggername")+"\t"+
						obj.getString("link")+"\n";
				
				
				
			}
			//html 태그 제거
			//String tag = "<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>";
//            titles =title.replaceAll(tag,"");
//            descriptions  =description.replaceAll(tag,"");
//            links  =link.replaceAll(tag,"");
//			
//			
			System.out.println(result);
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;

	}

	public static void main(String[] args) throws IOException {
		
		//검색어 입력
		String text= JOptionPane.showInputDialog("찾을 내용을 입력하세요");
		System.out.println(search(text));
		
		
		
	}
	
}


