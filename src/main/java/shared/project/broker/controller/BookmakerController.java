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

@RestController
@RequestMapping(path = "/v1/api/bookmaker")
public class BookmakerController {

    @Autowired
    private BookmakerService service;

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Bookmaker> getBookmaker(@PathVariable long id) {
        return service.getById(id);
    }

}

