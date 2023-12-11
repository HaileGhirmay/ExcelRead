package com.demo.ExcelProject;

import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WriterService {

    public static void writeRowsToCSV(List<Row> rows, String criteria) throws IOException {
        String csvFileName = createFileName(criteria);
        FileWriter csvWriter = new FileWriter(csvFileName);

        for (Row row : rows) {
            boolean firstCell = true;
            for (Cell cell : row) {
                if (!firstCell) {
                    csvWriter.append(",");
                }
                String cellValue = getCellValue(cell);
                csvWriter.append(cellValue);
                firstCell = false;
            }
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

    private static String createFileName(String criteria) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        return criteria + "_" + now.format(formatter) + ".csv";
    }

    private static String getCellValue(Cell cell) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }
}
