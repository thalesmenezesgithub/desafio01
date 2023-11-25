package com.devsuperior.totalvalue.services;

import com.devsuperior.totalvalue.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order){
        double basicValue = order.getBasic();

        if ( basicValue < 100) {
            return 20.00;
        }else if (basicValue >= 100 && basicValue <= 200) {
            return 12.00;
        } else {
            return 0.0;
        }
    }
}
