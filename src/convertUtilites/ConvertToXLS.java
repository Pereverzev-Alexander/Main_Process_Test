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

import entities.Request;

public class ConvertToXLS {

	void saveFile(List<Request> list, String name) throws FileNotFoundException, IOException {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("GeneralEntitys");
		Map<String, Object[]> data = new HashMap<String, Object[]>();
		for (int i=0;i<list.size();i++){
			data.put("i+1", new Object[] {list.get(i).getIncomeDateRaw(), 
					list.get(i).getClientFullName(), 
					list.get(i).getAddress(),
					list.get(i).getTypeServices(),
					list.get(i).getOperatorInitials(),
					list.get(i).getServiceDateRaw(),
					list.get(i).getMasterInitials(),
					list.get(i).getClosedDateRaw(),
					list.get(i).getComment()});
		}
		//Map<String, Object[]> data = new HashMap<String, Object[]>();
		//data.put("2", new Object[] {7d, "Sonya", "75K", "SALES", "Rupert"});
		
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
				else if(obj instanceof Long)
					cell.setCellValue((Long)obj);
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
		Request req = new Request();
		List<Request> list = new ArrayList<Request>();
		req.setAddress("abc");
		list.add(req);
		req.setAddress("123");
		list.add(req);
		req.setAddress("ghj");
		list.add(req);

		xls.saveFile(list, "res.xls");
		System.out.println("Writing on XLS file Finished!\n");
		//System.out.printf("list size =%d",list.size());
	}
}