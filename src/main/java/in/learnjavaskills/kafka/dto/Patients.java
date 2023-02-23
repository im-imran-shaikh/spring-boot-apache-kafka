package in.learnjavaskills.kafka.dto;

public class Patients
{
	private Long id;
	private String firstname;
	private String lastname;
	private Short age;
	private String diagnose;
	
	
	
	public Patients() {
	}
	public Patients(Long id, String firstname, String lastname, Short age, String diagnose) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.diagnose = diagnose;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	}
	public String getDiagnose() {
		return diagnose;
	}
	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	@Override
	public String toString() {
		return "Patients [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ ", diagnose=" + diagnose + "]";
	}
	
	
	
}
