package hello.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Properties;

@Controller
public class HomeController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("properties")
    @ResponseBody
    Properties properties() {
        return System.getProperties();
    }
}
