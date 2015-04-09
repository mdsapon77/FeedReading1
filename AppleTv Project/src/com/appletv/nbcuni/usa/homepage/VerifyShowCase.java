package com.appletv.nbcuni.usa.homepage;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appletv.nbcuni.usa.resources.DataFeed;
import com.appletv.nbcuni.usa.resources.ParentTest;
import com.appletv.nbcuni.usa.resources.ResponseFromATV;

public class VerifyShowCase extends ParentTest{
	
	 
	
	@Test
	public void matchShowCaseTitles() throws Exception{

		DataFeed d=new DataFeed();
		ResponseFromATV r=new ResponseFromATV();
		List<String>showCaseFeed=d.getShowCaseTitles(prop.getProperty("showCaseFeedUrl"));
		Reporter.log("Reading Showcase from Feeds and found "+showCaseFeed);
		List<String> showCaseAtv=r.getShowCaseTitles(prop.getProperty("showCaseUrl"));
		Reporter.log("Reading Showcase from ATV and found "+showCaseAtv);
		Assert.assertTrue(showCaseAtv.equals(showCaseFeed), "Title did not matched");
		Reporter.log("ShowCase Titles matched with Feed showcase");
		
		
	}

}
