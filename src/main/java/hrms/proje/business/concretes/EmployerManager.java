package hrms.proje.business.concretes;

import hrms.proje.business.abstracts.EmployerService;
import hrms.proje.dataAccess.abstracts.EmployerDao;
import hrms.proje.entities.concretes.Employer;
import hrms.proje.utilities.results.*;
import hrms.proje.utilities.verifications.abstracts.EmailVerificationService;
import hrms.proje.utilities.verifications.abstracts.HrmsApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailVerificationService emailVerificationService;
    private HrmsApprovalService hrmsApprovalService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService, HrmsApprovalService hrmsApprovalService) {
        this.employerDao = employerDao;
        this.emailVerificationService = emailVerificationService;
        this.hrmsApprovalService = hrmsApprovalService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {

        return new SuccessDataResult<>(this.employerDao.findAll(), "Employers listelendi.");
    }

    public Result emailOnayla(String email){
        if(!this.emailVerificationService.verifyEmail(email).isSuccess()){
            return new ErrorResult();
        }
        return new SuccessResult();
    }



    @Override
    public Result signUp(Employer employer) {

        if(!this.emailOnayla(employer.getEmail()).isSuccess()){
            return new ErrorResult("Email onaylanmadı.");
        }

        if(!this.hrmsApprovalService.isApprovedFromHrms(employer).isSuccess()){
            return new ErrorResult("Hrms personeli onaylamadı.");
        }

        this.employerDao.save(employer);
        return new SuccessResult(employer.getCompanyName() + " şirketi sisteme kayıt oldu.");
    }
}
