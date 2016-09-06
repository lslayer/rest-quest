package com.gk_software.entertainment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by vgogilchyn on 06.09.16.
 */
@Document(collection = "puzzles")
public class Puzzle {
    @Id
    @JsonIgnore
    private String id;
    @JsonIgnore
    private String alias;
    @JsonIgnore
    private final String solution;
    @JsonIgnore
    private final String nextAlias;

    private final String task;

    public Puzzle(String alias, String task, String solution, String nextAlias) {
        this.alias = alias;
        this.task = task;
        this.solution = solution;
        this.nextAlias = nextAlias;
    }

    public String getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public String getTask() {
        return task;
    }

    public String getSolution() {
        return solution;
    }

    public String getNextAlias() {
        return nextAlias;
    }
}
