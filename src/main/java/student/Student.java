package student;
import java.util.ArrayList;

import seminar.Seminar;
public class Student {
	private int id;
	private String vorname;
	private String nachname;
	private String matrikelnummer;
	private String email;
	private String passwort;
	private String studiengang;
	private String abschluss;
	private String seminarthema;
	private String seminar;
	private ArrayList<Seminar> beteiligteSeminaren;
	
	
	
	public Student(int id, String vorname, String nachname) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		
	}
	
	
	public Student(String vorname, String nachname, String email, String passwort, String matrikelnummer, String studiengang, String seminar, String abschluss, String seminarthema) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.passwort = passwort;
		this.matrikelnummer = matrikelnummer;
		this.studiengang = studiengang;
		this.seminar = seminar;
		this.abschluss = abschluss;
		this.seminarthema = seminarthema;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSeminar() {
		return seminar;
	}

	public String getVorname() {
		return vorname;
	}
	public String getStudiengang() {
		return studiengang;
	}

	public String getAbschluss() {
		return abschluss;
	}

	public String getSeminarthema() {
		return seminarthema;
	}

	public String getNachname() {
		return nachname;
	}
	
	public String getMail() {
		return email;
	}
	public String getMatrikelnummer() {
		return matrikelnummer;
	}
	//public ArrayList<Seminar> getBeteiligteSeminaren() {
	//	return beteiligteSeminaren;
	// }
	public void setBeteiligteSeminaren(ArrayList<Seminar> beteiligteSeminaren) {
		this.beteiligteSeminaren = beteiligteSeminaren;
	}
	
	public String getPasswort() {
		return passwort;
	}
	
}
