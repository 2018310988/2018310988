package gongneng;


import java.io.*;
import java.util.*;



class Functiont {
	
    ArrayList<Teacher_information> arry=new ArrayList<Teacher_information>();  			
	public Functiont()           
	{
		this.readfile();
	}
	public int find(String str) 
	{		
	    for (int i = 0; i<arry.size(); i++)
	      if (arry.get(i).getteaID().equals(str))
						return i;
			return -1;
	}	
	
	public void update(Teacher_information tea) {
		int flag=find(tea.getteaID());    
		arry.set(flag, tea);		   
	}	
	public boolean readfile() {					 
			String t=null;
			try{
				FileReader f1 = new FileReader("teacher.txt");
				BufferedReader br=new BufferedReader(f1);				
				arry.clear();    //	���ԭ�����б��е�����				
				while ((t= br.readLine())!= null)
					{
					  String [] s=t.split("\\s+");				 
					  Teacher_information te=Teacher_information(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);//ע�������ļ�ÿ��û���߸��ַ�����������
					  arry.add(te);
					  System.out.println("��ȡ�ļ���");
					  System.out.println(s[0]);
					}
				     f1.close();
				     br.close();				     
				     return true;
					} catch (IOException e) {
					e.printStackTrace();
					return false;
				}	
		     }					
	private Teacher_information Teacher_information(String string, String string2, String string3, String string4,
			String string5, String string6, String string7) {
		return null;
	}

	public boolean add(Teacher_information tea)
	     {		
		System.out.println();	
		System.out.println("Ҫ��ӵĽ�ʦ");	
		System.out.println(tea.fileString());
		System.out.println();
		if (find(tea.getteaID())!=-1)
			return false;		
		arry.add( tea); 
		return true;			
	}
	
	public boolean writefile() {
				FileWriter fw=null;
				BufferedWriter out=null;
				try {
					 fw = new FileWriter("teacher.txt");    
					 out = new BufferedWriter(fw);
					
						for(int i=0;i<arry.size();i++){
							String s=arry.get(i).fileString();
							System.out.println("�����б����ݣ�");
							System.out.println(arry.get(i).fileString());
					    	out.write(s);
					    	out.newLine();
					    }
						out.close();
						fw.close();
						return true;
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
		   }
	
	public boolean delete(String s)	
	{  
		int pos=find(s);
		if (pos==-1)
			return false;
		
		arry.remove(pos);    
		return true;
	}
	
		

}
