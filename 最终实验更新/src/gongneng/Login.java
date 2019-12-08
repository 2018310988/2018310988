package gongneng;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public  class Login extends JFrame implements  ActionListener{
	JFrame frame=new JFrame();
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;

	public Login(){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jlb1=new JLabel("请按身份登陆");
		jb1=new JButton("学生端");
		jb2=new JButton("教师端");

		frame.setLayout(new GridLayout(4, 1));

		jp1.add(jlb1);	
		jp3.add(jb1);
		jp3.add(jb2);
		frame.add(jp2);
		frame.add(jp1);
		frame.add(jp3);
		
		frame.setTitle("登录界面");
		frame.setSize(450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
				
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   frame.setVisible(false);
				new ManagerLogin();
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   frame.setVisible(false);
				new TeacherLogin();
			}
		});
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

