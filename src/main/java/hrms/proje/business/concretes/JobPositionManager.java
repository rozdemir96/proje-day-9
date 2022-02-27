package hrms.proje.business.concretes;

import hrms.proje.business.abstracts.JobPositionService;
import hrms.proje.dataAccess.abstracts.JobPositionDao;
import hrms.proje.utilities.results.*;
import hrms.proje.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobDao) {
        this.jobPositionDao = jobDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll(), "Data listelendi.");
    }

    public Result jobPositionControl(String positionName){
        if(this.jobPositionDao.findByPositionName(positionName) != null){
            return new ErrorResult();
        }
        return new SuccessResult();
    }

    @Override
    public Result add(JobPosition jobPosition) {

        if(!jobPositionControl(jobPosition.getPositionName()).isSuccess()){
            return new ErrorResult("İş pozisyonu sistemde kayıtlı.");
        }

        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("İş pozisyonu eklendi: " + jobPosition.getPositionName());
    }

}
