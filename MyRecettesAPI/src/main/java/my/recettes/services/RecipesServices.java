package my.recettes.services;

import my.recettes.entites.Recipes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RecipesServices {
    public Recipes saveRecipe(Recipes recipes);
    public Page<Recipes> getAllRecipes(PageRequest allRecipes);
    public Recipes getRecipes(Long id);
    public void deleteRecipes(Recipes recipes);
}
