public class MultipleChoiceQuestion extends SingleChoiceQuestion implements Question {

    /**
     * Creates a new multiple choice question.
     * @param question The question.
     * @param answers The array of answer choices.
     */
    public MultipleChoiceQuestion(String question, String[] answers) {
        super(question, answers);
    }


    /**
     * @return {@code True}
     */
    @Override
    public boolean multiChoice() {
        return true;
    }
}
