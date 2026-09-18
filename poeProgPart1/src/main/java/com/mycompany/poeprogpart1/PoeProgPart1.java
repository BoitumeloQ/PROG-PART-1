/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poeprogpart1;

/**
 *
 * @author cash coverters
 */
import java.util.Scanner;
public class PoeProgPart1 {

    public static void main(String[] args) {
        System.out.println("Registration Feature: ");
          
        Scanner myInput=new Scanner(System.in);
        
        Login login=new login();
        
        //DO A REGISTRATION FEATURE WHEREBY YOU ASK THE USER TO ENTER ALL OF THEIR DETAILS:
        System.out.println("======REGISTRATION====");
        
        System.out.println("Please enter your first name: ");
        String firstName=myInput.nextLine();
        System.out.println("Please enter your surname name: ");
        String lastName=myInput.nextLine();
        System.out.println("Please enter your username(must contain_ and no more than five characters): ");
        String userName=myInput.nextLine();
        System.out.println("Please enter your password(8+ characters, a capital, a letter and a special chatacter): ");
        String password=myInput.nextLine();
        System.out.println("Please enter your South African number(+27): ");
        String cellNumber=myInput.nextLine();
        
        //REGISTERUSER() DOES ALL THE VALIDATION AND OUTPTS THE MESSAGE.
        String registerResult=login.registerUser(userName, password, cellNumber, 
                firstName, lastName);
        System.out.println(registerResult);
        
        //YOU CAN ONLY MOVE TO THE LOGIN PHASE ON YOU HAVE SUCCESSFULLY REGISTERED
        if(registerResult.startsWith("Username successfully captured")){
            System.out.println();
            System.out.println("=====Login====");
            
            System.out.println("Please enter your username: ");
            String loginUsername=myInput.nextLine();
            
            System.out.println("Please enter your password: ");
            String loginPassword=myInput.nextLine();
            
            login.loginUser(loginUsername, loginPassword);
            System.out.println(login.returnLoginStatus());
            
        }
        //I CLOSE THE SCANNER ONCE THE PROGRAM IS DONE
        myInput.close();
    }

    private static class login extends Login {

        public login() {
        }
    }
}
