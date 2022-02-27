package hrms.proje.business.abstracts;

import hrms.proje.entities.concretes.Employer;
import hrms.proje.utilities.results.DataResult;
import hrms.proje.utilities.results.Result;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result signUp(Employer employer);
}
