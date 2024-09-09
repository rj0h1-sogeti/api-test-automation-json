package sogeti.api.context;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Data
public class World {


    private String baseUri;

    private String host;

    private static final Logger LOGGER = LoggerFactory.getLogger(World.class);

    private Map<String, Object> values = new HashMap();

    public void set(String key, Object value) {
        LOGGER.info("setting World for key " + key + " and value " + value.getClass());
        try {
            values.put(key, value);
        }
        catch (Exception e) {
            LOGGER.error("key / value pair could not be set -- check not null");
        }
    }
}
