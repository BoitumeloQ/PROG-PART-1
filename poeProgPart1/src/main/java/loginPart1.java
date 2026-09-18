/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cash coverters
 */

public class loginPart1 {
//DECLARATIONS
    private String userName;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;
    
    private boolean loginSuccessful;
    private Object Pattern;
    
    public static void loginPart1(){
        
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
       return password.equals(password);
   }
   public boolean checkCellPhoneNumber(String cellNumber){
       if(cellNumber==null){
           return false;
       }
       String cellPattern="^\\+27[0-9]{1,10}$";
       return cellNumber.equals(cellNumber);
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
