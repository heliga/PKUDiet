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
public class ProductDish {
	private int dishId;
        private int productId;
	private double weight;
	
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
        public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
        @Override
	public String toString(){
		return this.dishId+" "+this.productId+" "+this.weight;
	}
	
	public String getRecipe() {
		String query = "SELECT product_id, weight FROM product_dish WHERE dish_id = "+this.dishId+";";
		return query;
	}
        
        public static String getRecipeByDishId(int dishId) {
		String query = "SELECT product_id, weight FROM product_dish WHERE dish_id = "+dishId+";";
		return query;
	}
	
	public String addRecipe() {
		String query = "INSERT INTO product_dish (dish_id, product_id, weight) VALUES ('"+this.dishId+"', "+this.productId+"', "+this.weight+");";
		return query;
	}
	
	public String changeProduct(int newProductId){
		String query = "UPDATE product_dish SET product_id = '"+newProductId+"' WHERE productId = '"+this.productId+"';";
		return query;
	}
	
	public String changeWeight(double newWeight){
		String query = "UPDATE product_dish SET weight = '"+newWeight+"' WHERE weight = '"+this.weight+"';";
		return query;
	}
	
	public String deleteByDishId (){
		String query = "DELETE FROM product_dish WHERE dish_id = "+this.dishId+";";
		return query;
	}
	
	public String deleteByProductId (){
		String query = "DELETE FROM product_dish WHERE product_id = '"+this.productId+"';";
		return query;
	}
	
}
