package hrms.proje.api.controllers;

import hrms.proje.business.abstracts.JobPositionService;
import hrms.proje.entities.concretes.JobPosition;
import hrms.proje.utilities.results.DataResult;
import hrms.proje.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/jobpositions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }

    @PostMapping("addjobposition")
    public Result add(@RequestBody JobPosition jobPosition){

        return this.jobPositionService.add(jobPosition);
    }

}
