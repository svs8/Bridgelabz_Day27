package com.bridgelabz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

    public class EmployeePayrollFileService implements PayrollInterface{

        public static final String FILE_NAME = "employee-payroll.txt";

        @Override
        public void writeEmployeePayrollData(List employeePayrollList) {

            //Writing onto an String
            StringBuffer empBuffer = new StringBuffer();
            employeePayrollList.forEach(employeePayroll ->{
                String str = employeePayroll.toString().concat("\n");
                empBuffer.append(str);
            });
            //Writing onto an file
            try {
                Files.write(Paths.get(FILE_NAME),empBuffer.toString().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //Reading Data and Printing
        @Override
        public void readEmployeePayrollData() {
            try {
                List<String> list= Files.lines(Paths.get(FILE_NAME)).collect(Collectors.toList());
                System.out.println(list);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public long countEntries() {
            long count1 = 0;
            try {
                count1=Files.lines(Paths.get(FILE_NAME)).count();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return count1;
        }
    }

