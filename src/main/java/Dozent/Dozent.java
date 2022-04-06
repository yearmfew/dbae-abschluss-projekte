package Dozent;
import Seminar.Seminar;
import java.util.ArrayList;
public class Dozent {

	private int id;
	private String vorname;
	private String nachname;
	private ArrayList<Seminar> seminaren;
	
	
	
	
	
	public Dozent(int id, String vorname, String nachname) {
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
	public ArrayList<Seminar> getSeminaren() {
		return seminaren;
	}
	public void setSeminaren(ArrayList<Seminar> seminaren) {
		this.seminaren = seminaren;
	}
	
	
	
}
