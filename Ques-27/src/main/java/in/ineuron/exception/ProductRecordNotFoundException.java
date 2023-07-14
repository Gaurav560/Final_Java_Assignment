package in.ineuron.exception;

public class ProductRecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductRecordNotFoundException(String message) {
		super(message);
	}
}
