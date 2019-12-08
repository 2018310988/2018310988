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


public class show_stuall2 {	
	
	JTable table = null;
    DefaultTableModel model = null;
   public show_stuall2() {
	    JFrame jf = new JFrame("��ʾȫ����Ϣ(�����ͷ���԰�������������)");	   
	     JPanel panel = new JPanel();
	   Vector tcolumnNames=createColumnNames();
	   Vector tdata=createTableModelData();	   
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


	        table.setRowHeight(40);

	        table.getColumnModel().getColumn(0).setPreferredWidth(40);
             
	        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
	                
	        RowSorter sorter = new TableRowSorter(model);
	        table.setRowSorter(sorter);
	        JScrollPane pane = new JScrollPane(table);      

	        JScrollPane scrollPane = new JScrollPane(table);
	        panel.add(scrollPane);

	        jf.setContentPane(panel);
	        jf.pack();
	        jf.setSize(900, 600);
	        jf.add(scrollPane, BorderLayout.CENTER);
	        
	        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
			r.setHorizontalAlignment(JLabel.CENTER);   
			table.setDefaultRenderer(Object.class, r);
			
	        jf.setLocationRelativeTo(null);
	        int t=table.getRowCount();
	        if(t<=0){
	        	JOptionPane.showMessageDialog(null, "��ϵͳ�л�û��¼��ѧ����Ϣ������");
	        	jf.setVisible(false);
	        }
	        else {
	        	jf.setVisible(true);
	        }	 
	    }
    
     private Vector createColumnNames() {
       Vector columnNames = new Vector();
       columnNames.add("���");
       columnNames.add("����");
       columnNames.add("�Ա�");
       columnNames.add("����");
       columnNames.add("�绰����");
       columnNames.add("���̿γ�");
       columnNames.add("�꼶����");
       
       return columnNames;
   }
   
     private Vector createTableModelData() {
        
         Vector data = new Vector();
         String t=null;
			try{
				FileReader f1 = new FileReader("teacher.txt");
				BufferedReader br=new BufferedReader(f1);				
				int i=0;
				while ((t= br.readLine())!= null)
					{
					  String [] s=t.split("\\s+");						  
					  Vector rowData = new Vector();
			  
					  rowData.add(s[0]);					  
					  rowData.add(s[1]);
					  rowData.add(s[2]);
					  rowData.add(s[3]);
					  rowData.add(s[4]);			  
					  rowData.add(s[5]);   
					  rowData.add(s[6]);				  
					  data.add(rowData);					  
		  
					  i++;					   
					}
				     f1.close();
				     br.close();			     
				     
					} catch (IOException e) {
				
					e.printStackTrace();
					
				}	  
        return data;
     }   
}
