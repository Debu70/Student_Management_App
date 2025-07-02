package com.codeD.springorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codeD.springorm.DAO.StudentDao;
import com.codeD.springorm.entity.StudentEntity;


public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/codeD/springorm/config.xml");
		// fetch bean
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		//for insert Entries
		StudentEntity studentEntity = new StudentEntity(104, "Loji", "Odisha");
		int insertStudent = studentDao.insertStudent(studentEntity);
		System.out.println(insertStudent);
		
		//for get one entry 
		StudentEntity getStudentByID = studentDao.getStudnetById(104);
		System.out.println(getStudentByID);
		
		//for get All entries
		System.out.println(studentDao.getAllStudent());
		
		//for delete one entries
		studentDao.deleteStudent(105);
		System.out.println("Deleted...!");
		
		//for update a existing entry
		StudentEntity studentEntityForUpdate = new StudentEntity(104, "Sibu", "Odisha");
		studentDao.updateStudent(studentEntity);
		System.err.println("Update Successfully over .. "+studentEntityForUpdate.getstudent_id());
		
	}
}