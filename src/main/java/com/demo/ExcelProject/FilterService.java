package com.demo.ExcelProject;

import org.apache.poi.ss.usermodel.*;
import java.util.ArrayList;
import java.util.List;

public class FilterService {

    public static List<Row> filterRows(List<Row> rows, String columnName, String criteria) {
        List<Row> filteredRows = new ArrayList<>();
        int columnIndex = -1;

        for (Row row : rows) {
            if (row.getRowNum() == 0) { // Header row
                for (Cell cell : row) {
                    if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                        columnIndex = cell.getColumnIndex();
                        break;
                    }
                }
                if (columnIndex == -1) {
                    throw new RuntimeException("Column not found: " + columnName);
                }
            } else {
                Cell cell = row.getCell(columnIndex);
                if (cell != null && cell.getStringCellValue().equalsIgnoreCase(criteria)) {
                    filteredRows.add(row);
                }
            }
        }
        return filteredRows;
    }
}
