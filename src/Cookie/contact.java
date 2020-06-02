package Cookie;

public class contact {
	    private String Uname,email,sub,msg;

		public contact(String uname, String email, String sub, String msg) {
			super();
			Uname = uname;
			this.email = email;
			this.sub = sub;
			this.msg = msg;
		}

		public String getUname() {
			return Uname;
		}

		public void setUname(String uname) {
			Uname = uname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSub() {
			return sub;
		}

		public void setSub(String sub) {
			this.sub = sub;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}


}
