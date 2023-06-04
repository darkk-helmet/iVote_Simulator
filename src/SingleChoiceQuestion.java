public class SingleChoiceQuestion implements Question {
    private final String QUESTION;
    private String[] answers;

    /**
     * Creates a new single choice question.
     * @param question The question.
     * @param answers The array of answer choices.
     */
    public SingleChoiceQuestion(String question, String[] answers) {
        QUESTION = question;
        this.answers = answers;
    }

    @Override
    public String getQuestion() {
        return QUESTION;
    }

    @Override
    public String[] getAnswers() {
        return answers;
    }

    @Override
    public void changeAnswers(String[] answers) {
        this.answers = answers;
    }

    /**
     * @return {@code False}
     */
    @Override
    public boolean multiChoice() {
        return false;
    }
}
