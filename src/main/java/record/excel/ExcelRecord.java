package record.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import record.model.RecordType;
import record.model.RecordValue;

public class ExcelRecord {

	
	public static void excelValue(List<RecordValue> recordValues,RecordType rt) throws FileNotFoundException, IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("RecordValue");
        
        sheet.setColumnWidth(0, 15 * 50);
        sheet.setColumnWidth(1, 15 * 100);
        sheet.setColumnWidth(2, 25 * 256);
        sheet.setColumnWidth(3, 25 * 256);
        sheet.setColumnWidth(4, 25 * 256);
        sheet.setColumnWidth(5, 25 * 256);
        sheet.setColumnWidth(6, 25 * 256);
        sheet.setColumnWidth(7, 25 * 256);
        sheet.setColumnWidth(8, 25 * 256);
        sheet.setColumnWidth(9, 25 * 256);
        sheet.setColumnWidth(10, 25 * 256);
        sheet.setColumnWidth(11, 25 * 256);

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        
        Row rows = sheet.createRow(1);

        	Cell cell1 = rows.createCell(1); 
        	cell1.setCellStyle(cellStyle);
        	cell1.setCellValue(String.valueOf(rt.getId()).toUpperCase());
        	Cell cell2 = rows.createCell(2);
        	cell2.setCellStyle(cellStyle);
        	cell2.setCellValue(String.valueOf(rt.getName()).toUpperCase());
        	Cell cell3 = rows.createCell(3);
        	cell3.setCellStyle(cellStyle);
        	cell3.setCellValue(String.valueOf(rt.getColumn1()).toUpperCase());
        	Cell cell4 = rows.createCell(4);
        	cell4.setCellStyle(cellStyle);
        	cell4.setCellValue(String.valueOf(rt.getColumn2()).toUpperCase());
        	Cell cell5 = rows.createCell(5);
        	cell5.setCellStyle(cellStyle);
        	cell5.setCellValue(String.valueOf(rt.getColumn3()).toUpperCase());
        	Cell cell6 = rows.createCell(6);
        	cell6.setCellStyle(cellStyle);
        	cell6.setCellValue(String.valueOf(rt.getColumn4()).toUpperCase());
        	Cell cell7 = rows.createCell(7);
        	cell7.setCellStyle(cellStyle);
        	cell7.setCellValue(String.valueOf(rt.getColumn5()).toUpperCase());
        	Cell cell8 = rows.createCell(8);
        	cell8.setCellStyle(cellStyle);
        	cell8.setCellValue(String.valueOf(rt.getColumn6()).toUpperCase());
        	Cell cell9 = rows.createCell(9);
        	cell9.setCellStyle(cellStyle);
        	cell9.setCellValue(String.valueOf(rt.getColumn7()).toUpperCase());
        	Cell cell10 = rows.createCell(10);
        	cell10.setCellStyle(cellStyle);
        	cell10.setCellValue(String.valueOf(rt.getColumn8()).toUpperCase());
        	Cell cell11 = rows.createCell(11);
        	cell11.setCellStyle(cellStyle);
        	cell11.setCellValue(String.valueOf(rt.getColumn9()).toUpperCase());
        	        
        
        int rowCount = 1;
        
        for (RecordValue r : recordValues) {
        	
            Row row = sheet.createRow(++rowCount);

            Field[] persistentFields = r.getClass().getDeclaredFields();
            
            int columnCount = 0;
            for (Field field : persistentFields) {
            	Cell cell = row.createCell(++columnCount);
            	if(field.getName().equals("id")) {
            		cell.setCellValue(String.valueOf(r.getId()));
            	}
            	if(field.getName().equals("name")) {
                	cell.setCellValue(String.valueOf(r.getName()));
                }
            	if(field.getName().equals("column1")) {
                	cell.setCellValue(String.valueOf(r.getColumn1()));
                }
            	if(field.getName().equals("column2")) {
                	cell.setCellValue(String.valueOf(r.getColumn2()));
                }
            	if(field.getName().equals("column3")) {
                	cell.setCellValue(String.valueOf(r.getColumn3()));
                }
            	if(field.getName().equals("column4")) {
                	cell.setCellValue(String.valueOf(r.getColumn4()));
                }
            	if(field.getName().equals("column5")) {
                	cell.setCellValue(String.valueOf(r.getColumn5()));
                }
            	if(field.getName().equals("column6")) {
                	cell.setCellValue(String.valueOf(r.getColumn6()));
                }
            	if(field.getName().equals("column7")) {
                	cell.setCellValue(String.valueOf(r.getColumn7()));
                }
            	if(field.getName().equals("column8")) {
                	cell.setCellValue(String.valueOf(r.getColumn8()));
                }
            	if(field.getName().equals("column9")) {
                	cell.setCellValue(String.valueOf(r.getColumn9()));
                }
           
        }
        }
             
         
        try (FileOutputStream outputStream = new FileOutputStream("..\\..\\Desktop/RecordValue.xlsx")) {  
            workbook.write(outputStream);
            workbook.close();
        }
		
		
       
	}
	
	
	
	public static void excelType(List<RecordType>recordTypes) throws FileNotFoundException, IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("RecordType");
        
        sheet.setColumnWidth(0, 15 * 50);
        sheet.setColumnWidth(1, 15 * 100);
        sheet.setColumnWidth(2, 25 * 200);
        sheet.setColumnWidth(3, 25 * 200);
        sheet.setColumnWidth(4, 25 * 200);
        sheet.setColumnWidth(5, 25 * 200);
        sheet.setColumnWidth(6, 25 * 200);
        sheet.setColumnWidth(7, 25 * 200);
        sheet.setColumnWidth(8, 25 * 200);
        sheet.setColumnWidth(9, 25 * 200);
        sheet.setColumnWidth(10, 25 * 200);
        sheet.setColumnWidth(11, 25 * 200);

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);

        int rowCount = 0;
        
        for (RecordType r : recordTypes) {
        	
            Row row = sheet.createRow(++rowCount);
            int columnCount = 0;
            
            Field[] persistentFields = r.getClass().getDeclaredFields();
            
            for (Field field : persistentFields) {
            	Cell cell = row.createCell(++columnCount);
            	cell.setCellStyle(cellStyle);
            	if(field.getName().equals("id")) {
            		cell.setCellValue(String.valueOf(r.getId()));
            	}
            	if(field.getName().equals("name")) {
                	cell.setCellValue(String.valueOf(r.getName()));
                }
            	if(field.getName().equals("column1")) {
                	cell.setCellValue(String.valueOf(r.getColumn1()));
                }
            	if(field.getName().equals("column2")) {
                	cell.setCellValue(String.valueOf(r.getColumn2()));
                }
            	if(field.getName().equals("column3")) {
                	cell.setCellValue(String.valueOf(r.getColumn3()));
                }
            	if(field.getName().equals("column4")) {
                	cell.setCellValue(String.valueOf(r.getColumn4()));
                }
            	if(field.getName().equals("column5")) {
                	cell.setCellValue(String.valueOf(r.getColumn5()));
                }
            	if(field.getName().equals("column6")) {
                	cell.setCellValue(String.valueOf(r.getColumn6()));
                }
            	if(field.getName().equals("column7")) {
                	cell.setCellValue(String.valueOf(r.getColumn7()));
                }
            	if(field.getName().equals("column8")) {
                	cell.setCellValue(String.valueOf(r.getColumn8()));
                }
            	if(field.getName().equals("column9")) {
                	cell.setCellValue(String.valueOf(r.getColumn9()));
                }
           
        }
        }
         
        try (FileOutputStream outputStream = new FileOutputStream("..\\..\\Desktop/RecordType.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        }
		
	}
	
	
	

}
