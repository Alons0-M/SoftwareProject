package trelo_Git;

import java.util.*;

public class QuizManager {
    private Game game;

    public QuizManager() {
        game = new Game();
    }

    public void setupGame() {
        // Setting up categories and questions
        Category programming = new Category("Programming");
        programming.addQuestion(new Question("What is the time complexity of quicksort in the average case?", 
            List.of("O(n)", "O(n log n)", "O(n^2)", "O(log n)"), "O(n log n)"));
        
        Category hardware = new Category("Hardware");
        hardware.addQuestion(new Question("What does CPU stand for?", 
            List.of("Central Processing Unit", "Central Performance Unit", "Central Power Unit", "Central Parallel Unit"), "Central Processing Unit"));

        game.addCategory(programming);
        game.addCategory(hardware);

        // Adding players
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        game.addPlayer(player1);
        game.addPlayer(player2);
    }

    public void startGame() {
        game.start();
    }
}
