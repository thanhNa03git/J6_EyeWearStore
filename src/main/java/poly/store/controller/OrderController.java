package poly.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.store.cart.CartService;
import poly.store.entity.Account;
import poly.store.entity.Order;
import poly.store.entity.OrderDetail;
import poly.store.entity.Product;
import poly.store.service.AccountService;
import poly.store.service.OrderDetailService;
import poly.store.service.OrderService;
import poly.store.service.ProductService;

import java.util.Date;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    AccountService accountService;
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/order/checkout")
    public String checkout(@ModelAttribute("order")Order order){
        String username = "user1";
        Account account = accountService.findByUsername(username);
        order.setCreateDate(new Date());
        order.setAccount(account);
        return "order/checkout";
    }

//    button Purchase Now
    @PostMapping("/order/checkout")
    public String checkout(Model model, @ModelAttribute("order") Order order){
        //đưa đơn hàng vô database -> orderService
        orderService.creat(order);
        //lay cac mat hang trong gio hang roi duyet qua vong lap
        cartService.getItems().forEach(item -> {
            // cu 1 item thi tao ra 1 orderDetail
            OrderDetail detail = new OrderDetail();
            detail.setPrice(item.getPrice());
            detail.setQuantity(item.getQuantity());
            detail.setOrder(order);

            Product product = productService.findById(item.getId());
            detail.setProduct(product);
            //dem order detail vo database
            orderDetailService.create(detail);
        });
        //gọi lại địa chỉ url sang trang orderlist
        return "redirect:/order/list";
    }
    @RequestMapping("/order/list")
    public String list(Model model){
        String username = "user1";
        Account account = accountService.findByUsername(username);
        model.addAttribute("user", account);
        return "/order/list";
    }
    @RequestMapping("/order/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "order/detail";
    }
}
