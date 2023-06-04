public interface Question {
    /**
     * @return The question.
     */
    String getQuestion();

    /**
     * @return The string array of answer choices.
     */
    String[] getAnswers();

    /**
     * Change the answer choices.
     * @param answers The string array containing the new answer choices.
     */
    void changeAnswers(String[] answers);

    /**
     * Specifies whether the question is multiple choice.
     * @return {@code True} if multiple choice.
     */
    boolean multiChoice();
}
