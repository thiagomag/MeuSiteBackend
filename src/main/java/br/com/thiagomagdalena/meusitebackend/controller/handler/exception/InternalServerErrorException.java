package br.com.thiagomagdalena.meusitebackend.controller.handler.exception;

import br.com.thiagomagdalena.meusitebackend.controller.handler.dto.ErrorDetails;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends AbstractApiException {

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public InternalServerErrorException(ErrorDetails errorDetails, Throwable cause) {
        super(errorDetails, cause);
    }

    public InternalServerErrorException(String message, String origin) {
        super(message, origin);
    }

    public InternalServerErrorException(String message, String origin, String code) {
        super(message, origin, code);
    }

    public InternalServerErrorException(String message, String origin, Throwable cause) {
        super(message, origin, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
