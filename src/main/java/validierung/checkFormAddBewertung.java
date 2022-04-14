package validierung;

import java.util.HashMap;
import java.util.Map;

public class checkFormAddBewertung {
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
