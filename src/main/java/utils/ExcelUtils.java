package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    static Workbook workbook;
    static Sheet sheet;

    public static void setExcelFile(String path, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println("Excel file error: " + e.getMessage());
        }
    }

    public static String getCellData(int row, int col) {
        String data = "";
        try {
            Cell cell = sheet.getRow(row).getCell(col);
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            System.out.println("Cell data error: " + e.getMessage());
        }
        return data;
    }

    public static int getRowCount() {
        return sheet.getLastRowNum();
    }
}