import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.JOptionPane;

import org.json.JSONObject;
import org.json.JSONTokener;

public class PaPaGoMain {

	/**
	 * 
	 * @param target번역할 언어코드
	 * @param text 번역할 내용
	 * @return 번역 결과
	 */

	public static String papagoTranslate(String target, String text) {
		String ClientId= "MWT2ZigEC3jso2N7Q4Uf";
		String ClientSecret= "GuVS0hLBld";
		String apiUrl="https://openapi.naver.com/v1/papago/n2mt" ;
		String msg = null;//변역 결과
		HttpURLConnection con = null;//연결
		DataOutputStream dos=null;
		BufferedReader br = null; //받을때
		
		try {
			//ctrl+1 try/catch자동완성
			
			text = URLEncoder.encode(text,"UTF-8");
			//url연결
			URL url = new URL(apiUrl);
			con = (HttpURLConnection)url.openConnection();
			//header설정
			con.setRequestMethod("POST");
			con.setRequestProperty("X-Naver-Client-Id", ClientId);
			con.setRequestProperty("X-Naver-Client-Secret", ClientSecret);
			con.setDoOutput(true);
			
			//데이터 전송
			dos = new DataOutputStream(con.getOutputStream());
			String postParams = "source=ko&target="+target+"&text="+text;//쿼리스트링
			dos.writeBytes(postParams);//보내기
			dos.flush();//전송
			dos.close();
			
			//응답
			int responseCode = con.getResponseCode(); //응답 코드 받음
			if(responseCode ==HttpURLConnection.HTTP_OK)//200
				{
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {//에러일떄
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			msg = new String();
			while(true) {
				String str = br.readLine();
				if(str==null) break;
				msg +=str;
			}
			//변역된 내용만 msg에 저장장
			JSONObject json = new JSONObject(msg);
			msg = json.getJSONObject("message").getJSONObject("result").getString("translatedText");
			 	
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return msg;

	}

	public static void main(String[] args) {
		String text= JOptionPane.showInputDialog("번역할 내용을 입력하세요");
		System.out.println(papagoTranslate("en", text));
		
	}
}
