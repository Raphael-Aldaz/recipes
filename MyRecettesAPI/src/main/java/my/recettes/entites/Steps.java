package my.recettes.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class Steps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "recipe_id")
    private Recipes recipe;


}
