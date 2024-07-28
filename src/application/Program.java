package application;

<<<<<<< HEAD
import java.time.LocalDate;
=======
import java.time.LocalDateTime;
>>>>>>> 8dd8d892139b4f9a3ddd8834f2f4e2703b9a0d7d
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

<<<<<<< HEAD
import Services.ContractService;
import Services.PaypalService;
import entities.Contract;
import entities.Installment;
=======
import model_entities.CarRental;
import model_entities.Vehicle;
import model_service.AngolanTaxService;
import model_service.RentalService;
>>>>>>> 8dd8d892139b4f9a3ddd8834f2f4e2703b9a0d7d

public class Program {

	public static void main(String[] args) {
<<<<<<< HEAD

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter the contract data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.println("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.println("Contract value: ");
		Double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		
		System.out.print("Enter the number of installments: ");
		int numberInstallments = sc.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		cs.ProcessContract(contract,numberInstallments);
		
		
		System.out.println("Installments: ");
		for(Installment installment : contract.getInstallment()) {
			
			System.out.println(installment);
		}
		
		
		
		
		sc.close();
=======
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your rental details");

		System.out.println("Car model: ");
		String modelCar = sc.nextLine();
		System.out.print("Pick up (dd/MM/yyyy HH:mm): ");
		String pickUpStr = sc.nextLine();
		LocalDateTime start = LocalDateTime.parse(pickUpStr, formatter);

		System.out.print("Return (dd/MM/yyyy HH:mm): ");
		String returnStr = sc.nextLine();
		LocalDateTime finish = LocalDateTime.parse(returnStr, formatter);

		CarRental cr = new CarRental(start, finish, new Vehicle(modelCar));

		System.out.print("Enter hourly rate: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();

		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new AngolanTaxService());

		rentalService.ProcessInvoice(cr);
		System.out.println();
		System.out.println("INVOICE: ");
		System.out.println("Basic payment:" + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Tax:" + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));

		sc.close();

>>>>>>> 8dd8d892139b4f9a3ddd8834f2f4e2703b9a0d7d
	}

}
