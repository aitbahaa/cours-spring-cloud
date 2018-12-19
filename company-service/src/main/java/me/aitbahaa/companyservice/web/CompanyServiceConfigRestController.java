package me.aitbahaa.companyservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CompanyServiceConfigRestController {

    @Value("${me}")
    private String me;
    @Value("${xParam}")
    private String xParam;
    @Value("${yParam}")
    private String yParam;

    @GetMapping("serviceConfig")
    public Map<String, Object> serviceConfig() {
        Map<String, Object> params = new HashMap<>();

        params.put("me", me);
        params.put("xParam", xParam);
        params.put("yParam", yParam);
        params.put("currentThread", Thread.currentThread().getName());

        return params;
    }
}
