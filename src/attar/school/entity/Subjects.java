package attar.school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subjects")
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Math is required")
	private String math;
	@NotNull(message = "Arabic is required")
	private String arabic;
	@NotNull(message = "Science is required")
	private String science;
	@OneToOne
	@JoinColumn(name = "student_id")
	private Students students;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public String getArabic() {
		return arabic;
	}

	public void setArabic(String arabic) {
		this.arabic = arabic;

	}

	public String getScience() {
		return science;
	}

	public void setScience(String science) {
		this.science = science;
	}

	public Students getStudents() {
		return students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Subjects() {

	}
}
