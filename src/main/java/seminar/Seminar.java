package seminar;
import dozent.Dozent;
import student.Student;
public class Seminar {

	private int id;
	private String titel;
	private Dozent dozent;
	private String oberbegriff;
	private String thema;
	private String beschreibung;
	private Student zugewissenerStudent;
	private String semester;
	private boolean status;
	
	
	
	public Seminar(int id, String titel, String oberbegriff, String beschreibung, String thema,
			 String semester, boolean status) {
		super();
		this.id = id;
		this.titel = titel;
		this.oberbegriff = oberbegriff;
		this.thema = thema;
		this.beschreibung = beschreibung;
		this.semester = semester;
		this.status = status;
		
	}
	
	
	public Seminar(int id, String titel, Dozent dozent, String oberbegriff, String beschreibung,
			Student zugewissenerStudent, String semester, boolean status) {
		super();
		this.id = id;
		this.titel = titel;
		this.dozent = dozent;
		this.oberbegriff = oberbegriff;
		this.beschreibung = beschreibung;
		this.zugewissenerStudent = zugewissenerStudent;
		this.semester = semester;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public Dozent getDozent() {
		return dozent;
	}
	public void setDozent(Dozent dozent) {
		this.dozent = dozent;
	}
	public String getOberbegriff() {
		return oberbegriff;
	}
	public void setOberbegriff(String oberbegriff) {
		this.oberbegriff = oberbegriff;
	}
	
	
	public String getThema() {
		return thema;
	}


	public void setThema(String thema) {
		this.thema = thema;
	}


	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Student getZugewissenerStudent() {
		return zugewissenerStudent;
	}
	public void setZugewissenerStudent(Student zugewissenerStudent) {
		this.zugewissenerStudent = zugewissenerStudent;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String isStatus() {
		if(status == true) return "belegt";
		return "frei";
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		
		this.status = status;
	}
}
