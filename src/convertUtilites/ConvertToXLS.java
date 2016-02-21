package convertUtilites;

/*������ �� ����������� �������� � ���� ��������� ����������
�	���� ������ � ����� �� ������;
�	��� ������� � ������ ����;
�	����� � ������ ����;
�	������������ ������ (��������/TV/�������) � ����� �� ��;
�	��� ��������� ���������� ������ � ����� �� ���� �����;
�	����������� ���� ������ ������� � ����� �� ������;
�	��� ������� � ����� �� ���� ������;
�	���� �������� ������ � ����� �� ������
�	����������� ������ ����;

long _incomeDate,
String _fullNameClient,
String _address,
long _serviceDate,
long _closedDate,
String _comment*/



public class ConvertToXLS (String file) throws FileNotFoundException, IOException{
	File file = new File("requests.xls");
	FileInputStream fis = new FileInputStream(myFile);
	Workbook book = new HSSFWorkbook(fis);
	Sheet sheet = book.createSheet("Requests");

	// ��������� ���������� � ����
	//.getSheetAt(0);
	Row row = sheet.createRow(0); 

	// Get iterator to all the rows in current sheet 
	Iterator<Row> rowIterator = sheet.iterator();


	// Set to Iterate and add rows into XLS file 
	Set<String> newRows = data.keySet();

	// get the last row number to append new data 
	int rownum = sheet.getLastRowNum(); 



	while ()
	// ������� dd.mm.yyyy
	Cell _fullNameClient = row.createCell(0);
	name.setCellValue("_fullNameClient");

	Cell _incomeDate = row.createCell(1);
	name.setCellValue("_incomeDate");

	DataFormat format = book.createDataFormat();
	CellStyle dateStyle = book.createCellStyle();
	dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
	birthdate.setCellStyle(dateStyle);


	
	// ���������� �� � ����
	book.write(new FileOutputStream(file));
	book.close();
}
