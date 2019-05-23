package com.microservicesdemo.jsousek.models;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class ResponseModel {
    String user;
    String message;

}
