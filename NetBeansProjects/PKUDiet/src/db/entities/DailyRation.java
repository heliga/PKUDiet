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
import java.util.Date;

public class DailyRation {
	private Date date;
	private int patientId;
	private int mealtimeId;
        private int mealId;
	private double weight;
	private int portion;
		
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getMealtimeId() {
		return mealtimeId;
	}
	public void setMealtimeId(int mealtimeId) {
		this.mealtimeId = mealtimeId;
	}
        public int getMealId() {
		return mealId;
	}
	public void setMealId(int mealId) {
		this.mealId = mealId;
        }
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getPortion() {
		return portion;
	}
	public void setPortion(int portion) {
		this.portion = portion;
	}
	
}


