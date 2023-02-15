package shared.project.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shared.project.broker.model.Country;

public interface CountryRepository extends JpaRepository<Long, Country> {
    
}
