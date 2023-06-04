import java.util.ArrayList;

public class Student implements Voter {
    private final String ID;
    private ArrayList<Integer> answers = new ArrayList<>();

    /**
     * Creates a new student.
     * @param ID A unique identifier for the student.
     */
    public Student(String ID) {
        this.ID = ID;
    }

    @Override
    public ArrayList<Integer> getAnswers() {
        return answers;
    }

    @Override
    public void clearAnswers() {
        answers.clear();
    }

    @Override
    public String getID() {
        return ID;
    }
}
