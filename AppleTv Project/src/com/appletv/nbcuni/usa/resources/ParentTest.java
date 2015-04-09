package com.appletv.nbcuni.usa.resources;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class ParentTest {
	
	public Properties prop;
	 public FileInputStream fs;
	@BeforeTest
	public void startUp(){
		
		try{
			prop=new Properties();
			 fs=new FileInputStream(System.getProperty("user.dir")+"/src/com/appletv/nbcuni/usa/resources/config.properties");
			 prop.load(fs);
		}catch(Exception e){
			
		}
		
	}

}
