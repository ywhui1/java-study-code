package k.create;
import java.util.*;
import java.io.*;
public class ReadInit {
	public static String getParam(String name) {
		String value=null;
		try {
			FileInputStream fis=new FileInputStream("init");
			Properties prop=new Properties();
			prop.load(fis);
			value=prop.getProperty(name);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

}
