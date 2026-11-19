/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeprogpart1;
 
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author cash coverters
 */
public class storedMessages {

    // Parallel arrays for stored messages
    private static String[] storedMessageIds = new String[0];
    private static String[] storedMessageHashes = new String[0];
    private static String[] storedSenders = new String[0];
    private static String[] storedRecipients = new String[0];
    private static String[] storedMessages = new String[0];

    // Required arrays
    private static String[] sentMessages = new String[0];
    private static String[] disregardedMessages = new String[0];
    private static String[] messageHashes = new String[0];
    private static String[] messageIds = new String[0];

    private static final String DEFAULT_JSON_PATH = "stored_messages.json";
    private static int idCounter = 1;

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Populate arrays automatically using the required test data
        populateTestData();

        // Optionally merge additional records from stored_messages.json if present
        loadStoredMessagesFromJson(DEFAULT_JSON_PATH);

        boolean running = true;
        while (running) {
            printMainMenu();
            String choice = myScanner.nextLine().trim();

            switch (choice) {
                case "1" -> captureMessage(myScanner, "SENT");
                case "2" -> captureMessage(myScanner, "DISREGARD");
                case "3" -> loadStoredMessagesFromJson(promptForFilePath(myScanner));
                case "4" -> handleStoredMessagesMenu(myScanner);
                case "5" -> {
                    running = false;
                    System.out.println("Exiting application.");
                }
                default -> System.out.println("Invalid selection. Please choose 1 to 5.");
            }
        }

        myScanner.close();
    }

    // Populates arrays with Test Data Messages 1 through 5
    public static void populateTestData() {
        // Test Data Message 1: Recipient +27834557896 | "Did you get the cake?" | Flag: Sent
        addMessage("MSG001", "System", "+27834557896", "Did you get the cake?", "Sent");

        // Test Data Message 2: Recipient +27838884567 | "Where are you? You are late! I have asked you to be on time." | Flag: Stored
        addMessage("MSG002", "System", "+27838884567",
                "Where are you? You are late! I have asked you to be on time.", "Stored");

        // Test Data Message 3: Recipient +27834484567 | "Yohoooo, I am at your gate." | Flag: Disregard
        addMessage("MSG003", "System", "+27834484567", "Yohoooo, I am at your gate.", "Disregard");

        // Test Data Message 4: Developer 0838884567 | "It is dinner time !" | Flag: Sent
        addMessage("MSG004", "Developer", "0838884567", "It is dinner time !", "Sent");

        // Test Data Message 5: Recipient +27838884567 | "Ok, I am leaving without you." | Flag: Stored
        addMessage("MSG005", "System", "+27838884567", "Ok, I am leaving without you.", "Stored");

        System.out.println("Populated arrays with Test Data Messages 1 to 5.");
    }

    public static String addMessage(String id, String sender, String recipient, String body, String flag) {
        String cleanId = (id == null || id.isBlank()) ? String.format("MSG%03d", idCounter++) : id.trim();
        String cleanSender = (sender == null || sender.isBlank()) ? "Unknown" : sender.trim();
        String cleanRecipient = (recipient == null) ? "" : recipient.trim();
        String cleanBody = (body == null) ? "" : body;
        String cleanFlag = (flag == null) ? "" : flag.trim().toUpperCase();

        String hash = generateSimpleHash(cleanId + "|" + cleanSender + "|" + cleanRecipient + "|" + cleanBody);

        messageIds = appendToArray(messageIds, cleanId);
        messageHashes = appendToArray(messageHashes, hash);
//A SWITCH CASE STATEMENT TO CREATE THE MENU OPTION
        switch (cleanFlag) {
            case "SENT":
                sentMessages = appendToArray(sentMessages, cleanBody);
                break;
            case "DISREGARD":
            case "DISREGARDED":
                disregardedMessages = appendToArray(disregardedMessages, cleanBody);
                break;
            case "STORED":
                storedMessageIds = appendToArray(storedMessageIds, cleanId);
                storedMessageHashes = appendToArray(storedMessageHashes, hash);
                storedSenders = appendToArray(storedSenders, cleanSender);
                storedRecipients = appendToArray(storedRecipients, cleanRecipient);
                storedMessages = appendToArray(storedMessages, cleanBody);
                break;
            default:
                System.out.println("Unrecognized flag '" + flag + "' for message " + cleanId);
        }

        return hash;
    }

    private static void printMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Send a Message");
        System.out.println("2. Disregard a Message");
        System.out.println("3. Load Stored Messages from JSON");
        System.out.println("4. Stored Messages");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

        private static void captureMessage(Scanner myScanner, String sent) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

   
            
        }
    
   
    }
    //A JSON FILE IS INCORPORATED AT THIS POINT TO READ THE STORED ARRAYS

    public static void loadStoredMessagesFromJson(String filePathStr) {
        Path path = Paths.get(filePathStr);
        if (!Files.exists(path)) {
            return;
        }

        try {
            String jsonContent = Files.readString(path, StandardCharsets.UTF_8);
            Pattern objectPattern = Pattern.compile("\\{([^{}]*)\\}");
            Matcher objectMatcher = objectPattern.matcher(jsonContent);

            int loadedCount = 0;
            while (objectMatcher.find()) {
                String obj = objectMatcher.group(1);

                String id = firstNonEmpty(extractJsonField(obj, "messageId"), extractJsonField(obj, "id"));
                String sender = firstNonEmpty(extractJsonField(obj, "sender"), "StoredJSON");
                String recipient = firstNonEmpty(extractJsonField(obj, "recipient"), extractJsonField(obj, "developer"));
                String message = firstNonEmpty(extractJsonField(obj, "message"), extractJsonField(obj, "content"));
                String hash = firstNonEmpty(extractJsonField(obj, "messageHash"), extractJsonField(obj, "hash"));

                if (!message.isEmpty() || !id.isEmpty()) {
                    String assignedId = id.isEmpty() ? String.format("MSG%03d", idCounter++) : id;
                    String computedHash = hash.isEmpty()
                            ? generateSimpleHash(assignedId + "|" + sender + "|" + recipient + "|" + message)
                            : hash;

                    storedMessageIds = appendToArray(storedMessageIds, assignedId);
                    storedMessageHashes = appendToArray(storedMessageHashes, computedHash);
                    storedSenders = appendToArray(storedSenders, sender);
                    storedRecipients = appendToArray(storedRecipients, recipient);
                    storedMessages = appendToArray(storedMessages, message);

                    messageIds = appendToArray(messageIds, assignedId);
                    messageHashes = appendToArray(messageHashes, computedHash);
                    loadedCount++;
                }
            }

            if (loadedCount > 0) {
                System.out.println("Loaded " + loadedCount + " additional message(s) from " + filePathStr + ".");
            }
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    private static String firstNonEmpty(String primary, String fallback) {
        return (primary != null && !primary.isEmpty()) ? primary : (fallback != null ? fallback : "");
    }

    private static String extractJsonField(String jsonObjectBody, String fieldName) {
        Pattern fieldPattern = Pattern.compile("\"" + Pattern.quote(fieldName) + "\"\\s*:\\s*\"((?:\\\\.|[^\"\\\\])*)\"");
        Matcher matcher = fieldPattern.matcher(jsonObjectBody);
        if (matcher.find()) {
            return unescapeJson(matcher.group(1));
        }
        return "";
    }

    private static String unescapeJson(String raw) {
        return raw.replace("\\\"", "\"")
                  .replace("\\\\", "\\")
                  .replace("\\n", "\n")
                  .replace("\\r", "\r")
                  .replace("\\t", "\t");
    }

    // 2a. Display sender and recipient of all stored messages
    public static void displaySendersAndRecipients() {
        if (storedMessages.length == 0) {
            System.out.println("No stored messages available.");
            return;
        }
        System.out.println("\n--- Sender & Recipient (All Stored Messages) ---");
        for (int i = 0; i < storedMessages.length; i++) {
            System.out.printf("%d. Sender: %s | Recipient: %s%n",
                    (i + 1), storedSenders[i], storedRecipients[i]);
        }
    }

    // 2b. Display the longest stored message
    public static void displayLongestStoredMessage() {
        if (storedMessages.length == 0) {
            System.out.println("No stored messages available.");
            return;
        }

        int longestIndex = 0;
        for (int i = 1; i < storedMessages.length; i++) {
            if (storedMessages[i].length() > storedMessages[longestIndex].length()) {
                longestIndex = i;
            }
        }

        System.out.println("\n--- Longest Stored Message ---");
        System.out.println("Message ID : " + storedMessageIds[longestIndex]);
        System.out.println("Sender : " + storedSenders[longestIndex]);
        System.out.println("Recipient : " + storedRecipients[longestIndex]);
        System.out.println("Length : " + storedMessages[longestIndex].length() + " characters");
        System.out.println("Message : " + storedMessages[longestIndex]);
    }

    // 2c. Search for a Message ID and display the corresponding recipient and message
    public static void searchByMessageId(Scanner scanner) {
        if (storedMessageIds.length == 0) {
            System.out.println("No stored messages available.");
            return;
        }

        System.out.print("Enter Message ID to search: ");
        String targetId = scanner.nextLine().trim();

        for (int i = 0; i < storedMessageIds.length; i++) {
            if (storedMessageIds[i].equalsIgnoreCase(targetId)) {
                System.out.println("Recipient : " + storedRecipients[i]);
                System.out.println("Message : " + storedMessages[i]);
                return;
            }
        }

        System.out.println("No stored message found with ID: " + targetId);
    }

    // 2d. Search for all messages stored for a particular recipient
    public static void searchByRecipient(Scanner scanner) {
        if (storedRecipients.length == 0) {
            System.out.println("No stored messages available.");
            return;
        }

        System.out.print("Enter recipient to search for: ");
        String targetRecipient = scanner.nextLine().trim();

        int matchCount = 0;
        System.out.println("\n--- Stored Messages for Recipient: " + targetRecipient + " ---");
        for (int i = 0; i < storedRecipients.length; i++) {
            if (storedRecipients[i].equalsIgnoreCase(targetRecipient)) {
                matchCount++;
                System.out.printf("%d. [ID: %s] From %s: %s%n",
                        matchCount, storedMessageIds[i], storedSenders[i], storedMessages[i]);
            }
        }

        if (matchCount == 0) {
            System.out.println("No stored messages found for recipient: " + targetRecipient);
        }
    }

    // 2e. Delete a message using the message hash while keeping parallel arrays aligned
    public static void deleteByMessageHash(Scanner scanner) {
        if (storedMessageHashes.length == 0) {
            System.out.println("No stored messages available to delete.");
            return;
        }

        System.out.print("Enter Message Hash to delete: ");
        String targetHash = scanner.nextLine().trim();

        int indexToRemove = -1;
        for (int i = 0; i < storedMessageHashes.length; i++) {
            if (storedMessageHashes[i].equalsIgnoreCase(targetHash)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            System.out.println("No stored message found matching hash: " + targetHash);
            return;
        }

        String removedMessage = storedMessages[indexToRemove];
        storedMessageIds = removeAtIndex(storedMessageIds, indexToRemove);
        storedMessageHashes = removeAtIndex(storedMessageHashes, indexToRemove);
        storedSenders = removeAtIndex(storedSenders, indexToRemove);
        storedRecipients = removeAtIndex(storedRecipients, indexToRemove);
        storedMessages = removeAtIndex(storedMessages, indexToRemove);

        System.out.println("Deleted stored message: \"" + removedMessage + "\"");
    }

    // 2f. Display a report that lists the full details of all stored messages
    public static void displayFullStoredMessagesReport() {
        if (storedMessages.length == 0) {
            System.out.println("No stored messages available for report.");
            return;
        }

        System.out.println("\n================ STORED MESSAGES FULL REPORT ================");
        for (int i = 0; i < storedMessages.length; i++) {
            System.out.println("Record #" + (i + 1));
            System.out.println(" Message ID : " + storedMessageIds[i]);
            System.out.println(" Message Hash : " + storedMessageHashes[i]);
            System.out.println(" Sender : " + storedSenders[i]);
            System.out.println(" Recipient : " + storedRecipients[i]);
            System.out.println(" Message : " + storedMessages[i]);
            System.out.println("-------------------------------------------------------------");
        }
        System.out.println("Total Stored Messages: " + storedMessages.length);
    }

    private static String promptForFilePath(Scanner scanner) {
        System.out.print("Enter JSON file path (or press Enter for '" + DEFAULT_JSON_PATH + "'): ");
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? DEFAULT_JSON_PATH : input;
    }

    private static String generateSimpleHash(String input) {
        return Integer.toHexString(input.hashCode()).toUpperCase();
    }

    private static String[] appendToArray(String[] original, String value) {
        String[] updated = new String[original.length + 1];
        System.arraycopy(original, 0, updated, 0, original.length);
        updated[original.length] = value;
        return updated;
    }

    private static String[] removeAtIndex(String[] original, int index) {
        if (index < 0 || index >= original.length) {
            return original;
        }
        String[] updated = new String[original.length - 1];
        System.arraycopy(original, 0, updated, 0, index);
        System.arraycopy(original, index + 1, updated, index, original.length - index - 1);
        return updated;
    }
}

