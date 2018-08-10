package ua.crm.corporate.exceptions;

public class NotFoundCurrencyException extends Exception {

    public NotFoundCurrencyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "client not found!!!";
    }
}
