/*;
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mycompany.prog5121_poe.Message;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kgomotso
 */
public class MessageTest {
    
   //Test data for Message 1 (from the brief)
    String recipient1 = "+27718693002";
    String message1 = "Hi Mike, can you join us for dinner tonight?";

    //Test data for Message 2 (from the brief)
    String recipient2 = "08575975889";
    String message2 = "Hi Keegan, did you receive the payment?";

    //Fixed message ID for testing the hash
    String testID = "0012345678";

public MessageTest() {

 }

 ///==================The message should not be more than 250 characters==================

    @Test
    public void checkMessageLengthSuccess() {
        Message messageObj = new Message(testID, 0, recipient1, message1);
        String expected = "Message ready to send.";
        String actual = messageObj.checkMessageLength(message1);

        assertEquals(expected, actual);
    }

    @Test
    public void checkMessageLengthFailure() {
        //Building a message that is 260 characters long (10 too many)
        String longMessage = "";
        for (int i = 0; i < 260; i++) {
            longMessage += "a";
        }

        Message messageObj = new Message(testID, 0, recipient1, message1);
        String expected = "Message exceeds 250 characters by 10; please reduce the size.";
        String actual = messageObj.checkMessageLength(longMessage);

        assertEquals(expected, actual);
    }
  
     //==================The recipient number is correctly formatted==================

    @Test
    public void checkRecipientCellSuccess() {
        Message messageObj = new Message(testID, 0, recipient1, message1);
        String expected = "Cell phone number successfully captured.";
        String actual = messageObj.checkRecipientCell(recipient1);

        assertEquals(expected, actual);
    }

    @Test
    public void checkRecipientCellFailure() {
        Message messageObj = new Message(testID, 1, recipient2, message2);
        String expected = "Cell phone number is incorrectly formatted or does not contain an international code. "
                + "Please correct the number and try again.";
        String actual = messageObj.checkRecipientCell(recipient2);

        assertEquals(expected, actual);
    }
    
    

}
