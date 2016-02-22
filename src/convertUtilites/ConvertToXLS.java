package convertUtilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import entites.Info_request;

/* Заявка на подключение содержит в себе следующую информацию
•	Дата заявки – выбор из списка;
•	ФИО Клиента – ручной ввод;
•	Адрес – ручной ввод;
•	Подключаемая Услуга (Интернет/TV/Телефон) – выбор из БД;
•	ФИО Оператора принявшего заявку – выбор из базы данны;
•	Планируемая дата выезда мастера – выбор из списка;
•	ФИО Мастера – выбор из базы данных;
•	Дата закрытия заявки – выбор из списка
•	Комментарий ручной ввод;

long _incomeDate,
String _fullNameClient,
String _address,
long _serviceDate,
long _closedDate,
String _comment */

public class ConvertToXLS {
	
	void saveFile(List<Info_request> list, String name) throws FileNotFoundException, IOException {
		/*File myfile = new File(name);
	FileInputStream fis = new FileInputStream(myfile);
	HSSFWorkbook workbook = new HSSFWorkbook(fis);
	HSSFSheet sheet = workbook.createSheet("Sample sheet");
	POIFSFileSystem fs;*/

		//FileInputStream file = new FileInputStream(new File(name));

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Requests");
		
		
		for (int i=0;i<list.size();i++){
			Map<String, Object[]> data = new HashMap<String, Object[]>();
			data.put("i", new Object[] { , "Name", "Salary"});
		}
		Map<String, Object[]> data = new HashMap<String, Object[]>();
		data.put("1", new Object[] {6d, "Name", });
		data.put("2", new Object[] {7d, "Sonya", "75K", "SALES", "Rupert"});
		data.put("3", new Object[] {8d, "Kris", "85K", "SALES", "Rupert"}); 
		data.put("4", new Object[] {9, "Dave", "90K", "SALES", "Rupert"});

		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object [] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof Date) 
					cell.setCellValue((Date)obj);
				else if(obj instanceof Boolean)
					cell.setCellValue((Boolean)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
				else if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Double)
					cell.setCellValue((Double)obj);
			}
		}

		//Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();

		//Get iterator to all cells of current row
		//Iterator<Cell> cellIterator = row.cellIterator();

		//int rownum = sheet.getLastRowNum(); 
		
		FileOutputStream out = new FileOutputStream(name);
		workbook.write(out);
	    out.close();
	}

	public static void main(String[] argv) throws FileNotFoundException, IOException {
		ConvertToXLS xls = new ConvertToXLS();
		List<Info_request> list = new ArrayList<Info_request>();
		Info_request req = new Info_request();
		
		xls.saveFile(list, "res.xls");
		System.out.println("Writing on XLS file Finished!");
	}
}
