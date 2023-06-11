package fact.it.startproject.controller;

import fact.it.startproject.model.Contract;
import fact.it.startproject.model.Property;
import fact.it.startproject.model.Tenant;
import fact.it.startproject.repository.ContractRepository;
import fact.it.startproject.repository.PropertyRepository;
import fact.it.startproject.repository.TenantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
public class MainController {
    private final PropertyRepository propertyRepository;
    private final TenantRepository tenantRepository;
    private final ContractRepository contractRepository;

    public MainController(PropertyRepository propertyRepository,
                          TenantRepository tenantRepository,
                          ContractRepository contractRepository){
        this.propertyRepository = propertyRepository;
        this.tenantRepository = tenantRepository;
        this.contractRepository = contractRepository;
    }

    @RequestMapping("/")
    public String manageStaff(Model model) {
        List<Property> list = propertyRepository.findAll();
        model.addAttribute("allProperty", list);

        return "index";
    }

    @RequestMapping("/add_contract")
    public String addContract(HttpServletRequest request, Model model) {
        Long propertyId = Long.valueOf(request.getParameter("propertyId"));
        Property property = propertyRepository.getById(propertyId);
        List<Tenant> tenants = tenantRepository.findAll();

        model.addAttribute("allTenants", tenants);
        model.addAttribute("property", property);

        return "1_add_contract";
    }

    @RequestMapping("/process_contract")
    public String addOrderItem(HttpServletRequest request, Model model) {
        Long propertyId = Long.valueOf(request.getParameter("propertyId"));
        Property property = propertyRepository.getById(propertyId);

        Long tenantId = Long.valueOf(request.getParameter("tenant"));
        int rentalPrice = Integer.parseInt(request.getParameter("price"));
        Tenant tenant = tenantRepository.getById(tenantId);

        Contract contract = new Contract();
        contract.setProperty(property);
        contract.setTenant(tenant);
        contract.setRentalPrice(rentalPrice);
        contract.setActive(false);
        contractRepository.save(contract);

        List<Contract> contracts = contractRepository.findAll();
        model.addAttribute("contracts", contracts);

        return "2_contracts";
    }
}
