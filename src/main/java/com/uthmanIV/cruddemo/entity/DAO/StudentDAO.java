package com.uthmanIV.cruddemo.entity.DAO;

import com.uthmanIV.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Long id);
    List<Student> findAll();
    void saveAll(List<Student> students); // how can i implement this with entityManager
    Student findByLastName(String lastName);
    void deleteById(Long id);

    void updateDetails(Long id,String fName,String lName, String email);
    void reattach(Long id);
    void deleteAll();
}
