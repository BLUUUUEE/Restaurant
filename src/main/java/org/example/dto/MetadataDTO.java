package org.example.dto;

import org.example.abstractModel.Metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetadataDTO {
    private final static Map<String, Metadata> metadata = new HashMap<>();

    public static Metadata getMetadata(String key) {
        if(metadata.containsKey(key)) {
            return metadata.get(key);
        } else {
            throw new IllegalArgumentException("No such metadata exists");
        }
    }

    public static void addMetadata(String key, Metadata data) {
        metadata.put(key,data);
    }
}
