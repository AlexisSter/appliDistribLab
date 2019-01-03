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

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/department")
public class DepartmentsController {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    //@PreAuthorize("hasAnyRole('ADMIN')")
    //@RequestMapping(value = "/charge",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    //public String update(Model model) {
    //    model.addAttribute("form", new FormCountry());
    //    return "index";
    //}





    @RequestMapping(value = "/departments",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String departments (Model model) {
        List<DepartmentsEntity> a = departmentRepository.findAll();
        List<LocationsEntity> c = locationRepository.findAll();
        List<EmployeesEntity> b = employeeRepository.findAll();
        model.addAttribute("department",a);
        model.addAttribute("departmentDelete", new FormDepartment());
        model.addAttribute("departmentAdd", new FormDepartment());
        model.addAttribute("departmentEdit", new FormDepartment());
        model.addAttribute("location",c);
        model.addAttribute("employee",b);
        return "departments";

    }

    @PostMapping(value = "/delete")
    public String delete (@ModelAttribute("departmentDelete") FormDepartment department, Model model) {
        DepartmentsEntity b = departmentRepository.findByDepartmentId(department.getDepartmentId());





        departmentRepository.delete(b);



        departments(model);
        return "departments";

    }

    @PostMapping(value = "/add")
    public String add (@ModelAttribute("departmentAdd") FormDepartment department, Model model) {
        int id = department.getDepartmentId();
        Optional<DepartmentsEntity> opt = Optional.ofNullable(departmentRepository.findByDepartmentId(id));
        if(opt.isPresent()){
            System.out.println("Error country already exist");

        }
        else{
            DepartmentsEntity a= new DepartmentsEntity();
            a.setDepartmentId(department.getDepartmentId());
            a.setDepartmentName(department.getDepartmentName());
            a.setManagerId(department.getDepartmentManagerId());
            int name = department.getDepartmentLocation();
            Optional<LocationsEntity> t = Optional.ofNullable(locationRepository.findByLocationId(name));
            if(t.isPresent()) {
                //System.out.println(t.getRegionId());
                //System.out.println(t.getRegionName());
                LocationsEntity i = t.get();
                a.setLocationId(i);
            }
            else{
                System.out.println("error");
            }



            departmentRepository.save(a);


        }


        departments(model);
        return "departments";
    }
    @PostMapping(value = "/edit")
    public String edit (@ModelAttribute("departmentEdit") FormDepartment department, Model model) {
        int id = department.getDepartmentId();
        Optional<DepartmentsEntity> opt = Optional.ofNullable(departmentRepository.findByDepartmentId(id));
        if(opt.isPresent()){
            DepartmentsEntity b= opt.get();

            b.setDepartmentId(department.getDepartmentId());
            b.setDepartmentName(department.getDepartmentName());
            int name = department.getDepartmentLocation();

            //System.out.println(name);
            Optional<LocationsEntity> t = Optional.ofNullable(locationRepository.findByLocationId(name));
            if(t.isPresent()) {
                //System.out.println(t.getRegionId());
                //System.out.println(t.getRegionName());
                LocationsEntity i = t.get();
                b.setLocationId(i);
            }
            else{
                System.out.println("error");
            }
            departmentRepository.save(b);

        }
        else{
            System.out.println("Error country already exist");







        }


        departments(model);
        return "departments";
    }

    public static class FormDepartment {

        private  static int departmentId;

        private  static String departmentName;

        private static int departmentManagerId;

        private static  int departmentLocation;

        public static int getDepartmentId() {
            return departmentId;
        }

        public static String getDepartmentName() {
            return departmentName;
        }

        public static int getDepartmentManagerId() {
            return departmentManagerId;
        }

        public static int getDepartmentLocation() {
            return departmentLocation;
        }

        public static void setDepartmentId(int departmentId) {
            FormDepartment.departmentId = departmentId;
        }

        public static void setDepartmentName(String departmentName) {
            FormDepartment.departmentName = departmentName;
        }

        public static void setDepartmentManagerId(int departmentManagerId) {
            FormDepartment.departmentManagerId = departmentManagerId;
        }

        public static void setDepartmentLocation(int departmentLocation) {
            FormDepartment.departmentLocation = departmentLocation;
        }
    }





}