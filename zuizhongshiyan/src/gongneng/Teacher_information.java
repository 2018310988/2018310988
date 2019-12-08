package gongneng;

public class Teacher_information {
	private String teaID;    
	private String tname;   
	private String tsex;    
    private String tage;       
    private String tcallnumber;   
    private String tcourse;  
    private String tidentityID; 
    
 
    public Teacher_information() {
    
    }

    public Teacher_information(String teaID,String tname,String tsex,String tage,String tcallnumber,String tcourse,String tidentityID) {
    	super();
    	this.teaID=teaID;
    	this.tname=tname;
    	this.tsex=tsex;
    	this.tage=tage;
    	this.tcallnumber=tcallnumber;
    	this.tcourse=tcourse;
    	this.tidentityID=tidentityID;
    }
    public String getteaID() {
    	return this.teaID;
    }
    public void setteaID(String teaID) {
    	this.teaID=teaID;
    }
    
    public String gettName() {
    	return tname;
    }
    public void settName(String tname) {
    	this.tname=tname;
    }
    
    public String gettSex() {
    	return this.tsex;
    }
    public void settSex(String tsex) {
    	this.tsex=tsex;
    }
    
    public String gettAge() {
    	return this.tage;
    }
    public void settAge(String tage) {
    	this.tage=tage;
    }
    
    public String gettCallnumber() {
    	return this.tcallnumber;
    }
    public void settCallnummber(String tcallnumber) {
    	this.tcallnumber=tcallnumber;
    }
    
    public String gettcourse() {
    	return this.tcourse;
    }
    public void settcourse(String tcourse) {
    	this.tcourse=tcourse;
    }
    
    public String gettIdentityID() {
    	return this.tidentityID;
    }
    public void settIdentityID(String tidentityID) {
    	this.tidentityID=tidentityID;
    }
    

    public String fileString()
	{
		return teaID+" "+tname+" "+tsex+" "+tage+"  "+tcallnumber+"  "+tcourse+"  "+tidentityID;
	}

   
}

