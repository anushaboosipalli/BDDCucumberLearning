package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExcelUtility {

    public static Object[][] getXcelData() throws IOException, FileNotFoundException {
        File src = new File("C:\\Users\\anusha.b20\\Downloads\\BDDCucumberLearning\\src\\test\\TestData.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        System.out.println("RowCount " + rowCount);


        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i).getCell(k).toString();
                //System.out.println( data[i][k]);
            }
        }
        //System.out.println(data);
        wb.close();

        return data;
    }
}
