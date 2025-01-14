package dataDriven_excelDataProvider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class dataProvider {

DataFormatter formatter = new DataFormatter();
 @Test(dataProvider = "driveTest")
    public void testCaseData(String greeting, String communication, String id){
        System.out.println(greeting+communication+id);
    }


    @DataProvider(name = "driveTest")
    public Object[][] getData() throws IOException {

        //     Object[][] data = {{"hello","test","1"},{"bye", "message","33"},{"solo","cell", "55"}};
//     return data;
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
               data[i][j]=formatter.formatCellValue(cell);
           }
       }
   return data;

    }
}
