import java.util.Map;
import java.util.HashMap;

public class Responder {
  private Map<String, String> keywordResponses;

  public Responder() {
    keywordResponses = new HashMap<>();
    initializeResponses();
  }

  private void initializeResponses() {
    keywordResponses.put("file", "It seems you have a problem with a file. Is the file corrupted?");
    keywordResponses.put("save", "Are you having trouble saving? Maybe you don’t have write permissions.");
    keywordResponses.put("open", "If you can't open the file, it might be in use by another program.");
    keywordResponses.put("crash", "It sounds like the system is crashing. Have you tried updating the software?");
    keywordResponses.put("freeze", "If the system freezes, it might be overloaded. Try closing some applications.");
    keywordResponses.put("error", "Have you encountered an error message? Please provide more details.");
    keywordResponses.put("network", "Network issues can be tricky. Have you checked your internet connection?");
    keywordResponses.put("connection", "It looks like a connection issue. Maybe try restarting your router?");
    keywordResponses.put("internet", "Is your internet connection stable? Try checking with other devices.");
    keywordResponses.put("help", "I'm here to help! Please describe the issue you're facing in detail.");
    keywordResponses.put("slow", "If things are running slowly, try closing unnecessary programs.");
    keywordResponses.put("bug", "It sounds like you may have found a bug. Reporting it might help us fix it!");
  }

  public String generateResponse(String userInput) {
    userInput = userInput.toLowerCase();
    for (String keyword : keywordResponses.keySet()) {
      if (userInput.contains(keyword)) {
        return keywordResponses.get(keyword);
      }
    }
    return "That sounds interesting. Tell me more...";
  }
}
