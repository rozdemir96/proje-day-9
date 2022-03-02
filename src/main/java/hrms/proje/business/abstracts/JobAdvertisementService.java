package hrms.proje.business.abstracts;


import hrms.proje.entities.concretes.JobAdvertisement;
import hrms.proje.utilities.results.DataResult;
import hrms.proje.utilities.results.Result;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    Result add(JobAdvertisement jobAdvertisement);

    Result update(int jobAdvertisementid, boolean enabled);

    DataResult<List<JobAdvertisement>> getByEnabledTrue();

    DataResult<List<JobAdvertisement>> getByEnabledFalse();

    DataResult<List<JobAdvertisement>> getByEnabledTrueOrderByJobPostingDateAsc();

    DataResult<List<JobAdvertisement>> getByEnabledTrueOrderByJobPostingDateDesc();

    DataResult<List<JobAdvertisement>> getByEnabledTrueAndEmployer_Id(int employerId);

}
