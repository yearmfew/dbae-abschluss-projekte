package validierung;

import java.util.regex.Pattern;

public class Validierung {
	public Validierung() {
		
	}
	
	/*
	 * Kontrolliert ob der text fürht zu kein sql injection.
	 * @param text, text zu kontrollieren
	 * @return true oder false
	 * */
	public boolean textFelderCheck(String text) {
		// must be done!!!!
		return true;
	}
	/**
	 * Es kontrolliert ob der Name in der gewünchte Format ist.
	 * @param name, vor- oder nachname
	 * @return true oder false. wenn name gultig ist True usw. 
	 */
	public boolean nameCheck(String name) {
		return Pattern.matches("[A-Z]+([a-z]|[\\- ])*", name);
	}
	/**
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
	// needs to be checked..
	public boolean countCheck(String text, int count ) {
		return Pattern.matches("[A-Z]+([a-z]|[\\- ]){2,"+count+"}", text);
	}
	
	
}
