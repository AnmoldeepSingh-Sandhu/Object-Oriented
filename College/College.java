import java.util.ArrayList;

public class College{

    private ArrayList<Student> listOfStudents;

    // This is a College object
    public College(){

        listOfStudents = new ArrayList<Student>();


    }


    /**
     * this method will add new student to the college
     * @param student this is a student object which have name and address of the student
     */
    public void addStudent(Student student){

        listOfStudents.add(student);
        
    }



    /**
     * This method will be used to remove any student from the college by taking his/her student number
     * @param studentNumber this a  student number, that will be enter by the user to remove the student
     */
    public void removeStudent(int studentNumber){

        for(int i = 0; i< listOfStudents.size(); i++){

            Student remove = listOfStudents.get(i);

            if(studentNumber == remove.getStudentNum()){

                listOfStudents.remove(remove);

                i = listOfStudents.size();

            }

        }

    
    }



    /**
     * This method will find the any student data by taking his/her student number
     * @param studentNumber this a  student number, that will be enter by the user to find the student
     * @return it will return student data if there is student in the college with given student number otherwise error message.
     */
    public String lookForStudent(int studentNumber){


        for(int i = 0; i< listOfStudents.size(); i++){

            Student same = listOfStudents.get(i);

            if(studentNumber == same.getStudentNum()){

                return same.toString();

            }

        }

            return "\nThere is no student with this student number";

    }




    /**
     * This methos will be used to add grades for courses taken by each specific student
     * @param credits this represents total credits earned by the student for a course
     * @param gradePoints this represents total grade points earned by the student for a course
     * @param studentNumber this represents student number of a student who will get the grades
     * @return it will add grades for the student if there is student in the college with given student number otherwise error message.
     */
    public String addGrade(int credits, double gradePoints, int studentNumber){

        for(int i = 0; i< listOfStudents.size(); i++){

            Student addGrades = listOfStudents.get(i);

            if(studentNumber == addGrades.getStudentNum()){

                addGrades.addCourse(credits, gradePoints);

                return "\nGrades has been added.";
            }
        }

        return "\nThere is no student with this student ID";

    }



    /**
     * this method will be used to provide the student it's login ID
     * @param studentNumber this student number will be entered by the user to provide login Id to the student with this student number
     * @return it will return back the login Id of the student or error message if there is no student in the college with the given student number
     */
    public String loginID(int studentNumber){


        for(int i = 0; i< listOfStudents.size(); i++){

            Student same = listOfStudents.get(i);

            if(studentNumber == same.getStudentNum()){

                return "\nLogin ID: " + same.getLoginID().toString();

            }

        }

        return "\nThere is no student with this student ID";

    }


    /**
     * this method will be used to get the student data who have the highest GPA in the entire college
     * @return stundent data who have the highest GPA
     */
    public Student hightestGPA(){

        Student highest = listOfStudents.get(0);

        for(int i = 1; i< listOfStudents.size(); i++){

            Student student = listOfStudents.get(i);

            if( highest.getGPA() < student.getGPA()){

                highest = student;

            }

        }

        return highest;

    }
    


    
    /**
     * this method gives text represention of college
     */
    public String toString(){

        return "Student: " + listOfStudents.toString();
    }
    
}
