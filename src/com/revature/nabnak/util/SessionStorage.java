package com.revature.nabnak.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class SessionStorage {
    private Reader fileReader;
    private String[] sessionData;
    private String email;

    public SessionStorage(String email) {
        sessionData = new String[4];
        sessionData[0] = email;
    }

    private static void populateData() {
        System.out.println();
    }


}
