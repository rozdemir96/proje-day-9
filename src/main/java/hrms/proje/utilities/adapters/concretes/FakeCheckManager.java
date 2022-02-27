package hrms.proje.utilities.adapters.concretes;

import hrms.proje.entities.concretes.Employee;
import hrms.proje.utilities.adapters.abstracts.FakeCheckService;
import hrms.proje.utilities.results.Result;
import hrms.proje.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class FakeCheckManager implements FakeCheckService {
    @Override
    public Result checkIfRealPerson(Employee employee) {
        return new SuccessResult();
    }
}
