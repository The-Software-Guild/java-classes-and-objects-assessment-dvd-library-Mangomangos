/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwade.dvdlibrary.ui;

import com.jwade.dvdlibrary.dto.DvD;

import java.util.List;

/**
 *
 * @author jwade
 */
public class DvdLibraryView {

    private final UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Add new DVD");
        io.print("3. View a DVD");
        io.print("4. Edit a DVD");
        io.print("5. Remove a DVD");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices",1, 6);

    }
    public int printEditMenuAndGetSelection() {
      io.print("DVD Edit Menu");
      io.print("1. Edit release date");
      io.print("2. Edit MPAA rating");
      io.print("3. Edit director's name");
      io.print("4. Edit studio name");
      io.print("5. Edit user rating");
      io.print("6. Exit");
        return io.readInt("Please select from the above choices", 1, 6);
    }
    /*
     This method prompts the user for dvd ID, First Name, Last Name, and Cohort, 
    gathers this information, creates a new dvd object, and returns it to the caller.
     */
    public DvD getNewDvDInfo() {
         String title = io.readString("What is the title of the DVD?");
         String date = io.readString("What is the release date?");
         String mpaaRating = io.readString("What is the MPAA rating?");
         String director = io.readString("What is the director's name?");
         String studio = io.readString("What is the studio's name?");
         String userRating = io.readString("What is the user rating?");
         return new DvD(title, date, mpaaRating, director, studio, userRating);
    }

    /*
    This method simply displays a banner or heading to the UI indicating that 
    the next interactions on the screen will be for creating a new dvd
     */
    public void displayCreateDvDBanner() {
        io.print("=== Create DvD ===");
    }

    /*
    The second method displays a message that the new dvd was successfully created
    and waits for the user to hit Enter to continue
     */
    public void displayCreateSuccessBanner() {
        io.readString(
                "DvD successfully created.  Please hit enter to continue");
    }

    /*
    A method that takes a list of DVD objects as a parameter and displays the information for each Dvd to the screen.
     */
    public void displayDvdList(List<DvD> dvdList) {
        for (DvD dvd: dvdList){
             io.print("Title:" + dvd.getTitle());
             io.print("Release Date:" + dvd.getReleaseDate());
             io.print("MPAA Rating:" + dvd.getMPAA());
             io.print("Director's Name:" + dvd.getDirectorsName());
             io.print("Studio Name:" + dvd.getStudio());
             io.print("User Rating:" + dvd.getUserRating()+ "\n");
         }
        io.readString("Please hit enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===");
    }

    /*
    Shows the Display DVD banner
     */
    public void displayDisplayDvdBanner() {
        io.print("=== Display Dvd ===");
    }

    /*
    Get the dvd title to display information
     */
    public String getDvdTitleChoice() {
        return io.readString("Please enter the dvd title.");
    }

    /*
    Displays the dvd information
     */
    public void displayDvd(DvD dvd) {
        io.print("Title:" + dvd.getTitle());
        io.print("Release Date:" + dvd.getReleaseDate());
        io.print("MPAA Rating:" + dvd.getMPAA());
        io.print("Director's Name:" + dvd.getDirectorsName());
        io.print("Studio Name:" + dvd.getStudio());
        io.print("User Rating:" + dvd.getUserRating()+ "\n");

        io.readString("Please press enter to continue");

    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveResult(DvD dvdRecord) {
       io.print(dvdRecord.getTitle());
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    public void displayEditDvdBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditDvdSuccess() {
        io.readString(
                "DVD successfully Edited.  Please hit enter to continue");
    }

    public void displayEditReleaseDateBanner() {
        io.print("=== Edit DVD Release Date ===");
    }

    public void displayEditMpaaBanner() {
        io.print("=== Edit DVD MPAA rating ===");
    }

    public void displayEditDirectorNameBanner() {
        io.print("=== Edit DVD Director's Name ===");
    }

    public void displayEditStudio() {
        io.print("=== Edit DVD Studio ===");
    }

    public void displayEditUserRating() {
        io.print("=== Edit DVD User Rating ===");
    }

    public String getNewReleaseDate() {
        return io.readString("Please enter new release date.");
    }

    public String getNewMpaaRating() {
        return io.readString("Please enter new MPAA rating.");
    }

    public String getNewDirectorName() {
        return io.readString("Please enter new director's name.");
    }

    public String getNewUserRating() {
        return io.readString("Please enter new user rating.");
    }

    public String getNewStudio() {
        return io.readString("Please enter new studio.");
    }

    public void displayNullDVD() {
        io.print("No such DVD.");
        io.readString("Please hit enter to continue.");
    }

    public void displayDvdListEmptyMessage() {
        io.print("DVD list is empty");
        io.readString("Please hit enter to continue");
    }
}
