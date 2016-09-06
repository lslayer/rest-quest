package com.gk_software.entertainment.model;

/**
 * Created by vgogilchyn on 06.09.16.
 */
public class PuzzleSoultion {

    private String solution;

    public PuzzleSoultion(String solution) {
        this.solution = solution;
    }

    public PuzzleSoultion() {
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getSolution() {
        return solution;
    }
}
