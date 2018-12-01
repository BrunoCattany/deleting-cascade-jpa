package br.com.cattany.study.service.exception;

import br.com.cattany.study.enums.OrphanRemovalOption;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * @author Bruno Cattany
 * @since 03/11/2018
 */
final public class NotFoundOrphanRemovalOptionException extends RuntimeException {

    private final static String ERROR_MESSAGE = "Option not found. Please, choose a number between %s and %s. Available Options: %s";

    public NotFoundOrphanRemovalOptionException(@Nonnull OrphanRemovalOption[] enumValues) {
        super(String.format(ERROR_MESSAGE, getFirstOption(enumValues), getLastOption(enumValues), getAvailableOptions(enumValues)));
    }

    private static String getAvailableOptions(OrphanRemovalOption[] enumValues) {
        return Stream.of(enumValues)
                .map(e -> new StringBuilder()
                        .append("(")
                        .append(e.getOptionNumber())
                        .append(")")
                        .append(" - ")
                        .append(e.name()))
                .collect(joining(", "));
    }

    private static int getFirstOption(OrphanRemovalOption[] enumValues) {
        return enumValues[0].getOptionNumber();
    }

    private static int getLastOption(OrphanRemovalOption[] enumValues) {
        return enumValues[enumValues.length - 1].getOptionNumber();
    }
}
