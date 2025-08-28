package com.demo.commons.errors.exceptions;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class UnprocessableStreamingData extends GenericException {

  private static final String EXCEPTION_CODE = "00.00.07";

  public UnprocessableStreamingData(String message) {
    super(
        EXCEPTION_CODE,
        "Unprocessable streaming data: " + message,
        INTERNAL_SERVER_ERROR
    );
  }
}
