
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.prog5121_poe.Message;
import com.mycompany.prog5121_poe.MessageManagement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kgomotso
 */
public class StoredMessagesTests {

    private ArrayList<Message> sentMessages;
    private ArrayList<Message> storedMessages;
    private ArrayList<Message> disregardedMessages;
    private ArrayList<String> messageHashes;
    private ArrayList<String> messageIDs;

    private MessageManagement management;

    private Message message1;
    private Message message2;
    private Message message3;
    private Message message4;
    private Message message5;

    public StoredMessagesTests() {
    }

    @BeforeEach
    public void setUp() {

        sentMessages = new ArrayList<>();
        storedMessages = new ArrayList<>();
        disregardedMessages = new ArrayList<>();
        messageHashes = new ArrayList<>();
        messageIDs = new ArrayList<>();

        management = new MessageManagement();

        // Test Data Message 1
        message1 = new Message(
                "1234567890",
                1,
                "+27834557896",
                "Developer",
                "Did you get the cake?"
        );
        message1.setStatus("Sent");

        // Test Data Message 2
        message2 = new Message(
                "2345678901",
                2,
                "+27838884567",
                "Developer",
                "Where are you? You are late! I have asked you to be on time."
        );
        message2.setStatus("Stored");

        // Test Data Message 3
        message3 = new Message(
                "3456789012",
                3,
                "+27834484567",
                "Developer",
                "Yohoooo, I am at your gate."
        );
        message3.setStatus("Disregard");

        // Test Data Message 4
        message4 = new Message(
                "0838884567",
                4,
                "0838884567",
                "Developer",
                "It is dinner time!"
        );
        message4.setStatus("Sent");

        // Test Data Message 5
        message5 = new Message(
                "5678901234",
                5,
                "+27838884567",
                "Developer",
                "Ok, I am leaving without you."
        );
        message5.setStatus("Stored");

        // Populate sent messages
        sentMessages.add(message1);
        sentMessages.add(message4);

        // Populate stored messages
        storedMessages.add(message2);
        storedMessages.add(message5);

        // Populate disregarded messages
        disregardedMessages.add(message3);

        // Populate message hashes and IDs
        Message[] allMessages = {
            message1, message2, message3, message4, message5
        };

        for (Message currentMessage : allMessages) {
            messageHashes.add(currentMessage.getMessageHash());
            messageIDs.add(currentMessage.getMessageID());
        }
    }

    // Test 1 - Sent Messages array correctly populated
    @Test
    public void testSentMessagesArray() {

        assertEquals(2, sentMessages.size());

        assertEquals(
                "Did you get the cake?",
                sentMessages.get(0).getMessage()
        );

        assertEquals(
                "It is dinner time!",
                sentMessages.get(1).getMessage()
        );
    }

    // Test 2 - Display the longest stored message
    @Test
    public void testLongestStoredMessage() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;

        try {
            System.setOut(new PrintStream(output));

            management.displayLongestStoredMessage(storedMessages);

        } finally {
            System.setOut(originalOutput);
        }

        String result = output.toString();

        assertTrue(result.contains(
                "Where are you? You are late! I have asked you to be on time."
        ));
    }

    // Test 3 - Search for Message ID
    @Test
    public void testSearchMessageID() {

        // The question paper uses 0838884567 for this test.
        management.input = new Scanner(
                new ByteArrayInputStream(
                        "0838884567\n".getBytes(StandardCharsets.UTF_8)
                )
        );

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;

        try {
            System.setOut(new PrintStream(output));

            management.searchMessageByID(sentMessages);

        } finally {
            System.setOut(originalOutput);
        }

        String result = output.toString();

        assertTrue(result.contains("It is dinner time!"));
        assertTrue(result.contains("0838884567"));
    }

    // Test 4 - Search all stored messages for a recipient
    @Test
    public void testSearchMessagesByRecipient() {

        management.input = new Scanner(
                new ByteArrayInputStream(
                        "+27838884567\n".getBytes(StandardCharsets.UTF_8)
                )
        );

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;

        try {
            System.setOut(new PrintStream(output));

            management.searchMessageByRecipient(storedMessages);

        } finally {
            System.setOut(originalOutput);
        }

        String result = output.toString();

        assertTrue(result.contains(
                "Where are you? You are late! I have asked you to be on time."
        ));

        assertTrue(result.contains(
                "Ok, I am leaving without you."
        ));
    }

    // Test 5 - Delete a stored message using its hash
    @Test
    public void testDeleteMessageByHash() throws Exception {

        // Keep a backup of the existing JSON file
        Path jsonFile = Paths.get("message.json");

        boolean fileExisted = Files.exists(jsonFile);
        byte[] originalData = null;

        if (fileExisted) {
            originalData = Files.readAllBytes(jsonFile);
        }

        String searchHash = message2.getMessageHash();

        management.input = new Scanner(
                new ByteArrayInputStream(
                        (searchHash + "\n").getBytes(StandardCharsets.UTF_8)
                )
        );

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;

        try {
            System.setOut(new PrintStream(output));

            management.deleteMessageByHash(storedMessages);

            String result = output.toString();

            assertTrue(result.contains(
                    "Where are you? You are late! I have asked you to be on time."
            ));

            assertEquals(1, storedMessages.size());
            assertFalse(storedMessages.contains(message2));

        } finally {

            System.setOut(originalOutput);

            // Restore the original JSON file
            if (fileExisted) {
                Files.write(jsonFile, originalData);
            } else {
                Files.deleteIfExists(jsonFile);
            }
        }
    }

    // Test 6 - Display report
    @Test
    public void testDisplayReport() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;

        try {
            System.setOut(new PrintStream(output));

            management.reportOfStoredMessages(storedMessages);

        } finally {
            System.setOut(originalOutput);
        }

        String result = output.toString();

        // Check message hashes
        assertTrue(result.contains(message2.getMessageHash()));
        assertTrue(result.contains(message5.getMessageHash()));

        // Check recipients
        assertTrue(result.contains("+27838884567"));

        // Check message text
        assertTrue(result.contains(
                "Where are you? You are late! I have asked you to be on time."
        ));

        assertTrue(result.contains(
                "Ok, I am leaving without you."
        ));
    }

}