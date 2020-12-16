package domain.common;

public class ErrorMessage {
    private ErrorMessage() {
    }

    public static void print(ErrorMessageException errorMessageException) {
        System.out.println(errorMessageException.getMessage());
    }
}
