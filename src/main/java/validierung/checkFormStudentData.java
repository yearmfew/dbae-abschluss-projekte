package validierung;

import java.util.HashMap;
import java.util.Map;

public class checkFormStudentData {
		public Map checkForm(String vorname, String nachname, String email, String studiengang,
			 String matrikelnummer, String seminar, String abschluss, String seminarthema ) {
		
		Validierung validierung = new Validierung();
		boolean emailCheck = validierung.pruefeEmail(email);
		boolean nachnameCheck = validierung.pruefeName(nachname);
		boolean vornameCheck = validierung.pruefeName(vorname);
		boolean matrikelnummerCheck = validierung.pruefeMatrikelnummer(matrikelnummer);
		// boolean passwortCheck = validierung.pruefePasswort(passwort); 
		boolean emailExistAlready = validierung.isEmailExit(email);

		
		Map<String, String> result = new HashMap<String, String>();
		
		if(!emailCheck) {
			result.put("emailFormat", "Email entspricht nicht dem Format! ");
		}
		if (!nachnameCheck) {
			result.put("nachnameFormat", "Name entspricht nicht dem Format! ");
	    }
		if (!vornameCheck) {
			result.put("vornameFormat", "Name entspricht nicht dem Format! ");
	    }
		if (!matrikelnummerCheck) {
			result.put("matrikelnummerFormat" ,"Matrikelnummer entspricht nicht dem Format! ");
		}
		/* if (!passwortCheck) {
			result.put("emailFormat", "Passwort entspricht nicht dem Format! ");
		} */
		if(emailCheck) {
			result.put("emailAlreadyUsed", "Es gibt bereits einen Account mit dieser Email");
		}
		
		return result;
		
	}
}