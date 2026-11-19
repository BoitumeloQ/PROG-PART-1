/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeprogpart1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

    private static Object sentMessagesArray;
    private static Object storedMessagesArray;
    private static Object messageStatusArray;
    private static Object disregardedMessagesArray;
    private static Object allMessagesText;
    private static Object allMessages;
    private static int totalMessagesSent;
    private static Object messageStatusesArray;
    private static Object messagesIDsArray;

    private static String extractJsonString(String line) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void startsWith(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void rebuildStatusesArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void writeStoredMessagesToJson() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void clearArrays() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void rebuildStatusArrays() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void rebuildSentMessagesOutput() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Object messageIDsArray;
    private Object allRecipients;
    private Object messageHashesArray;
    private Object messageNumbersArray;
    private Object result;
    private int storedCounts;
    private Object json;



//MESSAGE CLASS
       
/**
 *
 * @author Boitumelo Lebepe-ST10527363
 */
    
public class Messages {

        private Object messageHashesArray;
        private Object messageIDsArrays;
        private Object messageNumbersArray;
        private Object allMessagesText;
//CONSTRUCTOR IS DEFINED AS IS WITHOUT ANY RETURN TYPE ALLOWING IT TO CORRECTLY INSTANTIATE OBJECTS
    public Messages(String recipient1, int i, String test, String hi_Mike_can_you_join_us_for_dinner_tonigh) {
    }
    private String messageID;
    private String recipient;
    private String msgText;
    private String msgHash;
    private int msgNum;
    private int storedEntries=0;
    private int storedCount;
    private String flag; //Declaration for part 3
    //PART 3
    //I ADDDED THE PARALLEL ARRAYLIST
    public static ArrayList<String>sentMessagesArray= new ArrayList<>();
    public static ArrayList<String>disregardMessagesArray= new ArrayList<>();
    public static ArrayList<String>storedMessagesArray= new ArrayList<>();
    public static ArrayList<String>MessagesHashesArray= new ArrayList<>();
    public static ArrayList<String>messagesIDArray= new ArrayList<>();
    
    
    public static ArrayList<String>allRecipients= new ArrayList<>();
    public static ArrayList<String>allMessagesTest= new ArrayList<>();
    
    public static ArrayList<String>messagesStatusArray= new ArrayList<>();
    public static ArrayList<String>messagesNumbersArray= new ArrayList<>();
    
    
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
    
    
    //PART 3:A METHOD IMPLEMENTED:
    private void addToArrays(){
        messageIDsArrays.add(messageID);
        messageHashesArray.add(messageHash);
        allRecipients.add(recipient);
        allMessagesText.add(messageText);
        messagesStatusArray.add(flag);
        messageNumbersArray.add(messageNumber);
        
        if (flag.equals("Sent")){
            sentMessagesArray.add(messageText);
        }
        else if(flag.equals("Disregard")){
            disregardedMessagesArray.add(messageText);
        }
        else(flag.equals("Stored")){
        storedMessagesArray.add(messageText);
    }
    }
    
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
    //PART 3:
    
    private static void rebuildStatusArray(){
        sentMessagesArray.clear();
        disregardedMessagesArray.clear();
        storedMessagesArray.clear();
        
        if(messageStatusArray.get(i).equals("Sent"))
        {
            sentMessagesArray.add(allMessagesText.get(i));
            
        }
        else if(messageStatusArray.get(i).equals("Disregard")){
            disregardedMessagesArray.add(allMessagesText.get(i));
        }
        else if(messageStatusArray.get(i).equals("Stored")){
            storedMessagesArray.add(allMessagesText.get(i));
        }
    }
}
private static void rebuild void rebuildSentMessagesOutput(){

  allMessages= "";
for (int i=0; i<allMessagesText.size(); i++){
if(messagesStatusesArray.get(i).equals("Sent")){

  allMessages = allMessages
          +"Message ID: " + messageIDsArray.get(i)+"\n"
          +"Message Hash: " + messageHashesArray.get(i) + "\n"
          +"Recipient: " + allRecipients.get(i)+"\n"
          +"Message: "+ allMessagesText.get(i)+"\n"
          + "---\n";
}
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
    //THIS MAKES SURE QUOTES AND SLASHES IN A MESSAGE DONT BREAK.
    private static String escapeJson(String text){
        StringBuilder result= new StringBuilder();
        
        for (int i=0; i < text.length(); i++){
            char c=text.charAt(i);
            
            switch(c){
                
                
                case '\\':
                    result.append("\\\\");
                    break;
                    
                case '"':
                    result.append("\\\"");
                     break;
                     
                case '\n':
                    result.append("\\n");
                    break;
                    
                case '\r':
                    result.append("\\r");
                    break;
                    
                case '\t':
                    result.append("\\t");
                    break;
                    
                case 'b':
                    result.append("\\b");
                    break;
                    
                case 'f':
                    result.append("\\f");
                    break;
                    
                default:
                    result.append(c);
                    break;
                    
            }
        }
        return result.toString();
    }
    
    //PART 3:THIS WRITES ALL STORED MESSAGES TO THE JSON FILE
    
    public void storeMessages(){
        writeStoredMessagesToJSON();
        
        private static void writeStoredMessagesToJson(){
    StringBuilder json= new StringBuilder();
    json.append("\n");
    
    boolean first = true;

    
    for (int i=0; i < allMessagesText.size(); i++){
    
    
    if (messageStatusesArray.get(i).equals("Stored")){
    if (!first){
    json.append(",\n");
}
    json.append("{\n")
            .append("    \"MessageID\":  \")"
            .append(escapeJson(messageIDsArray.get(i))).append("\",\n")
            .append("      \"MessageNumber\":  ")
            .append(messageNumbersArray.get(i)).append(",\n")
            .append("    \"Recipient\":  \")"
            .append(escapeJson(allRecipients.get(i))).append("\",\n")  
            .append("    \"Message\":  \")"
            .append(escapeJson(allMessagesText.get(i))).append("\",\n")
            .append("    \"MessageHash\":  \")"
            .append(escapeJson(messageHashesArray.get(i))).append("\",\n") 
            .append("  }");
    
    first = false;
}
}

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
    
    //PART 3: THIS READS BACK THE JSON FILE INTO THE ARRAYS WHEN THE PROFRAM STARTS
    
    public static void readMessagesFromJson(){
        clearArrays();
        
        File file = new File ("messages.json");
        
        if (!file.exists()){
            return;
        }
        try (Scanner scanner= new Scanner(file)){
            String currentID="";
            String currentRecipient="";
            String currentHash="";
            String currentMessage="";
            int currentNumber=0;
            
            while(scanner.hasNextLine()){
                String line=scanner.nextLine().trim();
                
                if(line.equals("{")){
                    
            currentID="";
            currentRecipient="";
            currentHash="";
            currentMessage="";
            currentNumber=0; 
                }
                else if (line.startsWith("\"MessagesID\": ")){
                    currentID=extractJsonString(line);
                } 
                else if(line.startsWith("\"MessagesNumber\": ")){
                    String number = line.substring(line.indexOf(":")+ 1).replace(",", "").trim();
                    currentNumber=Integer.parseInt(number);
                }
                else if (line.startsWith("\"Recipient\": ")){
                      currentRecipient=extractJsonString(line);
                }
                else if(line.startsWith("\"Message\": ")){
                     currentMessage=extractJsonString(line);
                }
                else if(line.startsWith("\"Message\": ")){
                  currentHash=extractJsonString(line);  
                }
                else if (line startsWith("}")){
                
                if(!currentID.isEmpty()){
                    messageIDsArray.add(currentID);
                    messageNumbersArray.add(currentNumber);
                    allRecipients.add(currentRecipient);
                    allMessagesText.add(currentMessages);
                    messageHashesArray.add(currentHash);
                    messageStatusesArray.add("Stored");
                }
            }
                }
            rebuildStatusArrays();
            }
        catch (Exception e){
            System.out.println("Error reading JSON file: "  + e.getMessages());
        }
        }
    public static void String displayLongestMessage(){
    if (storedMessagesArray.isEmpty()){
    return "No stored messages available";
}
String longest="";

      for (String msg: storedMessagesArray){
           if(msg.length() > longest.length()){
           longest=msg;
}
}
      return longest;
}
//PART 3
public static String searchByMessageID(String id){
    if(messagesIDsArray.get(i).equals(id)){
        return "MessageID: " + messageIDsArrays.get(i)
                + "\nRecipient: "+ allRecipients.get(i)
                + "\nMessage"+allMessagesText.get(i);
    }
}
return "Message ID not found";
    }
    //PART 3
    
    public static void searchByRecipient(String recipient){
        Strinf result ="";
        
        for (int=0; i < allRecipients.size(); i++){
        if(allRecipients.get(i).equals(recipient) && !messagesStatusesArray.get(i).equals("Disregarded")){
            result=result + "Message: " + allMessgesText.get(i) + "\n";
        }
    }
        if (result.equals("")){
            return "No messages found for this recipient.";
        }
    }
     if (result.equals("")){
    public static String deleteByHash(String hash){
        for(int i=0; i< messageHashesArray.size(); i++){
            if (messageHashesArray.get(i).equals(hash) && messageStatusesArray.get(i).equals("Stored")){
                String deleteMsg=allMessageText.get(i);
                
                
                messageIDsArray.remove(i);
                    messageNumbersArray.remove(i);
                    allRecipients.remove(i);
                    allMessagesText.remove(i);
                    messageHashesArray.remove(i);
                    messageStatusesArray.remove(i);
                    
                    rebuildStatusesArray();
                    rebuildSentMessagesOutput();
                    
                    writeStoredMessagesToJson();
                    
                    return "Message: \"" + deletedMsg + "\" successfuly deleted.";
            }
        }
        return "Hash not found.";
    }
    //PART3 DISPLAYING THE REPORT
    public static void displayReport(){
        String report= "----MESSAGE REPORT----\n";
        boolean found= false;
        
        report=report + "Sent messages: \n";
        
        for (int i=0; i< allMessagesText.size(); i++){
            if (messageStatusesArray.get(i).equals("Sent")){
                 report=report
                         +"MessageID: "+ messagesIDsArray.get(i) + "\n"
                         + "Message Hash: "+ messageHashesArray.get(i)+ "\n"
                         +"Recipient: "+ allRecipients.get(i)+"\n"
                         +"Messages: "+allMessagesText.get(i)+"\n"
                         + "------------------------------------------\n";
                         
                         found = true;
            }
        }
    }
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
        String recipient = null;
        String msgText = null;
        String msgHash = null;
        String messageID = null;
    return "Message ID: " + messageID + "\n"
            + "Message Hash: " + msgHash + "\n"
            + "Recipient: " + recipient + "\n"
            + "Message: " + msgText;
}
    

