package my.recettes.controllers;

import lombok.extern.slf4j.Slf4j;
import my.recettes.entites.Category;
import my.recettes.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@Slf4j
public class CategoryController {
    @Autowired
   private CategoryServiceImpl categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> listCategories = null;
        try{
            listCategories = categoryService.getAllCategories();
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseEntity.ok().body(listCategories);
    }
    @PostMapping("/categories")
    public ResponseEntity<Category> newCategory(@RequestBody Category categorie){
        Category newCat = null;
        try {
            newCat = categoryService.saveCategory(categorie);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseEntity.ok().body(newCat);
    }

    @DeleteMapping("/categories")
    public  ResponseEntity<?> deleteCategories(@RequestParam("id") Long id){
        try {
            Category category = categoryService.getCategory(id);
            categoryService.deleteCategory(category);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseEntity.ok().body(200);
    }
}
