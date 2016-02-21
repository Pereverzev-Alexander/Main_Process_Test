package convertUtilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

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
	void test(String f) throws FileNotFoundException, IOException {
	File file = new File("requests.xls");
	FileInputStream fis = new FileInputStream(file);
	Workbook book = new HSSFWorkbook(fis);
	Sheet sheet = book.createSheet("Requests");
	POIFSFileSystem fs;

	// Нумерация начинается с нуля
	//.getSheetAt(0);
	Row row = sheet.createRow(0); 

	// Get iterator to all the rows in current sheet 
	Iterator<Row> rowIterator = sheet.iterator();


//	// Set to Iterate and add rows into XLS file 
//	Set<String> newRows = data.keySet();

	// get the last row number to append new data 
	int rownum = sheet.getLastRowNum(); 

//
//
//	while (true) {
//	// формата dd.mm.yyyy
//	Cell _fullNameClient = row.createCell(0);
//	_fullNameClient.setCellValue("_fullNameClient");
//
//	Cell с = row.createCell(1);
//	_fullNameClient.setCellValue("_incomeDate");
//
//	DataFormat format = book.createDataFormat();
//	CellStyle dateStyle = book.createCellStyle();
//	dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
//	//birthdate.setCellStyle(dateStyle);
//	}
//	
//	// Записываем всё в файл
//	book.write(new FileOutputStream(file));
//	book.close();
	}
	
	public static void main(String[] argv) {
		System.out.println("Hello World!");
	}
}
