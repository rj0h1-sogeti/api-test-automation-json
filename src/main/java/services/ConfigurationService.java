package services;

import lombok.Data;
import models.Api;
import models.MultipleApis;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

@Data
public class ConfigurationService {

    private MultipleApis apis;
    private Api api;

    public ConfigurationService() {
    }

    private <T> T initializeFromYaml(String yamlFilePath, Class<T> type) {
        try (InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(yamlFilePath)) {
            Yaml yaml = new Yaml(new Constructor(type, new LoaderOptions()));
            return yaml.loadAs(inputStream, type);
        } catch (Exception e) {
            System.err.println("Error reading YAML file: " + e.getMessage());
            return null;
        }
    }

    public void initializeApis() {

        apis = initializeFromYaml("/env/applications.yaml", MultipleApis.class);

        if (apis != null) {
            System.out.println("Object initialized: " + apis);
        } else {
            System.out.println("Failed to initialize object from YAML file.");
        }
    }

}
