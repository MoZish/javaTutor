package fact.it.startproject.controller;

import fact.it.startproject.model.CashPayment;
import fact.it.startproject.model.ElectronicPayment;
import fact.it.startproject.model.Payment;
import fact.it.startproject.repository.PaymentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PaymentController {

    PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @RequestMapping("/getallpayments")
    public String getAllPayments(Model model) {
        model.addAttribute("paymentList", paymentRepository.findAll());
        return "result";
    }

    @RequestMapping("/getallsortedbyamount")
    public String getAllSortedByAmount (Model model) {
        model.addAttribute("paymentList", paymentRepository.findAllOrderByAmountAsc());
        return "result";
    }

    @RequestMapping("/getallcashpayments")
    public String getAllCashPayments (Model model) {
        List<Payment> cashList = paymentRepository.findAll().stream().filter(payment -> payment instanceof CashPayment).collect(Collectors.toList());

        model.addAttribute("paymentList", cashList);
        return "result";
    }

    @RequestMapping("/getallelectricpaymentssortedbycurrency")
    public String getAllElectricPayments (Model model) {
        List<Payment> electricList = paymentRepository.findAll().stream().filter(payment -> payment instanceof ElectronicPayment).sorted(Comparator.comparing(Payment::getCurrency)).collect(Collectors.toList());
        model.addAttribute("paymentList", electricList);

        return "result";
    }

    @RequestMapping("/paymentsgreaterthan")
    public String getPaymentsGreaterThan (HttpServletRequest request, Model model) {
        int amount = Integer.parseInt(request.getParameter("amount"));
        model.addAttribute("paymentList", paymentRepository.getByAmountGreaterThan(amount));

        return "result";

    }

}
