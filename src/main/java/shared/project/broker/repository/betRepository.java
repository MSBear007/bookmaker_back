package shared.project.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shared.project.broker.model.Bookmaker;

public interface BetRepository extends JpaRepository<Bookmaker, Long> {
}
