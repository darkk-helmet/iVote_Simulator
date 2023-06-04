import java.util.ArrayList;

public interface Voter {
    /**
     * @return The list of selected answer choices.
     */
    ArrayList<Integer> getAnswers();

    /**
     * Clears the list of selected answer choices.
     */
    void clearAnswers();

    /**
     * @return The {@code Voter}'s unique identifier.
     */
    String getID();
}
