package codewithfreddy;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

public class Main {



    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("\"C:\\Users\\Freddy\\Desktop\\TestCases.xlsx\"");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for(int i=0; i<sheets; i++ ){
            if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                //Identify testcases column by scanning the entire 1st row

                Iterator<Row> rows = sheet.iterator(); //sheet is collection of rows
               Row firstrow = rows.next();
              Iterator<Cell> ce= firstrow.cellIterator(); // row is collection of cells

                int k=0;
                int column = 0;
                while (ce.hasNext())
               {
               Cell value = ce.next();
               if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
               {
                  //desired column
                   column = k++;
               }
               k++;
              }
                //once column is identified then scan entire testcase column to identify purchase testcase row
                while (rows.hasNext())
                {
                    Row r=rows.next();
                   if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase"))
                   {
                       //after you grab purchase testcase row - pull all the data of that row and feet into test
                      Iterator<Cell> cv= r.cellIterator();
                      while (cv.hasNext())
                      {
                          cv.next();
                      }

                   }
                }
            }
        }
    }
}