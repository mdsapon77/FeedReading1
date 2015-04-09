package com.appletv.nbcuni.usa.resources;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DataFeed {
	

	static String url;
	static DocumentBuilder db;
	static Document doc;
	static DocumentBuilderFactory dbf;
	
	
	
private static void setUp(String episodesUrl){
	try{
		 
	 dbf = DocumentBuilderFactory.newInstance();
	 db = dbf.newDocumentBuilder();
	 doc = db.parse(new URL(episodesUrl).openStream());
	 doc.getDocumentElement().normalize();
	doc.getDocumentElement().normalize();
	}catch(Exception e){
		
	}
}

public List<String> getShowTitles(String url) throws Exception {
		
    List<String> allShowTitles = new ArrayList<String>();
    setUp(url);
	NodeList nList = doc.getElementsByTagName("item");

	int index=0; 
	for (int temp = 0; temp < nList.getLength(); temp++) {
		
		Node nNode = nList.item(temp);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			try{
			allShowTitles.add(eElement.getElementsByTagName("title").item(0).getTextContent());
			}catch(Exception e){
				
			}
			index++;
		}
	}
	return allShowTitles; 
}

public List<String> getShowCaseTitles(String url) throws Exception {
	
    List<String> allShowCaseTitles = new ArrayList<String>();
    setUp(url);
	NodeList nList = doc.getElementsByTagName("item");

	int index=0; 
	for (int temp = 0; temp < nList.getLength(); temp++) {
		
		Node nNode = nList.item(temp);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			try{
			allShowCaseTitles.add(eElement.getElementsByTagName("title").item(0).getTextContent());
			}catch(Exception e){
				
			}
			index++;
		}
	}
	return allShowCaseTitles; 
}


    public String getShowAssetID(String url, String showTitle) throws Exception {
		
    	String assetID = "";
    	
    	setUp(url);
    	NodeList nList = doc.getElementsByTagName("item");

    	int index=0; 
    	for (int temp = 0; temp < nList.getLength(); temp++) {
    		
    		
    		Node nNode = nList.item(temp);

    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    			Element eElement = (Element) nNode;
    			
    			try{
    				String actualShowTitle=eElement.getElementsByTagName("title").item(0).getTextContent();
    				if(actualShowTitle.equalsIgnoreCase(showTitle)){
    					String assetIdLink=eElement.getElementsByTagName("pl:id").item(0).getTextContent();
    					assetID=assetIdLink.substring(51);
    				}
    			
    			}catch(Exception e){
    				
    			}
    			index++;
    		}
    	}
		return assetID;
    	
	} 
    
    public HashMap<String,String> getShowData(String url) throws Exception {
		
    	HashMap<String,String> showData = new HashMap<String,String>();
    	
    
    	
		return showData;
    	
	} 
    
    public List<String> getShowEpisodeTitles(String url) throws Exception {
		
    	List<String> showEpisodeTitles = new ArrayList<String>();
    	
    	setUp(url);
 	   

    	NodeList nList = doc.getElementsByTagName("item");

    	int index=0; 
    	for (int temp = 0; temp < nList.getLength(); temp++) {
    		Node nNode = nList.item(temp);
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    			Element eElement = (Element) nNode;
    			try{
    				String isClip=eElement.getElementsByTagName("pl1:fullEpisode").item(0).getTextContent();
    				if(isClip.equalsIgnoreCase("true")){
    					showEpisodeTitles.add(eElement.getElementsByTagName("title").item(0).getTextContent());
    			
    				}
    			}catch(Exception e){
    				
    			}
    			index++;}
    	}
        	
    	return showEpisodeTitles;
    	
	} 
public List<String> getShowETitles(String url) throws Exception {
		
    	List<String> showClipTitles = new ArrayList<String>();
    	
    	setUp(url);
    	NodeList nList = doc.getElementsByTagName("item");

    	int index=0; 
    	for (int temp = 0; temp < nList.getLength(); temp++) {

    		Node nNode = nList.item(temp);
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    			Element eElement = (Element) nNode;
    			try{
    				String isClip=eElement.getElementsByTagName("pl1:fullEpisode").item(0).getTextContent();
    				if(isClip.equalsIgnoreCase("false")){
    				showClipTitles.add(eElement.getElementsByTagName("title").item(0).getTextContent());
    			
    				}
    			}catch(Exception e){
    				
    			}
    			index++;
    			

    		}
    	
        	
    	}
    	return showClipTitles;
    	
	} 
    
    public List<String> getShowClipTitles(String url) throws Exception {
		
    	List<String> showClipTitles = new ArrayList<String>();
    	
    	setUp(url);
    	NodeList nList = doc.getElementsByTagName("item");

    	int index=0; 
    	for (int temp = 0; temp < nList.getLength(); temp++) {

    		Node nNode = nList.item(temp);
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    			Element eElement = (Element) nNode;
    			try{
    				String isClip=eElement.getElementsByTagName("pl1:fullEpisode").item(0).getTextContent();
    				if(isClip.equalsIgnoreCase("false")){
    				showClipTitles.add(eElement.getElementsByTagName("title").item(0).getTextContent());
    			
    				}
    			}catch(Exception e){
    				
    			}
    			index++;
    			

    		}
    	
        	
    	}
    	return showClipTitles;
    	
	} 
    
    public List<String> getFeaturedShowTitles(String url) throws Exception {
		
    	List<String> allShowTitles = new ArrayList<String>();
    	
		
		
		return allShowTitles;
    	
	} 
    
 public Boolean isFeaturedShowMostRecentEpisodeAvailable(String url, String showTitle) throws Exception {
		
    	Boolean recentEpisodeAvailable = false;
    	
		
		
		return recentEpisodeAvailable;
    	
	} 
 
    public String getFeaturedShowMostRecentEpisode(String url, String showTitle) throws Exception {
		
    	String mostRecentTitle = "";
    	
		
		
		return mostRecentTitle;
    	
	} 
    
    public HashMap<String,String> getRestrictedEpisodeData(String url) throws Exception {
		
    	HashMap<String,String> showData = new HashMap<String,String>();
    	Boolean authEpisodePresent = false;
    	
    	List<String> showAssetIDs = new ArrayList<String>();
    	
    	
    	return showData;
    	
	} 
	
}


