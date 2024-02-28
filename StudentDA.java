import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class StudentDA{
    private List<Student> studentList;

    public List<Student> getStudentList(){
        return studentList;
    }

    public StudentDA(String blockCode) throws FileNotFoundException{
        studentList = new ArrayList<>();
        Scanner inputFile = new Scanner(new FileReader("BlockSectionStudent.csv"));

        while(inputFile.hasNext()){
            String blockSectionRow = new String();
            blockSectionRow = inputFile.nextLine();
            String[] blockSectionArray = new String[2];
            blockSectionArray = blockSectionRow.split(",");

            if(blockCode.equals(blockSectionArray[0].trim())){
                Scanner studentFile = new Scanner(new FileReader("Student.csv"));
                
                while(studentFile.hasNext() ){
                    String studentRow = new String();
                    studentRow = studentFile.nextLine();
                    String[] studentArray = new String [3];
                    studentArray = studentRow.split(",");

                    if(blockSectionArray[1].trim().equals(studentArray[0].trim())){
                        Student student = new Student();
                        student.setStudentNo(studentArray[0].trim());
                        student.setLastName(studentArray[1].trim());
                        student.setFirstName(studentArray[2].trim());
    
                        studentList.add(student);
                    }

                }

            }
        }
    
    }
}