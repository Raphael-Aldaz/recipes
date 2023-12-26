package my.recettes;


import lombok.extern.slf4j.Slf4j;
import my.recettes.entites.Category;
import my.recettes.repository.IngredientRepository;
import my.recettes.repository.QuantityRepository;
import my.recettes.services.CategoryServiceImpl;
import my.recettes.services.RecipesServices;
import my.recettes.services.StepsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
@Slf4j
public class MyRecettesApplication implements CommandLineRunner {
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private QuantityRepository quantityRepository;
    @Autowired
    private RecipesServices recipesServices;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private StepsServiceImpl stepsService;

    public static void main(String[] args) {
        SpringApplication.run(MyRecettesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Path directory = Paths.get(System.getProperty("user.home") + "/myRecettes/images");
        String defaultImg = "static/default.png";
        if(!Files.exists(directory)) {
            Files.createDirectories(directory);
            InputStream inputStream = new ClassPathResource(defaultImg).getInputStream();
            Path destinationFile = directory.resolve("default.png");
            try {
                Files.copy(inputStream, destinationFile);
                log.info("Fichier copié avec succès.");
            } catch(IOException e) {
                log.info("Une erreur s'est produite lors de la copie du fichier : " + e.getMessage());
            }
        }
        //generatedCategory();
    }

    public void generatedCategory() {
        Category vegan = categoryService.saveCategory(new Category(null, "Vegan"));
        Category viande = categoryService.saveCategory(new Category(null, "Viande"));
        Category fish = categoryService.saveCategory(new Category(null, "Poisson"));
        Category healthy = categoryService.saveCategory(new Category(null, "Healthy"));

    }
}
