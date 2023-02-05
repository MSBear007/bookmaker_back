package shared.project.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shared.project.broker.model.Bookmaker;

public interface BookmakerRepository extends JpaRepository<Bookmaker, Long>{
    
}
