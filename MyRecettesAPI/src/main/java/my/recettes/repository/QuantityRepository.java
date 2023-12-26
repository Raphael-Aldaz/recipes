package my.recettes.repository;

import my.recettes.entites.Ingredient;
import my.recettes.entites.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityRepository  extends JpaRepository<Quantity,Long> {
    List<Quantity> getQuantitiesByRecipeId(Long id);
}
