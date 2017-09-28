package attar.school.dao;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import attar.school.entity.Students;
import attar.school.entity.Subjects;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<Students> getStudents() {
		Session session = sessionfactory.getCurrentSession();
		Query<Students> query = session.createQuery("from Students", Students.class);
		List<Students> students = query.getResultList();
		return students;
	}

	@Override
	public List<Subjects> getsubject(int id) {
		Session session = sessionfactory.getCurrentSession();
		// Subjects subject=session.get(Subjects.class, id);
		Query query = session.createQuery("from Subjects where student_id=" + id);
		List<Subjects> subject = query.list();

		return subject;
	}

	@Override
	public void saveStudent(@Valid Students thestudent) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(thestudent);
	}

	@Override
	public void saveAverage(@Valid Subjects thesubject, Integer id) {
		Session session = sessionfactory.getCurrentSession();
		if (thesubject.getStudents() == null) {
			Students student = session.get(Students.class, id);
			thesubject.setStudents(student);
			session.save(thesubject);
		}
		Query query = session.createQuery("select id from Subjects where student_id=:id").setParameter("id", id);
		int num = (int) query.setMaxResults(1).getSingleResult();
		System.out.println(num);
		Subjects subject = session.get(Subjects.class, num);
		session.delete(subject);
		session.save(thesubject);
	}

	@Override
	public Subjects getUpdateSubject(Integer id) {
		Session session = sessionfactory.getCurrentSession();

		Query query = session.createQuery("from Subjects where student_id=:id").setParameter("id", id);

		if ((query.list().size() == 1)) {
			Subjects thesubject = (Subjects) query.getSingleResult();
			return thesubject;
		} else {

			Subjects newsubject = new Subjects();
			return newsubject;
		}

	}

	@Override
	public Students getStudent(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		Students thestudent = session.get(Students.class, id);
		return thestudent;
	}

	@Override
	public void deleteStudent(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		Students thestudent = session.get(Students.class, id);
		session.delete(thestudent);

	}
}
