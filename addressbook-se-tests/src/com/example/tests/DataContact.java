package com.example.tests;

public class DataContact implements Comparable<DataContact> {
	public String fname;
	public String lname;
	public String addr1;
	public String phoneHome;
	public String phoneMob;
	public String phoneWork;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String addr2;
	public String phone2;

	public DataContact() {
	}

	@Override
	public String toString() {
		return "DataContact [fname=" + fname + ", lname=" + lname
				+ ", email=" + email + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataContact other = (DataContact) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		return true;
	}

	@Override
	public int compareTo(DataContact other) {
		if (!this.fname.equals(other.fname)) {
			return this.fname.compareTo(other.fname);
		}
		else {
			return this.lname.compareTo(other.lname);			
		}
	}


	
}