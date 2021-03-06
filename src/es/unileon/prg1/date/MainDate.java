package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today, tomorrow;
		try{
		today = new Date(20, 4, 2018);
		tomorrow = new Date(21, 4, 2018);
		
		System.out.println(today+" isSameYear "+tomorrow+"? "+today.isSameYear(tomorrow));
		System.out.println(today+" isSameMonth "+tomorrow+"? "+today.isSameMonth(tomorrow));		
		System.out.println(today+" isSameDay "+tomorrow+"? "+today.isSameDay(tomorrow));
		System.out.println(today +" isSame "+tomorrow +"? "+today.isSame(tomorrow));
		System.out.println("Hoy el mes es: "+today.getMonthName());
		System.out.println("Mañana el mes sera: " + tomorrow.getMonthName());
		System.out.println("El dia " +today.getDay()+" del mes "+today.getMonth()+" es correcto? "+today.isMonthDayRight());
		System.out.println("El dia " +tomorrow.getDay()+" del mes "+tomorrow.getMonth()+" es correcto? "+tomorrow.isMonthDayRight());
		System.out.println("la estacion del primer mes "+today.getMonthName()+" es: "+today.getSeasonName());
		System.out.println("la estacion del segundo mes "+tomorrow.getMonthName()+" es: "+tomorrow.getSeasonName());
		System.out.println("quedan "+today.getMonthsLeft()+" para que acabe el anio");
		System.out.println("quedan "+tomorrow.getMonthsLeft()+" para que acabe el anio");
		System.out.println("fecha de hoy: "+today.toString());
		System.out.println("fecha de mañana: "+tomorrow.toString());
		System.out.println("quedan estos dias hasta el final de mes desde hoy "+today.datesLeft());
		System.out.println("quedan estos dias hasta el final de mes desde mañana "+tomorrow.datesLeft());
		System.out.println("meses con mismos dias "+today.sameMonthAndDay());
		System.out.println("meses con mismos dias "+today.DaysPastYear());
		System.out.println("intentos"+today.randomTriesDoWhile());
		}catch (DateException e){
			System.err.println("Fecha no valida: "+e.getMessage());
	}
}
}
