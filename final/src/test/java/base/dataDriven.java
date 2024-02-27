package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	public static String data[]=new String[10];
	public static String data1[]=new String[10];
	public static XSSFSheet sheet;
	public static XSSFWorkbook workbook;
	
	public static String[] readDataTravel(String fileName) throws IOException, FileNotFoundException
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\policyBazaar.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
	   sheet=workbook.getSheetAt(0);
				
				for(int col=0;col<8;col++)
				{
				
			data[col]=sheet.getRow(col).getCell(1).toString();
				}
				workbook.close();
				file.close();
				return data;
	}
	
	public static String[] readDataCar(String fileName) throws IOException, FileNotFoundException
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\policyBazaar.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheetAt(0);		
			for(int col=0;col<6;col++)
			{
			
		data1[col]=sheet.getRow(col).getCell(6).toString();
			}
			workbook.close();
			file.close();
			return data1;
		}
	
	public static void writeData(String fileName,String sheet1,String data1[],String data2[],String data3[]) throws IOException
	{
	FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\policyBazaar.xlsx");
     workbook = new XSSFWorkbook(fi);
     sheet = workbook.getSheet(sheet1);
     for(int i=0;i<data1.length;i++)
    	 sheet.createRow(i+1).createCell(0).setCellValue(data1[i]);
     for(int i=0;i<data2.length;i++)
    	 sheet.getRow(i+1).createCell(1).setCellValue(data2[i]);
     for(int i=0;i<data3.length;i++)
    	 sheet.getRow(i+1).createCell(2).setCellValue(data3[i]);
    	 
	FileOutputStream fo= new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\policyBazaar.xlsx");
	workbook.write(fo);
	workbook.close();
	fi.close();
}
	
	public static void writeDatahealth(String fileName,String sheet1,String data1[]) throws IOException
	{
	FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\policyBazaar.xlsx");
     workbook = new XSSFWorkbook(fi);
     sheet = workbook.getSheet(sheet1);
     for(int i=0;i<data1.length;i++)
     
    	 sheet.createRow(i+1).createCell(6).setCellValue(data1[i]);
    
    	 
     FileOutputStream fo= new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\policyBazaar.xlsx");
	workbook.write(fo);
	workbook.close();
	fi.close();
}
			
			
			

		}





