package my.recettes.repository;

import my.recettes.entites.Steps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepsRepository extends JpaRepository<Steps, Long> {
}
