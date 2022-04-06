package student;
import java.util.ArrayList;

import seminar.Seminar;
public class Student {
	private int id;
	private String vorname;
	private String nachname;
	private ArrayList<Seminar> beteiligteSeminaren;
	
	
	
	
	public Student(int id, String vorname, String nachname) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public ArrayList<Seminar> getBeteiligteSeminaren() {
		return beteiligteSeminaren;
	}
	public void setBeteiligteSeminaren(ArrayList<Seminar> beteiligteSeminaren) {
		this.beteiligteSeminaren = beteiligteSeminaren;
	}
	
	
}
