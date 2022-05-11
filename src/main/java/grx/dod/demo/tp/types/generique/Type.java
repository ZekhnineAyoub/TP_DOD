package grx.dod.demo.tp.types.generique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Type {

    private String name;
    private List<String> attributes;

    public Type(String name, String ... attributes) {
        this.name = name;
        this.attributes = new ArrayList<>();
        if (attributes!=null) {
            this.attributes.addAll(Arrays.asList(attributes));
        }
    }

    public Type(String name, Type parent, String ... attributes) {
        this.name = name;
        this.attributes = new ArrayList<>();
        if (parent!=null) {
            this.attributes.addAll(parent.getAttributes());
        }
        if (attributes!=null) {
            this.attributes.addAll(Arrays.asList(attributes));
        }
    }

    public String getName() {
        return name;
    }

    public String get(int pos) {
        if (pos<attributes.size()) {
            return attributes.get(pos);
        } else {
            return null;
        }
    }

    public List<String> getAttributes() {
        return attributes;
    }

}

