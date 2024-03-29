package gongneng;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.io.*;

import java.util.ArrayList;
import java.util.Vector;

//读取学生信息，展示在窗口

public class show_stuall2 {	
	
	JTable table = null;
    DefaultTableModel model = null;
	//显示全部学生信息
   public show_stuall2() {
	    JFrame jf = new JFrame("显示全部信息(点击表头可以按照升序降序排序)");	   
	    // 创建内容面板
	     JPanel panel = new JPanel();
	    // 表头（列名）
	   Vector tcolumnNames=createColumnNames();
	   Vector tdata=createTableModelData();	   
	 // 创建一个默认的表格模型
	    model = new DefaultTableModel(tdata, tcolumnNames);
	   table = new JTable(model);
       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
       JScrollPane tablePanel = new JScrollPane(table);  				        
       
       table.setForeground(Color.BLACK);                  
       table.setFont(new Font(null, Font.PLAIN, 20));      
       table.setSelectionForeground(Color.DARK_GRAY);     
       table.setSelectionBackground(Color.LIGHT_GRAY);     
       table.setGridColor(Color.WHITE);                    

       table.getTableHeader().setFont(new Font(null, Font.BOLD, 20));  
       table.getTableHeader().setForeground(Color.BLUE);               
       table.getTableHeader().setResizingAllowed(false);               
       table.getTableHeader().setReorderingAllowed(false);         


	        // 设置行高
	        table.setRowHeight(40);

	        // 第一列列宽设置为40
	        table.getColumnModel().getColumn(0).setPreferredWidth(40);
             
	        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
	        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
	        
	        //排序器	        
	        RowSorter sorter = new TableRowSorter(model);
	        table.setRowSorter(sorter);
	        JScrollPane pane = new JScrollPane(table);      

	        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
	        JScrollPane scrollPane = new JScrollPane(table);

	        // 添加 滚动面板 到 内容面板
	        panel.add(scrollPane);
	       // JScrollPane pane = new JScrollPane(table);
	        // 设置 内容面板 到 窗口
	        jf.setContentPane(panel);
	        jf.pack();
	        jf.setSize(900, 600);
	        jf.add(scrollPane, BorderLayout.CENTER);
	        
	        //数据居中显示
	        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
			r.setHorizontalAlignment(JLabel.CENTER);   
			table.setDefaultRenderer(Object.class, r);
			
	        jf.setLocationRelativeTo(null);
	        int t=table.getRowCount();
	        if(t<=0){
	        	JOptionPane.showMessageDialog(null, "该系统中还没有录入学生信息！！！");
	        	jf.setVisible(false);
	        }
	        else {
	        	jf.setVisible(true);
	        }	 
	    }
    
     private Vector createColumnNames() {
       Vector columnNames = new Vector();
       //columnNames.add("序号");
       columnNames.add("编号");
       columnNames.add("姓名");
       columnNames.add("性别");
       columnNames.add("年龄");
       columnNames.add("电话号码");
       columnNames.add("所教课程");
       columnNames.add("年级编码");
       
       return columnNames;
   }
   
     private Vector createTableModelData() {
        
         Vector data = new Vector();
         String t=null;
			try{
				FileReader f1 = new FileReader("teacher.txt");
				BufferedReader br=new BufferedReader(f1);				
				//arry.clear();//	清除原数组列表中的数据
				int i=0;
				while ((t= br.readLine())!= null)
					{
					  String [] s=t.split("\\s+");		//通过空格分割字符串数组					  
					  Vector rowData = new Vector();
				
					  //rowData.add("i");				  
					  rowData.add(s[0]);					  
					  rowData.add(s[1]);
					  rowData.add(s[2]);
					  rowData.add(s[3]);
					  rowData.add(s[4]);			  
					  rowData.add(s[5]);   
					  rowData.add(s[6]);				  
					  data.add(rowData);					  
					 // System.out.print(s[6]);					  
					  i++;					   
					}
				     f1.close();
				     br.close();			     
				     
					} catch (IOException e) {
							// TODO 自动生成的 catch 块
					e.printStackTrace();
					
				}	  
        return data;
     }   
}
