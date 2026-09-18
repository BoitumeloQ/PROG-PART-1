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
public class regLoginTest {

    private Object login;
    
    public regLoginTest() {
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
//=====assertEquals TESTS======
    @Test
    public void testUsernameCorrectlyFormatted_Flow(){
        Login login = new Login();
         String _=login.registerUser("kyl_1", "Ch&&sec@ke99!","+27838968976", "John","Doe");
        String msg="";
         assertEquals("Username successfully captured.Password successfully captured. Cellphone number added successfully", msg);
         assertTrue(login.loginUser("kyl_1", "Che&&sec@ke99"));
         assertEquals("Welcome John,Doe it is great to see  you again.", login.returnLoginStatus());
    }
    @Test
    public void testUsernameIncorrectlyFormatted(){
        Login login = new Login();
        String msg = login.registeredUser("'kyle!!!!!", "Ch&&sec@ke99!", "+27838968976", "John", "Doe");
        assertEquals("Username is not correctly formatted, please ensure that your username contains"+
                "an underscore and is no more than five characters in length",msg);
        
    }
    @Test
    public void testPasswordMeetsComplexity(){
        Login _ = new Login();
        Login login2 = new Login();
        String result=login2.registerUser("kyl_1","Ch&&sec@ke99!", "+27838968976", "John","Doe");
        assertTrue(result.startsWith("Username successfully captured"));
        
        assertTrue(login2.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    @Test
    public void testPasswordDoesNotMeetComplexity(){
     Login login = new Login();
     String msg = login.registeredUser("'kyle!!!!!", "Ch&&sec@ke99!", "+27838968976", "John", "Doe");
     assertEquals("Password is not correctly formatted; please ensure that your password contains" +
             "at least 8 characters, a capital letter,a number and a special character.", msg);
    }
     @Test
     public void testCellPhoneCorrectlyFormatted(){
        Login login= new Login();
        String msg = login.registeredUser("kyl_1", "Ch&&sec@ke99!","+27838968976", "John","Doe");
        assertTrue(msg.startsWith("Username successfully captured"));
        assertTrue(login.checkCellPhoneNumber(+27838976));
        
    }
     @Test
     public void testCellPhoneIncorrectlyFormatted(){
         Login login = new Login();
         String msg = login.registeredUser("kyl_1", "Ch&&sec@ke99!","+27838968976", "John","Doe");
         assertEquals("Cellphone number is incorrectly formatted does not contain the international" +
                 "code; please correct the number and try again", msg);
         
    }
     @Test
     public void testLoginFailed(){
         Login login = new Login();
         login.registerUser("kyl_1", "Ch&&sec@ke99!","+27838968976", "John","Doe");
         assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
     }
     @Test
     public void testLoginFailed(){
         Login login = new Login();
         login.registerUser("kyl_1", "Ch&&sec@ke99!","+27838968976", "John","Doe");
         assertFalse(login.loginUser("kyl_1","wrong"));
     }
     @Test
     public void testUsernameCorrectlyFormatted_Boolean(){
         assertTrue(login.checkUserName("kyle_1"));
     }
     @Test
     public void testUsernameincorrectlyFormatted_Boolean(){
         Login login = new Login();
         assertFalse(login.checkUserName("kyle!!!!!!!!"));
     }
     @Test
     public void testPasswordMeetsComplexity_Boolean(){
         Login login = new login();
         assertTrue(n.checkPasswordComplexity("Ch&&sec@ke99!"));
     }
    
    private void assertEquals(String username_successfully_capturedPassword_su, String msg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class Login {

        public Login() {
        }

        private String registerUser(String kyl_1, String chsecke99, String string, String john, String doe) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean loginUser(String kyl_1, String chesecke99) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String returnLoginStatus() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String registeredUser(String kyle, String chsecke99, String string, String john, String doe) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean checkPasswordComplexity(String chsecke99) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean checkCellPhoneNumber(int i) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean checkUserName(String kyle) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
