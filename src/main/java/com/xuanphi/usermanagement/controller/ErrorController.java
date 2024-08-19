package com.xuanphi.usermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    /**
     * @author phinx
     * @description show error 403 page
     */
    @GetMapping("/error-403")
    public String showError403() {
        return "error/403";
    }

    /**
     * @author phinx
     * @description show error 404 page
     */
    @GetMapping("/error-404")
    public String showError404() {
        return "error/404";
    }
}