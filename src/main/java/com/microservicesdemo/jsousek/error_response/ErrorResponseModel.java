package com.microservicesdemo.jsousek.error_response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class ErrorResponseModel {
    String error;
    String message;
}
