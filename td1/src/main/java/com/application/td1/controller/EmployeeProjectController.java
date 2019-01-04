package com.application.td1.controller;
import com.application.td1.model.*;
import com.application.td1.repository.*;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeProjectController {


    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JobRepository jobRepository;

    //@PreAuthorize("hasAnyRole('ADMIN')")
    //@RequestMapping(value = "/charge",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    //public String update(Model model) {
    //    model.addAttribute("form", new FormCountry());
    //    return "index";
    //}





    @RequestMapping(value = "/employees",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String employees (Model model) {
        List<EmployeesEntity> a = employeeRepository.findAll();
        List<JobsEntity> c = jobRepository.findAll();
        List<DepartmentsEntity> b = departmentRepository.findAll();
        model.addAttribute("employee",a);
        model.addAttribute("employeeDelete", new FormEmployee());
        model.addAttribute("employeeAdd", new FormEmployee());
        model.addAttribute("employeeEdit", new FormEmployee());
        model.addAttribute("job",c);
        model.addAttribute("department",b);
        return "employees";

    }

    @PostMapping(value = "/delete")
    public String delete (@ModelAttribute("employeeDelete") FormEmployee employee, Model model) {
        EmployeesEntity b = employeeRepository.findByEmployeeId(employee.getEmployeeId());





        employeeRepository.delete(b);



        employees(model);
        return "employees";

    }

    @PostMapping(value = "/add")
    public String add (@ModelAttribute("employeeAdd") FormEmployee employee, Model model) {
        int id = employee.getEmployeeId();
        Optional<EmployeesEntity> opt = Optional.ofNullable(employeeRepository.findByEmployeeId(id));
        if(opt.isPresent()){
            System.out.println("Error country already exist");

        }
        else{
            EmployeesEntity a= new EmployeesEntity();
            a.setEmployeeId(employee.getEmployeeId());
            a.setFirstName(employee.getFirstName());
            a.setLastName((employee.getLastName()));
            a.setEmail(employee.getEmail());
            a.setPhoneNumber(employee.getPhoneNumber());
            a.setSalary(employee.getSalary());
            a.setHireDate(employee.getHireDate());
            a.setCommissionPct(employee.getCommissionPct());
            a.setManagerId(employee.getManagerId());
            String name = employee.getJobId();
            Optional<JobsEntity> t = Optional.ofNullable(jobRepository.findByJobId(name));
            if(t.isPresent()) {
                //System.out.println(t.getRegionId());
                //System.out.println(t.getRegionName());
                JobsEntity i = t.get();
                a.setJobId(i);
            }
            else{
                System.out.println("error");
            }
            int name2 = employee.getDepartmentId();
            Optional<DepartmentsEntity> y = Optional.ofNullable(departmentRepository.findByDepartmentId(name2));
            if(y.isPresent()) {
                //System.out.println(t.getRegionId());
                //System.out.println(t.getRegionName());
                DepartmentsEntity u = y.get();
                a.setDepartmentId(u);
            }
            else{
                System.out.println("error");
            }



            employeeRepository.save(a);


        }


        employees(model);
        return "employees";
    }
    @PostMapping(value = "/edit")
    public String edit (@ModelAttribute("employeeEdit") FormEmployee employee, Model model) {
        int id = employee.getEmployeeId();
        Optional<EmployeesEntity> opt = Optional.ofNullable(employeeRepository.findByEmployeeId(id));
        if(opt.isPresent()){
            EmployeesEntity b= opt.get();
            b.setEmployeeId(employee.getEmployeeId());
            b.setFirstName(employee.getFirstName());
            b.setLastName((employee.getLastName()));
            b.setEmail(employee.getEmail());
            b.setPhoneNumber(employee.getPhoneNumber());
            b.setSalary(employee.getSalary());
            b.setHireDate(employee.getHireDate());
            b.setCommissionPct(employee.getCommissionPct());
            b.setManagerId(employee.getManagerId());

            int name = employee.getDepartmentId();

            Optional<DepartmentsEntity> t = Optional.ofNullable(departmentRepository.findByDepartmentId(name));
            if(t.isPresent()) {
                //System.out.println(t.getRegionId());
                //System.out.println(t.getRegionName());
                DepartmentsEntity i = t.get();
                b.setDepartmentId(i);
            }
            else{
                System.out.println("error");
            }
            String name2 = employee.getJobId();

            Optional<JobsEntity> u = Optional.ofNullable(jobRepository.findByJobId(name2));
            if(u.isPresent()) {
                //System.out.println(t.getRegionId());
                //System.out.println(t.getRegionName());
                JobsEntity i = u.get();
                b.setJobId(i);
            }
            else{
                System.out.println("error");
            }
            employeeRepository.save(b);

        }
        else{
            System.out.println("Error country already exist");







        }


        employees(model);
        return "employees";
    }

    public static class FormEmployee {

        private Integer employeeId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private Date hireDate;
        private BigDecimal salary;
        private BigDecimal commissionPct;
        private Integer managerId;
        private Integer departmentId;
        private String jobId;

        public Integer getEmployeeId() {
            return employeeId;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Date getHireDate() {
            return hireDate;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public BigDecimal getCommissionPct() {
            return commissionPct;
        }

        public Integer getManagerId() {
            return managerId;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public String getJobId() {
            return jobId;
        }

        public void setEmployeeId(Integer employeeId) {
            this.employeeId = employeeId;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setHireDate(Date hireDate) {
            this.hireDate = hireDate;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        public void setCommissionPct(BigDecimal commissionPct) {
            this.commissionPct = commissionPct;
        }

        public void setManagerId(Integer managerId) {
            this.managerId = managerId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public void setJobId(String jobId) {
            this.jobId = jobId;
        }
    }





}