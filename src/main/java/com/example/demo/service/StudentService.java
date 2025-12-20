package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.StudentEntity;

public interface StudentService{
        User postdata(User stu);
        List<User>getAllData();
        String DeleteData(int id);
        User getData(int id);
        StudentEntity updateData(int id,StudentEntity entity);
}