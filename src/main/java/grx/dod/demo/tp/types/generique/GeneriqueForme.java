package grx.dod.demo.tp.types.generique;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GeneriqueForme {
    private String type;

    private Map<String, Object> attributes;

    public GeneriqueForme(Type type, Object ... attributes) {
        this.type = type.getName();
        this.attributes = new HashMap<>();
        if (attributes!=null) {
            String name;
            for (int pos=0 ; pos<attributes.length ; pos++) {
                name = type.get(pos);
                if (name!=null) {
                    this.attributes.put(name, attributes[pos]);
                }
            }
        }
    }

    public GeneriqueForme(String type, Map<String, Object> attributes) {
        this.type = type;
        this.attributes = new HashMap<>();
        if (attributes!=null) {
            this.attributes.putAll(attributes);
        }
    }

    public String getType() {
        return type;
    }

    public Set<String> attributes() {
        return attributes.keySet();
    }

    public Object get(String attribute) {
        return attributes.get(attribute);
    }

}
