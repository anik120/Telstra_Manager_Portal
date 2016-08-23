package com.infy.excel;

import com.infy.beans.Employee;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Anik.B on 8/23/2016.
 */
public class GenerateMilestoneInfo {
    public static void main(String args[]){
        Integer rowNo = 0, columnNo = 0;
        Row row; Cell cell;
        Workbook workbook = new HSSFWorkbook();
        Sheet newSheet = workbook.createSheet(WorkbookUtil.createSafeSheetName("July-16 Milestone details"));
        List<String> tableHeadings = new ArrayList<>();
        tableHeadings.add("Talent Name\n");
        tableHeadings.add("\"Employee \n" +
                "Number\"\n");
        tableHeadings.add("SoW Tracking No.\n");
        tableHeadings.add("Team Name\n");
        tableHeadings.add("Milestone month\n");
        tableHeadings.add("Location\n");
        tableHeadings.add("Billing Rate\n");
        tableHeadings.add("Total Billable Days in Jun16\n");
        tableHeadings.add("Milestone Amount\n");
        tableHeadings.add("No of Leaves in Jun 16\n");
        tableHeadings.add("Leave Reconciliation for Jun 16\n");
        tableHeadings.add("Additional Working Days\n");
        tableHeadings.add("Additional Working Days Cost\n");
        tableHeadings.add("Total Delta Reconciliation Amount\n");

        //process SOW

        //process PEX
        Map<String,Employee> employeeDetails = ProcessPEX.Process();


        row = newSheet.createRow(rowNo);

        for (String heading: tableHeadings) {
            cell = row.createCell(columnNo);
            cell.setCellValue(heading);
            columnNo++;
        }
        try{
            FileOutputStream output = new FileOutputStream("Milestone_details.xls");
            workbook.write(output);
            System.out.println("Excel Sheet Created");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
