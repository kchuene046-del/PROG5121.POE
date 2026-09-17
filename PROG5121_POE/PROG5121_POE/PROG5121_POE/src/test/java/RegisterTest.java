/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.prog5121_poe.PROG5121_POE;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kgomotso
 */
public class RegisterTest {
    
    public RegisterTest() {
        
    }
    
    @Test
     public void checkUserNameCorrectlyFormatted() {
         String userName = "kyl_1";
         boolean expected = PROG5121_POE.checkUserName(userName);
            
         assertEquals(true,expected,"Welcome" + " " + userName);
     }
     
     @Test
     public void checkUserNameInCorrectlyFormatted() {
         String userName = "kyl!!!!!!!!";
         boolean expected = PROG5121_POE.checkUserName(userName);
            
         assertEquals(false,expected,"Username is not correctly formatted,"
                 + " please ensure that your username contains an underscore "
                 + "and is more than 5 charcters in legth");
     }
     
   @Test
     public void checkPasswordCorrectlyFormatted() {
         String password = "Ch&&sec@ke99!";
         boolean expected = PROG5121_POE.checkPasswordComplexity(password);
            
         assertEquals(true,expected,"Password successfully captured!");
     }  
     
    @Test
     public void checkPasswordInCorrectlyFormatted() {
         String userName = "kyl!!!!!!!!";
         boolean expected = PROG5121_POE.checkUserName(userName);
            
         assertEquals(false,expected,"Password is not correctly formatted, "
                 + "please ensure that the password contains at least 8 characters, "
                 + "a capital letter, a number and a special characture.");
     }
     //frhfrhfeherhtr gfhgrhgrtgrh grhgrhghgfhgf
   
     @Test
     public void checkCellPhoneNumnberCorrectlyFormatted() {
         String cellphoneNumber = "+27838968976";
         boolean expected = PROG5121_POE.checkCellPhoneNumber(cellphoneNumber);
            
         assertEquals(true,expected,"Cell number successfully captured!");
     }
  
     @Test
     public void checkCellPhoneNumberInCorrectlyFormatted() {
         String cellphoneNumber = "08966553";
         boolean expected = PROG5121_POE.checkCellPhoneNumber(cellphoneNumber);
            
         assertEquals(false,expected,"Cell number is incorrectly formatted or dose not "
                 + "contain an international code, please correct the number and try again");
     }
     @Test
     public void checkLoginSuccessfully()
     {
         String firstName = "Kgomotso";
         String lastName = "Chuene";
         String userName = "Kyl_1";
         String password = "Kgomo12345@";
         String registeredUserName = "Kyl_1";
         String registeredPassword = "Kgomo12345@";
         String expected = "Welcome " + firstName + "," + lastName + " it is great to see you again.";
         String actual = PROG5121_POE.LoginSatus(firstName, lastName, userName, password, registeredUserName, registeredPassword);
         
         assertTrue(actual.equals(expected),"");
     }
     
    @Test
     public void checkLoginfailure()
     {
         String firstName = "Kgomotso";
         String lastName = "Chuene";
         String userName = "Kyl_1";
         String password = "Kgomo12345@";
         String registeredUserName = "Kyl_1";
         String registeredPassword = "Kgomo12345@";
         String expected = "Username or password incorrect please try again";
         String actual = PROG5121_POE.LoginSatus(firstName, lastName, userName, password, registeredUserName, registeredPassword);
         
         assertFalse(actual.equals(expected),"");
     }
}
