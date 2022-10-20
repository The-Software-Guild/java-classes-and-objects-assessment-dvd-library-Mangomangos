/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwade.dvdlibrary;

import com.jwade.dvdlibrary.controller.DvdLibraryController;
import com.jwade.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.jwade.dvdlibrary.dao.DvdLibraryDao;
import com.jwade.dvdlibrary.ui.DvdLibraryView;
import com.jwade.dvdlibrary.ui.UserIO;
import com.jwade.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author jwade
 */
public class App {

    public static void main(String[] args) {
        /*
        Instantiate the UserIO, DvdLibraryView,dvdLibraryDao,  DvdLibraryController class and call the run method 
         */
        UserIO io = new UserIOConsoleImpl();

        DvdLibraryView view = new DvdLibraryView(io);

        DvdLibraryDao dao = new DvdLibraryDaoFileImpl();

        DvdLibraryController controller = new DvdLibraryController(view, dao);

        controller.run();
    }

}
