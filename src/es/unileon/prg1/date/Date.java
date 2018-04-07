package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	// Constructor mal programado: Permite crear fechas no validas
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public int getMonth(){
		return this.month;
	}
	public int getDay(){
		return this.day;
	}
	boolean isSameYear(Date another){
		if ( this.year == another.getYear() ){
			return true;
		}
		return false;
	}
	
	boolean isSameMonth(Date another){
		if(this.month == another.getMonth()){
			return true;
		}
		return false;
	}

	boolean isSameDay(Date another){
		if(this.day == another.getDay()){
			return true;
		}
		return false;
	}
	
	boolean isSame(Date another){
		if((this.year == another.getYear()) && (this.month == another.getMonth()) && (this.day == another.getDay())){
			return true;
		}
		return false;
	}
	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}
	
	public String getMonthName(){
		return this.getMonthName(this.getMonth());
	}
	
	private String getMonthName(int i){
	String name=null;
	switch(i){
	case 1:
	name="Enero";
	break;
	case 2:
	name="Febrero";
	break;
	case 3:
	name="Marzo";
	break;
	case 4:
	name="Abril";
	break;
	case 5:
	name="Mayo";
	break;
	case 6:
	name="Junio";
	break;
	case 7:
	name="Julio";
	break;
	case 8:
	name="Agosto";
	break;
	case 9:
	name="Septiembre";
	break;
	case 10:
	name="Octubre";
	break;
	case 11:
	name="Noviembre";
	break;
	case 12:
	name="Diciembre";
	break;
	}
	return name;
	}
	public int MonthLastDay(){
		return this.monthLastDay(this.month);
	}	
	private int monthLastDay(int i){
	int lastDay=1;
	switch(i){
	case 2:
	lastDay=28;
	break;

	case 4:
	case 6:
	case 9:
	case 11:
	lastDay=30;
	break;

	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
	lastDay=31;
	break;
	}
	return lastDay;
	}
	public boolean isMonthDayRight(){
		return this.isMonthDayRight(this.month);
	}
	private boolean isMonthDayRight(int i){
	boolean right=true;
	switch(i){
	case 2:
		if(this.day>=1 && this.day<=28){
		right=true;
		}
		else right=false;
		break;
	
	case 4:
	case 6:
	case 9:
	case 11:
		if(this.day>=1 && this.day<=30){
		right=true;
		}
		else right=false;
		break;

	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
		if(this.day>=1 && this.day<=31){
		right=true;
		}
		else right=false;
		break;
		}
		return right;
		}	
}
