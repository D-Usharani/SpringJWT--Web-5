package com.example.springjpaweb5.service;


import java.util.List;

import com.example.springjpaweb5.model.Course;

public interface CourseService
{

    List<Course> all();

    void save( Course course );

    void delete( String courseId );
}
