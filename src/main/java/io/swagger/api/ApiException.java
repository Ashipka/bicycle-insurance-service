package io.swagger.api;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-20T17:32:16.528247+02:00[Europe/Warsaw]")
public class ApiException extends Exception {
    private final int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}