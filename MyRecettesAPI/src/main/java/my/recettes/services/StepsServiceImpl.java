package my.recettes.services;

import lombok.extern.slf4j.Slf4j;
import my.recettes.entites.Steps;
import my.recettes.repository.StepsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class StepsServiceImpl implements StepsService{
    @Autowired
    private StepsRepository stepsRepository;
    /**
     * @param steps
     * @return
     */
    @Override
    public Steps newSteps(Steps steps) {
        return stepsRepository.save(steps);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Steps getSteps(Long id) {
        Steps step = null;
        try{
            step = stepsRepository.getById(id);
        } catch(Exception e){
          log.info("Erreur get s tep d'id :", id, e.getMessage());
        }
        return step;
    }

    /**
     * @return
     */
    @Override
    public List<Steps> getAllSteps() {
        List<Steps> allSteps = stepsRepository.findAll();
        return allSteps;
    }

    /**
     * @param steps
     */
    @Override
    public void deleteSteps(Steps steps) {
        try {
            stepsRepository.delete(steps);
        } catch (Exception e){
            log.info("Erreur suppresion step d'id :", steps.getId(), e.getMessage());
        }
    }
}
