package org.example;

import java.util.Scanner;

import java.util.logging.Logger;
class Student
{
    public static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    float gpa;
    public final String name;
    String  grade;
    Student(String name,float gpa,String  grade)
    {
        this.name=name;
        this.gpa=gpa;
        this. grade= grade;
    }
    public void update(float value)
    {
        gpa=value;
        if(value>=9)
        {
            grade="O";
        }
        else if(value>=8)
        {
            grade="A+";

        }
        else if(value>=7)
        {
            grade="A";

        }
        else if(value>=6)
        {
            grade="B+";

        }
        else if(value>=5)
        {
            grade="B";

        }
        else
        {
            grade="F";

        }
        LOGGER.info("---Updated Successfully---");

    }
    public String display()
    {
        String dublicate=String.valueOf(gpa);
        return name+" has a "+dublicate+" GPA "+" and grade is "+ grade;
    }
}
public class StudentGrade {
    public static final Logger LOGGER = Logger.getLogger("InfoLogging");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float gpa;
        LOGGER.info("Enter the Student Name:");
        String name = input.nextLine();
        while (true) {

                LOGGER.info("Enter the GPA:");
                gpa = input.nextFloat();
                if (gpa > 0 && gpa <= 10) {
                    break;
                } else {
                    LOGGER.info("Please enter Valid GPA");
                }

        }
        LOGGER.info("Enter the gradeLevel:");
        String grade = input.next();
        Student student = new Student(name, gpa, grade);
        int temp = 0;
        do {
            try {

                LOGGER.info("\n1.Update\n2.CheckData\n3.Exit\nEnter the Choice:");
                int key = input.nextInt();
                switch (key) {
                    case 1 -> {
                        LOGGER.info("Enter the GPA:");
                        float value = input.nextFloat();
                        if (value > 0 && value <= 10)
                            student.update(value);
                        else
                            LOGGER.info("please enter valid GPA");

                    }
                    case 2 -> {
                        String content = student.display();
                        LOGGER.info(content);
                    }
                    default -> {
                        temp = 1;
                        LOGGER.info("---Thank You---");
                    }
                }

            }
            catch (Throwable e) {
                String value = "Please Enter Valid Inputs:" + e;
                LOGGER.info(value);
                input.nextLine();
            }
        } while (temp != 1);
    }
}