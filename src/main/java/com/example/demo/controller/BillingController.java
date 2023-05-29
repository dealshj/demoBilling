package com.example.demo.controller;

import com.example.demo.beans.BillDetail;
import com.example.demo.service.BillingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@AllArgsConstructor
public class BillingController {
    private final BillingService billingService;
    @GetMapping(path = "/getbill")
    public String getBill(@RequestBody BillDetail billDetail)
    {
        return "Total bill is "+ billingService.getBill(billDetail);
    }
}
