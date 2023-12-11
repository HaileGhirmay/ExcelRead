package com.demo.ExcelProject;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReaderService {

    public static List<Row> readExcel(String fileName) throws Exception {
        List<Row> list = new ArrayList<>();
        FileInputStream file = new FileInputStream(new File(fileName));
        DataFormatter dataFormatter = new DataFormatter();
        Workbook workbook = new XSSFWorkbook(file);
        Iterator<Sheet> sheets = workbook.sheetIterator();

        while (sheets.hasNext()) {
            Sheet sheet = sheets.next();
            System.out.println("Sheet name is "+sheet.getSheetName());
            System.out.println("---------");
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                list.add(row);
                //adding print statement
                Iterator<Cell> cellIterator = row.iterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    //if(cell.getCellType() == CellType.STRING) {
                    //
                    //}
                    System.out.print(cellValue+"\t");
                }

            }
        }

        workbook.close();
        return list;
    }
}