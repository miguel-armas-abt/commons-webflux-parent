package com.demo.commons.errors.exceptions;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class UnexpectedSslException extends GenericException {

  private static final String EXCEPTION_CODE = "00.00.08";

  public UnexpectedSslException(String message) {
    super(
        EXCEPTION_CODE,
        "Unexpected SSL error: " + message,
        INTERNAL_SERVER_ERROR);
  }
}