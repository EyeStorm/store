package mm.pharmacy.services.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3891534644498426670L;

    public NotFoundException(String accountId) {
        super("No such account with id: " + accountId);
    }
}

