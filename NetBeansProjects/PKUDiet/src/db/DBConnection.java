/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author olga
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

		private String host;
		private String root;
		private String password;
		private String nameDB;
		private String url;
		
		private Properties properties = new Properties();
		private Connection postgresqlConnection;
				
		
		public DBConnection(){}
		
		public DBConnection(String host, String root, String password, String nameDB){
			this.host = host;
			this.root = root;
			this.password = password;
			this.nameDB = nameDB;
		}
		
		public DBConnection(String url, Properties properties){
			this.url = url;
			this.properties = properties;
		}
		
		public void initProperties(){
			
			url="jdbc:postgresql://" + host + "/" + nameDB;
			
			properties.setProperty("user",root);
			properties.setProperty("password", password);
			properties.setProperty("characterEncoding", "UTF-8");
			properties.setProperty("useUnicode", "true");
			
			System.out.println("URL: " + url);
		}
		
		public void init() {
			
                    try {
                        Class.forName("org.postgresql.Driver");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        postgresqlConnection = DriverManager.getConnection(url, properties);
                    } catch (SQLException ex) {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
		}
		
		public Connection getConnection(){
			return this.postgresqlConnection;
		}
		
		@Override
		public void finalize(){
		    try {
                        postgresqlConnection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
                    
		}
}
