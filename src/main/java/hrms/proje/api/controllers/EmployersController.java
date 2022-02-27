package hrms.proje.api.controllers;

import hrms.proje.business.abstracts.EmployerService;
import hrms.proje.entities.concretes.Employer;
import hrms.proje.utilities.results.DataResult;
import hrms.proje.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("getall")
    public DataResult<List<Employer>> getAll(){

        return this.employerService.getAll();
    }

    @PostMapping("signup")
    public Result signUp(Employer employer){
        return this.employerService.signUp(employer);
    }
}
