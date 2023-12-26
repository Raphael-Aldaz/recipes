package my.recettes.services;

import my.recettes.entites.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CategoryServices {
    public Category saveCategory(Category category);
    public List<Category> getAllCategories();
    public Category getCategory(Long id);
    public void deleteCategory(Category category);
    public Category updateCategory(Category category);



}
