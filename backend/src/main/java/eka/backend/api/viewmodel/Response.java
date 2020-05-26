package eka.backend.api.viewmodel;

import java.util.List;

public class Response<T> {
    private List<T> data;
    private String type;
    private String message;


    private Response() {
        this.data = null;
        this.type = null;
        this.message = null;
    }

    public Response(String type, String message) {
        this();
        this.type = type;
        this.message = message;
    }

    public Response(List<T> data, String type, String message) {
        this.data = data;
        this.type = type;
        this.message = message;
    }

    public List<T> getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }
}