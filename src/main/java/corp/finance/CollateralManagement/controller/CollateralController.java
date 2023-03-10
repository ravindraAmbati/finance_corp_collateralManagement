package corp.finance.CollateralManagement.controller;

import corp.finance.CollateralManagement.config.ServiceConfig;
import corp.finance.CollateralManagement.model.Collateral;
import corp.finance.CollateralManagement.model.Properties;
import corp.finance.CollateralManagement.service.CollateralService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/collaterals")
@RestController
public class CollateralController {

    private final CollateralService collateralService;

    private final ServiceConfig serviceConfig;

    @GetMapping("/all")
    public @ResponseBody List<Collateral> getAllCollaterals() {
        return collateralService.getAllCollaterals();
    }

    @PostMapping("/ids")
    public @ResponseBody List<Collateral> getCollaterals(@RequestBody List<String> collateralIds) {
        return collateralService.getCollaterals(collateralIds);
    }

    @GetMapping("/{collateralId}")
    public @ResponseBody Collateral getCollateral(@PathVariable("collateralId") String collateralId) {
        return collateralService.getCollateral(collateralId);
    }

    @GetMapping("/properties")
    public @ResponseBody Properties getProperties() {
        return new Properties(serviceConfig.getMessage(), serviceConfig.getBuildVersion(), serviceConfig.getMailDetails());
    }
}
