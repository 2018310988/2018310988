package gongneng;

public class Student_information {
	private String stuID;   
	private String name;     
	private String sex;    
    private String age;       
    private String callnumber;  
    private String home_place;  
    private String identityID;   
    
    public Student_information() {
    
    }
    public Student_information(String stuID,String name,String sex,String age,String callnumber,String home_place,String identityID) {
    	super();
    	this.stuID=stuID;
    	this.name=name;
    	this.sex=sex;
    	this.age=age;
    	this.callnumber=callnumber;
    	this.home_place=home_place;
    	this.identityID=identityID;
    }
    public String getStuID() {
    	return this.stuID;
    }
    public void setStuID(String stuID) {
    	this.stuID=stuID;
    }
    
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name=name;
    }
    
    public String getSex() {
    	return this.sex;
    }
    public void setSex(String sex) {
    	this.sex=sex;
    }
    
    public String getAge() {
    	return this.age;
    }
    public void setAge(String age) {
    	this.age=age;
    }
    
    public String getCallnumber() {
    	return this.callnumber;
    }
    public void setCallnummber(String callnumber) {
    	this.callnumber=callnumber;
    }
    
    public String getHome_place() {
    	return this.home_place;
    }
    public void setHome_place(String home_place) {
    	this.home_place=home_place;
    }
    
    public String getIdentityID() {
    	return this.identityID;
    }
    public void setIdentityID(String identityID) {
    	this.identityID=identityID;
    }
    
    public String fileString()
	{
		return stuID+" "+name+" "+sex+" "+age+"  "+callnumber+"  "+home_place+"  "+identityID;
	}

   
}

