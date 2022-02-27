package hrms.proje.utilities.verifications.abstracts;

import hrms.proje.entities.concretes.Employer;
import hrms.proje.utilities.results.Result;

public interface HrmsApprovalService {

    Result isApprovedFromHrms(Employer employer);
}
