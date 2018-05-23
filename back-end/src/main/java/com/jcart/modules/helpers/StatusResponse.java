package com.jcart.modules.helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class StatusResponse<T> {
    
    private T result;
    private String description;
    private int statusCode;
    private Long totalRecords;
    private Long serverTime;

    public StatusResponse() {
}

    public StatusResponse(APIStatus status) {
        this.statusCode = status.getCode();
        this.description = status.getDescription();
    }
    
    public StatusResponse(APIStatus status, T result) {
        this.statusCode = status.getCode();
        this.description = status.getDescription();
        this.result = result;
    }

    public StatusResponse(int status, T result) {
        this.statusCode = status;
        this.result = result;
    }

    public StatusResponse(int status, T result, long totalRecords) {
        this.statusCode = status;
        this.result = result;
        this.totalRecords = new Long(totalRecords);
    }

    public StatusResponse(T result, String description, int statusCode) {
        this.result = result;
        this.description = description;
        this.statusCode = statusCode;
    }

    public StatusResponse(int status, String desc) {
        this.statusCode = status;
        this.description = desc;
    }

}
