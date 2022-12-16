package GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;





public class ExcelUtilityAPI {
	
	 /** its used to read the data from Excel-Workbook base on below 
	 * @param sheetName
	 * @param rowNuum
	 * @param cellNum
	 * @param String data
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	// this is the generic code for fetching the String data in to excel Sheet
	public String getExcelData(String sheetName , int rowNum , int celNum) throws EncryptedDocumentException, IOException  {
		FileInputStream fis = new FileInputStream(IConstants.EXCELPATH);
		Workbook WB = WorkbookFactory.create(fis);
		String data= WB.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		
		return data;
		
	}
	// this is the generic code for fetching the integer data in to excel Sheet
	public int getExcelDataInt(String sheetName , int rowNum , int celNum) throws EncryptedDocumentException, IOException  {
		FileInputStream fis = new FileInputStream(IConstants.EXCELPATH);
		Workbook WB = WorkbookFactory.create(fis);
		int data1=(int) WB.getSheet(sheetName).getRow(rowNum).getCell(celNum).getNumericCellValue();
		
		return data1;
		
	}
	// this is the code for writing the data in to excel Sheet
	public void setExcelData(String sheetName , int rowNum , int celNum , int data) throws EncryptedDocumentException, IOException  {
		FileInputStream fis = new FileInputStream(IConstants.EXCELPATH);
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).setCellValue(data);
	    FileOutputStream fos= new FileOutputStream(IConstants.EXCELPATH);
	    wb.write(fos);
	    wb.close();
		
		
	}
}
