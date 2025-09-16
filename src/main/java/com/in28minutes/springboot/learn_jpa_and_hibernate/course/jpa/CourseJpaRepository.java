package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	// to make use of entity, we use entity manager
//	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	// all the mappings are already done, we only need to merge into course
	public void insert(Course course) {
		// to insert a row, we use merge
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course deleteCourse = entityManager.find(Course.class, id);
		entityManager.remove(deleteCourse);
	}
}
