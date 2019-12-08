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
	
	JLabel lb1=new JLabel("登录界面" );
	JLabel lb2=new JLabel("请输入学号");
	
  JTextField stid,name,age,phonenumber,course,grade;
  JRadioButton man,woman;
  ButtonGroup group=null;
  JButton input,query,delete,modify,display,back;
  JPanel p1,p2,p3,p4,p5,p6,p7,pv,ph,pb;
  
  public ManagerLogin(){      
      super("学生信息");
      stid=new JTextField(10);
      name=new JTextField(10);
      phonenumber=new JTextField(15);
      age=new JTextField(5);
      course=new JTextField(15);
      grade=new JTextField(18);
      
      group=new ButtonGroup();
      man=new JRadioButton("男");
      woman=new JRadioButton("女");
      group.add(man);
      group.add(woman);
      input=new JButton("增加学生信息");
      query=new JButton("查询学生信息");
      delete=new JButton("删除学生信息");
      modify=new JButton("修改学生信息");
      display=new JButton("显示全部");
      back=new JButton("返回登录界面");
  
      pb=new JPanel();
      pb.add(lb1,JLabel.CENTER);
              
      p1=new JPanel();     
     
      p1.add(lb2,JLabel.CENTER);
      p1.add(new JLabel("学号:",JLabel.CENTER));//JLabel.CENTER是指JLabel的中心点。CENTER是中心点的坐标
      p1.add(stid);
      
      p1.add(lb2,JLabel.CENTER);
      p1.add(new JLabel("学号:",JLabel.CENTER));
      p1.add(stid);
      
      p2=new JPanel();
      p2.add(new JLabel("姓名:",JLabel.CENTER));
      p2.add(name);
      p3=new JPanel();
      p3.add(new JLabel("性别:",JLabel.CENTER));
      p3.add(man);
      p3.add(woman);
      p4=new JPanel();
      p4.add(new JLabel("年龄:",JLabel.CENTER));
      p4.add(age);
      p5=new JPanel();
      p5.add(new JLabel("电话:",JLabel.CENTER));
      p5.add(phonenumber);    
      p6=new JPanel();
      p6.add(new JLabel("所选课程:",JLabel.CENTER));
      p6.add(course);
      p7=new JPanel();
      p7.add(new JLabel("年级:",JLabel.CENTER));
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
  			 JOptionPane.showMessageDialog(null, "该学生已存在\n\n请重新输入或者修改已经录入的学生");   			 
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
  			 JOptionPane.showMessageDialog(null, "录入的学生学号或姓名为空！！！\n\n请重新输入");
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
    		 
    		 System.out.println("信息管理员");
    		 System.out.println(stu.fileString());
    		 
    		 fun.add(stu);
    		 fun.writefile();
    		 
    		 JOptionPane.showMessageDialog(null, "成功");
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
  					 fw = new FileWriter("查询暂存文件.txt");
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
      			   JOptionPane.showMessageDialog(null, "未找到\n\n请重新输入");       			    
      		   }
      		   else {
					 fun.delete(sID); 
      		     fun.writefile();
      		     JOptionPane.showMessageDialog(null, "删除完毕\n");
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
   			   JOptionPane.showMessageDialog(null, "未找到\n\n请重新输入");
    			   return;  
   		    }    
       		else
    			   JOptionPane.showMessageDialog(null, "已存在该数据\n\n,确认返回后请输入需要修改后的数据");
     			 		    		     		 
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
      			 JOptionPane.showMessageDialog(null, "输入无效\n\n请重新输入");
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
        		 JOptionPane.showMessageDialog(null, "修改完毕");
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


