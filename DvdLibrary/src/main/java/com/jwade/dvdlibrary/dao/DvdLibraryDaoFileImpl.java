/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwade.dvdlibrary.dao;

import com.jwade.dvdlibrary.dto.DvD;

import java.io.*;
import java.util.*;

/**
 *
 * @author jwade
 *
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    public final String DVD_FILE ;
    public static final String DELIMITER = "::";
    /*
    Hash Map to store and retrieve the dvd with title name
     */
    private Map<String, DvD> dvds = new HashMap<>();

    public DvdLibraryDaoFileImpl() {
        DVD_FILE = "dvdTest.txt";
        loadDvdFile();
    }

    @Override
    public DvD addDvd(String title, DvD dvd) throws DvdLibraryDaoException {
        DvD newDvd = dvds.put(title, dvd);
        writeDvdFile();
        return newDvd;

      }

    /*
    This code gets all the DvDs objects out of the dvds map as a collection by calling the values() method.
     */
    @Override
    public List<DvD> getAllDvds() throws DvdLibraryDaoException {
        return new ArrayList<>(dvds.values());
    }

    /*
    This method is quite simple — we just ask the dvds map for the dvd object with the given title and return it
     */
    @Override
    public DvD getDvd(String title)throws DvdLibraryDaoException {
      return dvds.get(title);
    }

    @Override
    public DvD removeDvd(String title) throws DvdLibraryDaoException{
        DvD removedDvd = dvds.remove(title);
        writeDvdFile();
        return removedDvd;
    }

    

    /*
    Method to unmarshall the object or read a line of string
    from the line and convert it into an object
     */
    private DvD unmarshallDvd(String dvdAsText) {
        String [] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        DvD dvdFromFile = new DvD();
        dvdFromFile.setTitle(title);
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setMPAA(dvdTokens[2]);
        dvdFromFile.setDirectorsName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserRating(dvdTokens[5]);
        return dvdFromFile;
    }

    /*
    Method to Load file DVD_FILE into memory
     */
     private void loadDvdFile() {
         try{
             Scanner scanner = new Scanner(
                     new BufferedReader(
                             new FileReader(DVD_FILE)
                     ));
             String currentLine;
             DvD currentDvd;
             while (scanner.hasNextLine()){
                 currentLine = scanner.nextLine();
                 currentDvd = unmarshallDvd(currentLine);
                 dvds.put(currentDvd.getTitle(), currentDvd);
             }
             scanner.close();
         }catch (FileNotFoundException e){
             createFile();
         }
    }

    private void createFile() {
         try{
             File file = new File(DVD_FILE);
             file.createNewFile();
         } catch (IOException e){

         }
    }

    private String marshallDvd(DvD aDvd) {
       String dvdAsText = aDvd.getTitle() + DELIMITER;
       dvdAsText += aDvd.getReleaseDate() + DELIMITER;
       dvdAsText += aDvd.getMPAA() + DELIMITER;
       dvdAsText += aDvd.getDirectorsName() + DELIMITER;
       dvdAsText += aDvd.getStudio() + DELIMITER;
       dvdAsText += aDvd.getUserRating();
       return dvdAsText;
    }

    /**
     * Writes all Dvds in the library out to a DVD_FILE. See loadDvdFile
     * for file format.
     *
     * @throws Exception if an error occurs writing to the file
     */
    private void writeDvdFile() throws DvdLibraryDaoException {

        PrintWriter out;

        try{
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e){
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e
            );
        }

        String dvdAsText;
        List<DvD> dvdList = this.getAllDvds();
        for (DvD currentDvD: dvdList){
            dvdAsText = marshallDvd(currentDvD);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }

    @Override
    public DvD editReleaseDate(String title, String newReleaseDate) throws DvdLibraryDaoException {
       loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setReleaseDate(newReleaseDate);
        writeDvdFile();
        return currentDVD;
    }

    @Override
    public DvD editMPAA(String title, String newMpaaRating) throws DvdLibraryDaoException {
        DvD currentDVD = dvds.get(title);
        currentDVD.setMPAA(newMpaaRating);
        writeDvdFile();
        return currentDVD; 
    }

    @Override
    public DvD editDirectorName(String title, String newDirectorName) throws DvdLibraryDaoException {
        DvD currentDVD = dvds.get(title);
        currentDVD.setDirectorsName(newDirectorName);
        writeDvdFile();
        return currentDVD; 
    }

    @Override
    public DvD editUserRating(String title, String newUserRating) throws DvdLibraryDaoException {
        DvD currentDVD = dvds.get(title);
        currentDVD.setUserRating(newUserRating);
        writeDvdFile();
        return currentDVD;  
    }

    @Override
    public DvD editStudio(String title, String newStudioName) throws DvdLibraryDaoException {
        DvD currentDVD = dvds.get(title);
        currentDVD.setStudio(newStudioName);
        writeDvdFile();
        return currentDVD;    
    }

}
