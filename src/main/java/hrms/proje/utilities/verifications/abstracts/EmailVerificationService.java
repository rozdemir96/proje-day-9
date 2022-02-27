package hrms.proje.utilities.verifications.abstracts;

import hrms.proje.utilities.results.Result;

public interface EmailVerificationService {

    Result verifyEmail(String email);
}
