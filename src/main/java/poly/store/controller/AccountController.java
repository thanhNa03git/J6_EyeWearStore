package poly.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping("/account/setting")
    public String setting(){
        return "account/setting";
    }
    //Chinh sua profile
    @GetMapping("/account/edit-profile")
    public String editProfileForm(Model model, Authentication auth) {
        String username = auth.getName();
        Account account = accountService.findByUsername(username);
        model.addAttribute("account", account);
        return "account/edit-profile";
    }
    @PostMapping("/account/edit-profile")
    public String editProfileProcess(Model model,
                                     @ModelAttribute("account") Account account) {
        accountService.update(account);
        model.addAttribute("message", "Thông tin tài khoản của bạn đã được cập nhật");
        return "account/edit-profile";
    }
    //Quen mat khau
    @GetMapping("/account/forgot-password")
    public String forgotPasswordForm() {
        return "account/forgot-password";
    }
    @PostMapping("/account/forgot-password")
    public String forgotPasswordProcess(Model model,
                                        @RequestParam("username") String username,
                                        @RequestParam("email") String email) {
        return "account/forgot-password";
    }
    //Doi mat khau
    @GetMapping("/account/change-password")
    public String changePasswordForm(Model model,Authentication auth) {
        String username = auth.getName();
        Account account = accountService.findByUsername(username);
        model.addAttribute("account", account);
        return "account/change-password";
    }
    @PostMapping("/account/change-password")
    public String changePasswordProcess(Model model,
                                        @RequestParam("username") String username,
                                        @RequestParam("oldpass") String oldpass,
                                        @RequestParam("newpass") String newpass,
                                        @RequestParam("confirm") String confirm ) {


        return "account/change-password";
    }
}
