package my.recettes.services;

import lombok.extern.slf4j.Slf4j;
import my.recettes.entites.Quantity;
import my.recettes.repository.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuantityServiceImpl implements QuantityService {
    @Autowired
    private QuantityRepository quantityRepository;
    /**
     * @param quantity
     */
    @Override
    public void deleteQuantity(List<Quantity> quantity) {
        quantityRepository.deleteAll(quantity);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<Quantity> getQuantityByRecipeId(Long id) {
        return  quantityRepository.getQuantitiesByRecipeId(id);

    }

    /**
     * @param id
     * @return
     */
    @Override
    public Quantity getQuantity(Long id) {
        Quantity quantity = null;
        try {
            quantity = quantityRepository.getById(id);
        } catch (Exception e){
            log.info("Erreur recupération quantité d'id", id, e.getMessage());
        }
        return quantity;
    }
}
