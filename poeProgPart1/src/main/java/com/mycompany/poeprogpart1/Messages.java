/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeprogpart1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//MESSAGE CLASS
       
/**
 *
 * @author Boitumelo Lebepe-ST10527363
 */
    
public class Messages {
//CONSTRUCTOR IS DEFINED AS IS WITHOUT ANY RETURN TYPE ALLOWING IT TO CORRECTLY INSTANTIATE OBJECTS
    public Messages(int i, String recipient1, String test) {
    }
    private String messageID;
    private String recipient;
    private String msgText;
    private String msgHash;
    private int msgNum;
    private int storedEntries=0;
    private int storedCount;
    //THE FOLLOWING STATIC VARIABLES REMAIN PROPERLY SCOPED TO TRACK SHARED DATA ACROSS ALL INSTANCES OF THE CLASSES
    private static int totalMessagesSent=0;
    
    private static String allMessages="";
    
    private static String storedMsgs="";
    
    private static final int storedCounts=0;
    //THE CORRECTED CLASS DECLARATION PROPERLY SETS UP THE BLUEPRINT FOR HANDLING MESSAGES
    public String Messages (int msgNum, String recipient, String msgText){
        return("generateMessageID(), msgNum, recipient, msgText");
        
    }
    public  void Messages(String messageID, int msgNum, String recipient, String msgText){
        this.messageID = messageID;
        this.msgNum = msgNum;
        this.recipient = recipient;
        this.msgText = msgText;
        this.msgHash = createMessageHash();
        //THIS-KEYWORD CORRECTLY ASSIGNS INCOMING PARAMETERS TO THE CLASS'S PRIVATE INSTANCE FIELDS.
    }
    //THIS METHOD BUILDS A RANDOM 10-DIGIT NUMERIC STRING IDENTIFIER USING A RANDOM INSTANCE
    private static String generateMessageID(){
        Random random=new Random();
        String id = "";
           
        for(int i=0; i<10; i++){
            id=id + random.nextInt(10);
        }
        return id;
    }
    // THE CHECK MESSAGES METHOD CHECKS IF THE MESSAGE ID IS NULL OR EMPTY ANND RETURS A BOOLEAN RESULT
    public boolean checkMessageID(){
        if(messageID==null){
            return false;
        }
        return messageID.length()<=0;
    }
    //THE DISPLAY MESSAGES ID METHOD RETURNS A FORMATTED STRING THAT DISPLAYS THE GENERATED MESSAGE ID
    public String displayMessagesID(){
        return "Message ID generated: " + messageID;
    }
    //THIS METHOD EVALUATES IF TEXT EXCEEDS 250 CHARACTERS, RETURNING AN ERROR MESSAGE WITH THE CHARACTER EXCESS
    // OR SUCCESS STATE
    public static String checkMessageLength(String text){
        if(text.length()>250){
            int excess = text.length()-250;
            return "Message exceeds 250 characters by " + excess+ "; please reduce the size. ";
        }
        return "Message ready to send";
    }
    //THIS METHOD INSTANTIATES A LOGIN OBJECT TO VALIDATE THE RECIPIENTS PHONE NUMBER
    public  String checkRecipientCell(){
        Login login=new Login();
        if(login.checkCellPhoneNumber(recipient)){
            return "Cellphone number successfully captured.";
        }
        else{
            return"Cellphone number is incorrectly formatted or does not contain the international code.Please try again.";
        }
    }
    //THIS METHOD BUILDS A CUSTOMIZED ID NUMBER FOR THE MESSAGES
    public String createMessageHash(){
        if(msgText == null|| msgText.trim().equals("")){
            return"";
        }
        String firstTwo=messageID.substring(0,2);
        
        String numberPart=String.valueOf(msgNum);
        //VALIDATES IF IT IS NOT NULL OR EMPTY BEFORE PROCEEDING
        String[] words=msgText.trim().split("\\s+");
        //IT SPLITS THE MESSAGE TEXT INTO WORDS TO RETRIEVE THE FIRST & LAST WORDS
        String firstWord = words[0];
        String lastWord = words[words.length-1];
        //EXTRACTION OF CHARACTERS FOR THE MESSAGE ID AND CONVERS THE MESSAGE NUMBER INTO A STRING
        firstWord=firstWord.replaceAll("[a-zA-Z]", "");
        lastWord=lastWord=lastWord.replaceAll("^a-zA-Z","");
        //CONCATENATION
        String hash=firstTwo + ";" + numberPart + ";" + firstWord + lastWord;
        return hash.toUpperCase();
    }
    //METHOD HANDLES MESSAGES BASED ON A SELECTION CHOICE
    public String sendMessage(int choice){
        if(choice == 1){
            totalMessagesSent++;
            allMessages=allMessages
                    + "MessageID: "+ messageID+ "\n"
                    + "Message Hash: " + msgHash+ "\n"
                    + "Recipient: " + recipient + "\n"
                    + "Message: " + msgText + "\n"
                    + "---\n";
            return "Message successfully sent.";
        }
        else if(choice == 2){
            return "Press 0 to delete the message.";
        }
        else if(choice == 3){
            storeMessage();
            return "Message successfully stored.";
        }
        else{
            return "Invalid option.";
        }
    }
    public static String printMessages(){
        if(allMessages.equals("")){
            return "No messages sent yet.";
        }
        return allMessages;
    }
    public static int returnTotalMessages(){
        return totalMessagesSent;
    }
    private static String escapeJson(String text){
        String result= text.replace("\\","\\\\");
        result=result.replace("\"", "\\\"");
        result=result.replace("\n","\\n");
        return result;
                
    }
    String entry =" {\n"
            + "  \"MessageID\":\"" + escapeJson(messageID) + "\",\n"
            +"    \"MessageNumber\": "+ msgNum + ",\n"
            +"     \"Recipient\":\""+escapeJson(recipient)+"\",\n"
            +"      \"Message\':\""+escapeJson(msgText)+"\",\n"
            +"       \"MessageHash\":\""+escapeJson(msgHash)+"\"\n"
            + "  }";

        private void storeMessage() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    //COUNTS THE NUMBER OF STORED MESSAGES
    if(storedCounts > 0){
          storedEntries=storedEntries + ",\n";

    storedEntries = storedEntries + entry;
    
    
    try{
    FileWriter writer=new FileWriter("messages.json", false);
    writer.write("[n" + storedEntries + "\n]n");
    writer.close();
}
    catch(IOException e){
    System.out.println("Error saving message: " +  e.getMessage());
}
    
//GETTERS METHODS MEANING ENCAPSULATION, DATA WONT BE MANIPULATED
        
public String getMessageID(){
        String messageID = "";
    return messageID;
}
public String getRecipient(){
        String recipient = "";
    return recipient;
}

public String getMsgText(){
        String msgText ="";
    return msgText;
}
public int getMsgNum(){
        int msgNum = 0;
    return msgNum;
}
public String getMessageHash(){
        String msgHash="";
    return msgHash;
}
public String displayMessageDetails(){
    return "Message ID: " + messageID + "\n"
            + "Message Hash: " + msgHash + "\n"
            + "Recipient: " + recipient + "\n"
            + "Message: " + msgText;
}
    
}

