package poly.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/security/login/form")
	public String login() {
		return "security/login";
	}
	@RequestMapping("/security/login/success")
	public String success(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "security/login";
	}
	@RequestMapping("/security/login/failure")
	public String failure(Model model) {
		model.addAttribute("message", "Đăng nhập thất bại!");
		return "security/login";
	}
	@RequestMapping("/security/access/denied")
	public String denied(Model model) {
		model.addAttribute("message", "Không có thẩm quyền truy cập!");
		return "security/login";
	}
	@RequestMapping("/security/logout/success")
	public String logoutSuccess(Model model) {
		model.addAttribute("message", "Đăng xuất thành công!");
		return "security/login";
	}
}