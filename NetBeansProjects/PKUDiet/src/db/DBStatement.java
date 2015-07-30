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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBStatement {
	private Statement stmt;
	
	public DBStatement(){
		
	}
	
	public DBStatement(DBConnection connect){
		
            try {
                this.stmt = connect.getConnection().createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(DBStatement.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
	
	public ResultSet getQuery(String query) {
            ResultSet rs = null;
            try {
                rs = stmt.executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(DBStatement.class.getName()).log(Level.SEVERE, null, ex);
            }
		return rs;
		
	}

	public void setQuery(String query){
	    try {
                stmt.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(DBStatement.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
	
	
        @Override
	public void finalize() {
		if (stmt != null)
		try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBStatement.class.getName()).log(Level.SEVERE, null, ex);
                }
		
	}
}
