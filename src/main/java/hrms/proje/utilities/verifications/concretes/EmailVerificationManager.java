package hrms.proje.utilities.verifications.concretes;

import hrms.proje.utilities.results.Result;
import hrms.proje.utilities.results.SuccessResult;
import hrms.proje.utilities.verifications.abstracts.EmailVerificationService;
import org.springframework.stereotype.Service;

@Service
public class EmailVerificationManager implements EmailVerificationService {

    @Override
    public Result verifyEmail(String email) {

        return new SuccessResult("EmailVerificationManager: email doğrulandı.");
    }
}
