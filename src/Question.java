public interface Question {
    /**
     * @return The question.
     */
    String getQuestion();

    /**
     * @return The list of answer choices.
     */
    String[] getAnswers();

    /**
     * Specifies whether the question is multiple choice.
     * @return {@code True} if multiple choice.
     */
    boolean multiChoice();
}
