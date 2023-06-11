package fact.it.startproject.controller;

import fact.it.startproject.model.Tenant;
import fact.it.startproject.repository.TenantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TenantRestController {
    private final TenantRepository tenantRepository;

    public TenantRestController(TenantRepository tenantRepository){
        this.tenantRepository = tenantRepository;
    }

    @GetMapping("/tenants/select")
    public List<String> getTenantWithSpecificIncome(@RequestBody double income){
        List<Tenant> tenants = tenantRepository.getTenantsWithIncome(income);
        List<String> strings = new ArrayList<>();

        for (Tenant tenant : tenants){
            strings.add(String.format("%s with income %s", tenant.getName(), tenant.getIncome()));
        }

//        List<String> result = tenants.stream().map(tenant)

        return strings;
    }

    @PutMapping("/tenants/{id}")
    public ResponseEntity<Tenant> getDishById(@PathVariable("id") int tenantId, @RequestBody Integer num){
        Optional<Tenant> tenantCheck = tenantRepository.findById((long) tenantId);

        if (tenantCheck.isPresent()){
            Tenant tenant = tenantCheck.get();
            tenant.setIncome(num);

            tenantRepository.save(tenant);
            return new ResponseEntity<>(tenant, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/tenants/{id}")
    public ResponseEntity<Integer> deleteTenant(@PathVariable long id) {
        Optional<Tenant> tenantCheck = tenantRepository.findById(id);
        if (tenantCheck.isPresent()) {
            Tenant tenant = tenantCheck.get();
            tenantRepository.delete(tenant);
            return new ResponseEntity<>(tenantRepository.findAll().size(), HttpStatus.OK);
        }
        return new ResponseEntity<>(tenantRepository.findAll().size(), HttpStatus.NOT_FOUND);
    }
}
