/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poeprogpart1;

/**
 *
 * @author cash coverters
 */
import java.util.Scanner;
import org.json.simple.JSONObject;
public class PoeProgPart1 {

    private static Object msg;
    private static Object Message;

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
            
            
            if(login.isLoggedIn()){
                System.out.println();
                System.out.println("Welcome to QuickChat.");
                
                int numMsg=0;
                while(numMsg<=0){
                    System.out.println("How many messages do you wish to send? ");
                    String numInput=myInput.nextLine();
                    
                    try{
                        numMsg=Integer.parseInt(numInput);
                    }
                    catch(NumberFormatException e){
                        System.out.println("Please enter a valid number. ");
                        continue;
                    }
                    if(numMsg <=0){
                        System.out.println("Number must be greater than 0. ");
                    }
                }
               boolean msgsEntd=false;
               boolean running=true;
               while(running){
                   System.err.println();
                   System.out.println("----Menu----");
                   System.out.println("Option 1: Send Messages");
                   System.out.println("Option 2: Show reently sent messages");
                   System.out.println("Option 3: Quit");
                   System.out.println("Choose an option: ");
                   
                   String menuInput=myInput.nextLine();
                   int chooseOption;
                   
                   try{
                       chooseOption=Integer.parseInt(menuInput);
                   }
                   catch (NumberFormatException e){
                       System.out.println("Please enter a number: (1, 2 or 3). ");
                       continue;
                   }
                   if(chooseOption ==1){
                       if(msgsEntd){
                           System.out.println("You have already entered all " + numMsg + "mesages you set at the start. ");
                       }
                       else{
                           sendMessages(myInput, numMsg);
                           msgsEntd=true;
                       }
                   }
                   else if(chooseOption ==2){
                       System.out.println("Coming Soon! ");
                   }
                   else if(chooseOption ==3){
                       System.out.println("Goodbye! ");
                       running=false;
                   }
                   else{
                       System.out.println("Invalid option. Please choose again. ");
                   }
               }
            }
            
        }
        //I CLOSE THE SCANNER ONCE THE PROGRAM IS DONE
        myInput.close();
    }
    
    //BEGINNING OF PART 2
    
    
    private static void sendMessages(Scanner myInput, int numMsg){
        //THE SEND MESSAGES METHOD HANDLES SENDING MULTIPLE MESSAGES BASED ON USER INPUT
        // A FOR LOOP ITERATES THROUGH THE SPECIFIED NUMBER OF MESSAGES
        for(int i=0; i<numMsg; i++){
            System.out.println();
            System.out.println("----Message " + (i+1)+ "of" + numMsg + "----");
            
            //ENTER THE CELLPHONE NUMBER OF THE RECIPIENT 
            String recipient ="";
            boolean recipientOk=false;
            // A WHILE LOOP CONTINUES UNTIL A VALID RECIPIENT PHONE NUMBER IS PROVIDED
            //IT THEN PROMPTS THE USER TO ENTER THE RECIPIENTS CELL NUMBER AND READS INPUT
            while(!recipientOk){
                System.out.print("Enter recipient cell number(with international code,e.g,+271345678): ");
                recipient=myInput.nextLine();
                //HERE I WAS INSTANTIATING A NEW MESSAGES OBJCT WITH THE MESSAGE DETAILS
                Messages tempMsg= new Messages (i, recipient, "test");
                String checkResult=tempMsg.checkRecipientCell();
                System.out.println(checkResult);
                //HERE IT VALIDATES THE CELL NUMBER  BY CALLING THE CELL RECIPIENT METHOD()
                if ( checkResult.equals("Cell phone number successfully captured. ")){
                    recipientOk=true;
                }
            }
            String msgText="";
            boolean messageOk=false;
            while(!messageOk){
                //HERE THE WHILE LOOP PROMPTS THE USER TO TYPE A MESSAGE OF UP TO
                //250 CHARACTERS AND READS THE INPUT
                System.out.print("Enter your message(250 characters max): ");
                msgText=myInput.nextLine();
                //VALIDATION THE CHARACTERS USING THE LENGTH()FUNCTION
                String lengthResult=Message.checkMessageLength(msgText);
                System.out.println(msg.displayMessageID());
                //IT DISPLAYS THE MESSAGE ID AND MESSAGE DETAILS
                
                System.out.println();
                System.out.println("-----Message details------");
                System.out.println(msg.displayMessageDetails());
                //PRESENTATION OF OPTIONS MENU FOR SENDING,DISREGARDING OR STORING THE MESSAGE
                System.out.println();
                System.out.println("What would you like to do? ");
                System.out.println(" 1) Send messages " );
                System.out.println(" 2) Disregard Message ");
                System.out.println(" 3) Store Message to send later ");
                System.out.println("Choose an option: ");
                //IT THEN READS USERS CHOICE AND PARSES IT INTO AN INTEGER INSIDE A TRY BLOCK
                //AND HANDLES INVALID NUMBER FORMATS
                String sendInput=myInput.nextLine();
                int sendChoice;
                
                try{
                    //IT PROCESSES THE CHOICE BY CALLING SENDMESSAGES9SENDCHOICE)AND PRINTS
                    sendChoice=Integer.parseInt(sendInput);
                }
                    catch (NumberFormatException e){
                        System.out.println("Invalid input. Message disregarded");
                        continue;
                    }
                String sendResult=msg.sendMessages(sendChoice);
            System.out.println(sendResult);
               
            }
            System.out.println();
            System.out.println("Total messages sent: " + Message.returnTotalMessages());
            //PRINTS THE TOTAL NUMBER OF MESSAGES SENT.
            System.out.println();
            System.out.println("----All Messages Sent----");
            System.out.println(Message.printMessages());
        }
    }

    private static class login extends Login {

        public login() {
        }
    }
}
