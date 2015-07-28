package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import connection.DBConnection;
import tabels.Patient;

public class Main {

	public static void main(String[] args) throws SQLException {
		DBConnection connect = new DBConnection("localhost", "olga", "pku", "pku_diet");
		connect.initProperties();
		connect.init();
		Patient p = new Patient(); 
		String query = Patient.getPatientsByName("Пантелей", "Александра");
		ResultSet rs = connect.getQuery(query);
		while(rs.next()){
			p.setID(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setSurname(rs.getString("surname"));
			p.setDateOfBirth(rs.getDate("date_of_birth"));
			p.setGender(rs.getString("gender").charAt(0));
			System.out.println(p);
		}
		/*Scanner sc = new Scanner(System.in);
		p.setSurname(sc.next());
		p.setName(sc.next());
		try {
			p.setDateOfBirth(sc.next());
		} catch (ParseException e) {
			System.out.println("Дата рождения введана неверно. Пожалуйста, попробуйте еще раз!");
			e.printStackTrace();
		}
		p.setGender(sc.next());
		sc.close();
		query = p.addPatient();
		connect.setQuery(query);
		*/
		query = p.changeSurname("Колтун");
		connect.setQuery(query);
		query = Patient.getPatients();
		rs = connect.getQuery(query);
		while(rs.next()){
			p.setID(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setSurname(rs.getString("surname"));
			p.setDateOfBirth(rs.getDate("date_of_birth"));
			p.setGender(rs.getString("gender").charAt(0));
			System.out.println(p);
		}
		
		rs.close();
		connect.finalize();
		
	}

}
