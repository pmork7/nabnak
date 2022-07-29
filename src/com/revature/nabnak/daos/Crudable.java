package com.revature.nabnak.daos;

public interface Crudable<T> { // generic <T> we can use to assign as
    // Generics help insure type saftey

    int age = 16; // this is a CONSTANT variable, this is unchanging public and final keywords implicit

    // Create
    T create(T newObject);

    //Read
    T[] findAll();
    T findById(String id);

    // Update
    boolean update(T updatedObject);

    //Delete
    boolean delete(String id);

}
