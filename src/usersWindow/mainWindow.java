package usersWindow;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import convertUtilites.ConvertToXLS;
import dbUtilities.DbDriver;
import entities.Request;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;




public class mainWindow {
	private Text text;
	private Text text_1;
	private String password;
	private String login;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Table table;
	private int SelectRow;
	private DbDriver driver;
	private boolean connectionEstablished;
	private  List<Request> listReq =  null;
	private DateTime dateTime_Right;
	private DateTime dateTime_Left;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mainWindow window = new mainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	
	public void open() {
		Display display = Display.getDefault();
		Shell shlMyaplication = new Shell();
		shlMyaplication.setMaximized(true);
		shlMyaplication.setMinimized(true);
		Image image = new Image(display, "bg.png"); 
		connectionEstablished = false;
		
		
		
		
		/*
		Region region = new Region();
		ImageData imageData = image.getImageData();
		
		if (imageData.alphaData != null) {
		    Rectangle pixel = new Rectangle(0, 0, 1, 1);
		    for (int y = 0; y < imageData.height; y++) {
		        for (int x = 0; x < imageData.width; x++) {
		            if (imageData.getAlpha(x, y) == 255) {
		                pixel.x = imageData.x + x;
		                pixel.y = imageData.y + y;
		                region.add(pixel);
		            }
		        }
		    }
		} else {
		    ImageData mask = imageData.getTransparencyMask();
		    Rectangle pixel = new Rectangle(0, 0, 1, 1);
		    for (int y = 0; y < mask.height; y++) {
		        for (int x = 0; x < mask.width; x++) {
		            if (mask.getPixel(x, y) != 0) {
		                pixel.x = imageData.x + x;
		                pixel.y = imageData.y + y;
		                region.add(pixel);
		            }
		        }
		    }
		} */
		//shlMyaplication.setRegion(region); 
		//shlMyaplication.setBackgroundImage(image);
		
		shlMyaplication.setImage(SWTResourceManager.getImage(mainWindow.class, "/javax/swing/plaf/basic/icons/image-failed.png"));
		//shlMyaplication.setBackground(SWTResourceManager.getColor(102, 205, 170));
		shlMyaplication.setSize(780, 555);
		shlMyaplication.setText("Myapplication");
		shlMyaplication.setMinimumSize(780, 555);
		//shlMyaplication.setMaximized(true);
		


		 
		String[] data = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                  "Item 6", "Item 7", "Item 8", "Item 9", "Item 10" };
		Color bgColor = new Color(display, 0x2b, 0x2b, 0x2b);
				shlMyaplication.setLayout(new GridLayout(1, false));
				
				CTabFolder tabFolder_1 = new CTabFolder(shlMyaplication, SWT.BORDER);
				tabFolder_1.setSelectionBackground(SWTResourceManager.getColor(255, 215, 0));
				tabFolder_1.setMRUVisible(true);
				//tabFolder_1.setBackgroundImage(image);
				GridData gd_tabFolder_1 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
				gd_tabFolder_1.widthHint = 751;
				gd_tabFolder_1.heightHint = 471;
				tabFolder_1.setLayoutData(gd_tabFolder_1);
				tabFolder_1.setUnselectedCloseVisible(false);
				tabFolder_1.setUnselectedImageVisible(false);
				tabFolder_1.setSimple(false);
				tabFolder_1.setBackgroundMode(SWT.INHERIT_FORCE);
				//tabFolder_1.setSelectionBackground(SWTResourceManager.getColor(255, 215, 0));
				//tabFolder_1.setBackground(SWTResourceManager.getColor(255, 255, 255));
				
				CTabItem tabItem_5 = new CTabItem(tabFolder_1, SWT.NONE);
				tabItem_5.setText("\u041F\u043E\u0434\u043A\u043B\u044E\u0447\u0435\u043D\u0438\u0435");
				tabFolder_1.setBackgroundImage(image);
				Group group = new Group(tabFolder_1, SWT.NONE);
				tabItem_5.setControl(group);
				
				text = new Text(group, SWT.BORDER);
				text.setMessage("\u041B\u043E\u0433\u0438\u043D");
				text.setToolTipText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043B\u043E\u0433\u0438\u043D");
				text.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
				text.setBounds(68, 81, 106, 21);
				
				Label label = new Label(group, SWT.NONE);
				label.setBounds(39, 48, 175, 15);
				label.setText("\u041F\u043E\u0434\u043A\u043B\u044E\u0447\u0435\u043D\u0438\u0435 \u043A \u0431\u0430\u0437\u0435 \u0434\u0430\u043D\u043D\u044B\u0445");
				
				text_1 = new Text(group, SWT.BORDER | SWT.PASSWORD);
				text_1.setMessage("\u041F\u0430\u0440\u043E\u043B\u044C");
				text_1.setToolTipText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043F\u0430\u0440\u043E\u043B\u044C");
				text_1.setBounds(68, 120, 106, 21);
				
				Button button_1 = new Button(group, SWT.NONE);
				button_1.setBackground(SWTResourceManager.getColor(65, 105, 225));
				button_1.setText("\u041F\u043E\u0434\u043A\u043B\u044E\u0447\u0435\u043D\u0438\u0435");
				button_1.setToolTipText("\u041F\u043E\u0434\u043A\u043B\u044E\u0447\u0438\u0442\u044C\u0441\u044F \u043A \u0431\u0430\u0437\u0435");
				button_1.setForeground(SWTResourceManager.getColor(0, 0, 0));
				//Image imageCon = new Image(display, "connectButton.png"); 
				//button_1.setImage(imageCon);
				button_1.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// Здесь код для подключения к базе
						login=text.getText();
						password=text_1.getText();
						driver = new DbDriver("jdbc:mysql://85.10.205.173:3306/zayavki?autoReconnect=true&useSSL=false", login, password);
						connectionEstablished = driver.connect();
						if( !connectionEstablished)
						{
							System.out.println("Fail connect!");
						}
					}
				});
				button_1.setBounds(68, 178, 116, 21);
				
				Button btnNewButton = new Button(group, SWT.NONE);
				btnNewButton.setBackground(SWTResourceManager.getColor(65, 105, 225));
				btnNewButton.setToolTipText("\u041E\u0442\u043A\u043B\u044E\u0447\u0438\u0442\u044C\u0441\u044F \u043E\u0442 \u0431\u0430\u0437\u044B");
				btnNewButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// Здесь код для отключения от базы
						if(connectionEstablished)
							driver.close();
					}
				});
				//Image imageDiscon = new Image(display, "disconnectButton.png"); 
				//btnNewButton.setImage(imageDiscon);
				btnNewButton.setBounds(68, 219, 116, 21);
				btnNewButton.setText("\u041E\u0442\u043A\u043B\u044E\u0447\u0435\u043D\u0438\u0435");
					
					CTabItem tabItem = new CTabItem(tabFolder_1, SWT.NONE);
					tabItem.setText("\u0417\u0430\u043F\u0440\u043E\u0441");
					
					Composite composite = new Composite(tabFolder_1, SWT.NONE);
					tabItem.setControl(composite);
					composite.setVisible(true);
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					Button button = new Button(composite, SWT.NONE);
					button.setBackground(SWTResourceManager.getColor(65, 105, 225));
					button.setText("\u041E\u0431\u043D\u043E\u0432\u0438\u0442\u044C");
					button.setToolTipText("Обновить выборку");
					button.setBounds(26, 22, 96, 30);
					button.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							System.out.println("Нажата кнопка \"Загрузить заявку\"");
							try{
								if(!connectionEstablished)
									return;
								listReq = driver.getAllRequests();
								for(int i = 0; i < listReq.size(); i++){
									TableItem item = new TableItem(table, SWT.NONE);
									
									item.setText(new String[] {ConvertUnixTimestampToString(listReq.get(i).getIncomeDateRaw()),
											listReq.get(i).getClientFullName(), listReq.get(i).getAddress(), 
											listReq.get(i).getTypeServices(), listReq.get(i).getOperatorInitials(),
											ConvertUnixTimestampToString(listReq.get(i).getServiceDateRaw()), listReq.get(i).getMasterInitials(),
											ConvertUnixTimestampToString(listReq.get(i).getClosedDateRaw()), listReq.get(i).getComment()});
								}
							}catch(SQLException exp){
								exp.printStackTrace();
							}
							
							//SearchDialog dialog = new SearchDialog(shlMyaplication, SWT.DIALOG_TRIM);
							//Object t;
							// t= dialog.open();
							/*if(t!= null)
							{
								
							System.out.println(((res) t).r1 + Integer.valueOf(((res) t).r1));
							}
							else
							{
								System.out.println("Cancel was pressed");
							}*/
							
						}
					});
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					ComboViewer comboViewer = new ComboViewer(composite, SWT.NONE);
					Combo combo = comboViewer.getCombo();
					combo.setBounds(359, 86, 96, 23);
					
					Button btnNewButton_1 = new Button(composite, SWT.NONE);
					btnNewButton_1.setBackground(SWTResourceManager.getColor(65, 105, 225));
					btnNewButton_1.setText("Добавить заявку");
					btnNewButton_1.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
						}
					});
					btnNewButton_1.setToolTipText("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0437\u0430\u044F\u0432\u043A\u0443");
					btnNewButton_1.setBounds(155, 22, 104, 30);
					
					Button btnNewButton_2 = new Button(composite, SWT.NONE);
					btnNewButton_2.setToolTipText("\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u0432\u043E\u0430\u0442\u044C \u0437\u0430\u044F\u0432\u043A\u0438");
					btnNewButton_2.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							
						}
					});
					btnNewButton_2.setBackground(SWTResourceManager.getColor(65, 105, 225));
					btnNewButton_2.setBounds(290, 22, 115, 30);
					btnNewButton_2.setText("\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
					
					Button btnNewButton_3 = new Button(composite, SWT.NONE);
					btnNewButton_3.setBackground(SWTResourceManager.getColor(65, 105, 225));
					btnNewButton_3.setToolTipText("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C \u0432\u043D\u0435\u0441\u0451\u043D\u043D\u044B\u0435 \u0438\u0437\u043C\u0435\u043D\u0435\u043D\u0438\u044F");
					btnNewButton_3.setBounds(436, 22, 133, 30);
					btnNewButton_3.setText("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C \u0438\u0437\u043C\u0435\u043D\u0435\u043D\u0438\u044F");
					
					Button btnNewButton_4 = new Button(composite, SWT.NONE);
					btnNewButton_4.setBackground(SWTResourceManager.getColor(65, 105, 225));
					btnNewButton_4.setToolTipText("\u0412\u044B\u0433\u0440\u0443\u0437\u043A\u0430 \u0432 XLS \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442");
					btnNewButton_4.setBounds(600, 22, 115, 30);
					btnNewButton_4.setText("\u0412\u044B\u0433\u0440\u0443\u0437\u043A\u0430 \u0432 XLS");
					btnNewButton_4.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							System.out.println(dateTime_Right.toString());
							System.out.println(ConvertDateTimeToUnixTimestamp(dateTime_Right));
							System.out.println("d " + dateTime_Right.getDay() + "m " + dateTime_Right.getMonth() + "Y " + dateTime_Right.getYear());
							if(!connectionEstablished)
								return;
							try{
								listReq = new ArrayList<Request>();
								listReq = driver.getRequestsBetween(ConvertDateTimeToUnixTimestamp(dateTime_Left),
										ConvertDateTimeToUnixTimestamp(dateTime_Right));
								ConvertToXLS xls = new ConvertToXLS();
								xls.saveFile(listReq, "Report.xls");
							}catch(Exception exp){
								exp.printStackTrace();
							}
						}
					});
					
					DateTime dateTime = new DateTime(composite, SWT.BORDER);
					dateTime.setBounds(42, 86, 76, 24);
					
					text_2 = new Text(composite, SWT.BORDER);
					text_2.setBounds(149, 140, 96, 21);
					
					text_3 = new Text(composite, SWT.BORDER);
					text_3.setBounds(264, 86, 76, 21);
					
					ComboViewer comboViewer_1 = new ComboViewer(composite, SWT.NONE);
					Combo combo_1 = comboViewer_1.getCombo();
					combo_1.setBounds(42, 203, 91, 23);
					
					text_4 = new Text(composite, SWT.BORDER);
					text_4.setBounds(149, 86, 96, 21);
					
					text_5 = new Text(composite, SWT.BORDER);
					text_5.setBounds(149, 113, 96, 21);
					
					DateTime dateTime_1 = new DateTime(composite, SWT.BORDER);
					dateTime_1.setBounds(42, 262, 76, 24);
					
					text_6 = new Text(composite, SWT.BORDER);
					text_6.setBounds(174, 265, 76, 21);
					
					Label label_1 = new Label(composite, SWT.NONE);
					label_1.setBounds(42, 65, 76, 15);
					label_1.setText("\u0414\u0430\u0442\u0430 \u0437\u0430\u044F\u0432\u043A\u0438");
					
					Label label_2 = new Label(composite, SWT.NONE);
					label_2.setBounds(150, 65, 75, 15);
					label_2.setText("ФИО Клиента");
					
					Label label_3 = new Label(composite, SWT.NONE);
					label_3.setBounds(266, 65, 55, 15);
					label_3.setText("\u0410\u0434\u0440\u0435\u0441");
					
					Label label_4 = new Label(composite, SWT.NONE);
					label_4.setBounds(359, 65, 55, 15);
					label_4.setText("\u0423\u0441\u043B\u0443\u0433\u0430");
					
					Label label_5 = new Label(composite, SWT.NONE);
					label_5.setBounds(42, 182, 96, 15);
					label_5.setText("\u0424\u0418\u041E \u043E\u043F\u0435\u0440\u0430\u0442\u043E\u0440\u0430");
					
					DateTime dateTime_2 = new DateTime(composite, SWT.BORDER);
					dateTime_2.setBounds(149, 203, 76, 24);
					
					Label label_6 = new Label(composite, SWT.NONE);
					label_6.setBounds(149, 182, 191, 23);
					label_6.setText("\u041F\u043B\u0430\u043D\u0438\u0440\u0443\u0435\u043C\u0430\u044F \u0434\u0430\u0442\u0430 \u0432\u044B\u0435\u0437\u0434\u0430 \u043C\u0430\u0441\u0442\u0435\u0440\u0430");
					
					Label label_7 = new Label(composite, SWT.NONE);
					label_7.setBounds(42, 241, 126, 15);
					label_7.setText("\u0414\u0430\u0442\u0430 \u0437\u0430\u043A\u0440\u044B\u0442\u0438\u044F \u0437\u0430\u043A\u0430\u0437\u0430");
					
					Label lbll = new Label(composite, SWT.NONE);
					lbll.setBounds(174, 241, 96, 15);
					lbll.setText("\u041A\u043E\u043C\u043C\u0435\u043D\u0442\u0430\u0440\u0438\u0439");
					
					ComboViewer comboViewer_2 = new ComboViewer(composite, SWT.NONE);
					Combo combo_2 = comboViewer_2.getCombo();
					combo_2.setBounds(346, 203, 91, 21);
					
					Label label_8 = new Label(composite, SWT.NONE);
					label_8.setText("ФИО мастера");
					label_8.setBounds(346, 182, 96, 15);
					
					dateTime_Left = new DateTime(composite, SWT.BORDER);
					dateTime_Left.setBounds(42, 363, 77, 23);
					
					dateTime_Right = new DateTime(composite, SWT.BORDER);
					dateTime_Right.setBounds(149, 363, 77, 23);
					
					Label label_9 = new Label(composite, SWT.NONE);
					label_9.setText("Выбор календарного периода для выгрузки заявок");
					label_9.setBounds(42, 322, 271, 15);
					
					Label label_10 = new Label(composite, SWT.NONE);
					label_10.setText("От");
					label_10.setBounds(68, 342, 21, 15);
					
					Label label_11 = new Label(composite, SWT.NONE);
					label_11.setText("До");
					label_11.setBounds(174, 343, 21, 15);
					
					
					
					CTabItem tabItem_2 = new CTabItem(tabFolder_1, SWT.NONE);
					tabItem_2.setText("\u0412\u044B\u0431\u043E\u0440\u043A\u0430 \u0437\u0430\u044F\u0432\u043E\u043A");
					
					
					Composite composite_1 = new Composite(tabFolder_1, SWT.NONE);
					tabItem_2.setControl(composite_1);
		
					
					
					
					
					TableColumnLayout tcl_composite = new TableColumnLayout();
					composite_1.setLayout(tcl_composite);
					
					TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
					table = tableViewer.getTable();
					table.setHeaderVisible(true);
					table.setLinesVisible(true);
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseDown(MouseEvent arg0) {
							if(arg0.button == 3){
								System.out.println("SelectRow: " + SelectRow);
								TableItem item = table.getItem(SelectRow);
								String temp = "";
								for (int i = 0; i < table.getColumnCount(); i++) {
									temp = temp + item.getText(i) + " ";
								}
								System.out.println("SelectRowText: " + temp);
								
							}
							
							Rectangle clientArea = table.getClientArea();
					        Point pt = new Point(arg0.x, arg0.y);
					        int index = table.getTopIndex();
					        while (index < table.getItemCount()) {
					        	boolean visible = false;
					        	final TableItem item = table.getItem(index);
					        	for (int i = 0; i < table.getColumnCount(); i++) {
					        		Rectangle rect = item.getBounds(i);
						            if (rect.contains(pt)) {
						            	SelectRow = index;
						            	System.out.println("Test! " + index);
						            }
						            if (!visible && rect.intersects(clientArea)) {
						            	visible = true;
						            }
					        	}
					        	if (!visible)
					        		return;
					        	index++;
					        }
							
						}
					});
					
					final TableEditor editor = new TableEditor(table);
					table.addListener(SWT.MouseDoubleClick, new Listener() {
					  public void handleEvent(Event event) {
					    Rectangle clientArea = table.getClientArea();
					    Point pt = new Point(event.x, event.y);
					    int index = table.getTopIndex();
					    while (index < table.getItemCount()) {
					      boolean visible = false;
					      final TableItem item = table.getItem(index);
					      for (int i = 0; i < table.getColumnCount(); i++) {
					        Rectangle rect = item.getBounds(i);
					        if (rect.contains(pt)) {
					          final int column = i;
					          final Text text = new Text(table, SWT.NONE);
					          Listener textListener = new Listener() {
					            public void handleEvent(final Event e) {
					              switch (e.type) {
					              case SWT.FocusOut:
					                item.setText(column, text.getText());
					                text.dispose();
					                break;
					              case SWT.Traverse:
					                switch (e.detail) {
					                case SWT.TRAVERSE_RETURN:
					                  item
					                      .setText(column, text
					                          .getText());
					                //FALL THROUGH
					                case SWT.TRAVERSE_ESCAPE:
					                  text.dispose();
					                  e.doit = false;
					                }
					                break;
					              }
					            }
					          };
					          text.addListener(SWT.FocusOut, textListener);
					          text.addListener(SWT.Traverse, textListener);
					          editor.setEditor(text, item, i);
					          text.setText(item.getText(i));
					          text.selectAll();
					          text.setFocus();
					          return;
					        }
					        if (!visible && rect.intersects(clientArea)) {
					          visible = true;
					        }
					      }
					      if (!visible)
					        return;
					      index++;
					    }
					  }
					});
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					comboViewer.add(data);
		
			
					
					
					
					FormData fd_combo = new FormData();
					fd_combo.left = new FormAttachment(0, 55);
					fd_combo.right = new FormAttachment(0, 146);
					FormData fd_composite = new FormData();
					fd_composite.bottom = new FormAttachment(0, 192);
					fd_composite.right = new FormAttachment(0, 541);
					fd_composite.top = new FormAttachment(0, 147);
					fd_composite.left = new FormAttachment(0, 48);
					String[] colunmName = { "Дата заявки", "ФИО Клиента", "Адресс", "Подключаемая услуга", "ФИО Оператора",
			                  "Дата выезда мастера", "ФИО Мастера", "Дата закрытия заявки", "Комментарий" };
					for(int i = 0; i < 9; i++){
						TableViewerColumn tableViewerColumn  = new TableViewerColumn(tableViewer, SWT.NONE);
						TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
						tcl_composite.setColumnData(tblclmnNewColumn, new ColumnPixelData(200, true, true));
						tblclmnNewColumn.setText(colunmName[i]);
					}
					/*for(int i = 0; i < 30; i++){
						TableItem item = new TableItem(table, SWT.NONE);
						item.setText(new String[] { "" + i, "" + i, "" + i, "" + i, "" + i });
					}*/
				    editor.horizontalAlignment = SWT.LEFT;
				    editor.grabHorizontal = true;
					
					
					
					
					
					
					
		
		//shlMyaplication.setSize(imageData.x + imageData.width, imageData.y + imageData.height); 
		shlMyaplication.open();
		shlMyaplication.layout();
		while (!shlMyaplication.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		//region.dispose();
		image.dispose();
		display.dispose();
	}
	
	
	private String ConvertUnixTimestampToString(long time){
		Calendar mydate = Calendar.getInstance();
		mydate.setTimeInMillis(time*1000);
		return mydate.get(Calendar.DAY_OF_MONTH)+"."+Integer.toString(mydate.get(Calendar.MONTH)+1) + "."+mydate.get(Calendar.YEAR);
	}
	
	private long ConvertDateTimeToUnixTimestamp(DateTime time){
		Calendar cal = Calendar.getInstance();
        cal.set(time.getYear(),time.getMonth(),time.getDay());
		return cal.getTime().getTime()/(long)1000;
	}
	
}
