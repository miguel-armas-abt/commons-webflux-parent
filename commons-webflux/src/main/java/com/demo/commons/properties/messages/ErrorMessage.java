package com.demo.commons.properties.messages;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ErrorMessage {

  private boolean enabled;

  private Map<String, String> messages;
}