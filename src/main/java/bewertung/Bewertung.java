package bewertung;

public class Bewertung {
	private int id;
	private int foliengestaltung; // -1 = -, 0 = o, 1 = +
	private int spraclichePresentation; // -1 = -, 0 = o, 1 = +
	private int presentationstil; // -1 = -, 0 = o, 1 = +
	private int zeitlicheGestaltung; // -1 = -, 0 = o, 1 = +
	private int verstandnis; /// -1 = -, 0 = o, 1 = +
	private int inhaltlicheAufbereitung; // -1 = -, 0 = o, 1 = +
	private int verknuepfungMitAnderen; // -1 = -, 0 = o, 1 = +
	private int diskassionFuehrung; // -1 = -, 0 = o, 1 = +
	private int beteiligungDiskassionen; // -1 = -, 0 = o, 1 = +
	private String kommentar;  
	private int bewerterId;
	private int umfang;  // -1 = -, 0 = o, 1 = +
	private int referenzen; // -1 = -, 0 = o, 1 = +
	private int sprachlicheGestaltung; // -1 = -, 0 = o, 1 = +
	private int schwerigkeitsgrad; // -1 = -, 0 = o, 1 = +
	private String bewerterType; // student oder dozent
	
	
	
	
	
	
	
	/**
	 * @param id
	 * @param foliengestaltung
	 * @param spraclichePresentation
	 * @param presentationstil
	 * @param zeitlicheGestaltung
	 * @param verstandnis
	 * @param inhaltlicheAufbereitung
	 * @param verknuepfungMitAnderen
	 * @param diskassionFuehrung
	 * @param beteiligungDiskassionen
	 * @param kommentar
	 * @param bewerterId
	 * 
	 * Es ist für studierenden und Dozenten. 
	 */
	public Bewertung(int id, int foliengestaltung, int spraclichePresentation, int presentationstil,
			int zeitlicheGestaltung, int verstandnis, int inhaltlicheAufbereitung, int verknuepfungMitAnderen,
			int diskassionFuehrung, int beteiligungDiskassionen, String kommentar, int bewerterId) {
		super();
		this.id = id;
		this.foliengestaltung = foliengestaltung;
		this.spraclichePresentation = spraclichePresentation;
		this.presentationstil = presentationstil;
		this.zeitlicheGestaltung = zeitlicheGestaltung;
		this.verstandnis = verstandnis;
		this.inhaltlicheAufbereitung = inhaltlicheAufbereitung;
		this.verknuepfungMitAnderen = verknuepfungMitAnderen;
		this.diskassionFuehrung = diskassionFuehrung;
		this.beteiligungDiskassionen = beteiligungDiskassionen;
		this.kommentar = kommentar;
		this.bewerterId = bewerterId;
	}







	/**
	 * @param id
	 * @param foliengestaltung
	 * @param spraclichePresentation
	 * @param presentationstil
	 * @param zeitlicheGestaltung
	 * @param verstandnis
	 * @param inhaltlicheAufbereitung
	 * @param verknuepfungMitAnderen
	 * @param diskassionFuehrung
	 * @param beteiligungDiskassionen
	 * @param kommentar
	 * @param bewerterId
	 * @param umfang
	 * @param referenzen
	 * @param sprachlicheGestaltung
	 * @param schwerigkeitsgrad
	 * 
	 * Es ist für dozenten. Es gibt extra Bereichen, die nur bei Dozent ausfüllen werden können
	 */
	public Bewertung(int id, int foliengestaltung, int spraclichePresentation, int presentationstil,
			int zeitlicheGestaltung, int verstandnis, int inhaltlicheAufbereitung, int verknuepfungMitAnderen,
			int diskassionFuehrung, int beteiligungDiskassionen, String kommentar, int bewerterId, int umfang,
			int referenzen, int sprachlicheGestaltung, int schwerigkeitsgrad) {
		super();
		this.id = id;
		this.foliengestaltung = foliengestaltung;
		this.spraclichePresentation = spraclichePresentation;
		this.presentationstil = presentationstil;
		this.zeitlicheGestaltung = zeitlicheGestaltung;
		this.verstandnis = verstandnis;
		this.inhaltlicheAufbereitung = inhaltlicheAufbereitung;
		this.verknuepfungMitAnderen = verknuepfungMitAnderen;
		this.diskassionFuehrung = diskassionFuehrung;
		this.beteiligungDiskassionen = beteiligungDiskassionen;
		this.kommentar = kommentar;
		this.bewerterId = bewerterId;
		this.umfang = umfang;
		this.referenzen = referenzen;
		this.sprachlicheGestaltung = sprachlicheGestaltung;
		this.schwerigkeitsgrad = schwerigkeitsgrad;
	}







	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}







	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}







	/**
	 * @return the foliengestaltung
	 */
	public int getFoliengestaltung() {
		return foliengestaltung;
	}







	/**
	 * @param foliengestaltung the foliengestaltung to set
	 */
	public void setFoliengestaltung(int foliengestaltung) {
		this.foliengestaltung = foliengestaltung;
	}







	/**
	 * @return the spraclichePresentation
	 */
	public int getSpraclichePresentation() {
		return spraclichePresentation;
	}







	/**
	 * @param spraclichePresentation the spraclichePresentation to set
	 */
	public void setSpraclichePresentation(int spraclichePresentation) {
		this.spraclichePresentation = spraclichePresentation;
	}







	/**
	 * @return the presentationstil
	 */
	public int getPresentationstil() {
		return presentationstil;
	}







	/**
	 * @param presentationstil the presentationstil to set
	 */
	public void setPresentationstil(int presentationstil) {
		this.presentationstil = presentationstil;
	}







	/**
	 * @return the zeitlicheGestaltung
	 */
	public int getZeitlicheGestaltung() {
		return zeitlicheGestaltung;
	}







	/**
	 * @param zeitlicheGestaltung the zeitlicheGestaltung to set
	 */
	public void setZeitlicheGestaltung(int zeitlicheGestaltung) {
		this.zeitlicheGestaltung = zeitlicheGestaltung;
	}







	/**
	 * @return the verstandnis
	 */
	public int getVerstandnis() {
		return verstandnis;
	}







	/**
	 * @param verstandnis the verstandnis to set
	 */
	public void setVerstandnis(int verstandnis) {
		this.verstandnis = verstandnis;
	}







	/**
	 * @return the inhaltlicheAufbereitung
	 */
	public int getInhaltlicheAufbereitung() {
		return inhaltlicheAufbereitung;
	}







	/**
	 * @param inhaltlicheAufbereitung the inhaltlicheAufbereitung to set
	 */
	public void setInhaltlicheAufbereitung(int inhaltlicheAufbereitung) {
		this.inhaltlicheAufbereitung = inhaltlicheAufbereitung;
	}







	/**
	 * @return the verknuepfungMitAnderen
	 */
	public int getVerknuepfungMitAnderen() {
		return verknuepfungMitAnderen;
	}







	/**
	 * @param verknuepfungMitAnderen the verknuepfungMitAnderen to set
	 */
	public void setVerknuepfungMitAnderen(int verknuepfungMitAnderen) {
		this.verknuepfungMitAnderen = verknuepfungMitAnderen;
	}







	/**
	 * @return the diskassionFuehrung
	 */
	public int getDiskassionFuehrung() {
		return diskassionFuehrung;
	}







	/**
	 * @param diskassionFuehrung the diskassionFuehrung to set
	 */
	public void setDiskassionFuehrung(int diskassionFuehrung) {
		this.diskassionFuehrung = diskassionFuehrung;
	}







	/**
	 * @return the beteiligungDiskassionen
	 */
	public int getBeteiligungDiskassionen() {
		return beteiligungDiskassionen;
	}







	/**
	 * @param beteiligungDiskassionen the beteiligungDiskassionen to set
	 */
	public void setBeteiligungDiskassionen(int beteiligungDiskassionen) {
		this.beteiligungDiskassionen = beteiligungDiskassionen;
	}







	/**
	 * @return the kommentar
	 */
	public String getKommentar() {
		return kommentar;
	}







	/**
	 * @param kommentar the kommentar to set
	 */
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}







	/**
	 * @return the bewerterId
	 */
	public int getBewerterId() {
		return bewerterId;
	}







	/**
	 * @param bewerterId the bewerterId to set
	 */
	public void setBewerterId(int bewerterId) {
		this.bewerterId = bewerterId;
	}







	/**
	 * @return the umfang
	 */
	public int getUmfang() {
		return umfang;
	}







	/**
	 * @param umfang the umfang to set
	 */
	public void setUmfang(int umfang) {
		this.umfang = umfang;
	}







	/**
	 * @return the referenzen
	 */
	public int getReferenzen() {
		return referenzen;
	}







	/**
	 * @param referenzen the referenzen to set
	 */
	public void setReferenzen(int referenzen) {
		this.referenzen = referenzen;
	}







	/**
	 * @return the sprachlicheGestaltung
	 */
	public int getSprachlicheGestaltung() {
		return sprachlicheGestaltung;
	}







	/**
	 * @param sprachlicheGestaltung the sprachlicheGestaltung to set
	 */
	public void setSprachlicheGestaltung(int sprachlicheGestaltung) {
		this.sprachlicheGestaltung = sprachlicheGestaltung;
	}







	/**
	 * @return the schwerigkeitsgrad
	 */
	public int getSchwerigkeitsgrad() {
		return schwerigkeitsgrad;
	}







	/**
	 * @param schwerigkeitsgrad the schwerigkeitsgrad to set
	 */
	public void setSchwerigkeitsgrad(int schwerigkeitsgrad) {
		this.schwerigkeitsgrad = schwerigkeitsgrad;
	}







	/**
	 * @return the bewerterType
	 */
	public String getBewerterType() {
		return bewerterType;
	}







	/**
	 * @param bewerterType the bewerterType to set
	 */
	public void setBewerterType(String bewerterType) {
		this.bewerterType = bewerterType;
	}
	
	
	
}
