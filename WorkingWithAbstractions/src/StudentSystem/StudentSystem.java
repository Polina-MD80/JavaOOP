package StudentSystem;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public
class StudentSystem {
    private Map<String, Student> studentByNameInfo;

    public
    StudentSystem () {
        this.studentByNameInfo = new HashMap<> ();
    }

    public
    Map<String, Student> getStudentByNameInfo () {
        return this.studentByNameInfo;
    }

    public
    void ParseCommand (String[] command) {

        if (command.length == 4) {
            Student student = createStudent (command);
            addStudentInfo (student);

        } else if (command.length == 2) {
            Student student = studentByNameInfo.get (command[1]);
            if (student != null) {
                System.out.println (student);
            }
        } else {
            throw new InputMismatchException ("Invalid Input");
        }
    }

    private
    void addStudentInfo (Student student) {
        this.studentByNameInfo.put (student.getName (), student);
    }

    private
    Student createStudent (String[] command) {
        return new Student (command[1], Integer.parseInt (command[2]), Double.parseDouble (command[3]));
    }
}
