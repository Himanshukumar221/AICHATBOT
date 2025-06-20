



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chatbot {
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField inputField;
    private ResponseEngine responseEngine;

    public Chatbot() {
        responseEngine = new ResponseEngine();
        createUI();
    }

    private void createUI() {
        frame = new JFrame("AI Chatbot - Java");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.addActionListener(e -> sendMessage());

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void sendMessage() {
        String userInput = inputField.getText();
        if (userInput.isEmpty()) return;

        chatArea.append("You: " + userInput + "\n");
        String response = responseEngine.getResponse(userInput);
        chatArea.append("Bot: " + response + "\n\n");
        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Chatbot::new);
    }
}
