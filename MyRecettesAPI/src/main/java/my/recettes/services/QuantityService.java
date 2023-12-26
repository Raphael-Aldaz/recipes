package my.recettes.services;

import my.recettes.entites.Quantity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuantityService {
    public void deleteQuantity(List<Quantity> quantity);
    public List<Quantity> getQuantityByRecipeId(Long id);
    public Quantity getQuantity(Long id);
}
