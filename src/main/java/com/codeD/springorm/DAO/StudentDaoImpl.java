package com.codeD.springorm.DAO;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.codeD.springorm.entity.StudentEntity;

public class StudentDaoImpl implements StudentDao {

	private HibernateTemplate hibernateTemplate;

	// getters and setters
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// for insert student
	@Transactional
	public int insertStudent(StudentEntity studentEntity) {

		Integer insert_student = (Integer) this.hibernateTemplate.save(studentEntity);
		return insert_student;
	}

	// for getById
	public StudentEntity getStudnetById(int student_id) {

		StudentEntity getStudent = this.hibernateTemplate.get(StudentEntity.class, student_id);
		return getStudent;
	}

	// for getAll Entries
	public List<StudentEntity> getAllStudent() {
		List<StudentEntity> loadAllStudent = this.hibernateTemplate.loadAll(StudentEntity.class);
		return loadAllStudent;
	}

	// for delete Entries
	@Transactional
	public void deleteStudent(int student_id) {
		StudentEntity studentEntity = this.hibernateTemplate.get(StudentEntity.class, student_id);
		if (studentEntity != null) {
			this.hibernateTemplate.delete(studentEntity);
		} else {
			System.out.println("Not Found..!");
		}
	}

	// for update entries
	@Transactional
	public void updateStudent(StudentEntity studentEntity) {
		this.hibernateTemplate.update(studentEntity);
	}
}
