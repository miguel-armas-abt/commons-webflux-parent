package com.demo.poc.commons.core.errors.exceptions;

import com.demo.poc.commons.core.constants.Symbol;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class FileReadException extends GenericException {

  private static final String EXCEPTION_CODE = "00.00.02";

  public FileReadException(String message) {
    super(
        EXCEPTION_CODE,
        "File is not readable" + Symbol.COLON_WITH_SPACE + message,
        INTERNAL_SERVER_ERROR
    );
  }
}
