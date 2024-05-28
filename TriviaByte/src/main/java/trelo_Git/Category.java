package trelo_Git;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Category {
    private String name;
    private List<Question> questions;

    public Category(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getRandomQuestion() {
        Random rand = new Random();
        return questions.get(rand.nextInt(questions.size()));
    }
}
