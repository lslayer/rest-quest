package com.gk_software.entertainment.model;

/**
 * Created by vgogilchyn on 06.09.16.
 */
public class ResponseToSolution {

    private Boolean right;
    private String linktoNextPuzzle;

    public ResponseToSolution(String linktoNextPuzzle, Boolean right) {
        this.linktoNextPuzzle = linktoNextPuzzle;
        this.right = right;
    }

    public Boolean getRight() {
        return right;
    }

    public void setRight(Boolean right) {
        this.right = right;
    }

    public String getLinktoNextPuzzle() {
        return linktoNextPuzzle;
    }

    public void setLinktoNextPuzzle(String linktoNextPuzzle) {
        this.linktoNextPuzzle = linktoNextPuzzle;
    }
}
