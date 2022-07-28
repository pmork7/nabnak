package com.revature.nabnak.menus;

import java.io.BufferedReader;

public abstract class Menu { // abstract classs
    protected String name; // this only allows any class within the package or sub-class (any extending Menu) to have access to this attribute
    protected String route;
    protected BufferedReader terminalReader; //Dependency Injection - as a requirement for the class to function that you want to inject at Instantiate

    public Menu(String name, String route, BufferedReader terminalReader){
        this.name = name;
        this.route = route;
        this.terminalReader = terminalReader;
    }

    public String getName(){
        return name;
    }

    public String getRoute(){
        return route;
    }

    // Adding abstract keyword requires that any class that inherits this Menu class MUST implement it
    public abstract void render();
}
