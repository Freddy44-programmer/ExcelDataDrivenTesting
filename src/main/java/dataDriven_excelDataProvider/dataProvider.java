package dataDriven_excelDataProvider;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class dataProvider {


    @Test(dataProvider = "driveTest")
    public void testCaseData(String greeting, String communication, String id){
        System.out.println(greeting+communication+id);
    }


    @DataProvider(name = "driveTest")
    public void getData() throws IOException {

        //     Object[][] data = {{"hello","test","1"},{"bye", "message","33"},{"solo","cell", "55"}};
//     return data;


    }
}
