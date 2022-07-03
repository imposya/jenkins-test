package ru.imposya.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") int a,
                                 @RequestParam(value = "b") int b,
                                 @RequestParam(value = "action") String action,
    Model model)

    {
        double result;
        switch(action) {
            case ("multiplication") :
                result = a * b;
                model.addAttribute("message", "a * b = " + result);
                break;
            case ("addition") :
                result = a + b;
                model.addAttribute("message", "a + b = " + result);
                break;
            case ("substraction") :
                result = a - b;
                model.addAttribute("message", "a - b = " + result);
                break;
            case ("division") :
                result = (double) a / b;
                model.addAttribute("message", "a / b = " + result);
                break;
            default:
                model.addAttribute("message", "wrong action");
                break;
        }
        return "first/calculator";
    }
}
