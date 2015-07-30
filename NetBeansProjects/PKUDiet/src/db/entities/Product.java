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
public class Product {
	private int id;
	private String name;
	private double energy;
        private double protein;
        private double phe;
        private double fats;
        private double carbohydrates;
	
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
	public double getEnergy() {
		return energy;
	}
	public void setEnergy(double energy) {
		this.energy = energy;
	}
        public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
        public double getPhe() {
		return phe;
	}
	public void setPhe(double phe) {
		this.phe = phe;
	}
        public double getFats() {
		return fats;
	}
	public void setFats(double fats) {
		this.fats = fats;
	}
        public double getCarbohydrates() {
		return carbohydrates;
	}
	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	
        @Override
	public String toString(){
		return this.id+" "+this.name+" "+this.energy+" "+this.protein+" "+this.phe+" "+this.fats+" "+this.carbohydrates;
	}
	
	public static String getProducts() {
		String query = "SELECT * FROM product;";
		return query;
	}
	
	public static String getProductById(int id) {
		String query = "SELECT * FROM product WHERE id = " + id + ";";
		return query;
	}
	
	public static String getProductByName(String name) {
		String query = "SELECT * FROM product WHERE name = '" + name + "';";
		return query;
	}
	
	public String addProduct() {
		String query = "INSERT INTO product (name, energy, protein, phe, fats, carbohydrates) VALUES ('"+this.name+"', '"+this.energy+"', '"+this.protein+"', "+this.phe+"', '"+this.fats+"', "+this.carbohydrates+"');";
		return query;
	}
	
	public String changeName(String newName){
		String query = "UPDATE product SET name = '"+newName+"' WHERE name = '"+this.name+"';";
		return query;
	}
	
	public String changeEnergy(double newEnergy){
		String query = "UPDATE product SET energy = '"+newEnergy+"' WHERE energy = '"+this.energy+"';";
		return query;
	}
        
        public String changeProtein(double newProtein){
		String query = "UPDATE product SET protein = '"+newProtein+"' WHERE protein = '"+this.protein+"';";
		return query;
	}
        
        public String changePhe(double newPhe){
		String query = "UPDATE product SET phe = '"+newPhe+"' WHERE phe = '"+this.phe+"';";
		return query;
	}
        
        public String changeFats(double newFats){
		String query = "UPDATE product SET fats = '"+newFats+"' WHERE fats = '"+this.fats+"';";
		return query;
	}
        
        public String changeCarbohydrates(double newCarbohydrates){
		String query = "UPDATE product SET carbohydrates = '"+newCarbohydrates+"' WHERE carbohydrates = '"+this.carbohydrates+"';";
		return query;
	}
	
	public String deleteById (){
		String query = "DELETE FROM product WHERE id = "+this.id+";";
		return query;
	}
	
	public String deleteByName (){
		String query = "DELETE FROM product WHERE name = '"+this.name+"';";
		return query;
	}
	
}
