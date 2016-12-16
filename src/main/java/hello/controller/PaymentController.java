package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hello.domain.PaymentForm;
import java.util.Base64;

@Controller
public class PaymentController {

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("greeting", new PaymentForm());
        return "test";
    }

    @RequestMapping(value="/PaymentManager/PaymentInput.do", method=RequestMethod.POST)
    public String paymentSubmit(@ModelAttribute PaymentForm form, Model model) {

        try {
            byte[] bytes = Base64.getDecoder().decode(form.getContent());
            String content = new String(bytes, "utf-8");
            form.setContent(content);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        model.addAttribute("greeting", form);
        return "test-result";
    }

}
