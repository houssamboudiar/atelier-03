package com.realestate.models;

public class Date{

	private int date;
	private int month;
	private int year;
	
	public Date() {
		
	}
	
	public Date(int date, int month, int year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	public boolean isAfter(Date d2) {
		
		if(this.getYear() > d2.getYear() )
			return true;
		else {
			if(this.getYear() < d2.getYear()) {
				return false;
			}else {
				if(this.getMonth() > d2.getMonth() )
					return true;
				else {
					if(this.getMonth() < d2.getMonth()) {
						return false;
					}else {
						if(this.getDate() < d2.getDate()) {
							return false;
						}else {
							return true;
						}
					}
				}
			}
		}
	}
	
	public Date convertToDate(String date) {
		String _day = (String) date.subSequence(8, 10);
		String _month = (String) date.subSequence(5, 7);
		String _year = (String) date.subSequence(0, 4);
		int day = 0, month = 0, year = 0;
		
		for(int i=1; i<32; i++) {
			if(_day.equals(""+i)) {
				day = i;
				break;
			}
		}
		
		for(int i=1; i<13; i++) {
			if(_month.equals(""+i)) {
				month = i;
				break;
			}
		}
		
		for(int i=2018; i<2019; i++) {
			if(_year.equals(""+i)) {
				year = i;
				break;
			}
		}
		
		return new Date(day, month, year);
		
	}
		
}
