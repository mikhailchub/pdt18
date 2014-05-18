package com.example.tests;

public class Data_AddressBook {
	public String fname;
	public String lname;
	public String addr1;
	public String phone_home;
	public String phone_mob;
	public String phone_work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String addr2;
	public String phone2;

	public Data_AddressBook() {
	}
	
	public Data_AddressBook(String ab_fname, String ab_lname, String ab_addr1,
			String ab_phone_home, String ab_phone_mob, String ab_phone_work,
			String ab_email, String ab_email2, String ab_bd_day,
			String ab_bd_month, String ab_bd_year, String ab_addr2,
			String ab_phone2) {
		this.fname = ab_fname;
		this.lname = ab_lname;
		this.addr1 = ab_addr1;
		this.phone_home = ab_phone_home;
		this.phone_mob = ab_phone_mob;
		this.phone_work = ab_phone_work;
		this.email = ab_email;
		this.email2 = ab_email2;
		this.bday = ab_bd_day;
		this.bmonth = ab_bd_month;
		this.byear = ab_bd_year;
		this.addr2 = ab_addr2;
		this.phone2 = ab_phone2;
	}
}