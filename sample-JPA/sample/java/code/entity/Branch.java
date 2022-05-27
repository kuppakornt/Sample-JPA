package entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Table(name="branch")
public class Branch {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int serial;
   
    public String name;
    public double area;
    
    public transient int staff;
}
class A { }
class B { }