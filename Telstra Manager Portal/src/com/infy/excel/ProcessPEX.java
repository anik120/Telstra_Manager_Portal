package com.infy.excel;

import com.infy.beans.Employee;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Anik.B on 8/23/2016.
 */
public class ProcessPEX {
    public static Map<String, Employee> employeeDetails= new HashMap<String, Employee>();

    public static Map<String, Employee> Process(){

        JFileChooser fileChooser = new JFileChooser();
        Integer returnValue = fileChooser.showOpenDialog(null);
        try{
            if(returnValue == JFileChooser.APPROVE_OPTION){
                Workbook workbook = new HSSFWorkbook(new FileInputStream(fileChooser.getSelectedFile()));
                Sheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIerator = sheet.rowIterator();
                rowIerator.next();
                while(rowIerator.hasNext()){
                    Row row = rowIerator.next();
                    String empId = row.getCell(0).toString();
                    if(employeeDetails.containsKey(empId)){
                        Float totalHoursWorked = employeeDetails.get(empId).getTotalHoursWorked();
                        totalHoursWorked += Float.parseFloat(row.getCell(5).toString());
                        employeeDetails.get(empId).setTotalHoursWorked(totalHoursWorked);
                    }
                    else{
                        Employee employee = new Employee();
                        employee.setEmpNo(empId);
                        employee.setEmpName(row.getCell(1).toString());
                        employee.setAccountType(row.getCell(2).toString());
                        employee.setEmpType(row.getCell(3).toString());
                        employee.setTotalHoursWorked(Float.parseFloat(row.getCell(5).toString()));
                        employee.setTelstraManager(row.getCell(19).toString());
                        employeeDetails.put(empId,employee);
                    }
                }
                Set<String> keys = employeeDetails.keySet();
                for (String key: keys) {
                    Employee employee = employeeDetails.get(key);
                    System.out.println(employee.getEmpNo() + " " + employee.getEmpName() + " " + employee.getTotalHoursWorked());
                }
            }
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("Invalid file/file location");
        }catch (Exception e){
            e.printStackTrace();
        }
        return employeeDetails;
    }

}
