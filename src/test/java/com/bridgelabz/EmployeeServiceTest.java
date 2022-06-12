package com.bridgelabz;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeServiceTest {


        @Test
        public void ThreeEmployeesWhenGivenToFileShouldMatchEmployeeEntries(){
            List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
            EmployeePayrollData[] employeePayrollArray = {
                    new EmployeePayrollData(1,"amit",2000),
                    new EmployeePayrollData(2,"hari",1000),
                    new EmployeePayrollData(3,"ram",3000)
            };
            employeePayrollList= Arrays.asList(employeePayrollArray);
            EmployeeService employeeService = new EmployeeService(employeePayrollList);
            employeeService.writeEmployeeData(EmployeeService.IOService.FILE_IO);
            employeeService.readEmployeeData(EmployeeService.IOService.FILE_IO);
            Assert.assertEquals(3,employeeService.countEntries(EmployeeService.IOService.FILE_IO));
        }


    }



