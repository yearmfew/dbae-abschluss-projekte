package validierung;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Birol Yilmaz
 *
 */
public class checkFormAddSeminar {

	public Map checkForm(String titel, String thema, String oberbegriff, String beschreibung) {
		Map<String, String> result = new HashMap<String, String>();
		
		Validierung validierung = new Validierung();
		boolean titelCheck = validierung.textFelderCheck(titel);
		boolean themaCheck = validierung.textFelderCheck(thema);
		boolean oberbegriffCheck = validierung.textFelderCheck(oberbegriff);
		boolean beschreibungCheck = validierung.textFelderCheck(beschreibung);

		
		if(!titelCheck) {
			result.put("titelFehler", "Es gibt unerlaubte Zeichnen mit Titel");
		}
		if(!themaCheck) {
			result.put("themaFehler", "Es gibt unerlaubte Zeichnen mit Thema");
		}
		if(!oberbegriffCheck) {
			result.put("oberbegriffFehler", "Es gibt unerlaubte Zeichnen mit Oberbegriff");
		}
		if(!beschreibungCheck) {
			result.put("beschreibungFehler", "Es gibt unerlaubte Zeichnen mit Beschreibung");
		}
		
		return result;
	}
}
