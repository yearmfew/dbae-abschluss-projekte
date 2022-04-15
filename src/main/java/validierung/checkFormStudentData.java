package validierung;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Anas Souseh
 *
 */
public class checkFormStudentData {
	public Map checkForm(String vorname, String nachname, String email, String passwort, String studiengang,
			String matrikelnummer, String seminar, String abschluss, String seminarthema) {

		Validierung validierung = new Validierung();
		boolean emailCheck = validierung.pruefeEmail(email);
		boolean nachnameCheck = validierung.pruefeName(nachname);
		boolean vornameCheck = validierung.pruefeName(vorname);
		boolean matrikelnummerCheck = validierung.pruefeMatrikelnummer(matrikelnummer);
		boolean passwortCheck = validierung.pruefePasswort(passwort);
		boolean emailExistAlready = validierung.isEmailExit(email);
		boolean seminarPressed = validierung.isPressed(seminar);
		boolean studiumPressed = validierung.isPressed(studiengang);
		boolean abschlussPressed = validierung.isPressed(abschluss);

		Map<String, String> result = new HashMap<String, String>();

		if (!emailCheck) {
			result.put("emailFormat", "Email entspricht nicht dem Format! ");
		}
		if (!nachnameCheck) {
			result.put("nachnameFormat", "Nachname entspricht nicht dem Format! ");
		}
		if (!vornameCheck) {
			result.put("vornameFormat", "Vorname entspricht nicht dem Format! ");
		}
		if (!matrikelnummerCheck) {
			result.put("matrikelnummerFormat", "Matrikelnummer entspricht nicht dem Format! ");
		}
		if (!passwortCheck) {
			result.put("passwortFormat", "Passwort entspricht nicht dem Format! ");
		}
		if (emailExistAlready) {
			result.put("emailAlreadyUsed", "Es gibt bereits einen Account mit dieser Email");
		} 
		if (!seminarPressed | !studiumPressed | !abschlussPressed) {
			result.put("buttonNotPressed", "Die Auswahl von Seminar, Abschluss, und Studiengang ist Pflicht!");
		}
		return result;

	}
}
