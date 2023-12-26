package my.recettes.services;

import my.recettes.entites.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IngredientService {
    public Ingredient newIngredient(Ingredient ingredient);
    public Ingredient getIngredient(Long id);
    public Page<Ingredient> getAllIngredient(PageRequest page);
    public void deleteIngredient(Ingredient ingredient);
}
