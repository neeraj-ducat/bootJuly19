package com.ducat.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Course;
@Repository
public interface CourseDao extends CrudRepository<Course, Integer>
{
public Optional<Course> findByName(String name);
}
