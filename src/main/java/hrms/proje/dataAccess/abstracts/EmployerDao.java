package hrms.proje.dataAccess.abstracts;

import hrms.proje.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

    Employer findByEmail(String email);
}
