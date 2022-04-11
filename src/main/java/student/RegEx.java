package student;

import java.util.regex.Pattern;

public class RegEx {
	
	public static boolean pruefeEmail(String email) {
		return Pattern.matches("([a-z\\.\\-\\+]){2,63}@([a-z\\.\\-\\+]){2,191}", email);
	}

	public static boolean pruefeName(String name) {
		return Pattern.matches("[A-Z]{1}[a-z]+([\\s-]{1})*([A-Z]{1}[a-z]{2,20})*", name);
	}
	
	public static boolean pruefeMatrikelnummer(String matrikelnummer) {
		return Pattern.matches("^[0-9]{6,8}$", matrikelnummer);
	}
	// Noch Fehler die Reihenfolge passt noch nicht
	// aA? -> geht und ist richtig aber Aa? -> geht nicht, muss aber gehen
	public static boolean pruefePasswort(String password) {
		return Pattern.matches("(.*[a-z].*)(.*[A-Z].*)(.*[^(a-zA-Z_0-9)].*)", password);
	}
	//(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^(a-zA-Z_0-9)]) //lookahead funktioniert nicht
}


