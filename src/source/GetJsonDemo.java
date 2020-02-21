package source;
import java.io.*;
import java.net.*;


/**
 * download 疫情数据
 * 
 * @author Ronin_Wang
 *
 */
public class GetJsonDemo {
	
	String data = "";
	
	public String getdata() {
		
		String url = "http://sa.sogou.com/new-weball/page/sgs/epidemic?type_page=pcpop";
		StringBuffer json = new StringBuffer();
		
		try {
			//通过url获得连接

	         URL u = new URL(url);

	         URLConnection yc = u.openConnection();

	         //读取返回的数据

	         BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(),"UTF-8"));

	         String inputline = null;

	         while((inputline=in.readLine())!=null){

	            json.append(inputline);

	         }

	         in.close();
	         String str = json.toString();
	       //找到截取字符串开始位置
	 		int startIndex = str.indexOf("window.__INITIAL_STATE__") + 27;
//	 		System.out.println("startIndex:"+startIndex);
	 		//找到截取字符串结束位置
	 		int endIndex = str.indexOf("</script",startIndex);
//	 		System.out.println("endIndex:"+endIndex);
//	 		System.out.println("-------end3--------");
	 		
	 		//截取字符串
	 		data = str.substring(startIndex, endIndex);
//			System.out.println(data);
			

			
			
		} catch (Exception e) {

	         e.printStackTrace();

	      }
		System.out.println("------end download data---------");
		return data;
		
	}
}
