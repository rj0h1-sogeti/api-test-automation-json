package models;

import lombok.Data;

@Data
public class Api {

    private String scheme;
    private String uri;

    public Api() {
    }
}
