package de.tum.hackatum.hellofresh.persistence.food.relationship;

import de.tum.hackatum.hellofresh.persistence.food.recipe.RecipeEntity;
import de.tum.hackatum.hellofresh.persistence.user.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientPreferenceRepository extends JpaRepository<IngredientPreferenceEntity, Long> {

    List<IngredientPreferenceEntity> findAllByUserDetailsEntity(UserDetailsEntity userDetailsEntity);

}
