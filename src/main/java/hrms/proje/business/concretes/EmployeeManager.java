package hrms.proje.business.concretes;

import hrms.proje.business.abstracts.EmployeeService;
import hrms.proje.dataAccess.abstracts.EmployeeDao;
import hrms.proje.entities.concretes.Employee;
import hrms.proje.utilities.adapters.abstracts.FakeCheckService;
import hrms.proje.utilities.adapters.abstracts.MernisCheckService;
import hrms.proje.utilities.results.*;
import hrms.proje.utilities.verifications.abstracts.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private EmailVerificationService emailVerificationService;
    private MernisCheckService mernisCheckService;
    private FakeCheckService fakeCheckService;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, EmailVerificationService emailVerificationService, MernisCheckService mernisCheckService, FakeCheckService fakeCheckService) {
        this.employeeDao = employeeDao;
        this.emailVerificationService = emailVerificationService;
        this.mernisCheckService = mernisCheckService;
        this.fakeCheckService = fakeCheckService;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(this.employeeDao.findAll(), "Employees listelendi.");
    }

    public Result emailControl(String email){
        if(this.employeeDao.findByEmail(email) != null){
            return new ErrorResult("Email sistemde kayıtlı.");
        }
        return new SuccessResult("Email sistemde kayıtlı değil.");
    }

    public Result identityNumberControl(String identityNumber){
        if(this.employeeDao.findByIdentityNumber(identityNumber) != null){
            return new ErrorResult();
        }
        return new SuccessResult();
    }

    @Override
    public Result signUp(Employee employee) throws Exception {
        if(employee.getFirstname().isEmpty() ||
           employee.getLastname().isEmpty() ||
           employee.getEmail().isEmpty() ||
           employee.getIdentityNumber().isEmpty() ||
           employee.getPassword().isEmpty() ||
           employee.getBirthOfYear().isEmpty()){
            return new ErrorResult("Hiçbir alan boş bırakılamaz.");
        }

        if(!this.mernisCheckService.checkIfRealPerson(employee).isSuccess()){
            return new ErrorResult("Tc Kimlik No gerçek bir kişiye ait değil.");
        }

        if(!this.emailControl(employee.getEmail()).isSuccess()){
            return new ErrorResult("Email sistemde kayıtlı olduğundan eklenemedi.");
        }

        if(!this.identityNumberControl(employee.getIdentityNumber()).isSuccess()){
            return new ErrorResult("Tc Kimlik No sistemde kayıtlı olduğundan eklenemedi.");
        }

        if(!this.emailVerificationService.verifyEmail(employee.getEmail()).isSuccess()){
            return new ErrorResult("Email doğrulaması sağlanamadı.");
        }

        this.employeeDao.save(employee);
        return new SuccessResult(employee.getFirstname() + " sisteme kayıt oldu.");
    }
}
