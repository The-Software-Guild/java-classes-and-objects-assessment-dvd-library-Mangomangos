/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwade.dvdlibrary.dto;

/**
 *
 * @author salajrawi
 */

public class DvD {
    private String title;
    private String releaseDate;
    private String MPAA;
    private String directorsName;
    private String studio;

    private String userRating;


    public DvD() {
    }

    public DvD(String title, String releaseDate, String MPAA, String directorsName, String studio, String userRating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.MPAA = MPAA;
        this.directorsName = directorsName;
        this.studio = studio;
        this.userRating = userRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAA() {
        return MPAA;
    }

    public void setMPAA(String MPAA) {
        this.MPAA = MPAA;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
