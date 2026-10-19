/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    Messages msg =new Messages(1, "08575975889", "Hi Keegan, did you recieve payment?");
    assertEquals("Cellphone number is incorrectly formatted or does not contain an international code.Please correct the nummber and try again",
    msg.chechRecipientCell());
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
    Messages msg = new Messages(0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
    assertTrue(msg.checkMessageID());
    essertEquals("Message ID generated: " + msg.getMessageID(), msg.displayMessageID());
    System.out.println(msg.displayMessageID());
}
@Test
public void testSentMessageSeng(){
    Messages msg = new Messages(0,"+27718693002","Hi Mike, can you join us for dinner tonight?");
    assertEquals("Message successfully sent.", msg.sentMessage(2));
}
@Test
public void testSentMessageDisregard(){
    Messages msg=new Messages(1, "08575975889", "Hi Keegan, did you recieve the payment?");
    assertEquals("Press 0 to delete the message.", msg.sentMessage(2));
}
@Test
public void testSentMessageStore(){
    Messages msg = new Messages(0,"+2718693002", "Hi Mike, can you join us for dinner tonight?");
    assertEquals("Message successfully stored.",msg.sentMessage(3));
}
@Test
public void testMessagesIDLength(){
    Messages msg = new Messages(0,"+27718693002","Hi Mike,can you join us for dinner tonight?");
    assertTrue(msg.getMessageID().length()<=10);
    assertEquals(10, msg.getMessageID().length());
}

@Test
public void testReturnTotalMessages(){
    int before= Messages.returnTotalMessages();
    Messages msg= new Messages(0,"+27718693003", "Hi Mike, can you join us for dinner tonight?");
    msg.sentMessage(1);
    assertEquals(before + 1, Messages.returnTotalMessages());
}
@Test
public void testTotalAfterSendAndDiscard(){
    int before =Messages.returnTotalMessages();
    Messages msg1= new Messages(0,"+27718693002","Hi Mike, can you jin us for dinner tonight?");
    Messages msg2= new Messages(1, "08575975889", "Hi Keegan, did you receive payment?");
    msg1.sentMessage(1);
    msg2.sentMessage(2);
    assertEquals(before + 1, Messages.returnTotalMessages());
}

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

