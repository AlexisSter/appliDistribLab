package com.application.td1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees", schema = "humanresources", catalog = "")
public class EmployeesEntity {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private Integer managerId;
    private DepartmentsEntity departmentId;
    private JobsEntity jobId;
    @JsonIgnore
    private List<JobHistoryEntity> jobhistoryList;

    public EmployeesEntity(){}

    public EmployeesEntity(EmployeesEntity employeesEntity) {
        this.commissionPct=getCommissionPct();
        this.departmentId=getDepartmentId();
        this.email=getEmail();
        this.employeeId=getEmployeeId();
        this.firstName=getFirstName();
        this.hireDate=getHireDate();
        this.jobhistoryList=getJobhistoryList();
        this.jobId=getJobId();
        this.lastName=getLastName();
        this.managerId=getManagerId();
        this.phoneNumber=getPhoneNumber();
        this.salary=getSalary();
    }

    @Id
    @Column(name = "EMPLOYEE_ID")
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "HIRE_DATE")
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "SALARY")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "COMMISSION_PCT")
    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Basic
    @Column(name = "MANAGER_ID")
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesEntity that = (EmployeesEntity) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(hireDate, that.hireDate) &&
                Objects.equals(salary, that.salary) &&
                Objects.equals(commissionPct, that.commissionPct) &&
                Objects.equals(managerId, that.managerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct, managerId);
    }

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    public DepartmentsEntity getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentsEntity departmentId) {
        this.departmentId = departmentId;
    }

    @ManyToOne
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", nullable = false)
    public JobsEntity getJobId() {
        return jobId;
    }

    public void setJobId(JobsEntity jobId) {
        this.jobId = jobId;
    }

    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.REMOVE)
    public List<JobHistoryEntity> getJobhistoryList() {
        return jobhistoryList;
    }

    public void setJobhistoryList(List<JobHistoryEntity> jobhistoryList) {
        this.jobhistoryList = jobhistoryList;
    }
}
