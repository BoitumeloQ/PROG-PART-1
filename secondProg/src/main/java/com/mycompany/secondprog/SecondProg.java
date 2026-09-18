/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.secondprog;

/**
 *
 * @author cash coverters
 */
import java.util.Scanner;
public class SecondProg {

    public static void main(String[] args) {
        
        System.out.println("Registration Feature!");
        
        //DECLARATIONS
        String firstName="";
        String lastName="";
        String userName;
        String password;
        String cellNumber;
        String regUsername="";
        String regPassword="";
         
        //CREATION OF AN ACCOUNT
        //PROMPTING THE USER TO ENTER NAMES AND THE PASSWORD
        Scanner myInput= new Scanner(System.in);
        System.out.println("REGISTRATION");
        System.out.println("Please enter your first name: ");
        firstName=myInput.nextLine();
        System.out.println("Please enter your surname: ");
        lastName=myInput.nextLine();
       
        //USE A WHILE THAT CHECKS ALL CONDITIONS ARE MET:
        //USE A WHILE LOOP TO CHECK IF THE USERNAME HAS AN UNDERSCORE
        
        while(true){  //dont forget to remove the while trues
            System.out.print("Please enter your username ");
            userName=myInput.nextLine();
            
            //USE AN IF STATEMENT TO CHECK IF THE USERNAME HAS AN _ AND IS <=5
            if(userName.contains("_") && userName.length()<=5){
                System.out.println("Username is successfully captured! ");
                break;
            }
            else{
                System.out.println("Username is not correctly formatted; " + 
                        "please ensure that your username contains an underscore '_'" + 
                        "and is no more than five characters long.");
            }
        }
       //ENTERING A PASSWORD AND CHECKING ITS COMPLEXITY
       //USE A WHILE LOOP TO ENSURE THAT THE PASSWORD ENTERED MEETS ALL THE CONDITIONS
       while(true){
           System.out.println("Please enter your password: ");
           password=myInput.nextLine();
           
           //USE AN IF STATEMENT TO ENSURE THE PASSWORD MEETS THE COMPLEXITY
           if(password.length()>=8){
               System.out.println("Password successfully captured! ");
               break;
           }
           else{
               System.out.println("Password is not correctly formatted; " + 
                       "please ensure that the password contains atleast 8 characters, " + 
                       "a letter, " + "a number, " +"and a special character. " );
            }
       }
       //CELLPHONE NUMBER VALIDATION USING THE SOUTH AFRICAN CODE: 
       //USE THE REGEX METHOD
       //USE A WHILE LOOP TO ENTER THE CELLPHONE NUMBER:
       while(true){
           System.out.println("Please enter your South African cellpone number: ");
           cellNumber=myInput.nextLine();
           
           //USE AN IF STATEMENT TO VALIDATE THE CELLPHONE NUMBER: 
           if( cellNumber.contains("+27")){
               System.out.println("Cellphone number successfully added!");
               break;
           }
           else{
               System.out.println("Cellphone number incorrectly formatted "+
                       "or does not contain international code");
           }
       }
    
     //COMPLETE THE REGISTRATION FEATURE AND MAKE SURE THE USER CAN ENTER AGAIN:
    //STORE REGISTRATION DETAILS IF VALIDATION PASSES:(USE IF CASCADING STATEMENTS
     //IMPLEMENT A CLASS THAT WILL USE METHODS TO CHECK THE VALIDITY OF THE METHODS: 
     // METHOD TO CHECK FOR THE PASSWORD VALIDITY: 
     
     if(regPassword == password){
         System.out.print("Password is successfully captured. ");
     }
 else if(regUsername == userName){
      System.out.print("Username is successfully entered. ");
  }
 else{
     System.out.print(" Password or username is incorrect, please try again. ");
 }
    }
    //MAIN METHOD TO RUN THE REGISTRATION FEATURE:
    
        
    }
    public static boolean checkPasswordComplexity(String password) {

        // CHECK IF PASSWORD HAS ATLEAST 8 CHARACTERS
        if (password.length() < 8) {
            return false;
        }
    
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        // CHECKING FOR EACH CHARACTER IN THE PASSWORD
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            // CHECKING  FOR A CAPITAL LETTER
            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            }

            // CHECKING FOR A NUMBER
            if (Character.isDigit(ch)) {
                hasNumber = true;
            }

            // CHECKING FOR A SPECIAL CHARACTER
            if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }
     // PASSWORD RETURNS AS VALID IF ALL THE REQUIREMENTS ARE MET: 
        return hasCapital && hasNumber && hasSpecial;
    }

    //USE ANOTHER METHOD TO CHECK THE VALIDITY OF THE USERNAME: 
    public static boolean checkUserName(String userName){
        if(userName.length() <=5){
            return true;
            
        }
        for(int i=0; i<userName.length(); i++){
        } 
        return false;
    }
    //USE THE REGEX FORMAT TO VALIDATE THE CELLPHONE TO SOUTH AFRICAN CODE
    //CODE SOURCED FROM CHATGBT AND W3SCHOOLS
    
public static boolean checkCellPhone(String cellNumber){
    String cellNumberPattern= "^(\\+27|27|0)[6-8]\\d{8}$";
        String regex = null;
        return cellNumber.matches("regex:cellNumberPattern");
}
//login the user
public static String registerUser(String userName, String password, String cellNumber){
    if (!checkUserName(userName)){
        return "Username is not correctly formatted; please ensure " +
                "that the username contains underscore and is " +
                "no more than five characters long. ";
    }
    else if(!checkPasswordComplexity(password)){
        return "Password is not correctly formatted; please ensure " +
                "that the password contains at least eight characters, "+
                "a capital letter, a number, and a special character. ";
    }
    else if(!checkCellPhoneNumber(cellNumber)){
        return "Cell number is incorrectly formatted or does not "+ 
                "contain an international code; please try again.";
    }
    else{
        return "User is succcessfully registered! ";
    }
      
        }
//VALIDATE THE USERNAME:
public static boolean checkUsername(String userName){
    return userName.contains("_") && userName.length()<=5;
}

//AUTHENTICATE USER CREDENTIALS
public static boolean loginUser(String userName,String password){
    String regPassword="";
    String regUsername="";
    
    return userName.equals(regUsername) && password.equals(regPassword);
}
        //RETURNS THE STATUS MESSAGE GOR LOGIN SUCCESS OR FAILURE
public static String returnLoginStatus(boolean isLoggedIn){
    if(isLoggedIn){
        String firstName="";
        String lastName="";
        return "Welcome "+ firstName + "," + lastName + "it is great to see you again.";
    }
    else{
        return "Username or password is incorrect, please try again.";
    }
}


    private static boolean checkCellPhoneNumber(String cellNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }







//THIS CLASS BASICALLY VALIDATES THE INPUT INFORMATION FROM THE USER AND IT ALSO REGISTERS ANY NEW USERS.
    //IT FURTHERMORE ALLOWS THEM TO LOG BACK IN USING THE SAME DETAILS
    //ACCORDING TO THE POE, THE LOGIN CLASS HAS TO HAVE ALL THE METHODS IN IT.
//DECLARATIONS
    private String userName;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;
    
    private boolean loginSuccessful;
    
    public Login(){
        
    }
    public boolean checkUserName(String UserName){
        if (userName==null){
            return false;
        }
    
    return userName.contains("_") && userName.length()<=5;
    }
   public boolean checkPasswordComplexity(String password) {
       if(password==null){
           return false;
       }
       String passwordPattern="^^(?=.[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\[\\]{};'.<>/?]).{8,}$";
       return Pattern.matches(passwordPattern, password);
   }
   public boolean checkCellPhoneNumber(String cellNumber){
       if(cellNumber==null){
           return false;
       }
       String cellPattern="^\\+27[0-9]{1,10}$";
       return Pattern.matches(cellPattern, cellNumber);
   }
   public String registerUser(String userName, String passsword, String cellNumber, 
           String firstName, String lastName){
       
       if(!checkUserName(userName)){
           return "Username is not correctly formatted; please ensure that your username contains"+
                   "an underscore and is no more than five characters long.";
       }
       if(!checkPasswordComplexity(password)){
           return "Password is not correctly formatted; please ensure that the password contains"+
                   "at least eight characters, a capital letter, a number and a special character";
       }
       if(!checkCellPhoneNumber(cellNumber)){
           return "Cell phone number is incorrectly formatterd or does not contain" +
                   "international code; please correct the number and try again";
       }
       this.userName=userName;
       this.password=password;
       this.cellNumber=cellNumber;
       this.firstName=firstName;
       this.lastName=lastName;
       
       return "Username succesfully captured.Password successfully captured.Cellphone number is successfully added";
       
   }
   public boolean loginUser(String enteredUsername, String enteredPassword){
       if(userName==null || password==null){
           
           loginSuccessful=false;
           
           return false;
       }
       loginSuccessful=userName.equals(enteredUsername) && password.equals(enteredPassword);
       return loginSuccessful;
   }
   public String returnLoginStatus(){
       if(loginSuccessful){
           return "Welcome"+ firstName + "," + lastName + "it is great to see you again. ";
       }
       else{
           return "Username or password incorrect; please try again. ";
       }
   }
}
