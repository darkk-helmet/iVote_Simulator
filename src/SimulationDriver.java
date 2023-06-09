import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimulationDriver {
    private static final Random RANDOM = new Random();

    /**
     * Adds a random number (between 10 and 30) of {@code Student} objects to a list.
     * @param voters The list of {@code Voter} objects to add to.
     */
    private static void generateRandomStudents(ArrayList<Voter> voters) {
        for (int i = 0; i < RANDOM.nextInt(10, 31); i++) {
            voters.add(new Student(String.valueOf(i + 1)));
        }
    }

    /**
     * Randomly selects answer choices (between 1 and {@code question.getAnswers().length}) for each {@code Voter}.
     * @param voters The list of {@code Voter} objects to add random answers to.
     * @param question The {@code Question}
     */
    private static void generateRandomAnswers(ArrayList<Voter> voters, Question question) {
        int numAnswers;
        HashSet<Integer> selectedAnswers = new HashSet<>(question.getAnswers().length);

        for (int i = 0; i < voters.size(); i++) {
            numAnswers = RANDOM.nextInt(1, question.getAnswers().length + 1);
            // Select a random amount of answers if the question is multiple choice
            if (question.multiChoice()) {
                for (int j = 0; j < numAnswers; j++) {
                    int randAnswer = RANDOM.nextInt(1, question.getAnswers().length + 1);
                    while (selectedAnswers.contains(randAnswer)) {
                        randAnswer = RANDOM.nextInt(1, question.getAnswers().length + 1);
                    }
                    voters.get(i).getAnswers().add(randAnswer);
                    selectedAnswers.add(randAnswer);
                }
                selectedAnswers.clear();
            }
            // Otherwise, only select one answer
            else {
                voters.get(i).getAnswers().add(numAnswers);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String[] answers = {"int var1 = 100;", "final int var2;", "public static final int var3 = 100;",
                "private int var4 = 100;"};
        String[] trueFalse = {"True", "False"};
        Question q1 = new MultipleChoiceQuestion("Which of the interface variable declarations are correct?",
                answers);
        Question q2 = new SingleChoiceQuestion("Object Oriented Programming is easy.", trueFalse);
        VotingService vs = new VotingService();
        ArrayList<Voter> students = new ArrayList<>();

        generateRandomStudents(students);
        vs.displayQuestion(q1);
        TimeUnit.SECONDS.sleep(3);
        generateRandomAnswers(students, q1);
        vs.getVotes(students, q1);
        TimeUnit.SECONDS.sleep(3);

        vs.displayQuestion(q2);
        TimeUnit.SECONDS.sleep(3);
        generateRandomAnswers(students, q2);
        vs.getVotes(students, q2);
    }
}
