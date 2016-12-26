package hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hello.domain.Person;

@Controller
public class DataTableController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = {"/data-table"}, method = RequestMethod.GET)
    public String table(Model model) {

        logger.info("dandelion data table example");

        List<Person> persons = new ArrayList<>(115);
        for (int i = 1; i <= 115; i++) {
            Person person = new Person();
            person.setId(String.valueOf(i));
            person.setFirstName("John" + i);
            person.setLastName("Doe" + i);
            persons.add(person);
        }

        model.addAttribute("persons", persons);

        return "data-table";
    }

}
