package my.recettes.controllers;

import lombok.extern.slf4j.Slf4j;
import my.recettes.entites.Quantity;
import my.recettes.entites.Recipes;
import my.recettes.services.QuantityServiceImpl;
import my.recettes.services.RecipesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/api")
@CrossOrigin("*")
public class RecipesController {
    Path directory = Paths.get(System.getProperty("user.home") + "/myRecettes/images");
    @Autowired
    private RecipesServiceImpl recipesService;
    @Autowired
    private QuantityServiceImpl quantityService;

    @GetMapping("/recipes")
    public ResponseEntity<Page<Recipes>> allRecipes(@RequestParam("page") int page){
        Page<Recipes> listRecipes = null;
        try{
            PageRequest pageRequest = PageRequest.of(page, 6);
             listRecipes = recipesService.getAllRecipes(pageRequest);
        } catch (Exception e){
             log.info(e.getMessage());
        }
        return  ResponseEntity.ok().body(listRecipes);
    }
    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipes> getRecipes(@PathVariable("id") Long id){
        Recipes recipes = null;
        try{
             recipes = recipesService.getRecipes(id);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseEntity.ok().body(recipes);
    }
    @PostMapping("/recipes")
    public ResponseEntity<Recipes> newRecipes(@RequestBody Recipes recipes){
        System.out.println(recipes);
        Recipes newRecipes = new Recipes();
        try{
            newRecipes.setName(recipes.getName());
            newRecipes.setPicture("default.png");
            newRecipes.setTime(recipes.getTime());
            newRecipes.setDifficulty(recipes.getDifficulty());
        if (!recipes.getCategories().isEmpty()) {
            recipes.setCategories(recipes.getCategories());
            recipesService.saveRecipe(newRecipes);
        } else {
            recipesService.saveRecipe(newRecipes);
        }
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseEntity.ok().body(newRecipes);
    }

    @DeleteMapping("/recipes")
    public ResponseEntity<?> deleteMapping(@RequestParam ("id") Long id){
        try {
            Recipes recipes = recipesService.getRecipes(id);
            List<Quantity> quantity = quantityService.getQuantityByRecipeId(id);
            quantityService.deleteQuantity(quantity);

            recipesService.deleteRecipes(recipes);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseEntity.ok().body("Recette supprimé");
    }

    @GetMapping(path = "/picture/{id}", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public ResponseEntity<?> getPhoto(@PathVariable("id") Long id) {
        Path directory = Paths.get(System.getProperty("user.home") + "/myRecettes/images");
        byte[] file = null;
        try{
            if(!Files.exists(directory)){
                Files.createDirectories(directory);
            }
           Recipes recipes = recipesService.getRecipes(id);
            if(recipes.getPicture() == null ) {

               recipes.setPicture("default.png");
            };
           file = Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/myRecettes/images/" + recipes.getPicture()));
        } catch(Exception e){
            log.error("pb avec download de l'image d'id :", id);
            return ResponseEntity.internalServerError().body(e.getCause());
        }
        return ResponseEntity.ok().body(file);
    }



}
