/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.poeprogpart1.Messages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    private Object Message;

/**
 *
 * @author cash coverters
 */
public class messagesTest {

        private Object Messages;
    
    public messagesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
@Test
public void testMessageLengthSuccess(){
    String message="Hi Mike, can you join us for dinner tonight?";
    assertEquals("Message ready to send.", Messages.checkMessageLength(message));
}
@Test
public void testMessageLengthFailure(){
    String longMessage="";
    for (int i=0; i<260; i++){
        longMessage=longMessage + "a";
    }
    assertEquals("Message exceeds 250 characters by 10, pleaese reduce the size.", 
            Messages.checkMessageLength(longMessage));
}
@Test
public void testRecipientCorrect(){
    Messages msg= new Messages(0, "+27123456789" + "Hi Mike, can you join us for dinner tonight?");
    assertEquals("Cellphone number successfylly captured.", msg.checkRecipientCell());
}
@Test
public void testRecipientIncorrect(){
    Messages msg =new Messages("08575975889", 1, "Hi Keegan, did you recieve payment?", "Hi Mike, can you join us for dinner tonight?");
    assertEquals("Cellphone number is incorrectly formatted or does not contain an international code.Please correct the nummber and try again",
    msg.checkRecipientCell());
}
@Test
public void testMessageHashCorrect(){
    Messages msg = new Messages("0012345678",0,"+27718693002", "Hi Mike, can you join us for dinner tonight?");
    assertEquals("00:0:HITONIGHT", msg.createMessageHash());
}
@Test
public void testMessageHashesInLoop(){
    String[] ids = {"0012345678","5512345678","997654321"};
    String[] texts={
        "Hi Mike, can you join us for dinner tonight?",
        "Hi Keegan, did you receive the payment?",
        "Okay"};
    String[] expected={"00:0HITONIGHT","55:1:HIPAYMENT","99:2:OKAYOKAY"};
    }
    }
@Test
public void testMessageIDCreated(){
    Messages msg = new Messages("+27718693002", 0, "Hi Mike, can you join us for dinner tonight?", "Hi Mike, can you join us for dinner tonight?");
    assertTrue(msg.checkMessageID());
    essertEquals("Message ID generated: " + msg.getMessageID(), msg.displayMessageID());
    System.out.println(msg.displayMessageID());
}
@Test
public void testSentMessageSeng(){
    Messages msg = new Messages("+27718693002", 0,"Hi Mike, can you join us for dinner tonight?", "Hi Mike, can you join us for dinner tonight?");
    assertEquals("Message successfully sent.", msg.sentMessage(2));
}
@Test
public void testSentMessageDisregard(){
    Messages msg=new Messages("08575975889", 1, "Hi Keegan, did you recieve the payment?", "Hi Mike, can you join us for dinner tonight?");
    assertEquals("Press 0 to delete the message.", msg.sentMessage(2));
}
@Test
public void testSentMessageStore(){
    Messages msg = new Messages("+2718693002", 0, "Hi Mike, can you join us for dinner tonight?", "Hi Mike, can you join us for dinner tonight?");
    assertEquals("Message successfully stored.",msg.sentMessage(3));
}
@Test
public void testMessagesIDLength(){
    Messages msg = new Messages("+27718693002", 0,"Hi Mike,can you join us for dinner tonight?", "Hi Mike, can you join us for dinner tonight?");
    assertTrue(msg.getMessageID().length()<=10);
    assertEquals(10, msg.getMessageID().length());
}

@Test
public void testReturnTotalMessages(){
    int before= Messages.returnTotalMessages();
    Messages msg= new Messages("+27718693003", 0, "Hi Mike, can you join us for dinner tonight?", "Hi Mike, can you join us for dinner tonight?");
    msg.sentMessage(1);
    assertEquals(before + 1, Messages.returnTotalMessages());
}
@Test
public void testTotalAfterSendAndDiscard(){
    int before =Messages.returnTotalMessages();
    Messages msg1= new Messages("+27718693002", 0,"Hi Mike, can you jin us for dinner tonight?", "Hi Mike, can you join us for dinner tonight?");
    Messages msg2= new Messages("08575975889", 1, "Hi Keegan, did you receive payment?", "Hi Mike, can you join us for dinner tonight?");
    msg1.sentMessage(1);
    msg2.sentMessage(2);
    assertEquals(before + 1, Messages.returnTotalMessages());
}
//BEGINNING OF PART 3 TESTS
@Test
public void testSentMessageArrayPopulated(){
    Message message1= new Message(1);
    message1.setRecipient("+27834557896");
    message1.setMessage("Did you get the cake?");
    message1.createMessageHash();
    message1.sentMessage(1);
    
    Message message4 = new Message(4);
    message4.setRecipient("0838884567");
    message4.setMessage("It is dinner time!");
    message4.createMessageHash();
    message4.sentMessage(1);
    
    boolean foundmessage1 = Message.getSentMessages().stream().anyMatch(s-> s.contains( "Did you get the cake?"));
    boolean foundmessage4 = Message.getSentMessages().stream().anyMatch(s-> s.contains("It is dinner time!"));
    
    assertTrue(foundmessage1, "Sent messages should contain 'Did you get the cake?'");
    assertTrue(foundmessage4, "Sent messages should contain'It is dinner time!'");
}
    @Test
    public void testDisplayLongestMessage(){
    Message message2= new Message(2);
    message2.setRecipient("+27838884567");
    message2.setMessage("Where are you? You are late! I have asked you to come on time.");
    message2.createMessageHash();
    message2.storeMessage();
    
    Message message5= new Message(5);
    message5.setRecipient("+278388884567");
    message5.setMessage("Ok,I am leaving without you.");
    message5.createMessageHash();
    message5.storeMessage();
    
    Message.loadStoredMessagesFromFile();
    String result = Message.displayLongestStoredMessage();
    assertTrue(result.contains("Where are you? You are late! I have asked you to be on time"), "Longest message should be message 2");
}
    @Test
    public void testSearchByMessageID(){
        Message message4= new Message(4);
        message4.setRecipient("0838884567");
        message4.setMessage("It is dinner time!");
        message4.createMessageHash();
        message4.storeMessage();
        
        Message.loadStoredMessagesFromFile();
        String result= Message.searchByMessageID(message4.getMessageID());
        
        assertTrue(result.contains("It is dinner time!"), "Searcg by ID should return'It is dinner time!'");
        assertTrue(result.contains("0838884567"), "Search by ID should return recipient '0838884567'");
}
@Test
public void testDeletedHash(){
    Message message2= new Message(2);
    message2.setRecipient("+27838884567");
    message2.setMessage("Where are you? You are late! I have asked you to come on time.");
    message2.createMessageHash();
    message2.storeMessage();
    
      Message.loadStoredMessagesFromFile();
      String result= Message.deletedByHash(message2.getMessageHash());
      
      assertTrue(result.contains("successfully deleted"), "Result should confirm deletion");
      assertTrue(result.contains("Where are you? You are late!"), "Result should include the deleted message text");
}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

