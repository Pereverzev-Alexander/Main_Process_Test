package convertUtilites;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import entities.Request;

public class ConvertToXLS {
	//unloading in xls
	public void saveFile(List<Request> list, String name) throws FileNotFoundException, IOException {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("GeneralEntitys");
		//thin lines
		CellStyle style = workbook.createCellStyle();
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderTop(CellStyle.BORDER_THIN);
		//thick lines
		CellStyle style_thick = workbook.createCellStyle();
		style_thick.setBorderBottom(CellStyle.BORDER_THICK);
		style_thick.setBorderRight(CellStyle.BORDER_THICK);
		style_thick.setBorderLeft(CellStyle.BORDER_THICK);
		style_thick.setBorderTop(CellStyle.BORDER_THICK);
		
		
		
		Map<String, Object[]> data = new HashMap<String, Object[]>();
		//create heading
		data.put(Integer.toString(1), new Object[] {"Дата регистрации заявки",
				"ФИО клиента",
				"Адрес клиента",
				"Тип подключаемой услуги (Интернет/ТВ/Телефон)",
				"ФИО Оператора принявшего заявку",
				"Планируемая дата выезда",
				"ФИО мастера",
				"Дата закрытия заявки",
		"Комментарий к заявке"});
		
		//filling
		for (int i=0;i<list.size();i++){
			data.put(Integer.toString(i+2), new Object[] {ConvertUnixTimestampToString(list.get(i).getIncomeDateRaw()), 
					list.get(i).getClientFullName(), 
					list.get(i).getAddress(),
					list.get(i).getTypeServices(),
					list.get(i).getOperatorInitials(),
					ConvertUnixTimestampToString(list.get(i).getServiceDateRaw()),
					list.get(i).getMasterInitials(),
					ConvertUnixTimestampToString(list.get(i).getClosedDateRaw()),
					list.get(i).getComment()});
		}
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object [] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				//draw border
				if (rownum==1)
					cell.setCellStyle(style_thick);
				else
				cell.setCellStyle(style);
				//types of cells
				if(obj instanceof Date) 
					cell.setCellValue((Date)obj);
				else if(obj instanceof Boolean)
					cell.setCellValue((Boolean)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
				else if(obj instanceof Long)
					cell.setCellValue((Long)obj);
				else if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Double)
					cell.setCellValue((Double)obj);
			}
			
		}

		//Get iterator to all the rows in current sheet
		//Iterator<Row> rowIterator = sheet.iterator();
		//Get iterator to all cells of current row
		//Iterator<Cell> cellIterator = row.cellIterator();
		//int rownum = sheet.getLastRowNum();
		
		
        
		int countColumns = 10;
		for (int i=0;i<countColumns;i++){
			sheet.autoSizeColumn(i);
		}
		FileOutputStream out = new FileOutputStream(name);
		workbook.write(out);
		workbook.close();
		out.close();
	}
	
	private String ConvertUnixTimestampToString(long time){
		Calendar mydate = Calendar.getInstance();
		mydate.setTimeInMillis(time*1000);
		return mydate.get(Calendar.DAY_OF_MONTH)+"."+Integer.toString(mydate.get(Calendar.MONTH)+1) + "."+mydate.get(Calendar.YEAR);
	}

	public static void main(String[] argv) throws FileNotFoundException, IOException {
		ConvertToXLS xls = new ConvertToXLS();
		Request req = new Request();
		List<Request> list = new ArrayList<Request>();
		req.setAddress("abc");
		list.add(req);
		req.setAddress("123");
		list.add(req);
		req.setAddress("ghj");
		req.setClientName("Вася");
		list.add(req);

		xls.saveFile(list, "res.xls");
		System.out.println("Writing on XLS file Finished!\n");
	}
}