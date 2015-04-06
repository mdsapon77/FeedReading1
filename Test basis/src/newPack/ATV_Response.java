package newPack;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ATV_Response {

	static String url;
	static DocumentBuilder db;
	static Document doc;
	static DocumentBuilderFactory dbf;
	
	
	public static void setup() throws NoSuchAlgorithmException, KeyManagementException, IOException{
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

     URL url = new URL("https://dev-appletv.nbcuni.com/tv/usa/home?displayOverlay=false");
     URLConnection con = url.openConnection();
	}
	
	public String[] getShowcaseElement(String url) throws MalformedURLException, SAXException, IOException, ParserConfigurationException, KeyManagementException, NoSuchAlgorithmException {
		
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

     URL uurl = new URL(url);
     //URLConnection con = uurl.openConnection();
		dbf = DocumentBuilderFactory.newInstance();
		 db = dbf.newDocumentBuilder();
		 doc = db.parse(uurl.openStream());
		 doc.getDocumentElement().normalize();
		
	 
		NodeList nPanList = doc.getElementsByTagName("showcasePoster");
		String[] showCaseElement=new String[nPanList.getLength()];

		int index=0;
		for(int temp = 0 ; temp <nPanList.getLength(); temp++){
			
		Node nNode = nPanList.item(temp);
		
		if(nNode.getNodeType()==Node.ELEMENT_NODE){
			Element eElement = (Element) nNode;
			String mUrl=eElement.getAttribute("accessibilityLabel");
			showCaseElement[temp]=mUrl;
			//System.out.println(mUrl);
			index++;
		}
		
		}
		return showCaseElement;
		//System.out.println("Total showcase items :"+index);
	
		} 
		
	


public void getShelfTitle(String url) throws MalformedURLException, SAXException, IOException, ParserConfigurationException {

dbf = DocumentBuilderFactory.newInstance();
 db = dbf.newDocumentBuilder();
 doc = db.parse(new URL(url).openStream());
 doc.getDocumentElement().normalize();


NodeList nPanList = doc.getElementsByTagName("shelf");

int index=0;
for(int temp = 0 ; temp <nPanList.getLength(); temp++){
Node nNode = nPanList.item(temp);

if(nNode.getNodeType()==Node.ELEMENT_NODE){
	Element eElement = (Element) nNode;
	String mUrl=eElement.getAttribute("id");
	String[] u=mUrl.split("shelf_");
	System.out.println("Shelf title  :"+u[1]);
	index++;
}

}
System.out.println("Total Shelves present :"+index);

} 

public void getShelfContentsByTitle(String url) throws MalformedURLException, SAXException, IOException, ParserConfigurationException {

dbf = DocumentBuilderFactory.newInstance();
 db = dbf.newDocumentBuilder();
 doc = db.parse(new URL(url).openStream());
 doc.getDocumentElement().normalize();


NodeList nPanList = doc.getElementsByTagName("collectionDivider");

int index=0;
for(int temp = 0 ; temp <nPanList.getLength(); temp++){
Node nNode = nPanList.item(temp);

if(nNode.getNodeType()==Node.ELEMENT_NODE){
	Element eElement = (Element) nNode;
	String mUrl=eElement.getAttribute("id");
	String[] u=mUrl.split("_");
	
	System.out.println(u[1]);
}

}
System.out.println("Total items present in Latest Episodes :"+index);

} 

}
