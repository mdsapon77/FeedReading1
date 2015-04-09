package com.appletv.nbcuni.usa.homepage;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.appletv.nbcuni.usa.pages.ShowsPage;
import com.appletv.nbcuni.usa.resources.DataFeed;
import com.appletv.nbcuni.usa.resources.ParentTest;
import com.appletv.nbcuni.usa.resources.ResponseFromATV;

public class VerifyShowsPage extends ParentTest{
	
	@Test
	public void verifyATVShowPage() throws Exception{
		DataFeed d=new DataFeed();
		ResponseFromATV r=new ResponseFromATV();
		
		
		List<String>showsFeed=d.getShowTitles(prop.getProperty("showUrl"));
		Reporter.log("Reading Shows Title from Feeds and found "+showsFeed);
		List<String> showsAtv=r.getShowsTitles(prop.getProperty("showsPageUrl"));
		Reporter.log("Reading Shows Title from ATV and found "+showsAtv);
		Assert.assertTrue(showsAtv.equals(showsFeed), "Title did not matched");
		Reporter.log("Shows Titles matched with Feed showcase");
		
	}

}
