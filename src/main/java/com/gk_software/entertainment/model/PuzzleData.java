package com.gk_software.entertainment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * Created by vgogilchyn on 06.09.16.
 */

@Document(collection = "puzzle_data")
public class PuzzleData {

    @Id
    private String id;
    private Map<String, Object> data;

    public PuzzleData(Map<String, Object> data) {
        this.data = data;
    }

    public PuzzleData() {
        this.data = new HashMap<String, Object>();
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void put(String path, Object data) {
        this.data.put(path, data);
    }
}
