package com.revature.nabnak.util;


import java.io.Reader;

public class SessionManager {
    private Reader fileReader;
    private String[] sessionData;
    private String email;

    public SessionManager(String email) {
        sessionData = new String[4];
        sessionData[0] = email;
    }

    private static void populateData() {
        System.out.println();
    }


}
