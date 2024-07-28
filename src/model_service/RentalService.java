package model_service;

import java.time.Duration;

import model_entities.CarRental;
import model_entities.Invoice;

public class RentalService {
	
	private Double PricePerHour;
	private Double PricePerDay;
	
	private TaxService taxservice;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxservice) {
		PricePerHour = pricePerHour;
		PricePerDay = pricePerDay;
		this.taxservice = taxservice;
	}
	
	
	public void ProcessInvoice(CarRental carRental ) {
		
		double minutes= Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours= minutes /60.0;
		double day = hours /24.0;
		Double basicPAyment;
		if (hours <= 12) {
			basicPAyment = PricePerHour * Math.ceil(hours);	
		}else {
			basicPAyment = PricePerDay  * Math.ceil(day);
		}
		double tax = taxservice.tax(basicPAyment);
		
		carRental.setInvoice(new Invoice(basicPAyment,tax));
	}
	
	

}
