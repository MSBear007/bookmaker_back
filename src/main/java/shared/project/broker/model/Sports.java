package shared.project.broker.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sports", schema = "public")
public class Sports {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable(name="bet_types_sports", 
        joinColumns = @JoinColumn(name="sports_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="bet_type_id", referencedColumnName = "id"))
    private List<BetType> betTypes;
}
