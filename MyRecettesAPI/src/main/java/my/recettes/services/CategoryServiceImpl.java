package my.recettes.services;

import my.recettes.entites.Category;
import my.recettes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements  CategoryServices{
    @Autowired
    private CategoryRepository categoryRepository;
    /**
     * @param category
     * @return
     */
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * @param
     * @return
     */
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Category getCategory(Long id) {
        return categoryRepository.getById(id);
    }

    /**
     * @param category
     */
    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    /**
     * @param category
     * @return
     */
    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
