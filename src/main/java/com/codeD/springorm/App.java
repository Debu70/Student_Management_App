package com.codeD.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codeD.springorm.DAO.StudentDao;
import com.codeD.springorm.entity.StudentEntity;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/codeD/springorm/config.xml");

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        while (flag) {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("Press 1 for Insert Student");
            System.out.println("Press 2 for Get One Student Entry");
            System.out.println("Press 3 for Get All Student Entries");
            System.out.println("Press 4 for Delete Existing Student Entry");
            System.out.println("Press 5 for Update One Student Entry");
            System.out.println("Press 6 for Exit");
            System.out.println("====================================");

            try {
                int userInput = Integer.parseInt(bufferedReader.readLine());

                switch (userInput) {
                    case 1: {
                        // Insert Student
                        System.out.print("Enter Student ID: ");
                        int id = Integer.parseInt(bufferedReader.readLine());

                        System.out.print("Enter Student Name: ");
                        String name = bufferedReader.readLine();

                        System.out.print("Enter Student City: ");
                        String city = bufferedReader.readLine();

                        StudentEntity student = new StudentEntity();
                        student.setstudent_id(id);
                        student.setstudent_name(name);
                        student.setstudent_address(city);

                        int inserted = studentDao.insertStudent(student);
                        System.out.println("Student Inserted Successfully with ID: " + inserted);
                        break;
                    }
                    case 2: {
                        // Get one student
                        System.out.print("Enter Student ID to Fetch: ");
                        int id = Integer.parseInt(bufferedReader.readLine());

                        StudentEntity student = studentDao.getStudnetById(id);
                        if (student != null) {
                            System.out.println("Student Details: " + student);
                        } else {
                            System.out.println("Student not found with ID: " + id);
                        }
                        break;
                    }
                    case 3: {
                        // Get all students
                        List<StudentEntity> students = studentDao.getAllStudent();
                        for (StudentEntity s : students) {
                            System.out.println(s);
                        }
                        break;
                    }
                    case 4: {
                        // Delete student
                        System.out.print("Enter Student ID to Delete: ");
                        int id = Integer.parseInt(bufferedReader.readLine());

                        studentDao.deleteStudent(id);
                        System.out.println("Student deleted with ID: " + id);
                        break;
                    }
                    case 5: {
                        // Update student
                        System.out.print("Enter Student ID to Update: ");
                        int id = Integer.parseInt(bufferedReader.readLine());

                        System.out.print("Enter Updated Name: ");
                        String name = bufferedReader.readLine();

                        System.out.print("Enter Updated City: ");
                        String city = bufferedReader.readLine();

                        StudentEntity student = new StudentEntity();
                        student.setstudent_id(id);
                        student.setstudent_name(name);
                        student.setstudent_address(city);

                        studentDao.updateStudent(student);
                        System.out.println("Student Updated Successfully!");
                        break;
                    }
                    case 6: {
                        System.out.println("Thank You For Using Student Management App!");
                        flag = false;
                        break;
                    }
                    
                }
            } catch (Exception e) {
                System.out.println("Invalid Input. Please Try Again!");
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
