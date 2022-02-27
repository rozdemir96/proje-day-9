package hrms.proje.business.abstracts;

import hrms.proje.entities.concretes.Employee;
import hrms.proje.utilities.results.DataResult;
import hrms.proje.utilities.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();
    Result signUp(Employee employee) throws Exception;
}
