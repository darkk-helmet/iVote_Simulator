public class SingleChoiceQuestion implements Question {
    private String question;
    private String[] answers;

    /**
     * Creates a new single choice question.
     * @param question The question.
     * @param answers The array of answer choices.
     */
    public SingleChoiceQuestion(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String[] getAnswers() {
        return answers;
    }

    /**
     * @return {@code False}
     */
    @Override
    public boolean multiChoice() {
        return false;
    }
}
