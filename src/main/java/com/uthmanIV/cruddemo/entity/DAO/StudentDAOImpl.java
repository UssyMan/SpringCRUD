package com.uthmanIV.cruddemo.entity.DAO;

import com.uthmanIV.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("From Student", Student.class);//we pass two params the queryParam&classObj
        return query.getResultList(); // returns the List<Student> from the TypedQuery<Student>
    }

    @Override
    public void saveAll(List<Student> students) {

    }

    @Override
    public Student findByLastName(String studentLastName) {
        TypedQuery<Student> student = entityManager
                .createQuery("From Student Where lastName=:lName",Student.class);
        student.setParameter("lName",studentLastName);
        return student.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);
    }
    //reversing a detach
    @Transactional
    public void reattach(Long id){
        Student student = entityManager.find(Student.class,id);
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateDetails(Long id,String fName,String lName, String email) {
        Student student = entityManager.find(Student.class, id);
        student.setFirstName(fName);
        student.setLastName(lName);
        student.setEmail(email);

        entityManager.merge(student);
        //this method needs all the data inputs even if you wouldn't update an input which is sad
    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
