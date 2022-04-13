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
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		
	}
	
	
	public Student(String vorname, String nachname, String email,  String matrikelnummer, String studiengang, String seminar, String abschluss, String seminarthema) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
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
	
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public void setNachname(String nachname) {
		this.nachname = nachname;
	}


	public void setMatrikelnummer(String matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}


	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}


	public void setAbschluss(String abschluss) {
		this.abschluss = abschluss;
	}


	public void setSeminarthema(String seminarthema) {
		this.seminarthema = seminarthema;
	}


	public void setSeminar(String seminar) {
		this.seminar = seminar;
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
