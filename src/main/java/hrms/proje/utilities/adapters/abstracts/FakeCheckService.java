package hrms.proje.utilities.adapters.abstracts;

import hrms.proje.entities.concretes.Employee;
import hrms.proje.utilities.results.Result;

public interface FakeCheckService {

    Result checkIfRealPerson(Employee employee);
}
