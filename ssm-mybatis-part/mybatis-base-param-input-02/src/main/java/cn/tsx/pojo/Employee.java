package cn.tsx.pojo;

public class Employee {

    private Integer empId;

    private String empName;

    private Double empSalary;

    public Employee() {
    }

    public Employee(Integer empId, String empName, Double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    /**
     * 获取
     *
     * @return empId
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置
     *
     * @param empId
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取
     *
     * @return empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * 设置
     *
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * 获取
     *
     * @return empSalary
     */
    public Double getEmpSalary() {
        return empSalary;
    }

    /**
     * 设置
     *
     * @param empSalary
     */
    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public String toString() {
        return "Employee{empId = " + empId + ", empName = " + empName + ", empSalary = " + empSalary + "}";
    }

}