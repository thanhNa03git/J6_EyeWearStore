package poly.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poly.store.entity.Account;
import poly.store.entity.Order;
import poly.store.service.AccountService;
import poly.store.service.OrderService;

import java.util.Date;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    AccountService accountService;

    @GetMapping("/order/checkout")
    public String checkout(@ModelAttribute("order")Order order){
        String username = "user1";
        Account account = accountService.findByUsername(username);
        order.setCreateDate(new Date());
        order.setAccount(account);
        return "order/checkout";
    }

//    @PostMapping("/order/checkout")
//    public String checkout(){
//
//    }
}
