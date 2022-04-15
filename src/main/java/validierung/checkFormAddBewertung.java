package validierung;

import java.util.HashMap;
import java.util.Map;

public class checkFormAddBewertung {
	public Map checkForm(String kommentar) {
		Map<String, String> result = new HashMap<String, String>();

		Validierung validierung = new Validierung();
		boolean kommentarFehler = validierung.textFelderCheck(kommentar);
		if (!kommentarFehler) {
			result.put("kommentarFehler", "Es gibt unerlaubte Zeichnen mit Kommentar");
		}
		return result;
	}

	public Map checkForm(int foliengestaltung, int spraclichePresentation, int presentationstil,
			int zeitlicheGestaltung, int verstandnis, int inhaltlicheAufbereitung, int verknuepfungMitAnderen,
			int diskassionFuehrung, int beteiligungDiskassionen, int umfang, int referenzen, int sprachlicheGestaltung,
			int schwierigkeitsgrad) {

		Map<String, String> ergebnis = new HashMap<String, String>();
		Validierung validierung = new Validierung();

		boolean umfangfehler = validierung.benotungsFeldCheck(umfang);
		boolean fgFehler = validierung.benotungsFeldCheck(foliengestaltung);
		boolean spFehler = validierung.benotungsFeldCheck(spraclichePresentation);
		boolean psFehler = validierung.benotungsFeldCheck(presentationstil);
		boolean zsFehler = validierung.benotungsFeldCheck(zeitlicheGestaltung);
		boolean verstaendnisFehler = validierung.benotungsFeldCheck(verstandnis);
		boolean iaFehler = validierung.benotungsFeldCheck(inhaltlicheAufbereitung);
		boolean vmaFehler = validierung.benotungsFeldCheck(verknuepfungMitAnderen);
		boolean dfFehler = validierung.benotungsFeldCheck(diskassionFuehrung);
		boolean bDFehler = validierung.benotungsFeldCheck(beteiligungDiskassionen);
		boolean referenzenFehler = validierung.benotungsFeldCheck(referenzen);
		boolean sgFehler = validierung.benotungsFeldCheck(sprachlicheGestaltung);
		boolean skgFehler = validierung.benotungsFeldCheck(schwierigkeitsgrad);

		if (!umfangfehler) {
			ergebnis.put("umfangFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!fgFehler) {
			ergebnis.put("fgFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!spFehler) {
			ergebnis.put("spFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!psFehler) {
			ergebnis.put("psFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!zsFehler) {
			ergebnis.put("zsFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!verstaendnisFehler) {
			ergebnis.put("verstaendnisFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!iaFehler) {
			ergebnis.put("iaFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!vmaFehler) {
			ergebnis.put("vmaFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!dfFehler) {
			ergebnis.put("dfFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!bDFehler) {
			ergebnis.put("bdFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!referenzenFehler) {
			ergebnis.put("referenzenFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!sgFehler) {
			ergebnis.put("sgFehler", "Die Zeichen sind nicht erlaubt!");
		}
		if (!skgFehler) {
			ergebnis.put("skgFehler", "Die Zeichen sind nicht erlaubt!");
		}
		return ergebnis;
	}

}
