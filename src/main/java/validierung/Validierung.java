package validierung;

import java.util.regex.*;

import database.DatabaseStudent;
/**
 * 
 * @author Birol Yilmaz, Anas Souseh
 *
 */
public class Validierung {
	public Validierung() {

	}

	/*
	 * @author Birol Yilmaz
	 * Kontrolliert ob der text fürht zu kein sql injection.
	 * 
	 * @param text, text zu kontrollieren
	 * 
	 * @return true oder false
	 */
	public boolean textFelderCheck(String text) {

		
		return Pattern.matches("([A-Z]|[a-z]|\\s+|[\\-|\\&|\\.|\\,|\\:|\\;])*", text);

	}

	/**
	 * @author Anas Souseh
	 * Es kontrolliert ob der Name in der gewünchte Format ist.
	 * 
	 * @param name, vor- oder nachname
	 * @return true oder false. wenn name gultig ist True usw.
	 */
	public boolean nameCheck(String name) {
		return Pattern.matches("[A-Z]+([a-z]|[\\- ])*", name);
	}

	/**
	 * @author Anas Souseh
	 * Es kontrolliert ob email in der gewünschten format ist.
	 * gewünshte Format: 
	 * • Sie besteht aus zwei Teilen, die mit einem @ getrennt werden
	 * • Erlaubte Zeichen sind Kleinbuchstaben, Punkte, Plus und Minus
	 * • Sie ist nicht beliebig lang: Der lokale Teil (vor dem ”@“) ist nicht länger als 63 Zeichen,
	 * • die E-Mail Adresse insgesamt ist nicht länger als 254 Zeichen.
	 * @param email email zu registrieren.
	 * @return true or false. Wenn email gultig ist True usw.
	 */
	public boolean mailCheck(String email) {
		System.out.println(email);
		return Pattern.matches("^([a-z]|[\\+|\\-|\\.]){1,63}[@](([a-z]|[\\+|\\-|\\.]){1,190})$", email);

	}

	// needs to be checked.. Does not work
	public boolean countCheck(String text, int count) {
		return Pattern.matches("[A-Z]+([a-z]|[\\- ]){2," + count + "}", text);
	}


	// anas teil
	//
	public boolean pruefeEmail(String email) {
		return Pattern.matches("([a-z\\.\\-\\+]){1,63}@([a-z\\.\\-\\+]){2,191}", email);
	}
	// name auf 20 begrenzt. besteht aus mind 2 buchstaben

	/**
	 * @author Anas Souseh
	 * @param email
	 * @return
	 */
	public  boolean pruefeEmail(String email) {
		return Pattern.matches("([a-z\\.\\-\\+]){1,63}@([a-z\\.\\-\\+]){2,191}", email);
	}

	public boolean pruefeName(String name) {
		return Pattern.matches("[A-Z]{1}[a-z]+([\\s-]{1})*([A-Z]{1}[a-z]{2,20})*", name);
	}
	// 6-8 zahlen
	public boolean pruefeMatrikelnummer(String matrikelnummer) {
		return Pattern.matches("^[0-9]{6,8}$", matrikelnummer);
	}

	// positive lookahead nach beliebigen matches mit mind 1x alle bedingungen
	// bedingung= 1 groß, 1 klein, 1 sonderzeichen
	// ?=.* syntax für lookahead: versucht pattern in passwort zu finden
	public boolean pruefePasswort(String password) {
		Pattern passwordOK = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[^(a-zA-Z_0-9)])");
		Matcher match = passwordOK.matcher(password);

		// falls ein pattern gefunden wird wird ein match geworfen
		boolean matchExists = match.find();
		System.out.println("matchexists= " + matchExists);
		return matchExists;

		boolean passwordMatch= true;
		if (match == null ) {
			passwordMatch = false;
			
		} 
		return passwordMatch;

	}

	public boolean isEmailExit(String email) {
		boolean isEmailExist = false; // falls keine mail
		// prüft in datenbank ob email existiert
		isEmailExist = DatabaseStudent.isEmailExist(email);
		return isEmailExist;
	}
	

	public boolean benotungsFeldCheck(int bewertung) {
		boolean bewertungRichtig = false;
		if (bewertung == 1 | bewertung == 0 | bewertung == -1) {
			bewertungRichtig = true;
		} 
	return bewertungRichtig;
	
	} 


}
