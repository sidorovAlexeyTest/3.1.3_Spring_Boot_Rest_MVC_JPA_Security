package org.sidorov.Spring_Boot_JPA_MVC_SECURITY.controlles.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class PageController {

    @GetMapping("admin")
    public ModelAndView getAdminPage(ModelAndView modelAndView) {
        modelAndView.setViewName("admin_page");
        return modelAndView;
    }

    @GetMapping("user")
    public ModelAndView getUserPage(ModelAndView modelAndView) {
        modelAndView.setViewName("user_page");
        return modelAndView;
    }

    @GetMapping("login")
    public ModelAndView getLoginPage(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
