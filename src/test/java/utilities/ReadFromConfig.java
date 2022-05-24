package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFromConfig {
	
	public  Properties pro;
	
	public ReadFromConfig() {
		
		try {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//Configurations//config.properties");
			pro=new Properties();
			pro.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String baseUrl() {
		String baseurl=pro.getProperty("baseurl");
		return baseurl;
	}
	
	public String userName() {
		String username=pro.getProperty("username");
		return username;
	}
	
	public String passWord() {
		String password=pro.getProperty("password");
		return password;
	}
	
	public String chromePath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String firefoxPath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	

}
