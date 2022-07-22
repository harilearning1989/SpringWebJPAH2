package com.web.demo.services;

import com.web.demo.helper.CSVHelper;
import com.web.demo.model.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService{

    @Override
    public List<Employee> getEmployeeList() {
        InputStream isc = CSVHelper.loadEmpFile("EmpData5000Bkp.csv");
        List<Employee> employeeList = csvToTutorials(isc);
        return employeeList;
    }
    public static List<Employee> csvToTutorials(InputStream is) {
        List<Employee> employeeList = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
             CSVParser csvParser = new CSVParser(isr,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            Employee employee = null;
            int i=1;
            for (CSVRecord csvRecord : csvRecords) {
                employee = getEmpRecord(csvRecord);
                employee.setId(i);
                employeeList.add(employee);
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    private static Employee getEmpRecord(CSVRecord csvRecord) {
        Employee employee = new Employee();
        employee.setEmpId(csvRecord.get(0));
        employee.setFirstName(csvRecord.get("FirstName"));
        employee.setLastName(csvRecord.get("LastName"));
        employee.setGender(csvRecord.get("Gender"));
        employee.setEmail(csvRecord.get("EMail"));
        employee.setFatherName(csvRecord.get("FatherName"));
        employee.setDob(csvRecord.get("dob"));
        employee.setDoj(csvRecord.get("doj"));
        employee.setSalary(Integer.parseInt(csvRecord.get("Salary")));
        employee.setPhone(csvRecord.get("phone"));
        employee.setCountry(csvRecord.get("County"));
        employee.setCity(csvRecord.get("City"));
        employee.setState(csvRecord.get("State"));
        employee.setZip(Integer.parseInt(csvRecord.get("Zip")));
        employee.setRegion(csvRecord.get("Region"));
        return employee;
    }

    private void printFileContent(InputStream is) {
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
