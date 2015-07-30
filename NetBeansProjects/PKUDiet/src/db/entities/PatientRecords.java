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

public class PatientRecords {
	private int id;
	private Date date;
	private int patientId;
	private double height;
	private double weight;
	private double phe;
	private String note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getPhe() {
		return phe;
	}
	public void setPhe(double phe) {
		this.phe = phe;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
    /**
     *
     * @return
     */
    @Override
	public String toString(){
		return this.id+" "+this.date+" "+this.patientId+" "+this.height+" "+this.weight+" "+this.phe+" "+this.note;
	}
	
	public static String getPatientRecords() {
		String query = "SELECT * FROM patient_records;";
		return query;
	}
	
	public static String getPatientRecordsById(int id) {
		String query = "SELECT * FROM patient_records WHERE id = " + id + ";";
		return query;
	}
	
	public static String getPatientRecordsByPatientId(int patientId) {
		String query = "SELECT * FROM patient_records WHERE patient_id = " + patientId + ";";
		return query;
	}
	
}

