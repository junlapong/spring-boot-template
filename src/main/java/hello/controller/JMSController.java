package hello.controller;

import hello.jms.JMSSend;
// import hello.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JMSController {

    private static final Logger logger = LoggerFactory.getLogger(JMSController.class);

    // @Autowired
    // CustomerRepository customerRepo;

    @Autowired
    JMSSend jmsSend;

    @RequestMapping(value = "/jms", method = RequestMethod.GET)
    public String jmsHome(@RequestParam(value = "payload", required = false, defaultValue = "Hello World!") String payload, Model model) {
        jmsSend.sendMsg(payload);
        return "index";
    }
}
