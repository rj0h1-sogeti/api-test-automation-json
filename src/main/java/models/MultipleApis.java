package models;

import java.util.Map;

public class MultipleApis {
    private Map<String, Api> apis;

    public MultipleApis() {
    }

    public Api getApi(String name) {
        return apis.get(name);
    }
}
