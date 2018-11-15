package br.com.cattany.study.service.exception;

/**
 * @author Bruno Cattany
 * @since 03/11/2018
 */
final public class NotFoundOrphanRemovalOptionException extends RuntimeException {

    private final static String ERROR_MESSAGE = "Option not found. Please, choose a number between %s and %s.";

    public NotFoundOrphanRemovalOptionException(int inferiorLimit, int upperLimit) {
        super(String.format(ERROR_MESSAGE, inferiorLimit, upperLimit));
    }
}
