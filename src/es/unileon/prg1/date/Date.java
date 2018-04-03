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

	boolean isSameYear(Date another){
		if ( this.year == another.getYear() ){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}
	public String getMonthName(){
	String name="";
	switch(this.month){
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
}
