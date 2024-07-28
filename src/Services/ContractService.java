package Services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {

	public OnlinePaymentService OnlinePaymentService;

	public ContractService(Services.OnlinePaymentService onlinePaymentService) {
		OnlinePaymentService = onlinePaymentService;
	}

	public void ProcessContract(Contract contract, int months) {

		double basicQuota = contract.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {
			LocalDate Vdate = contract.getDate().plusMonths(i);
			double interest = OnlinePaymentService.interest(basicQuota, i);
			double fee = OnlinePaymentService.paymentFree(basicQuota + interest);
			
			double quota = basicQuota + interest + fee;
			
			contract.getInstallment().add(new Installment(Vdate,quota));
		}

	}

}
