package com.abratu.entities;

public class Response {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    private String status;
    private String data;
    private String detailedMessage;

    public Response(String status, String data, String detailedMessage) {
        this.status = status;
        this.data = data;
        this.detailedMessage = detailedMessage;
    }

    public Response() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }
}
