package tabels;

public class Dish {
	private int id;
	private String name;
	private double weight;
	
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString(){
		return this.id+" "+this.name+" "+this.weight;
	}
	
	public static String getDishes() {
		String query = "SELECT * FROM dish;";
		return query;
	}
	
	public static String getDishesById(int id) {
		String query = "SELECT * FROM dish WHERE id = " + id + ";";
		return query;
	}
	
	public static String getDishesByName(String name) {
		String query = "SELECT * FROM dish WHERE name = '" + name + "';";
		return query;
	}
	
	public String addDish() {
		String query = "INSERT INTO dish (name, weight) VALUES ('"+this.name+"', "+this.weight+");";
		return query;
	}
	
	public String changeName(String newName){
		String query = "UPDATE dish SET name = '"+newName+"' WHERE name = '"+this.name+"';";
		return query;
	}
	
	public String changeWeight(double newWeight){
		String query = "UPDATE dish SET weight = '"+newWeight+"' WHERE weight = '"+this.weight+"';";
		return query;
	}
	
	public String deleteById (){
		String query = "DELETE FROM dish WHERE id = "+this.id+";";
		return query;
	}
	
	public String deleteByName (){
		String query = "DELETE FROM dish WHERE name = '"+this.name+"';";
		return query;
	}
	
}
