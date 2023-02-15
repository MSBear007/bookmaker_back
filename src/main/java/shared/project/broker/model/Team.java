package shared.project.broker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "team", schema = "public")
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    @Column(columnDefinition = "text", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @Getter @Setter
    private Country country;

    @ManyToOne
    @JoinColumn(name = "sports_id")
    private Sports sports;

}
