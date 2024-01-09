package excepciones;

/**
 * Excepción personalizada para los errores relacionados con la biblioteca.
 */
public class BibliotecaException extends Exception {

	private static final long serialVersionUID = 9075095558068192043L;

	/**
	 * Constructor vacío de la excepción.
	 */
	public BibliotecaException() {
		super();
	}

	/**
	 * Constructor de la excepción con mensaje y causa.
	 * 
	 * @param message el mensaje de la excepción
	 * @param cause la causa de la excepción
	 * @param enableSuppression indica si la supresión está habilitada o no
	 * @param writableStackTrace indica si el seguimiento de pila se puede escribir o no
	 */
	public BibliotecaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Constructor de la excepción con mensaje y causa.
	 * 
	 * @param message el mensaje de la excepción
	 * @param cause la causa de la excepción
	 */
	public BibliotecaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor de la excepción con mensaje.
	 * 
	 * @param message el mensaje de la excepción
	 */
	public BibliotecaException(String message) {
		super(message);
	}

	/**
	 * Constructor de la excepción con causa.
	 * 
	 * @param cause la causa de la excepción
	 */
	public BibliotecaException(Throwable cause) {
		super(cause);
	}
	
}