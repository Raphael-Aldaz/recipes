package my.recettes.services;

import my.recettes.entites.Steps;

import java.util.List;

public interface StepsService {
    public Steps newSteps(Steps steps);
    public Steps getSteps(Long id);
    public List<Steps> getAllSteps();
    public void deleteSteps(Steps steps);
}
