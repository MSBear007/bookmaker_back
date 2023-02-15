package shared.project.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shared.project.broker.model.BetType;

public interface BetTypeRepository extends JpaRepository<Long, BetType> {
    
}
