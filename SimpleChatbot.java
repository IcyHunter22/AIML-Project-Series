import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SimpleChatbot {

    private String name = "";
    private Map<String, String> context = new HashMap<>();
    private int unrecognizedInputCount = 0; // Counter for unrecognized inputs

    private Set<String> colorSet;
    private Set<String> hobbySet;
    private Map<String, String> seasonSet;

    public SimpleChatbot() {
        // Initialize the set of valid color names
        colorSet = new HashSet<>();
        String[] colors = {
            "black", "blue", "brown", "cyan", "gray", "green", "magenta", "orange",
            "pink", "purple", "red", "white", "yellow"
        };
        for (String color : colors) {
            colorSet.add(color);
        }

        // Initialize the set of common hobbies
        hobbySet = new HashSet<>();
        String[] hobbies = {
            "painting", "drawing", "hiking", "biking", "running", "swimming", "reading",
            "writing", "cooking", "baking", "gardening", "fishing", "traveling", "knitting",
            "sewing", "dancing", "singing", "playing guitar", "playing piano", "gaming",
            "photography", "bird watching", "collecting", "yoga", "meditation"
        };
        for (String hobby : hobbies) {
            hobbySet.add(hobby);
        }

        // Initialize the map of valid seasons and their responses
        seasonSet = new HashMap<>();
        seasonSet.put("summer", "Summer is great for beach vacations!");
        seasonSet.put("winter", "Winter is wonderful with all the snow!");
        seasonSet.put("fall", "Fall is beautiful with all the colorful leaves!");
        seasonSet.put("autumn", "Autumn is beautiful with all the colorful leaves!");
        seasonSet.put("spring", "Spring is lovely with all the blooming flowers!");
    }

    public String greet() {
        return "Hello! I am Chatbot. What's your name?";
    }

    public String farewell() {
        return "Goodbye! It was nice talking to you.";
    }

    public String askQuestion(String question) {
        return question;
    }

    public String respondToGreeting(String userInput) {
        if (name.isEmpty()) {
            name = userInput.trim();
            return "Nice to meet you, " + name + "! How can I help you today?";
        }
        return "We've already been introduced. How can I help you?";
    }

    public String respondToQuestion(String userInput) {
        Map<String, String> responses = new HashMap<>();
        responses.put("how are you?", "I'm just a bot, but I'm doing great! How about you?");
        responses.put("what is your name?", "I'm just a simple chatbot created to help you.");
        responses.put("what can you do?", "I can chat with you, remember our conversation, and ask you questions.");
        responses.put("where are you from?", "I exist in the digital world, created by a programmer.");
        responses.put("tell me a joke", "Why don't scientists trust atoms? Because they make up everything!");

        userInput = userInput.trim().toLowerCase();
        String response = responses.get(userInput);
        if (response == null) {
            unrecognizedInputCount++;
            return handleUnrecognizedInput();
        }
        unrecognizedInputCount = 0; // Reset the counter if input is recognized
        return response;
    }

    public void rememberContext(String question, String answer) {
        context.put(question, answer);
    }

    public String getContext(String question) {
        return context.getOrDefault(question, null);
    }

    private String handleUnrecognizedInput() {
        if (unrecognizedInputCount < 3) {
            return "I'm sorry, I don't understand that. Can you ask something else?";
        } else {
            unrecognizedInputCount = 0; // Reset the counter after guiding the user
            return "I'm still learning and might not understand everything. Try asking questions like 'What can you do?' or 'Tell me a joke'.";
        }
    }

    private boolean isValidColor(String input) {
        return colorSet.contains(input.toLowerCase());
    }

    private boolean isValidHobby(String input) {
        return hobbySet.contains(input.toLowerCase());
    }

    private boolean isValidSeason(String input) {
        return seasonSet.containsKey(input.toLowerCase());
    }

    private boolean isValidYesNo(String input) {
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no");
    }

    private String askValidColor(Scanner scanner, String question) {
        while (true) {
            System.out.println(question);
            String userInput = scanner.nextLine().trim().toLowerCase();
            if (isValidColor(userInput)) {
                return userInput;
            } else {
                System.out.println("I don't think this is a color. Please try again.");
            }
        }
    }

    private String askValidHobby(Scanner scanner, String question) {
        while (true) {
            System.out.println(question);
            String userInput = scanner.nextLine().trim().toLowerCase();
            if (isValidHobby(userInput)) {
                return userInput;
            } else {
                System.out.println("I'm sorry, I don't think that this is a hobby. Could you please try again?");
            }
        }
    }

    private String askValidSeason(Scanner scanner, String question) {
        while (true) {
            System.out.println(question);
            String userInput = scanner.nextLine().trim().toLowerCase();
            if (isValidSeason(userInput)) {
                System.out.println(seasonSet.get(userInput)); // Print the unique response for the season
                return userInput;
            } else {
                System.out.println("I'm sorry, I didn't think this is a season. Could you please try again?");
            }
        }
    }

    private String askYesNo(Scanner scanner, String question) {
        while (true) {
            System.out.println(question);
            String userInput = scanner.nextLine().trim().toLowerCase();
            if (isValidYesNo(userInput)) {
                return userInput;
            } else {
                System.out.println("I'm sorry, I didn't quite get that. Could you please try again?");
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(greet());
        String userInput = scanner.nextLine();
        System.out.println(respondToGreeting(userInput));

        String favoriteColor = askValidColor(scanner, "What is your favorite color?");
        rememberContext("What is your favorite color?", favoriteColor);
        System.out.println("Got it! Your favorite color is: " + favoriteColor);

        String hobby = askValidHobby(scanner, "What is your hobby?");
        rememberContext("What is your hobby?", hobby);
        System.out.println("Got it! Your hobby is: " + hobby);

        String favoriteSeason = askValidSeason(scanner, "What is your favorite season?");
        rememberContext("What is your favorite season?", favoriteSeason);
        System.out.println("Got it! Your favorite season is: " + favoriteSeason);

        String likeMovies = askYesNo(scanner, "Do you like movies?");
        rememberContext("Do you like movies?", likeMovies);
        if (likeMovies.equalsIgnoreCase("yes")) {
            System.out.println("That's awesome! Movies are a great way to relax and enjoy some time off.");
        } else {
            System.out.println("That's okay! Everyone has their own preferences.");
        }
        System.out.println("Got it! You said: " + likeMovies);

        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("bye") || userInput.equalsIgnoreCase("goodbye") || userInput.equalsIgnoreCase("exit")) {
                System.out.println(farewell());
                break;
            }
            String response = respondToQuestion(userInput);
            System.out.println("Chatbot: " + response);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        SimpleChatbot bot = new SimpleChatbot();
        bot.run();
    }
}
