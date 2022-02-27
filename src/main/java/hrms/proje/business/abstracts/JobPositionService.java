package hrms.proje.business.abstracts;

import hrms.proje.entities.concretes.JobPosition;
import hrms.proje.utilities.results.DataResult;
import hrms.proje.utilities.results.Result;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();
    Result add(JobPosition jobPosition);
}
