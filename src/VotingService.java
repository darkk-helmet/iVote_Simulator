import java.util.ArrayList;

public class VotingService {
    private int[] answerCount = new int[10];

    /**
     * Prints a question and candidate answers to standard output.
     * @param question The {@code Question} containing the question and answers.
     */
    public void displayQuestion(Question question) {
        System.out.println(question.getQuestion());
        for (int i = 0; i < question.getAnswers().length; i++)
            System.out.println((i + 1) + ") " + question.getAnswers()[i]);
    }

    /**
     * Counts how many voters selected each answer.
     * @param voters The list of {@code Voter} objects whose answers are to be counted.
     * @param question The {@code Question} containing the answer choices. There must be no more than 10 answer
     *                 choices in order for votes to be counted.
     */
    public void getVotes(ArrayList<Voter> voters, Question question) {
        if (question.getAnswers().length > 10) {
            System.out.println("\nQuestion has too many choices. A maximum of " + answerCount.length + " choices are " +
                    "allowed. Voting will not open.\n");
            return;
        }

        int numVoters = voters.size();
        int numAnswers;
        ArrayList<Integer> voterAnswers;

        for (int i = 0; i < numVoters; i++) {
            numAnswers = voters.get(i).getAnswers().size();
            voterAnswers = voters.get(i).getAnswers();
            // Get all answers submitted by the voter if the question is multiple choice
            if (question.multiChoice()) {
                for (int j = 0; j < numAnswers; j++) {
                    answerCount[voterAnswers.get(j) - 1]++;
                }
            }
            // Otherwise, only get the last answer submitted by the voter
            else {
                answerCount[voterAnswers.get(numAnswers - 1) - 1]++;
            }
            voters.get(i).clearAnswers();
        }

        displayResults(question);
    }

    /**
     * Prints the count for each answer to standard output.
     * @param question The {@code Question} containing the number of possible answer choices.
     */
    private void displayResults(Question question) {
        System.out.println("\nRESULTS");
        for (int i = 0; i < question.getAnswers().length; i++) {
            System.out.println(question.getAnswers()[i] + " : " + answerCount[i] +
                    (i == question.getAnswers().length - 1 ? "\n" : ""));
        }
    }

}
