package shared.project.broker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shared.project.broker.model.Bookmaker;
import shared.project.broker.repository.BookmakerRepository;

@Service
public class BookmakerService {

    @Autowired
    private BookmakerRepository repo;

    public Optional<Bookmaker> getById(long id) {
        return repo.findById(id);
    }
}
