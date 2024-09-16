package models;

import lombok.Data;

import java.io.InputStream;

@Data
public class Api {

    String name;
    String baseUrl;

    public Api(String name, String baseUrl) {
        this.name = name;
        this.baseUrl = baseUrl;
    }
}
