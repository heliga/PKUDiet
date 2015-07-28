package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

		private String host;
		private String root;
		private String password;
		private String nameDB;
		private String url;
		
		private Properties properties = new Properties();
		private Connection postgresqlConnection;
		private Statement stmt;
		
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
				postgresqlConnection = DriverManager.getConnection(url, properties);
				stmt = postgresqlConnection.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		public ResultSet getQuery(String query){
			ResultSet rs = null;
			try {
				rs = stmt.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}
		
		public void setQuery(String query){
			try {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void finalize(){
			try {
				stmt.close();
				postgresqlConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
