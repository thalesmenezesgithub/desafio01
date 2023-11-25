package com.devsuperior.totalvalue.services;

import com.devsuperior.totalvalue.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService){
        this.shippingService = shippingService;
    }

    public double total(Order order){
        double discountValue = order.getBasic() * (order.getDiscount() / 100);
        double totalValue = (order.getBasic() - discountValue) + shippingService.shipment(order);

        return totalValue;
    }
}
