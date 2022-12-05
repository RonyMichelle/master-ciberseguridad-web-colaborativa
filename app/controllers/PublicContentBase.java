package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String type){
        if (isPasswordValid(password)){
            User u = new User(username, HashUtils.getMd5(password), type, -1);
            u.save();
            registerComplete();
        } else {
            flash.error("Password does not match policy");
            register();
        }
    }

    public static void registerComplete(){
        render();
    }


    private static boolean isPasswordValid(String password) {
        return password.length() > 7;
    }
}
