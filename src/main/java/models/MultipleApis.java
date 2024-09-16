package models;

import java.util.HashMap;
import java.util.Map;

public class MultipleApis {
    private Map<String, Api> apis = new HashMap<>();

    public void MultipleApis(Map<String, Api> apis) {
        this.apis = apis;
    }

    public Api getApi(String name) {
        return apis.get(name);
    }
}
