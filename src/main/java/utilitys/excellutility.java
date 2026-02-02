package utilitys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Baseclass.Library;

public class excellutility  {
	
	private static Logger logger;
	static {
		logger = Logger.getLogger(excellutility.class);
		PropertyConfigurator.configure("C:\\Users\\moinu\\eclipse-workspace\\Flipkart\\src\\test\\resources\\property\\Log4j.properties");
	}
	
	public String excelread(String sheet,int Rownumber,int cellnumber) throws IOException {
		String path = System.getProperty("user.dir")
		        + "/src/test/resources/TestData/Flipkartdata.xlsx";


		
		FileInputStream read = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(read);
		XSSFSheet Sh = book.getSheet(sheet);
		XSSFRow Row = Sh.getRow(Rownumber);
		XSSFCell cell = Row.getCell(cellnumber);
		logger.info("**************** Read Excel sheet  ****************");
        
		String value = cell.getStringCellValue();
	     book.close();
	     read.close();
	     return value;
	}

    public void  excelwrite(String sheet, int RowNumber,int CellNumber, String text ) throws IOException {
    	
    	String path1 = System.getProperty("user.dir")
		        + "/src/test/resources/TestData/Flipkartdata.xlsx";


		
		FileInputStream read = new FileInputStream(path1);
		XSSFWorkbook book = new XSSFWorkbook(read);
		XSSFSheet Sh = book.getSheet(sheet);
		XSSFRow Row = Sh.getRow(RowNumber);
		XSSFCell cell = Row.createCell(CellNumber);
		cell.setCellValue(text);
		FileOutputStream write = new FileOutputStream(path1);
		book.write(write);
		write.close();
		book.close();
		logger.info("****************** Write in excel sheet  ****************");


    	
    	
    }
}
