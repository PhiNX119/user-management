package com.xuanphi.usermanagement.model.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionResponse {

    private Integer businessErrorCode;

    private String businessExceptionDescription;

    private String error;

    private Set<String> validationErrors;

    private Map<String, String> errors;
}