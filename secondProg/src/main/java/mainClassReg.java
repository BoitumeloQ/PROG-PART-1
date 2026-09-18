/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cash coverters
 */
public class mainClassReg {
    //REGISTRATION CLASS 
    //VALIDATING ALL THE CONDITIONS
    
     //IMPLEMENT A CLASS THAT WILL USE METHODS TO CHECK THE VALIDITY OF THE METHODS: 
     // METHOD TO CHECK FOR THE PASSWORD VALIDITY:  
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
        return cellNumber.matches("regex:cellNumberPattern");
}
//Regitering the user
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

    private static boolean checkCellPhoneNumber(String cellNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}


