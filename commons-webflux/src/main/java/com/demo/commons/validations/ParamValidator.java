package com.demo.commons.validations;

import com.demo.commons.restserver.utils.RestServerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ParamValidator {

  private final List<ParamMapper> paramMappers;
  private final BodyValidator bodyValidator;

  public <T> Mono<Map.Entry<T, Map<String, String>>> validateHeadersAndGet(ServerRequest serverRequest, Class<T> paramClass) {
    Map<String, String> headers = RestServerUtils.extractHeadersAsMap(serverRequest);
    return validateAndGet(headers, paramClass);
  }

  public <T> Mono<Map.Entry<T, Map<String, String>>> validateQueryParamsAndGet(ServerRequest serverRequest, Class<T> paramClass) {
    Map<String, String> queryParams = RestServerUtils.extractQueryParamsAsMap(serverRequest);
    return validateAndGet(queryParams, paramClass);
  }

  public <T> Mono<Map.Entry<T, Map<String, String>>> validateFormDataAndGet(ServerRequest serverRequest, Class<T> paramClass) {
    return RestServerUtils.extractFormDataAsMap(serverRequest)
        .flatMap(formData -> validateAndGet(formData, paramClass));
  }

  public <T> Mono<Map.Entry<T, Map<String, String>>> validateAndGet(Map<String, String> paramsMap, Class<T> paramClass) {
    ParamMapper<T> mapper = ParamMapper.selectMapper(paramClass, paramMappers);
    Map.Entry<T, Map<String, String>> tuple = mapper.map(paramsMap);
    return bodyValidator.validateAndGet(tuple.getKey())
        .map(params -> tuple);
  }
}