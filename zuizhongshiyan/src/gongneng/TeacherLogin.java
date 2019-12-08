package gongneng;

//��Ϣ������Ա��½��Ľ���
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;/*ArrayList;
import java.util.Hashtable;
*/
public class TeacherLogin extends JFrame implements  ActionListener{
	
	Functiont fun=new Functiont();
	
	//������� 
	JLabel lb1=new JLabel("��¼����" );
	JLabel lb2=new JLabel("����������");
	
  JTextField stid,name,age,phonenumber,course,grade;
  JRadioButton man,woman;
  ButtonGroup group=null;
  JButton input,query,delete,modify,display,back;
  JPanel p1,p2,p3,p4,p5,p6,p7,pv,ph,pb;
  
  public TeacherLogin(){      
      super("��ʦ��Ϣ����ϵͳ");
      stid=new JTextField(10);
      name=new JTextField(10);
      phonenumber=new JTextField(15);
      age=new JTextField(5);
      course=new JTextField(15);
      grade=new JTextField(18);
      
      group=new ButtonGroup();
      man=new JRadioButton("��");
      woman=new JRadioButton("Ů");
      group.add(man);
      group.add(woman);
      input=new JButton("���ӽ�ʦ��Ϣ");
      query=new JButton("��ѯ���������Ľ�ʦ��Ϣ");
      delete=new JButton("ɾ����ʦ��Ϣ");
      modify=new JButton("�޸Ľ�ʦ��Ϣ");
      display=new JButton("��ʾȫ����ʦ��Ϣ");
      back=new JButton("���ص�¼����");
  
      pb=new JPanel();
      pb.add(lb1,JLabel.CENTER);
              
      p1=new JPanel();
     
      p1.add(lb2,JLabel.CENTER);
      p1.add(new JLabel("ѧ��:",JLabel.CENTER));
      p1.add(stid);
      
      p2=new JPanel();
      p2.add(new JLabel("����:",JLabel.CENTER));
      p2.add(name);
      p3=new JPanel();
      p3.add(new JLabel("�Ա�:",JLabel.CENTER));
      p3.add(man);
      p3.add(woman);
      p4=new JPanel();
      p4.add(new JLabel("����:",JLabel.CENTER));
      p4.add(age);
      p5=new JPanel();
      p5.add(new JLabel("�绰:",JLabel.CENTER));
      p5.add(phonenumber);    
      p6=new JPanel();
      p6.add(new JLabel("��ѡ�γ�:",JLabel.CENTER));
      p6.add(course);
      p7=new JPanel();
      p7.add(new JLabel("�꼶:",JLabel.CENTER));
      p7.add(grade);
     
      pv=new JPanel();
      pv.setLayout(new GridLayout(7,1));   
          
      pv.add(p1);
      pv.add(p2);
      pv.add(p3);
      pv.add(p4);
      pv.add(p5);
      pv.add(p6);
      pv.add(p7);
             
      ph=new JPanel();      
      ph.add(input);
      ph.add(query);
      ph.add(modify);
      ph.add(delete);    
      ph.add(display);
      ph.add(back);
             
      Container con=getContentPane();
      con.setLayout(new BorderLayout());
      con.add(pb, BorderLayout.NORTH);
      con.add(pv, BorderLayout.CENTER);
      con.add(ph, BorderLayout.SOUTH);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setBounds(100,100,900,450);
      setVisible(true);
        
      Teacher_information tea=new Teacher_information();
      ArrayList<Teacher_information> arry=new ArrayList<Teacher_information>();

      input.addActionListener(new ActionListener() {
  	   public void actionPerformed(ActionEvent e) {		     		     
  		 String teaID = stid.getText();    
  		 if(fun.find(teaID)!=-1)
  		 {
  			 JOptionPane.showMessageDialog(null, "�ñ�Ŷ�Ӧ�Ľ�ʦ�Ѿ����ڣ�����\n\n��������������޸��Ѿ�¼��Ľ�ʦ");   			 
 
   			stid.setText("");
 			 name.setText("");
 			 age.setText("");
 			 phonenumber.setText("");
 			course.setText("");
 			 grade.setText("");
  			 return;
  		 }      		 
  		 String tname = name.getText();  		 
  
  		 if(teaID.equals("")||tname.equals(""))
  		 {
  			 JOptionPane.showMessageDialog(null, "¼��Ľ�ʦ��Ż�����Ϊ�գ�����\n\n����������");
  			 return;
  		 }  	   		 	 
    		 String tage = age.getText();     		 
    		 if(tage.equals(""))
 			    tage="--";  		 
    		 String tcall = phonenumber.getText();
    		 if(tcall.equals(""))
    			  tcall="--";
    		 String thome = course.getText();
    		
			if(thome.equals(""))
    		    thome="--";
    		 String tiden = grade.getText();
    		if(tiden.equals(""))
    		   tiden="--";
    		 String tsex=null;
           if(man.isSelected()){
              tsex=man.getText();
           }
           else{
               tsex=woman.getText();
           }   
          
    		 tea.setteaID(teaID);
    		 tea.settAge(tage);
    		 tea.settName(tname);
    		 tea.settSex(tsex);
    		 tea.settCallnummber(tcall);

    		 tea.settIdentityID(tiden);
    		 
    	
    	
    		 System.out.println("��Ϣ����Ա");
    		 System.out.println(tea.fileString());
    		 
    		 fun.add(tea);
    		 fun.writefile();
    		 
    		 JOptionPane.showMessageDialog(null, "�ɹ�");
    		 //dispose();
    		 setVisible(false); 
    		 new ManagerLogin();
    		 

  	   }   	   
     });
      
                 

      display.addActionListener(new ActionListener() {
 	   public void actionPerformed(ActionEvent e) {     		   
      
 		   new show_stuall2();   		     		   
 	    }	     		   
      });
                  
  
      query.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent e) {      		  
     		   String tID = stid.getText();   
     		   if(tID.equals(""))
     		     tID="--";       		   
       		  String tname = name.getText();  		 
       		  if(tname.equals(""))
     			   tname="--";      		 	 
         	  String tage = age.getText();     		 
         	  if(tage.equals(""))         
      			    tage="--";  		 
         	  String tcall = phonenumber.getText();
         	 if(tcall.equals(""))
         			  tcall="--";
         		 String thome = course.getText();
         		if(thome.equals(""))
         		    thome="--";
         		 String tiden = grade.getText();
         		if(tiden.equals(""))
         		   tiden="--";
         		 String tsex=null;
                if(man.isSelected()){
                   tsex=man.getText();
                }
                else {
             	    if(woman.isSelected())
                      tsex=woman.getText();
                    else {
						  tsex="--";
					   }
                }          		
      
      	 		FileWriter fw=null;
  				BufferedWriter out=null;
  				try {
  					 fw = new FileWriter("��ѯʱ��ʱ��ŵ��ļ�.txt");
  					 out = new BufferedWriter(fw);
  					
  					 out.write(tID+"  ");
  					 out.write(tname+"  ");
  					 out.write(tsex+"  ");
  					 out.write(tage+"  "); 					   					 
  					 out.write(tcall+"  ");
  					 out.write(thome+"  ");
  					 out.write(tiden+"  "); 
  				   					 
  					out.close();
  					fw.close();
  						
  				} catch (IOException e1) {
  					e1.printStackTrace();
  					
  				}     				
  			
  				new show2();  
  				
  			
  				stid.setText("");
  				name.setText("");
  				age.setText("");
  				phonenumber.setText("");
  				course.setText("");
  				grade.setText("");
  				group.clearSelection();
  				
      	    }	     		   
           }); 
     

     
        delete.addActionListener(new ActionListener() {
      	   public void actionPerformed(ActionEvent e) {
      		   String tID = stid.getText();    
      		   int flag=fun.find(tID);
      		   if(flag==-1)
      		   {
      			   JOptionPane.showMessageDialog(null, "δ���ҵ��ñ�ŵĽ�ʦ������\n\n����������");       			    
      		   }
      		   else {
					 fun.delete(tID); 
      		     fun.writefile();
      		     JOptionPane.showMessageDialog(null, "ɾ���ɹ�������\n");
				 }
     		
      		 
        		stid.setText("");
      			name.setText("");
      			age.setText("");
      			phonenumber.setText("");
      			course.setText("");
      			grade.setText("");
      			group.clearSelection();
      		   
      	    }	     		   
           });       
        
     
        modify.addActionListener(new ActionListener() {
        	   public void actionPerformed(ActionEvent e) {
        		  String teaID = stid.getText();    
        		 int flag=fun.find(teaID);    
       		 if (flag==-1)
       		 {
   			   JOptionPane.showMessageDialog(null, "δ���ҵ��ñ�ŵĽ�ʦ������\n\n����������");
    			   return;  
   		    }    
       		else
    			   JOptionPane.showMessageDialog(null, "��ϵͳ�д��ڸý�ʦ����\n\n,ȷ�Ϸ��غ���������Ҫ�޸ĺ������");
     			 		    		     		 
    		 String tage = age.getText();     		 
    		 if(tage.equals(""))
 			    tage="--";  		 
    		 String tcall = phonenumber.getText();
    		 if(tcall.equals(""))
    			  tcall="--";
    		 String thome = course.getText();
    		if(thome.equals(""))
    		    thome="--";
    		 String tiden = grade.getText();
    		if(tiden.equals(""))
    		   tiden="--";
    		 String tsex=null;
           if(man.isSelected()){
              tsex=man.getText();
           }
           else{
               tsex=woman.getText();
           }   
           String tname = name.getText();  		 
  	
  		 if(tname.equals(""))
  		 {
  			 JOptionPane.showMessageDialog(null, "����Ľ�ʦ��Ч\n\n����������");
  			 return;
  		 }  	
      
        		 tea.setteaID(teaID);
        		 tea.settAge(tage);
        		 tea.settName(tname);
        		 tea.settSex(tsex);
        		 tea.settCallnummber(tcall);
        	
        		 tea.settIdentityID(tiden);
       		 
        		 fun.update(tea);       
        		 fun.writefile();
        		 JOptionPane.showMessageDialog(null, "�޸ĳɹ�������");
        		
        		 stid.setText("");
   			name.setText("");
   			age.setText("");
   			phonenumber.setText("");
   			course.setText("");
   			grade.setText("");
   			group.clearSelection();	 		 			          		         		 
        	    }	     		             	   
             });
                      
    back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);   
			new Login();
		}
	});
   }

	@Override
	public void actionPerformed(ActionEvent arg0) {

		
	}

}


