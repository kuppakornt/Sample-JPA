package web;
import java.util.ArrayList;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
class Start {
	public static void main(String[] data) {
		ApplicationContext context;
		context = SpringApplication.run(Empty.class);
	}
}
@SpringBootApplication
class Empty { }

@RestController
class Show {
	@RequestMapping("/list-staff")
	ArrayList m() {
		ArrayList a = new ArrayList();
		try {
			var factory = Persistence.
							createEntityManagerFactory("primary");
			var manager = factory.createEntityManager();

			String jpql = " select m from Staff m   " +
						  " where m.salary >= :slr  ";
			Query q = manager.createQuery(jpql);
			q.setParameter("slr", 30000);
			a = (ArrayList)q.getResultList();
			manager.close(); factory.close();
		} catch (Exception e) {
			a.add(e);
		}
		return a;
	}
}
