package com.demo.commons.validations.headers;

import java.util.Map;

import com.demo.commons.validations.ParamMapper;
import com.demo.commons.tracing.enums.ForwardedParam;
import com.demo.commons.tracing.enums.TraceParam;

public class DefaultHeadersMapper implements ParamMapper {

  @Override
  public Object map(Map<String, String> params) {
    return DefaultHeaders.builder()
        .channelId(params.get(ForwardedParam.CHANNEL_ID.getKey()))
        .traceParent(params.get(TraceParam.TRACE_PARENT.getKey()))
        .build();
  }

  @Override
  public boolean supports(Class<?> paramClass) {
    return DefaultHeaders.class.isAssignableFrom(paramClass);
  }
}
