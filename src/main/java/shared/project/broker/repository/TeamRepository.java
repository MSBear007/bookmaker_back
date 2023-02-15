package shared.project.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shared.project.broker.model.Team;

public interface TeamRepository extends JpaRepository<Long, Team> {
     
}
