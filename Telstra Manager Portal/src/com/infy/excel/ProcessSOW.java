package com.infy.excel;

import com.infy.beans.Employee;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Anik.B on 8/23/2016.
 */
public class ProcessSOW {

    public static void main(String args[]){
        Map<String, Employee> employeeDetails = new HashMap<>();
        JFileChooser fileChooser = new JFileChooser();
        Integer returnValue = fileChooser.showOpenDialog(null);
        try{
            if(returnValue == JFileChooser.APPROVE_OPTION){
                Workbook workbook = new HSSFWorkbook(new FileInputStream(fileChooser.getSelectedFile()));
                Sheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIerator = sheet.rowIterator();
                rowIerator.next();
                rowIerator.next();

                while(rowIerator.hasNext()){
                    Row row = rowIerator.next();
                    if(row.getCell(0).toString().equals("Total"))
                        break;
                    Employee employee = new Employee();
                    employee.setTelstraManager(row.getCell(1).toString());
                    System.out.println(row.getCell(4).toString());
                    employee.setEmpName(row.getCell(3).toString().replace("E7", "").replace(".",""));
                    employee.setEmpNo(row.getCell(4).toString().replace("E7", "").replace(".",""));
                    /*Long empNo = Long.parseLong(row.getCell(4).toString());
                    empNo = empNo.longValue();
                    employee.setEmpNo(empNo.toString());*/
                    employee.setRate(Float.parseFloat(row.getCell(6).toString().replace("$","")));
                    employee.setTeamName(row.getCell(2).toString());
                    employee.setLocation(row.getCell(12).toString());
                    employeeDetails.put(employee.getEmpNo(), employee);
                }
            }
            Set<String> keys = employeeDetails.keySet();
            for (String key: keys) {
                Employee employee = employeeDetails.get(key);
                System.out.println(employee.getEmpNo() + " " + employee.getEmpName() + " " + employee.getTelstraManager() + " " + employee.getTeamName() + employee.getLocation());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
