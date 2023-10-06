// import java.text.Format;

public class Student{

    private String name;
    private String address;
   
    private double totalGPA;
    private String loginID;


	private int studentNumber;
	private static int student_numbers = 10000001;

    
    /**
     * This is student constructor, it will get the name and address of the student give him his/her unique student number
     * @param givenName it will store the student name enter by the user
     * @param givenAddress it will store the address enter by the user
     */

    public Student(String givenName, String givenAddress){

        name = givenName;
        address = givenAddress;
      
        studentNumber = student_numbers;
        student_numbers++;
    }




    /**
     * 
     * @param name it will store the name of student
     * @return it will return the name of student
     */

    public String getName(String name){
        return name;
    }


    
    /**
     * 
     * @param address it will store the address of the student
     * @ it will return the address of the student
     */
    public String getAddress(String address){
        return address;
    }



    /**
     * This method get the total credits and grade point of the student and call calculateGPA method and return the total GPA 
     * @param totalCredits it will store the sum of credits from all the courses taken by student
     * @param totalGradePoints it will store the sum of grade points from all the courses taken by student
     * @return it will return the GPA of student
     */

    public double addCourse(int totalCredits, double totalGradePoints){

        return calculateGPA(totalCredits, totalGradePoints);
    }



    /**
     * This method calculate the GPA
     * @param totalCredits it will store the sum of credits from all the courses taken by student
     * @param totalGradePoints it will store the sum of grade points from all the courses taken by student
     * @return it will return the GPA of student
     */

    public double calculateGPA(int totalCredits, double totalGradePoints){

        totalGPA = totalGradePoints/totalCredits;

        return totalGPA;
    }


    /**
     * 
     * @return it will return the GPA of a student
     */
    public double getGPA(){

        //  a = Double.toString(totalGPA);
        String a = String.format("%.2f", totalGPA);
        totalGPA = Double.parseDouble(a);
        return totalGPA;
    }



    /**
     * this method give each student it's unique student number
     * @return it will return student number 
     */
    public int getStudentNum(){
        return studentNumber;
    }


    /**
     * this method will use student name and student number to create the login ID for the student
     * @return it will return the login ID of each student
     */

    public String getLoginID(){

        name.trim();

        String studentNum = Integer.toString(studentNumber);
        loginID = name.toLowerCase().substring(0, 1);

     

        String lastName = name.split(" ")[1];

        if(lastName.length() < 3){

            loginID += lastName.toLowerCase();
        }else{

            loginID += lastName.toLowerCase().substring(0, 3);
        }



        loginID+= studentNum.substring(5);
        return loginID;
    }


    /**
     * This method will convert all data to string to show the user final result
     */

    public String toString(){

        return "\n Name: " + name + "\n Address: "+ address + "\n GPA: "+ totalGPA +"\n Student Number: " + studentNumber + "\n Login ID: " + loginID;
    }
     
}
