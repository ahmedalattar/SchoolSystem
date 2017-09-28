package attar.school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "students")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "FirstName is required")
	@Pattern(regexp = "[a-zA-Z]{1,}", message = "Wrong Name")
	private String first_name;
	@Pattern(regexp = "[a-zA-Z]{1,}", message = "Wrong Name")
	@NotNull(message = "LastName is required")
	private String last_name;
	@Column(name = "classes")
	@Pattern(regexp = "^[1-4]-[1-4]$", message = "only 1-1 to 4-4")
	@NotNull(message = "Class is required")
	private String classes;
	@NotNull(message = "Age is required")
	@Min(value = 10, message = "Age must greater than 10")
	@Max(value = 20, message = "Age must less than 20")
	private Integer age;
	@OneToOne(mappedBy = "students")
	private Subjects subject;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	public Students() {

	}

}
