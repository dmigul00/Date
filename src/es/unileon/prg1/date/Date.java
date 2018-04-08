package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year)throws DateException{
		StringBuffer message = new StringBuffer();
		if(day<=0){
			message.append("Dia no valido, no pueden ser negativo - wrong value for day: " +day);
		}
		if(month<=0){
			message.append("Mes no valido, no pueden ser negativo - wrong value for month: " + month);			
		}else{
			if(month>12){
				message.append("Rango de valor de los meses desde 1 hasta 12, no puede ser mayor - wrong value for month: "+month);							
			}else{
				if(day>lastDayMonth(month)){
					message.append("Combinacion dia/mes - wrong combination: " +day+ "/" +month);						
				}				
			}
		}
		if(year<0){
			message.append("Año negativo - wrong value for year: " +year);			
		}
		
		if (message.length()!=0){
			throw new DateException(message.toString());
		}else{
		this.day = day;
		this.month = month;
		this.year = year;
	}
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
	default:
		name="error";
	}
	return name;
	}
	public int lastDayMonth(){
		return this.lastDayMonth(this.month);
	}	
	private int lastDayMonth(int i){
	int day=1;
	switch(i){
	case 2:
	day=28;
	break;

	case 4:
	case 6:
	case 9:
	case 11:
	day=30;
	break;

	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
	day=31;
	break;
	}
	return day;
	}
	public boolean isMonthDayRight(){
		return this.isMonthDayRight(this.month);
	}
	private boolean isMonthDayRight(int i){
	boolean right=true;
	switch(i){
	case 2:
		if(this.day<=28){
		right=true;
		}
		else right=false;
		break;
	
	case 4:
	case 6:
	case 9:
	case 11:
		if(this.day<=30){
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
		if(this.day<=31){
		right=true;
		}
		else right=false;
		break;
		}
		return right;
		}

	public String getSeasonName(){
	String season=null;
	switch(this.month){
		case 1:
		case 2:
		case 3:
		season="invierno";
		break;

		case 4:
		case 5:
		case 6:
		season="primavera";
		break;

		case 7:
		case 8:
		case 9:
		season="verano";
		break;

		case 10:
		case 11:
		case 12:
		season="otono";
		break;

		default:
		season="error";
		}
		return season;
		}

	public String getMonthsLeft()throws DateException{
		StringBuilder daysleft;
		daysleft=new StringBuilder();
		Date auxiliar;
		int i=day;
		auxiliar=new Date(this.day,this.month,this.year);
			while(i<lastDayMonth()){
				auxiliar.day++;
				daysleft.append(auxiliar+"\n");
				i++;
			}
			
	return daysleft.toString();
	}

	public String datesLeft(){
	StringBuffer datesLeft=new StringBuffer();
	try{
	for(int i=this.day+1; i<=31; i++){
	Date left;
	left=new Date(i,this.month,this.year);
	if(left.isMonthDayRight()==true){
	datesLeft.append("\n"+left);
	}
	}
	}catch (DateException e){
			System.err.println("Date.datesLeft: "+e.getMessage());
	}
	return datesLeft.toString();
	}
	
	public String sameMonthAndDay(){
	StringBuffer sameMonthAndDay=new StringBuffer();
	try{
	for(int i=1;i<=12;i++){
	Date sameDate=new Date(this.day,i,this.year);
		if(this.lastDayMonth()==sameDate.lastDayMonth()){
		sameMonthAndDay.append(this.getMonthName(i)+", ");
		}
		}
		}catch (DateException e){
			System.err.println("Date.sameMonthsWithSameDays: "+e.getMessage());
	}
		return sameMonthAndDay.toString();
	}
	
	public int DaysPastYear()throws DateException{
			int res;
			res=0;
			Date aux;
			aux=new Date(1,1,this.year);
				for(int i=1;i<this.month;i++){
					res=res+aux.lastDayMonth();
					aux.month=i+1;
				}
		return res + this.day -1;
		}
		
		public int randomTriesDoWhile()throws DateException{
			int tries,a,b,c;
			tries=0;
			do{
				a= (int)(Math.random()*12) +1;
				b= (int)(Math.random()*this.lastDayMonth()) +1;
				c= this.year;
				tries++;	

			}while(!this.isSame(new Date(a,b,c)));
			
		return tries;
		}

	public String DayOfWeek()throws DateException{
		String day=null;
		int day;
		Date aux;
		aux=new Date(this.day,this.month,this.year);
		day=aux.DaysPastOfYear()%7;
		switch(day){
		case 0: 
			day="Lunes";
		break;
		case 1: 
			day="Martes";
		break;
		case 2: 
			day="Miercoles";
		break;
		case 3: 
			day="Jueves";
		break;
		case 4: 
			day="Viernes";
		break;
		case 5: 
			day="Sabado";
		break;
		case 6: 
			day="Domingo";
		break;
		}
		return day;
		}
}
