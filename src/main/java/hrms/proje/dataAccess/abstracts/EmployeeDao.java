package hrms.proje.dataAccess.abstracts;

import hrms.proje.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    Employee findByEmail(String email);
    Employee findByIdentityNumber(String identityNumber);

}
