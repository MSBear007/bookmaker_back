package shared.project.broker.service.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import shared.project.broker.model.Bookmaker;

@Service
public class Parser {
    @Autowired
    Googler testParse;

    @Getter @Setter
    private Bookmaker bookmaker;

    public void parse1xstavka() {

    }
}
