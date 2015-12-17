package org.nac.sms.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.nac.sms.model.Student;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean insertStudent(Student student) {
        List<Student> existingStudentsNid = getAllStudents();
        boolean status = isExist(student, existingStudentsNid);
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        if (status) {
            session.save(student);
        }
        session.getTransaction().commit();
        return status;
    }

    @Override
    public List<Student> getAllStudents() {
        String hql = "FROM Student";
        return (List<Student>) getSessionFactory().openSession().createQuery(hql).list();
    }

    @Override
    public boolean updateStudent(Student studentToBeUpdated) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        String hql = "FROM Student WHERE nid != :nationalID";
        Query queryOne = session.createQuery(hql);
        queryOne.setString("nationalID", studentToBeUpdated.getNid());
        List<Student> studentsNotToBeUpdated = queryOne.list();
        boolean status = isExist(studentToBeUpdated, studentsNotToBeUpdated);

        if (status) {
            String sql = "UPDATE Student SET name = :name, roll = :roll, email = :email, "
                    + "district = :district, phone = :phoneNumber, cgpa = :cgpa, blood_group"
                    + " = :bloodGroup WHERE nid = :nid";
            Query query = session.createSQLQuery(sql);
            query.setString("name", studentToBeUpdated.getName());
            query.setString("roll", studentToBeUpdated.getRoll());
            query.setString("email", studentToBeUpdated.getEmail());
            query.setString("district", studentToBeUpdated.getDistrict());
            query.setString("phoneNumber", studentToBeUpdated.getPhoneNumber());
            query.setString("cgpa", studentToBeUpdated.getCgpa());
            query.setString("bloodGroup", studentToBeUpdated.getBloodGroup());
            query.setString("nid", studentToBeUpdated.getNid());
            query.executeUpdate();
        }
        session.getTransaction().commit();
        return status;
    }

    @Override
    public void deleteStudent(int studentID) {
        List<Student> existingStudentsNid = getAllStudents();
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        for (Student std : existingStudentsNid) {
            if (Objects.equals(std.getId(), studentID)) {
                session.delete(std);
                break;
            }
        }
        session.getTransaction().commit();
    }

    @Override
    public Student getStudent(int studentID) {
        List<Student> existingStudentsNid = getAllStudents();
        for (Student student : existingStudentsNid) {
            if (Objects.equals(studentID, student.getId())) {
                return student;
            }
        }
        return null;
    }

    private boolean isExist(Student student, List<Student> students) {
        boolean notExist = true;
        for (Student std : students) {
            if (Objects.equals(student.getRoll(), std.getRoll())) {
                notExist = false;
                break;
            } else if (Objects.equals(student.getEmail(), std.getEmail())) {
                notExist = false;
                break;
            } else if (Objects.equals(student.getPhoneNumber(), std.getPhoneNumber())) {
                notExist = false;
                break;
            } else if (Objects.equals(student.getNid(), std.getNid())) {
                notExist = false;
                break;
            }
        }
        return notExist;
    }
}
