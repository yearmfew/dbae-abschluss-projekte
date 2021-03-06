package seminar;
import dozent.Dozent;
import student.Student;
/**
 * 
 * @author Birol Yilmaz
 *
 */
public class Seminar {

	private int id;
	private String titel;
	private Dozent dozent;
	private int dozentId;
	private String oberbegriff;
	private String thema;
	private String beschreibung;
	private Student zugewissenerStudent;
	private String semester;
	private boolean status;
	
	
	// add semster
	public Seminar( String titel, int dozentId, String oberbegriff, String beschreibung, String thema,
			 String semester, boolean status) {
		super();
		this.titel = titel;
		this.dozentId = dozentId;
		this.oberbegriff = oberbegriff;
		this.thema = thema;
		this.beschreibung = beschreibung;
		this.semester = semester;
		this.status = status;
		
	}
	// in edit semester
	public Seminar( int id, String titel, int dozentId, String oberbegriff, String beschreibung, String thema,
			 String semester, boolean status) {
		super();
		this.id = id;
		this.titel = titel;
		this.dozentId = dozentId;
		this.oberbegriff = oberbegriff;
		this.thema = thema;
		this.beschreibung = beschreibung;
		this.semester = semester;
		this.status = status;
		
	}
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
	
	
	public int getDozentId() {
		return dozentId;
	}


	public void setDozentId(int dozentId) {
		this.dozentId = dozentId;
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
		if(status == true) return "vergeben";
		return "frei";
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		
		this.status = status;
	}
}
