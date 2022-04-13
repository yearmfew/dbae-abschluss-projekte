package dozent;
import java.util.ArrayList;

import seminar.Seminar;
public class Dozent {

	private int id;
	private String vorname;
	private String nachname;
	private String titel;
	private String email;
	private ArrayList<Seminar> seminaren;
	
	
	
	
	
	public Dozent(int id, String vorname, String nachname, String titel, String email) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.titel = titel;
		this.email = email;
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
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Seminar> getSeminaren() {
		return seminaren;
	}
	public void setSeminaren(ArrayList<Seminar> seminaren) {
		this.seminaren = seminaren;
	}
	
	
	
}
