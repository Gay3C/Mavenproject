package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderHolder1 {
	
	public static String[][] dataProviderMethod() throws IOException {
		
		
		File src = new File("C:\\Users\\Gayathri\\Documents\\BusyQA\\Assignment7&8.xlsx");
		
		//load the excel file
		FileInputStream fis = new FileInputStream(src);//InputStream - To read the excel file
		
		//load the workbook from the excel file
		
		XSSFWorkbook Wb = new XSSFWorkbook(fis);

		//load the sheet 
		XSSFSheet sheet = Wb.getSheetAt(0);
		
		int RowNum = sheet.getLastRowNum()+1;
		int ColNum = sheet.getRow(0).getLastCellNum();
		
		System.out.println(RowNum);
		System.out.println(ColNum);
		
		String[][] data = new String[RowNum][ColNum];
		
		for(int i =0;i<RowNum;i++) {
			for(int j=0;j<ColNum;j++) {
				data[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		
		//enhanced for loop
		/*for(String[] i:data) {
			for(String j:i) {
				System.out.println(j);
			}
		}*/
		
		/*for(int i =0;i<RowNum;i++) {
			for(int j=0;j<ColNum;j++) {
				System.out.println(data[i][j]);
			}
		}*/
		
		return data;
		
		}

		
		@DataProvider(name="StuLogin1")
		public static Object[][] loginData() throws IOException{
			//return type is object always for dataProvider methods
			Object[][] arrayObject = dataProviderMethod();//Static methods doesn't need objects to execute
			return arrayObject;
		}
		


}
