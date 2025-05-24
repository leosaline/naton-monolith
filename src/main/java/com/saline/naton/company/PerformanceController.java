package com.saline.naton.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PerformanceController {

    @GetMapping(value = "/performance")
    public String generateLoadArray() {
        List<Company> companyList = new ArrayList<>();

        for (int i = 0; i < 6000000; i++) {
            companyList.add(new Company(1L, "teste", "teste", 1L, true));
        }

        List<Company> companies = companyList.stream().toList();

        return "executou";
    }
}
