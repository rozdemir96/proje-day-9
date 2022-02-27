package hrms.proje.api.controllers;

import hrms.proje.business.abstracts.EmployeeService;
import hrms.proje.entities.concretes.Employee;
import hrms.proje.utilities.results.DataResult;
import hrms.proje.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("getall")
    public DataResult<List<Employee>> getAll(){
        return this.employeeService.getAll();
    }

    @PostMapping("signup")
    public Result signUp(@RequestBody Employee employee) throws Exception {
        return this.employeeService.signUp(employee);
    }
}
