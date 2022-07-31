package com.revature.nabnak.daos;

import com.revature.nabnak.models.Session;
import com.revature.nabnak.util.CustomCollections.LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SessionDao implements Crudable<Session>{
    @Override
    public Session create(Session session) {

        return null;
    }

    @Override
    public Session[] findAll() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("resources/sessions.txt"));
            String line = reader.readLine();
            while (line != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Session findById(String id) {
        return null;
    }

    @Override
    public boolean update(Session updatedSession) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }


}
