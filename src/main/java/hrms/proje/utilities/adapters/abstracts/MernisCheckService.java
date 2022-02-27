package hrms.proje.utilities.adapters.abstracts;

import hrms.proje.entities.concretes.Employee;
import hrms.proje.utilities.results.Result;

public interface MernisCheckService {

    Result checkIfRealPerson(Employee employee) throws Exception;
}
