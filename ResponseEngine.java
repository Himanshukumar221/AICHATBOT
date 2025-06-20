



import java.util.HashMap;
import java.util.Map;

public class ResponseEngine {
    private final Map<String, String> faqMap;

    public ResponseEngine() {
        faqMap = new HashMap<>();

        // Rule-based FAQ responses
        faqMap.put("hi", "Hello! How can I help you?");
        faqMap.put("hello", "Hi there! What would you like to know?");
        faqMap.put("what is ai", "AI stands for Artificial Intelligence. It's the simulation of human intelligence in machines.");
        faqMap.put("how are you", "I'm a bot, but I'm functioning well. Thanks!");
        faqMap.put("bye", "Goodbye! Have a great day.");
        faqMap.put("help", "I can answer questions about AI, Java, and general topics.");
    }

    public String getResponse(String input) {
        input = input.toLowerCase().trim();

        for (String key : faqMap.keySet()) {
            if (input.contains(key)) {
                return faqMap.get(key);
            }
        }
        return "I'm sorry, I don't understand that. Try asking something else.";
    }
}

