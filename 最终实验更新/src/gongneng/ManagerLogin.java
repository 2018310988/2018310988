package gongneng;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class ManagerLogin extends JFrame implements  ActionListener{
	
	Function fun=new Function();
	
	JLabel lb1=new JLabel("��¼����" );
	JLabel lb2=new JLabel("������ѧ��");
	
  JTextField stid,name,age,phonenumber,course,grade;
  JRadioButton man,woman;
  ButtonGroup group=null;
  JButton input,query,delete,modify,display,back;
  JPanel p1,p2,p3,p4,p5,p6,p7,pv,ph,pb;
  
  public ManagerLogin(){      
      super("ѧ����Ϣ");
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
      input=new JButton("����ѧ����Ϣ");
      query=new JButton("��ѯѧ����Ϣ");
      delete=new JButton("ɾ��ѧ����Ϣ");
      modify=new JButton("�޸�ѧ����Ϣ");
      display=new JButton("��ʾȫ��");
      back=new JButton("���ص�¼����");
  
      pb=new JPanel();
      pb.add(lb1,JLabel.CENTER);
              
      p1=new JPanel();     
     
      p1.add(lb2,JLabel.CENTER);
      p1.add(new JLabel("ѧ��:",JLabel.CENTER));//JLabel.CENTER��ָJLabel�����ĵ㡣CENTER�����ĵ������
      p1.add(stid);
      
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
      setBounds(110,110,910,460);
      setVisible(true);
        
      Student_information stu=new Student_information();
      ArrayList<Student_information> arry=new ArrayList<Student_information>();
      
      input.addActionListener(new ActionListener() {
  	   public void actionPerformed(ActionEvent e) {		     		     
  		 String sID = stid.getText();   
  		 if(fun.find(sID)!=-1)
  		 {
  			 JOptionPane.showMessageDialog(null, "��ѧ���Ѵ���\n\n��������������޸��Ѿ�¼���ѧ��");   			 
    			stid.setText("");
    			 name.setText("");
    			 age.setText("");
    			 phonenumber.setText("");
    			course.setText("");
    			 grade.setText("");
     			 return;
  		 }      		 
  		 String sname = name.getText();  		 
  		 if(sID.equals("")||sname.equals(""))
  		 {
  			 JOptionPane.showMessageDialog(null, "¼���ѧ��ѧ�Ż�����Ϊ�գ�����\n\n����������");
  			 return;
  		 }  	   		 	 
    		 String sage = age.getText();     		 
    		 if(sage.equals(""))
 			    sage="--";  		 
    		 String scall = phonenumber.getText();
    		 if(scall.equals(""))
    			  scall="--";
    		 String shome = course.getText();
    		if(shome.equals(""))
    		    shome="--";
    		 String siden = grade.getText();
    		if(siden.equals(""))
    		   siden="--";
    		 String ssex=null;
           if(man.isSelected()){
              ssex=man.getText();
           }
           else{
               ssex=woman.getText();
           }   
          
    		 stu.setStuID(sID);
    		 stu.setAge(sage);
    		 stu.setName(sname);
    		 stu.setSex(ssex);
    		 stu.setCallnummber(scall);
    		 stu.setHome_place(shome);
    		 stu.setIdentityID(siden);
    		 
    		 System.out.println("��Ϣ����Ա");
    		 System.out.println(stu.fileString());
    		 
    		 fun.add(stu);
    		 fun.writefile();
    		 
    		 JOptionPane.showMessageDialog(null, "�ɹ�");
    		 setVisible(false); 
    		 new ManagerLogin();
    		 

  	   }   	   
     });
      

        display.addActionListener(new ActionListener() {
   	   public void actionPerformed(ActionEvent e) {     		       
   		   new show_stuall();   		     		   
   	    }	     		   
        });
                    
        query.addActionListener(new ActionListener() {
      	   public void actionPerformed(ActionEvent e) {      		  
      		   String sID = stid.getText();  
      		   if(sID.equals(""))
      		     sID="--";       		   
        		  String sname = name.getText();  		 
        		  if(sname.equals(""))
      			   sname="--";      		 	 
          	  String sage = age.getText();     		 
          	  if(sage.equals(""))        
       			    sage="--";  		 
          	  String scall = phonenumber.getText();
          	 if(scall.equals(""))
          			  scall="--";
          		 String shome = course.getText();
          		if(shome.equals(""))
          		    shome="--";
          		 String siden = grade.getText();
          		if(siden.equals(""))
          		   siden="--";
          		 String ssex=null;
                 if(man.isSelected()){
                    ssex=man.getText();
                 }
                 else {
              	    if(woman.isSelected())
                       ssex=woman.getText();
                     else {
						  ssex="--";
					   }
                 }          		            

      	 		FileWriter fw=null;
  				BufferedWriter out=null;
  				try {
  					 fw = new FileWriter("��ѯ�ݴ��ļ�.txt");
  					 out = new BufferedWriter(fw);
  					 out.write(sID+"  ");
  					 out.write(sname+"  ");
  					 out.write(ssex+"  ");
  					 out.write(sage+"  "); 					   					 
  					 out.write(scall+"  ");
  					 out.write(shome+"  ");
  					 out.write(siden+"  "); 	   					 
  					out.close();
  					fw.close();
  						
  				} catch (IOException e1) {
  					e1.printStackTrace();
  					
  				}     				

  				new show1();  
  				
  
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
      		   String sID = stid.getText();   
      		   int flag=fun.find(sID);
      		   if(flag==-1)
      		   {
      			   JOptionPane.showMessageDialog(null, "δ�ҵ�\n\n����������");       			    
      		   }
      		   else {
					 fun.delete(sID); 
      		     fun.writefile();
      		     JOptionPane.showMessageDialog(null, "ɾ�����\n");
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
        		  String sID = stid.getText();   
        		 int flag=fun.find(sID);      		
       		 if (flag==-1)
       		 {
   			   JOptionPane.showMessageDialog(null, "δ�ҵ�\n\n����������");
    			   return;  
   		    }    
       		else
    			   JOptionPane.showMessageDialog(null, "�Ѵ��ڸ�����\n\n,ȷ�Ϸ��غ���������Ҫ�޸ĺ������");
     			 		    		     		 
        		 String sage = age.getText();     		 
        		 if(sage.equals(""))
     			    sage="--";  		 
        		 String scall = phonenumber.getText();
        		 if(scall.equals(""))
        			  scall="--";
        		 String shome = course.getText();
        		if(shome.equals(""))
        		    shome="--";
        		 String siden = grade.getText();
        		if(siden.equals(""))
        		   siden="--";
        		 String ssex=null;
                 if(man.isSelected()){
                     ssex=man.getText();
                  }
                  else{
                      ssex=woman.getText();
                  }   
                  String tname = name.getText();  		 
         	
         		 if(tname.equals(""))
         		 {
      			 JOptionPane.showMessageDialog(null, "������Ч\n\n����������");
      			 return;
      		 }  	

        		 stu.setStuID(sID);
        		 stu.setAge(sage);
        		 stu.setName(sname);
        		 stu.setSex(ssex);
        		 stu.setCallnummber(scall);
        		 stu.setHome_place(shome);
        		 stu.setIdentityID(siden);
       		 
        		 fun.update(stu);     
        		 fun.writefile();
        		 JOptionPane.showMessageDialog(null, "�޸����");
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


