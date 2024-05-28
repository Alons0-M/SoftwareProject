package trelo_Git;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private List<Player> players;
    private List<Category> categories;
    private Scanner scanner;

    public Game() {
        players = new ArrayList<>();
        categories = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void start() {
        System.out.println("Welcome to the Trivia Game!");
        for (Player player : players) {
            System.out.println("It's " + player.getName() + "'s turn.");
            askQuestion(player);
        }
        end();
    }

    public void askQuestion(Player player) {
        Category category = categories.get(new Random().nextInt(categories.size()));
        Question question = category.getRandomQuestion();

        System.out.println("Category: " + category.getName());
        System.out.println(question.getQuestionText());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ": " + options.get(i));
        }

        System.out.print("Your answer: ");
        int answerIndex = scanner.nextInt() - 1;
        String answer = options.get(answerIndex);

        if (question.isCorrect(answer)) {
            System.out.println("Correct!");
            player.incrementScore();
        } else {
            System.out.println("Wrong! The correct answer was: " + question.getCorrectAnswer());
        }
    }

    public void end() {
        System.out.println("Game Over! Here are the scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
}
