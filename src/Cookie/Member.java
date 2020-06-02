package Cookie;

public class Member
{
    private String fname,lname,uname,pass,email,mno;

	public Member(String fname, String lname, String uname, String pass, String email, String mno) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.pass = pass;
		this.email = email;
		this.mno = mno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

    
}
