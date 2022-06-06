package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Conbd {

	private Connection connexio;
	
	/*public Connexio() {
		try {
			
			this.connexio = DriverManager.getConnection("jdbc:mysql://ffames.cat/projecte_amv","fora","Dam2020!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}*/
	
	public Conbd(String host, String bd, int port, String usuari, String contrasenya) {
		try {
			this.connexio = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+bd,usuari,contrasenya);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Conbd() {
		 try
	        {
	     	    SAXBuilder sax = new SAXBuilder();
	            Document doc = (Document) sax.build(".\\config.xml");
	            Element arrel = (Element) doc.getRootElement();
	            
	            List<Element> llista= arrel.getChildren("bbdd"); 
	                for (Element target : llista) {
			            String host = target.getChildText("host");
			            String bd = target.getChildText("bd");
			            String port = target.getChildText("port");
			            String usuari = target.getChildText("usuari");
			            String contraseña = target.getChildText("contrasenya");
			            
						this.connexio = DriverManager.getConnection("jdbc:mysql://"+ host  + ":" + Integer.parseInt(port) + "/" + bd , usuari , contraseña);
	                }
				    		
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
}
	
	public Connection getConexio() {
		return connexio;
	}
}

/*package model;

import java.sql.*;
import java.util.Properties;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conbd {
	
	Connection conn = null;
	
	private String servidor = "localhost";
	private String baseDades = "transpotravelrecu";
	private String usuari = "root";
	private String password = "lugaji123456789";
	
	public Connection getConexio() {
		
		Properties props = new Properties();		
		props.put("user", usuari);
		props.put("password", password);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + baseDades,props);
			
			return conn;
			
		}catch(Exception e) {
			
			System.out.println("Error base de dades " + e.getMessage());
			return null;
			
		}
		
		
	}
	
	
}*/
