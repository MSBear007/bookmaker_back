package shared.project.broker.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bet_type", schema = "public")
public class BetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter @Setter
    @ManyToMany (mappedBy = "betTypes", fetch = FetchType.LAZY)
    private List<Sports> sports;

    /**
     * For example, 1Win means bet for first team win
     * Total>2.5 means bet for total > 2.5 goals
     */
    @Getter @Setter
    private String description;
}
