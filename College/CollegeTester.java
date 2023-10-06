import java.util.Scanner;

public class CollegeTester {

    /**
     * This main will be used to call the methods from another files(College.java)
     * @param args nothing
     */
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        College langara = new College();

        int done = 0;

        // This loop will show the user menu until he don't want to exit
        while(done == 0){

            System.out.println("\n");
            System.out.println("\nEnter (S) to add new student.");
            System.out.println("Enter (L) to look for a student.");
            System.out.println("Enter (R) to remove the student.");
            System.out.println("Enter (A) to add course marks for student.");
            System.out.println("Enter (I) to get the login ID of a student.");
            System.out.println("Enter (H) to get student with the highest GPA in the college.");
            System.out.println("Enter (E) to EXIT.");

            
            
            System.out.print("\nEnter the value from above given menu: ");
            char option = userInput.next().toUpperCase().charAt(0);



            //This will be to add new student
            if(option == 'S'){

                System.out.print("\nEnter the student name(firstname lastname): ");

                String name = userInput.nextLine();

                if( name.length() < 1){
                    name = userInput.nextLine();
                }

                System.out.print("\nEnter the student address: ");

                String address = userInput.nextLine();

                langara.addStudent(new Student(name, address));




            // This will be used for removing the student from the college
            }else if(option == 'R'){

                String studentNum = "0";// string for checking the length
                int studentNumber = 0;// interger

                while(studentNum.length() != 8 ){

                    System.out.print("\nEnter the 8 digit student number to remove the student: ");

                    studentNumber = userInput.nextInt();

                    studentNum = Integer.toString(studentNumber);
                }

                langara.removeStudent(studentNumber);


            //This will be used to add grade for courses taken by the student 
            }else if(option == 'A'){


                System.out.print("\nEnter the credits earned for the course(integer): ");
                int credit = userInput.nextInt();

                System.out.print("\nEnter the grade points for the course(double): ");
                double gradePoints = userInput.nextDouble();


                String studentNum = "0";// string for checking the length
                int studentNumber = 0;// interger

                while(studentNum.length()< 8){

                    System.out.print("\nEnter the 8 digit student number of the student who take this course: ");
                    studentNumber = userInput.nextInt();
                    studentNum = Integer.toString(studentNumber);
                }

                langara.addGrade(credit, gradePoints, studentNumber);

                System.out.println(langara.addGrade(credit, gradePoints, studentNumber));

                    
            //This will be used to get the login Id of a student    
            }else if(option == 'I'){

                String studentNum = "0";// string for checking the length
                int studentNumber = 0;// interger

                while(studentNum.length()< 8){

                    System.out.print("\nEnter the 8 digit student number of the student for which you want the login ID: ");
                    studentNumber = userInput.nextInt();
                    studentNum = Integer.toString(studentNumber);
                }

                langara.loginID(studentNumber);

                System.out.println(langara.loginID(studentNumber));


            // This will be used to look for specific student in the college
            }else if(option == 'L'){

                String studentNum = "0";// string for checking the length
                int studentNumber = 0;// interger

                while(studentNum.length() != 8){

                    System.out.print("\nEnter the 8 digit student number of the student for which you want the details: ");
                    studentNumber = userInput.nextInt();

                    studentNum = Integer.toString(studentNumber);
                }

                langara.lookForStudent(studentNumber);

                System.out.println(langara.lookForStudent(studentNumber));


            // This will be used to get the student with highest GPA in the college
            }else if(option == 'H'){

                langara.hightestGPA();

                System.out.println("\nStudent with highest GPA in the college: \n" + langara.hightestGPA());


            // This will be used to exit the program
            }else if(option == 'E'){

                    done = 1;
                    System.out.println("\nThank You.");

            //If user enter anything that is not in the menu, this will ask the user to enter the intem from the menu
            }else{
                System.out.println("\nTry again");
            }


        }  

        userInput.close();
    }
    
}
