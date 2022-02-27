package hrms.proje.utilities.verifications.concretes;

import hrms.proje.entities.concretes.Employer;
import hrms.proje.utilities.results.Result;
import hrms.proje.utilities.results.SuccessResult;
import hrms.proje.utilities.verifications.abstracts.HrmsApprovalService;
import org.springframework.stereotype.Service;

@Service
public class HrmsApprovalManager implements HrmsApprovalService {

    @Override
    public Result isApprovedFromHrms(Employer employer) {

        return new SuccessResult();
    }
}
