package my.recettes.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Nullable
    private String picture;
    private Long time;
    private int difficulty;
    private int nbPersons;

    @ManyToMany
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn (name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", targetEntity = Quantity.class)
    private List<Quantity> quantities = new ArrayList<>();

    @OneToMany(mappedBy = "recipe")
    private List<Steps> steps = new ArrayList<>();
}
