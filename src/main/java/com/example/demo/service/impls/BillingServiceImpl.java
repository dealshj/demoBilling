package com.example.demo.service.impls;



import com.example.demo.beans.Product;
import com.example.demo.beans.BillDetail;
import com.example.demo.beans.UserDetails;
import com.example.demo.enums.ItemDiscounts;
import com.example.demo.enums.ProductTypes;
import com.example.demo.enums.UserTypes;
import com.example.demo.service.BillingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class BillingServiceImpl implements BillingService {
     double userDiscountPercentage ;
    @Override
    public double getBill(BillDetail billDetail) {
        UserDetails userDetails = billDetail.getUserDetails();
        userDiscountPercentage = getUserDiscount(userDetails.getUserType(), userDetails.getUserSince());
        double totalBill = 0.0d;

        for (Product p : billDetail.getItemLst()) {
            totalBill += getDiscountedProductPrice(p);
        }
            totalBill= totalBill - getAdditionalDiscountForEvery100Doller(totalBill);
        return totalBill;

    }

    private int getAdditionalDiscountForEvery100Doller(double totalBill) {
        int remainder= (int) (totalBill/100);
        return remainder*5 ;
    }

    private double getDiscountedProductPrice(Product product) {
        return product.getQuantity() * product.getUnitPrice() - getDiscountOnProductPrice(product);
    }

    private double getDiscountOnProductPrice(Product product) {
        return product.getQuantity() * product.getUnitPrice() *
                ((product.getType().equals(ProductTypes.GROCERY)) ? 0 : userDiscountPercentage);
    }

    private double getUserDiscount(UserTypes userType, LocalDateTime userSince) {
        double userDiscountPercentage = 0.0d;
        switch (userType) {
            case AFFILIATE:
                userDiscountPercentage = ItemDiscounts.AFFILIATE.getDiscount();
                break;
            case CUSTOMER:
                if (ChronoUnit.YEARS.between(userSince, LocalDateTime.now()) > 2) {
                    userDiscountPercentage = ItemDiscounts.CUSTOMER.getDiscount();
                }
                break;
            case EMPLOYEE:
                userDiscountPercentage = ItemDiscounts.EMPLOYEE.getDiscount();
                break;
        }
        return userDiscountPercentage;
    }
}
