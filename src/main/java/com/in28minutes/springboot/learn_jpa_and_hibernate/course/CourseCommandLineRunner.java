package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

// to make it run at start up
@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
	// to inject repo
	@Autowired
//	private CourseJdbcRepository repository;
//	private CourseJpaRepository repository;
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		repository.insert();
//		repository.insert(new Course(1, "learn aws", "in28minutes"));
//		repository.insert(new Course(2, "learn devops", "in28minutes"));
//		repository.insert(new Course(3, "learn angular", "in28minutes"));
		repository.save(new Course(1, "learn aws", "in28minutes"));
		repository.save(new Course(2, "learn devops", "in28minutes"));
		repository.save(new Course(3, "learn angular", "in28minutes"));
		

		repository.deleteById(1l);
		System.out.println(repository.findById(2l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor("in28minutes"));
	}
}
