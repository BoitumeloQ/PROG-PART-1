/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeprogpart1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cash coverters
 */
public class messagesID {
    
  
    public class MessagesIDs{  //Generates and tracks uniques message IDs
        private List<Integer> messageIDs;
        private int currentId;
        private final ArrayList<Object> messagesIDs;
        
        public MessagesIDs(){ //Initialise ID tracking
            this.messagesIDs= new ArrayList<>();
            this.currentId=0;
            
        }
        public int generateMessageId(){ //Generates and returns a new unique ID
            currentId++;
            messageIDs.add(currentId);
            return currentId;
        }
        // Gets all generated message IDs
        public List<Integer> getMessageIDs(){return messageIDs;}
        
        //Checks if an ID has been generated
        
    }
}
