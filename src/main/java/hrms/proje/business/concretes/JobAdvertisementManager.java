package hrms.proje.business.concretes;

import hrms.proje.business.abstracts.JobAdvertisementService;
import hrms.proje.dataAccess.abstracts.JobAdvertisementDao;
import hrms.proje.entities.concretes.JobAdvertisement;
import hrms.proje.utilities.results.DataResult;
import hrms.proje.utilities.results.Result;
import hrms.proje.utilities.results.SuccessDataResult;
import hrms.proje.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;

    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Bütün ilanlar listelendi.");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {

        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public Result update(int jobAdvertisementid, boolean enabled) {

        JobAdvertisement jobAdvertisement;
        jobAdvertisement = this.jobAdvertisementDao.findById(jobAdvertisementid).get();

        jobAdvertisement.setEnabled(enabled);

        this.jobAdvertisementDao.save(jobAdvertisement);

        return new SuccessResult("İlan " + enabled + " durumuna getirildi.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEnabledTrue() {

        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEnabledTrue(), "Aktif ilanlar Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEnabledFalse() {

        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEnabledFalse(), "Pasif ilanlar Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEnabledTrueOrderByJobPostingDateAsc() {

        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEnabledTrueOrderByJobPostingDateAsc(), "Artan sırada listelendi.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEnabledTrueOrderByJobPostingDateDesc() {

        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEnabledTrueOrderByJobPostingDateDesc(), "Azalan sırada listelendi.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEnabledTrueAndEmployer_Id(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEnabledTrueAndEmployer_Id(employerId), "EmployerId'ye göre listelendi.");
    }
}
