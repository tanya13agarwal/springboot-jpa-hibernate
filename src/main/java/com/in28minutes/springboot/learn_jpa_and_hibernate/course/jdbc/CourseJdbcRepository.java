package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	// to fire queries
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
//	values(1, 'Learn AWS', 'in28minutes');
	private static String INSERT_QUERY = 
			""" 
				insert into course(id, name, author)
				values(?,?,?);

			""";
	
	private static String DELETE_QUERY = 
			""" 
				delete from course
				where id = ?;

			""";
	
	private static String SELECT_QUERY = 
			""" 
				select * from course
				where id = ?;

			""";
	
	public void insert(Course course) {
//		springJdbcTemplate.update(INSERT_QUERY);
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY,id);
	}
	
	public Course findById(long id) {
		// RowMapper maps each resultset to a bean
		// we are using id to extract that id's row from the table and mapping it to a bean of course class 
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
