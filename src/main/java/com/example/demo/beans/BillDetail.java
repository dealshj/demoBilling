package com.example.demo.beans;

import lombok.Data;
import lombok.Setter;

import java.util.List;

@Setter
@Data
public class BillDetail {
    private UserDetails userDetails;
    private List<Product> itemLst;

    public BillDetail(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }


    @Override
    public String toString() {
        return "Shopper{" +
                "userDetails=" + userDetails +
                '}';
    }


}
