package com.bridgelabz;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
        private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

        enum IOService {
            CONSOLE_IO,
            FILE_IO
        }

        EmployeeService() {

        }

        EmployeeService(List<EmployeePayrollData> employeePayrollList) {
            this.employeePayrollList = employeePayrollList;

        }

        void writeEmployeeData(IOService ioService) {
            PayrollInterface<EmployeePayrollData> obj;
            if (IOService.CONSOLE_IO.equals(ioService)) {
                obj = new EmployeePayrollConsoleService();
                obj.writeEmployeePayrollData(employeePayrollList);
            } else if (IOService.FILE_IO.equals(ioService)) {
                obj = new EmployeePayrollFileService();
                obj.writeEmployeePayrollData(employeePayrollList);
            }
        }

        void readEmployeeData(IOService ioService) {
            PayrollInterface<EmployeePayrollData> obj;
            if (IOService.CONSOLE_IO.equals(ioService)) {
                obj = new EmployeePayrollConsoleService();
                obj.readEmployeePayrollData();
            } else if (IOService.FILE_IO.equals(ioService)) {
                obj = new EmployeePayrollFileService();
                obj.readEmployeePayrollData();
            }
        }
        long countEntries(IOService ioService){
            PayrollInterface<EmployeePayrollData> obj;
            long count=0;
            if (IOService.CONSOLE_IO.equals(ioService)) {
                obj = new EmployeePayrollConsoleService();
                count = obj.countEntries();
            } else if (IOService.FILE_IO.equals(ioService)) {
                obj = new EmployeePayrollFileService();
                count= obj.countEntries();
            }
            return count;
        }
    }
