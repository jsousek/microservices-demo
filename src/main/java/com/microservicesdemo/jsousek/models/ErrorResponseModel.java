package com.microservicesdemo.jsousek.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponseModel {
    String error;
    String errorMessage;
}
