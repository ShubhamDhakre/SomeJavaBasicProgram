package Shubhamjava;
import java.util.Scanner;

class StudentDetail{
    String name ;
    int age ;
    int rollno;
    float percentage;
   void detail() {
     System.out.println("Student Name is :"+ this.name);
     System.out.println("Student Age is :"+ this.age);
     System.out.println("Student Rollno is :"+this.rollno);
     System.out.println("Student Percentage is "+this.percentage); }

} 
class Student{
    public static void main(String[]args){ 
        StudentDetail m = new StudentDetail();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name");
        m.name = sc.nextLine();
        System.out.println("Enter Student Age");
        m.age = sc.nextInt();
        System.out.println("Enter Student Rollno");
        m.rollno = sc.nextInt();
        System.out.println("Enter Student Percentage");
        m.percentage = sc.nextFloat();
        System.out.println("IF WE WANT TO PRINT THE DETAIL OF THE STUDENT THE PRESS 1 ;");
        int a = sc.nextInt();
        if(a==1)
        m.detail();
        System.out.println("THANK YOU FOR USE ");

    } 
    
    
    
    

}