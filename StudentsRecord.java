import java.util.ArrayList;
import java.util.Scanner;

class Students {
     int ID;
     String name;
     int marks;

    public Students(int id,String name,int marks){
        this.ID=id;
        this.name=name;
        this.marks=marks;
    }

    public void display(){
        System.out.println("ID : "+ID+" Name : "+name+" Marks : "+marks);
    }
}

public class StudentsRecord{
   
static ArrayList<Students> studList=new ArrayList<>();
static Scanner scanner=new Scanner(System.in);

public static void main(String[] args) {
     System.out.println("*****Student Record Management System*****");
    int choice;
    do { 

         System.out.println("Enter any option");
    System.out.println("1. Add Students");
    System.out.println("2. View students");
    System.out.println("3. Update Students");
    System.out.println("4. Delete students");
    System.out.println("5. Exit");
    choice=scanner.nextInt();
    
        switch(choice){
            case 1:
                addStudent();
                break;
            case 2:
                viewDetail();
                break;
            case 3:
                updateStudent();
                break;
            case 4:
                deleteStudent();
                break;
            case 5:
                System.out.println("Exited");
        }
    
    } while (choice!=5);

}

static void addStudent(){
    // int choice=scanner.nextInt();
   
    System.out.println("Enter Student ID : ");
    int ID =scanner.nextInt();
    scanner.nextLine();

    System.out.println("Enter Student Name : ");
    String name=scanner.nextLine();

    System.out.println("Enter Marks: ");
    int marks=scanner.nextInt();

    studList.add(new Students(ID, name, marks));
    System.out.println("Student Record Added Successfully!");
    System.out.println();

}

static void viewDetail(){
    if(studList.isEmpty()){
        System.out.println("No Records Found");
    }
    else{
        System.out.println("Student Records: ");
        for(Students students:studList){
            
            students.display();
        }
    }
        System.out.println();

}

static void updateStudent() {
    System.out.println("Enter Student ID to Update:");
    int id = scanner.nextInt();
    scanner.nextLine(); // consume the leftover newline

    boolean found = false; // flag to check if student is found

    for (Students s : studList) {
        if (s.ID == id) {
            System.out.println("Enter new Name: ");
            s.name = scanner.nextLine();

            System.out.println("Enter new marks: ");
            s.marks = scanner.nextInt();

            System.out.println("Updated Successfully");
            found = true;
            break; // no need to check further
        }
    }

    if (!found) {
        System.out.println("**ID Doesn't Match. Please enter correct student ID!**");
    }

    System.out.println();
}


static void deleteStudent() {
    System.out.println("Enter Student ID to Delete: ");
    int id = scanner.nextInt();
    
    boolean found = false;

    for (int i = 0; i < studList.size(); i++) {
        if (studList.get(i).ID == id) {
            studList.remove(i);
            System.out.println("Successfully Removed!");
            found = true;
            break; // stop after deletion
        }
    }

    if (!found) {
        System.out.println("***Student ID not Found***");
    }

    System.out.println();
}


}
