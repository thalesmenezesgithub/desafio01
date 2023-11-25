package com.devsuperior.totalvalue;

import com.devsuperior.totalvalue.entities.Order;
import com.devsuperior.totalvalue.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class TotalValueApplication implements CommandLineRunner {

    private OrderService orderService;

    public TotalValueApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TotalValueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner input = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Entre com o código do produto:");
        int code = input.nextInt();
        order.setCode(code);

        System.out.println("Entre com o valor base do produto:");
        double basic = input.nextDouble();
        order.setBasic(basic);

        System.out.println("Entre com o valor desconto do produto:");
        double discount = input.nextDouble();
        order.setDiscount(discount);

        //Order order =  new Order(1034,150.00,20.0);
        System.out.println("");
        System.out.println("Código do pedido: " + order.getCode());
        System.out.printf("Valor total:  R$%.2f%n ", orderService.total(order) );
    }
}
