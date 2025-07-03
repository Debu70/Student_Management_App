package com.codeD.springorm.DAO;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.codeD.springorm.entity.StudentEntity;

public interface StudentDao {

	// for insert student
	@Transactional
	public int insertStudent(StudentEntity studentEntity);

	// for getById
	public StudentEntity getStudnetById(int student_id);

	// for getAll Entries
	public List<StudentEntity> getAllStudent();

	// for delete Entries
	@Transactional
	public void deleteStudent(int student_id);

	// for update entries
	@Transactional
	public void updateStudent(StudentEntity studentEntity);
}
