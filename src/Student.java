import java.util.ArrayList;

public class Student implements Voter {
    private final String ID;
    private final ArrayList<Integer> ANSWERS = new ArrayList<>();

    /**
     * Creates a new student.
     * @param ID A unique identifier for the student.
     */
    public Student(String ID) {
        this.ID = ID;
    }

    @Override
    public ArrayList<Integer> getAnswers() {
        return ANSWERS;
    }

    @Override
    public void clearAnswers() {
        ANSWERS.clear();
    }

    @Override
    public String getID() {
        return ID;
    }
}
