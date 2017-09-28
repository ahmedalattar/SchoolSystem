package attar.school.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import attar.school.dao.StudentDao;
import attar.school.entity.Students;
import attar.school.entity.Subjects;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	@Transactional
	public List<Students> getStudents() {

		return studentDao.getStudents();
	}

	@Override
	@Transactional
	public List<Subjects> getsubject(int id) {

		return studentDao.getsubject(id);
	}

	@Override
	@Transactional
	public void saveStudent(@Valid Students thestudent) {

		studentDao.saveStudent(thestudent);

	}

	@Override
	@Transactional
	public void saveAverage(@Valid Subjects thesubject, Integer id) {
		studentDao.saveAverage(thesubject, id);

	}

	@Override
	@Transactional
	public Subjects getUpdateSubject(Integer id) {

		return studentDao.getUpdateSubject(id);
	}

	@Override
	@Transactional
	public Students getStudent(Integer id) {

		return studentDao.getStudent(id);
	}

	@Override
	@Transactional
	public void deleteStuednt(Integer id) {

		studentDao.deleteStudent(id);

	}

}
