package poly.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.store.entity.Account;
import poly.store.service.AccountService;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    //dangky
    @GetMapping("/account/sign-up")
    public String signUpForm(@ModelAttribute("account") Account account) {
        return "account/sign-up";
    }
    @PostMapping("/account/sign-up")
    public String signUpProcess(Model model,
                                @ModelAttribute("account") Account account,
                                @RequestParam("confirm") String confirm) {
        if(!confirm.equals(account.getPassword())) {
            model.addAttribute("message", "Xác nhận mật khẩu không chính xác");
        } else {
            accountService.create(account);
            model.addAttribute("message", "Đăng ký thành công");
        }
        return "account/sign-up";
    }
    //Chinh sua profile

    //Quen mat khau

    //Doi mat khau
}
