package attar.school.services;

import java.util.List;

import javax.validation.Valid;

import attar.school.entity.Students;
import attar.school.entity.Subjects;

public interface StudentService {

	List<Students> getStudents();

	List<Subjects> getsubject(int id);

	void saveStudent(@Valid Students thestudent);

	void saveAverage(@Valid Subjects thesubject,Integer id);

	Subjects getUpdateSubject(Integer id);

	Students getStudent(Integer id);

	void deleteStuednt(Integer id);
	
	

}

