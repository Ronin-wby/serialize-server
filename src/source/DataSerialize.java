package source;

import java.text.SimpleDateFormat;
import java.util.Date;

import source.DemoSerializer.Demo;
import source.DemoSerializer.Demo.Builder;


public class DataSerialize {
	

	// 序列化
	public byte[] serialize(String data) {
		Builder builder = DemoSerializer.Demo.newBuilder();
		String message = new Provincialdata().setProvincialdata(data);
		builder.setFileName("疫情最新数据").setSendDate(getStringDate()).setFileContent(message);
		
		Demo demo = builder.build();
		
		byte[] byteArray = demo .toByteArray();

		
		return byteArray;
	}
	
	
	public  String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

}// end class
