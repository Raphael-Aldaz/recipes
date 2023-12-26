package my.recettes.services;

import lombok.extern.slf4j.Slf4j;
import my.recettes.entites.Ingredient;
import my.recettes.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class IngredientServiceImpl implements IngredientService{
    @Autowired
    private IngredientRepository ingredientRepository;
    /**
     * @param ingredient
     * @return
     */
    @Override
    public Ingredient newIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Ingredient getIngredient(Long id) {
        Ingredient ingredient = null;
        try{
            ingredient = ingredientRepository.getById(id);
        } catch (Exception e){
            log.info("Erreur récuperation ingredient d'id :", id);
        }
        return  ingredient;
    }

    /**
     * @param page
     * @return
     */
    @Override
    public Page<Ingredient> getAllIngredient(PageRequest page) {
        return ingredientRepository.findAll(page);
    }

    /**
     * @param ingredient
     */
    @Override
    public void deleteIngredient(Ingredient ingredient) {
        try{
            ingredientRepository.delete(ingredient);
        } catch (Exception e){
            log.info("Erreur suppresion ingredient d'id", ingredient.getId() + e.getMessage());
        }
    }
}
