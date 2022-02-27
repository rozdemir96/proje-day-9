package hrms.proje.utilities.adapters.concretes;

import hrms.proje.entities.concretes.Employee;
import hrms.proje.utilities.adapters.abstracts.MernisCheckService;
import hrms.proje.utilities.results.ErrorResult;
import hrms.proje.utilities.results.Result;
import hrms.proje.utilities.results.SuccessResult;
import mernis.KPSPublicSoap;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class MernisCheckManager implements MernisCheckService {

    @Override
    public Result checkIfRealPerson(Employee employee) throws Exception {

        KPSPublicSoap kpsPublicSoap = new KPSPublicSoap();

        boolean result = kpsPublicSoap.TCKimlikNoDogrula(
                Long.parseLong(employee.getIdentityNumber()),
                employee.getFirstname().toUpperCase(new Locale("tr", "TR")),
                employee.getLastname().toUpperCase(new Locale("tr", "TR")),
                Integer.parseInt(employee.getBirthOfYear())
        );

        if(!result){
            return new ErrorResult();
        }
        return new SuccessResult();
    }
}
