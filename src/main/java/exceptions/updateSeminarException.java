package exceptions;
/**
 * 
 * @author Birol Yilmaz
 *
 */
public class updateSeminarException extends Exception {
	public updateSeminarException() {
		super("Es gibt ein Problem mit DatabaseSeminar updateSeminar()");
	}
}
