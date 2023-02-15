package shared.project.broker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import shared.project.broker.model.Bookmaker;
import shared.project.broker.service.BookmakerService;
import shared.project.broker.service.parser.Googler;

@RestController
@RequestMapping(path = "/v1/api/bookmaker")
public class BookmakerController {

    @Autowired
    private BookmakerService service;

    @Autowired 
    private Googler testParse;

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Bookmaker> getBookmaker(@PathVariable long id) {
        try {
            testParse.googleMatch("ПСЖ", "Бавария", "Футбол", null, null, "1xstavka.ru");
        }
        catch (Exception exc) {
            
        }
        return service.getById(id);
    }
}

