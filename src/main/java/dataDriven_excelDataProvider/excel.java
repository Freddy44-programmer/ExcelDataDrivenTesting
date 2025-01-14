package dataDriven_excelDataProvider;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class excel {

    @Test
    public void getExcel() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Freddy\\Desktop\\BookTestcase.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        sheet.getRow(0);
        XSSFRow row = sheet.getRow(0);
        int colcount = row.getLastCellNum();
        Object data[][] = new Object[rowCount-1][colcount];
        for(int i=0; i<rowCount-1; i++)
        {
            row = sheet.getRow(i+1);
            for(int j=0; j<colcount; j++)
            {
                XSSFCell cell=row.getCell(j);
                row.getCell(j);
            }
        }

    }
}
