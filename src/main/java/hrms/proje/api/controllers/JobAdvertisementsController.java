package hrms.proje.api.controllers;

import hrms.proje.business.abstracts.JobAdvertisementService;
import hrms.proje.entities.concretes.JobAdvertisement;
import hrms.proje.utilities.results.DataResult;
import hrms.proje.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobadvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){

        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("getall")
        public DataResult<List<JobAdvertisement>> getAll(){
            return this.jobAdvertisementService.getAll();
        }

    @GetMapping("getalltrue")
    public DataResult<List<JobAdvertisement>> getByEnabledTrue(){
        return this.jobAdvertisementService.getByEnabledTrue();
    }

    @GetMapping("getallfalse")
    public DataResult<List<JobAdvertisement>> getByEnabledFalse(){
        return this.jobAdvertisementService.getByEnabledFalse();
    }

    @GetMapping("getByEnabledTrueOrderByJobPostingDateAsc")
    public DataResult<List<JobAdvertisement>> getByEnabledTrueOrderByJobPostingDateAsc(){
        return this.jobAdvertisementService.getByEnabledTrueOrderByJobPostingDateAsc();
    }

    @GetMapping("getByEnabledTrueOrderByJobPostingDateDesc")
    public DataResult<List<JobAdvertisement>> getByEnabledTrueOrderByJobPostingDateDesc(){
        return this.jobAdvertisementService.getByEnabledTrueOrderByJobPostingDateDesc();
    }

    @GetMapping("getByEnabledTrueAndEmployer_Id")
    public DataResult<List<JobAdvertisement>> getByEnabledTrueAndEmployer_Id(int employerId){
        return this.jobAdvertisementService.getByEnabledTrueAndEmployer_Id(employerId);
    }

    @PutMapping("update")
    public Result update(@RequestParam int jobAdvertisementid, @RequestParam boolean enabled){
        return this.jobAdvertisementService.update(jobAdvertisementid, enabled);
    }
}
