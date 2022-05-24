package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	
	public String excelLibrary(String Sheetname, int rowNum, int cellNum) {
		String retVal=null;
		try {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//testdata//TestExcel.xlsx");
			Workbook wb=WorkbookFactory.create(file);
			Sheet sh=wb.getSheet(Sheetname);
			Row rw=sh.getRow(rowNum);
			Cell cel=rw.getCell(cellNum);
			retVal=cel.getStringCellValue();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		
		
		return retVal;
	}
	
	public int lastRow(String Sheetname) {
		int retVal=0;
		try {
			FileInputStream fil=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//testdata//TestExcel.xlsx");
			Workbook wb=WorkbookFactory.create(fil);
			Sheet sh=wb.getSheet(Sheetname);
			retVal=sh.getLastRowNum();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		
		
		return retVal;
	}

}
