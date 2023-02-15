package shared.project.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shared.project.broker.model.Sports;

public interface SportsRepository extends JpaRepository<Long, Sports>{
    
}
