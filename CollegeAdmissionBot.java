import java.util.Scanner;

public class CollegeAdmissionBot {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CollegeAdmissionBot bot = new CollegeAdmissionBot();
        bot.startConversation();
    }

    // Start the conversation with the user
    public void startConversation() {
        System.out.println("Hello! I'm your College Admission Bot. Let's get started with some questions about college admission.");

        askQuestion("admission procedures");
        askQuestion("admission requirements");
        askQuestion("admission deadlines");
        askQuestion("financial aid");
        askQuestion("scholarships");
        askQuestion("credit transfer");
        askQuestion("gpa requirement");
        askQuestion("sat/act scores");
        askQuestion("housing");
        askQuestion("student life");
        askQuestion("online courses");

        System.out.println("Thank you for your responses! If you have more questions, feel free to ask next time. Goodbye!");
    }

    // Method to ask a specific question
    private void askQuestion(String topic) {
        String question = generateQuestion(topic);
        System.out.print("Bot: " + question + "\nYou: ");
        String userInput = scanner.nextLine().trim();
        String response = generateResponse(topic, userInput);
        System.out.println("Bot: " + response);
    }

    // Generate question based on topic
    private String generateQuestion(String topic) {
        switch (topic) {
            case "admission procedures":
                return "Can you describe the admission procedures you're interested in?";
            case "admission requirements":
                return "What do you want to know about the admission requirements?";
            case "admission deadlines":
                return "What deadlines do you need information about?";
            case "financial aid":
                return "Are you looking for information on how to apply for financial aid?";
            case "scholarships":
                return "What types of scholarships are you interested in?";
            case "credit transfer":
                return "Do you need information about transferring credits from another college?";
            case "gpa requirement":
                return "Are you curious about the GPA requirement for a specific program?";
            case "sat/act scores":
                return "Do you need to know if SAT/ACT scores are required?";
            case "housing":
                return "What would you like to know about campus housing options?";
            case "housing price":
            return "Would you like to know the housing prices?";
            case "student life":
                return "Are you interested in learning about student life on campus?";
            case "online courses":
                return "Do you need information about online courses offered by the college?";
            default:
                return "What would you like to know about college admissions?";
        }
    }

    // Generate response based on topic and user input
    private String generateResponse(String topic, String userInput) {
        switch (topic) {
            case "admission procedures":
                return "To apply, fill out the online application, submit transcripts, and provide letters of recommendation.";
            case "admission requirements":
                return "Requirements include a completed application, high school transcripts, SAT/ACT scores, and two letters of recommendation.";
            case "admission deadlines":
                return "Deadlines: Early Decision - Nov 1, Regular Decision - Jan 1, Transfer - March 1";
            case "financial aid":
                return "To apply for financial aid, fill out the FAFSA form and submit any required financial documents.";
            case "scholarships":
                return "Scholarships include merit-based, need-based, and departmental awards. Check the college website for details.";
            case "credit transfer":
                return "Yes, credits from accredited institutions are generally transferable. Submit your transcripts for evaluation.";
            case "gpa requirement":
                return "The minimum GPA requirement is usually around 3.0, but it varies by program.";
            case "sat/act scores":
                return "Yes, SAT/ACT scores are typically required, but some programs may have test-optional policies.";
            case "housing":
                return "Campus housing includes dormitories, apartments, and special interest housing. Visit the housing office for more details.";
            case "housing price": 
                return "$12,768 per academic year for a double room with a meal plan, $8,904 per academic year for a shared room (without meal plan)";
            case "student life":
                return "Student life is vibrant with numerous clubs, sports, and cultural events. There's something for everyone!";
            case "online courses":
                return "Yes, we offer a variety of online courses and programs. Check the college's online learning platform for more information.";
            default:
                return "I'm not sure how to answer that. Could you please provide more details or ask another question?";
        }
    }
}
