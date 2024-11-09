package fall24.hsf301.slot1.pojo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "fistName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "mark")
	private int mark;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Set<Book> books;

	public Student(String firstName, String lastName, int mark) {
		super();
		books = new HashSet<Book>();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
	}

	public Student(int id, String firstName, String lastName, int mark) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
	}

	public Student() {
		this.firstName = "";
		this.lastName = "";
		this.mark = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, mark);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& mark == other.mark;
	}

}
