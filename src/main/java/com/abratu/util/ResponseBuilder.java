package com.abratu.util;

import com.abratu.entities.Response;
import com.google.gson.Gson;

public class ResponseBuilder {

    public static String buildPositiveResponse(String message) {
        Response response = new Response(Response.SUCCESS, message, "");
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    public static String buildNegativeResponse(String message) {
        Response response = new Response(Response.FAILED, "{}", message);
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}
