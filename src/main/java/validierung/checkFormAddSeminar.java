package validierung;

import java.util.HashMap;
import java.util.Map;

public class checkFormAddSeminar {

	public Map checkForm(String freiText) {
		Map<String, String> result = new HashMap<String, String>();
		
		Validierung validierung = new Validierung();
		boolean freitextCheck = validierung.textFelderCheck(freiText);
		if(!freitextCheck) {
			result.put("freitextFehlet", "Es gibt unerlaubte Zeichnen mit Kommentar");
		}
		return result;
	}
}
