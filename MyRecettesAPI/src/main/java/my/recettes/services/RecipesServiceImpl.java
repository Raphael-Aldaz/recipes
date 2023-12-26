package my.recettes.services;

import lombok.extern.slf4j.Slf4j;
import my.recettes.entites.Recipes;
import my.recettes.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RecipesServiceImpl implements RecipesServices {
    @Autowired
    private RecipesRepository recipesRepository;

    /**
     * @param recipes
     * @return recipe who has been created
     */
    @Override
    public Recipes saveRecipe(Recipes recipes) {
        return recipesRepository.save(recipes);
    }

    /**
     * @param allRecipes
     * @return the list avec all recipes sort by poage
     */
    @Override
    public Page<Recipes> getAllRecipes(PageRequest allRecipes) {
        return recipesRepository.findAll(allRecipes);
    }

    /**
     * @param id
     * @return A recipe by is ID
     */
    @Override
    public Recipes getRecipes(Long id) {
        Recipes recipes = null;
        try {
            Optional<Recipes> optionalRecipe = recipesRepository.findById(id);
            if (optionalRecipe.isPresent()) recipes = optionalRecipe.get();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return recipes;
    }

    /**
     * @param  recipes
     */
    @Override
    public void deleteRecipes(Recipes recipes) {
        try {
            recipesRepository.delete(recipes);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}