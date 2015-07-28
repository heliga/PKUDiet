package tabels;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Patient {
	private int id;
	private String surname;
	private String name;
	private Date dateOfBirth;
	private char gender;
	
	public void setID(int id){
		this.id=id;
	}
	
	public void setSurname(String surname){
		this.surname=surname;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setDateOfBirth(Date dateOfBirth){
		this.dateOfBirth=dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		this.dateOfBirth = format.parse(dateOfBirth);
	}
	
	public void setGender(char gender){
		this.gender=gender;
	}
	
	public void setGender(String gender){
		this.gender = gender.charAt(0);
	}
	
	public int getID(){
		return this.id;
	}
	
	public String getSurname(){
		return this.surname;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Date getDateOfBirth(){
		return this.dateOfBirth;
	}
	
	public char getGender(){
		return this.gender;
	}
	
	public String toString(){
		return this.id+" "+this.name+" "+this.surname+" "+this.dateOfBirth+" "+this.gender;
	}
	
	public static String getPatients() {
		String query = "SELECT * FROM patient;";
		return query;
	}
	
	public static String getPatientsById(int id) {
		String query = "SELECT * FROM patient WHERE id = "+id+";";
		return query;
	}
	
	public static String getPatientsByName(String surname, String name) {
		String query = "SELECT * FROM patient WHERE surname||name like '"+surname+"'||'"+name+"';";
		return query;
	}
	
	public static String getPatientsByDateOfBirth(Date dateOfBirth) {
		String query = "SELECT * FROM patient WHERE date_of_birth = '"+dateOfBirth+"';";
		return query;
	}
	
	public static String getPatientsByGender(char gender) {
		String query = "SELECT * FROM patient WHERE gender = '"+gender+"';";
		return query;
	}
	
	public static String getIdByName(String name) {
		String query = "SELECT id FROM patient WHERE name = '"+name+"';";
		return query;
	}
	
	public String addPatient() {
		String query = "INSERT INTO patient (surname, name, date_of_birth, gender) VALUES ('"+this.surname+"', '"+this.name+"', '"+this.dateOfBirth+"', '"+this.gender+"');";
		return query;
	}
		
	public String changeSurname(String newSurname){
		String query = "UPDATE patient SET surname = '"+newSurname+"' WHERE surname = '"+this.surname+"';";
		return query;
	}
	
	public String changeName(String newName){
		String query = "UPDATE patient SET name = '"+newName+"' WHERE name = '"+this.name+"';";
		return query;
	}
	
	public String changeDateOfBirth (Date newDateOfBirth){
		String query = "UPDATE patient SET date_of_birth = '"+newDateOfBirth+"' WHERE date_of_birth = '"+this.dateOfBirth+"';";
		return query;
	}
	
	public String changeGender (char newGender){
		String query = "UPDATE patient SET gender = '"+newGender+"' WHERE gender = '"+this.gender+"';";
		return query;
	}
	
	public String deleteById (){
		String query = "DELETE FROM patient WHERE id = "+this.id+";";
		return query;
	}
	
	public String deleteBySurname (){
		String query = "DELETE FROM patient WHERE surname = '"+this.surname+"';";
		return query;
	}
	
	public String deleteByName (){
		String query = "DELETE FROM patient WHERE name = '"+this.name+"';";
		return query;
	}
	
	public String deleteByDateOfBirth (){
		String query = "DELETE FROM patient WHERE date_of_birth = '"+this.dateOfBirth+"';";
		return query;
	}
	
	public String deleteByGender (){
		String query = "DELETE FROM patient WHERE gender = '"+this.gender+"';";
		return query;
	}
	
}
