package com.example.demo;

import com.example.demo.beans.BillDetail;
import com.example.demo.beans.Product;
import com.example.demo.beans.UserDetails;
import com.example.demo.enums.ProductTypes;
import com.example.demo.enums.UserTypes;
import com.example.demo.service.BillingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	BillingService billingService;

	@Test
	public void UserIsAffiliate()  {
		assertEquals(210,billingService.getBill(getBillDetail(UserTypes.AFFILIATE)));
	}
	@Test
	public void UserIsEmployee(){
		assertEquals(175,billingService.getBill(getBillDetail(UserTypes.EMPLOYEE)));
	}

	@Test
	public void UserIsOldCustomer(){
		assertEquals(220,billingService.getBill(getBillDetail(UserTypes.CUSTOMER)));
	}

	@Test
	public void UserIsRecentCustomer(){
		LocalDateTime localDateTime = LocalDateTime.of(2023, 05, 22, 3, 15);
		UserDetails userDetails = new UserDetails(UserTypes.CUSTOMER, localDateTime);
		BillDetail billDetail =getBillDetail(UserTypes.CUSTOMER);
		billDetail.setUserDetails(userDetails);
		assertEquals(230,billingService.getBill(billDetail));
	}

	private  BillDetail getBillDetail(UserTypes userTypes) {
		LocalDateTime localDateTime = LocalDateTime.of(2018, 11, 22, 3, 15);
		UserDetails userDetails = new UserDetails(userTypes, localDateTime);
		List<Product> itmLst=new ArrayList<>();
		Product p=new Product("a",2, ProductTypes.CLOTHS,100);
		Product p1=new Product("b",2,ProductTypes.GROCERY,20);
		itmLst.add(p);
		itmLst.add(p1);
		BillDetail billDetail=new BillDetail(userDetails);
		billDetail.setItemLst(itmLst);
		return billDetail;
	}

}
