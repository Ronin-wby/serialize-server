package source;

import org.json.*;

public class Provincialdata {
	public String setProvincialdata(String data) {
		JSONObject jsonobj = new JSONObject(data);
//		System.out.println(jsonobj);
//		System.out.println("-------end2--------");
		
		JSONObject jsonobj2 = jsonobj.getJSONObject("data");
//		System.out.println(jsonobj2);
//		System.out.println("-------end3------");

		JSONArray array = jsonobj2.getJSONArray("area");
//		System.out.println(array);
//		System.out.println("-------end4------");

		JSONObject jsonobj3 = new JSONObject(array.get(0).toString());
		
//		System.out.println("*****");
//		System.out.println(jsonobj3.toString());
		return jsonobj3.toString();
		
	}
}
