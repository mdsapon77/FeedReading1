package com.appletv.nbcuni.usa.resources;



import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ResponseFromATV {
	

	static String url;
	static DocumentBuilder db;
	static Document doc;
	static DocumentBuilderFactory dbf;
	
	
	
private static void setUp(String episodesUrl){
	try{
	     TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
    };

    // Install the all-trusting trust manager
    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, new java.security.SecureRandom());
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

    // Create all-trusting host name verifier
    HostnameVerifier allHostsValid = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    // Install the all-trusting host verifier
    HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

    URL url = new URL(episodesUrl);
    dbf = DocumentBuilderFactory.newInstance();
	 db = dbf.newDocumentBuilder();
	 doc = db.parse(url.openStream());
	 doc.getDocumentElement().normalize();
	}catch(Exception e){
		
	}
}



public List<String> getShowCaseTitles(String url) throws Exception {
	
    
    setUp(url);
    NodeList nPanList = doc.getElementsByTagName("showcasePoster");
    List<String> allShowCaseTitles=new ArrayList<String>();
	//String[] allShowCaseTitles=new String[nPanList.getLength()];

	int index=0;
	for(int temp = 0 ; temp <nPanList.getLength(); temp++){
		
	Node nNode = nPanList.item(temp);
	
	if(nNode.getNodeType()==Node.ELEMENT_NODE){
		Element eElement = (Element) nNode;
		String mUrl=eElement.getAttribute("accessibilityLabel");
		//allShowCaseTitles[temp]=mUrl;
		allShowCaseTitles.add(mUrl);
			
	}
	
		}
	
	return allShowCaseTitles; 
}

public List<String> getShowsTitles(String url) throws Exception {
	
    
    setUp(url);
    NodeList nPanList = doc.getElementsByTagName("fourByThreePoster");
    List<String> allShowCaseTitles=new ArrayList<String>();
	//String[] allShowCaseTitles=new String[nPanList.getLength()];

	int index=0;
	for(int temp = 0 ; temp <nPanList.getLength(); temp++){
		
	Node nNode = nPanList.item(temp);
	
	if(nNode.getNodeType()==Node.ELEMENT_NODE){
		Element eElement = (Element) nNode;
		String mUrl=eElement.getAttribute("accessibilityLabel");
		//allShowCaseTitles[temp]=mUrl;
		allShowCaseTitles.add(mUrl);
			
	}
	
		}
	
	return allShowCaseTitles; 
}


	
}