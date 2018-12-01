package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel {

//	public static String readexcel(String file, int sheet, int row, int col) throws EncryptedDocumentException, IOException {
//		FileInputStream fin = null;
//			fin = new FileInputStream(file);
//			Workbook w = new XSSFWorkbook(fin);
//			org.apache.poi.ss.usermodel.Sheet s= w.getSheetAt(sheet);
//			Row r=s.getRow(row);
//			Cell c=r.getCell(col);
//			return c.getStringCellValue();
//			
//			
//		
//	}
	public static Object[][] readexcelfordataprovider(String file, String sheet, int row, int col)  {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook w = null;
		try {
			w = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		org.apache.poi.ss.usermodel.Sheet s = w.getSheet(sheet);
	
		
		Object readdata[][]=new Object[2][2];
	
	
			for(int i=0; i<s.getLastRowNum();i++)
			{
				for(int j=0; j<col;j++)
				{System.out.println(s.getRow(i+1).getCell(j).getStringCellValue());
					readdata[i][j]=s.getRow(i+1).getCell(j).getStringCellValue();
		
				}
			}
			
			return readdata;
			
			
		
	}
	
	
}