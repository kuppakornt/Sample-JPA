package entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity @Table(name="staff")
public class Staff {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int serial;
	
	@Column(name="first_name", nullable=false)
	public String firstName;
	
	@Column(name="last_name")
	public String lastName;
	
	public double salary;
	
	@Column(unique=true)
	public String email;
}