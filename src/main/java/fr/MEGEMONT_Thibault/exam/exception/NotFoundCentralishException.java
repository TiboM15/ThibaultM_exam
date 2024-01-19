package fr.MEGEMONT_Thibault.exam.exception;

import lombok.Getter;

@Getter
public class NotFoundCentralishException extends RuntimeException {

    private final String type;

    private final String field;

    private final Object value;

    public NotFoundCentralishException(String type, String field, Object value) {
        this.type = type;
        this.field = field;
        this.value = value;
    }
}
