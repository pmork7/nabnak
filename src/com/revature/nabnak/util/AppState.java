package com.revature.nabnak.util;

import com.revature.nabnak.menus.DashboardMenu;
import com.revature.nabnak.menus.RegisterMenu;
import com.revature.nabnak.menus.WelcomeMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private static boolean isRunning;
    private final MenuRouter menuRouter;

    public AppState(){
        isRunning = true;
        menuRouter = new MenuRouter();

        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));

        WelcomeMenu welcomeMenu = new WelcomeMenu(terminalReader, menuRouter);
        RegisterMenu registerMenu = new RegisterMenu(terminalReader, menuRouter);
        DashboardMenu dashboardMenu = new DashboardMenu(terminalReader, menuRouter);

        menuRouter.addMenu(welcomeMenu);
        menuRouter.addMenu(registerMenu);
        menuRouter.addMenu(dashboardMenu);

    }

    public void startup(){
        while (isRunning) {
            menuRouter.transfer("/welcome");
        }
    }

    public static void shutdown(){
        isRunning = false;
    }
}
