package validierung;

import java.util.HashMap;
import java.util.Map;


public class checkFormEditSeminarData {
	/**
	 * Kontrolliert ob die Form data rictig ist.
	 * es returniert einen result mit size 0 wenn alles okay ist. wir nutzen diese info 
	 * wenn etwas falsh ist es returniert einen result mit fehler name und erklarung. 
	 * 
	 * @param titel
	 * @param thema
	 * @param dozentId
	 * @param oberbegriff
	 * @param beschreibung
	 * @param semster
	 * 
	 */
	public Map checkForm(String titel, int dozentId, String thema, 
			 String oberbegriff, String beschreibung, String semester ) {
		Validierung validierung = new Validierung();
		boolean titelCheck = validierung.textFelderCheck(titel);
		boolean themaCheck = validierung.textFelderCheck(thema);
		boolean oberbegriffCheck = validierung.textFelderCheck(oberbegriff);
		boolean beschreibungCheck = validierung.textFelderCheck(beschreibung); 
		boolean semesterCheck = validierung.textFelderCheck(semester) && validierung.countCheck(semester, 10) ; 

		
		Map<String, String> result = new HashMap<String, String>();
		
		if(titelCheck) {
			result.put("titelHatUnerlaubteZeichnen", "Es gibt unerlaubte Zeichnen mit dieser Titel");
		}
		if (!themaCheck) {
			result.put("themaHatUnerlaubteZeichnen", "Es gibt unerlaubte Zeichnen mit dieser Thema");
	    }
		if (!oberbegriffCheck) {
			result.put("oberbegriffHatUnerlaubteZeichnen", "Es gibt unerlaubte Zeichnen mit dieser Thema.");
		}
		if (!beschreibungCheck) {
			result.put("beschreibungHatUnerlaubteZeichnen", "Es gibt unerlaubte Zeichnen mit dieser Thema.");
		}
		
		if (!semesterCheck) {
			result.put("semesterHatUnerlaubteZeichnen", "Es gibt unerlaubte Zeichnen mit dieser Thema oder es ist mehr als 10 zeichnen.");
		}
		
		return result;
		
	}
}
