/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.entities;

/**
 *
 * @author olga
 */
public class Mealtime {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
        @Override
	public String toString(){
		return this.id+" "+this.name;
	}
	
	public static String getMealtimes() {
		String query = "SELECT * FROM mealtime;";
		return query;
	}
	
	public static String getMealtimesById(int id) {
		String query = "SELECT * FROM mealtime WHERE id = " + id + ";";
		return query;
	}
	
	public static String getMealtimesByName(String name) {
		String query = "SELECT * FROM mealtime WHERE name = '" + name + "';";
		return query;
	}
	
	public String addMealtime() {
		String query = "INSERT INTO mealtime (name) VALUES ('"+this.name+"');";
		return query;
	}
	
	public String changeName(String newName){
		String query = "UPDATE mealtime SET name = '"+newName+"' WHERE name = '"+this.name+"';";
		return query;
	}
	
	public String deleteById (){
		String query = "DELETE FROM mealtime WHERE id = "+this.id+";";
		return query;
	}
	
	public String deleteByName (){
		String query = "DELETE FROM mealtime WHERE name = '"+this.name+"';";
		return query;
	}
}
