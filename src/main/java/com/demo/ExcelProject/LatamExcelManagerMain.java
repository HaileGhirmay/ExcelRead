package com.demo.ExcelProject;

import java.util.List;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Row;

public class LatamExcelManagerMain {
    private static final String filePath="C:/Users/Dell/Desktop/latam project/ExcelRead/Financial Sample.xlsx";
    private static String columnName = "Country";
    private static String criteria = "Canada";
    public static void main(String[] args) {
        try {
          Properties props = PropsLoaderService.loadProperties("app.properties");
           System.out.println("An excel file found at:"+ props.getProperty("filePath") + " " + " with the filter criteria:->"+props.getProperty("columnName") + "and " + props.getProperty("criteria") + "" + " is loaded successfully");

            String filePath = props.getProperty("filePath");
           String columnName = props.getProperty("columnName");
              String criteria = props.getProperty("criteria");

            List<Row> rows = ReaderService.readExcel(filePath);
            System.out.println("Rows read: " + rows.size());

           List<Row> filteredRows = FilterService.filterRows(rows, columnName, criteria);
            System.out.println("number of Rows filtered: " + filteredRows.size());

            WriterService.writeRowsToCSV(filteredRows, criteria);
          System.out.println(" filters done and Rows written to CSV and saved successfully at: " + props.getProperty("filePath") );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


