package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hello.domain.PaymentForm;

@Controller
public class PaymentController {

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("greeting", new PaymentForm());
        return "test";
    }

    @RequestMapping(value="/PaymentManager/PaymentInput.do", method=RequestMethod.POST)
    public String paymentSubmit(@ModelAttribute PaymentForm greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "test-result";
    }

}
