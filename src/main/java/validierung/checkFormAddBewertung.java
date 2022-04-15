package validierung;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Birol Yilmaz
 *
 */
public class checkFormAddBewertung {
	/**
	 * Kontrolliert ob kommentar in gewünschte Form ist.
	 * @param kommentar 
	 * @return result (Map) 
	 */
	public Map checkForm(String kommentar) {
		Map<String, String> result = new HashMap<String, String>();
		
		Validierung validierung = new Validierung();
		boolean kommentarFehler = validierung.textFelderCheck(kommentar);
		if(!kommentarFehler) {
			result.put("kommentarFehler", "Es gibt unerlaubte Zeichnen mit Kommentar");
		}
		return result;
	}
}
