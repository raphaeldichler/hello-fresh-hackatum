package de.tum.hackatum.hellofresh.persistence.food;


import de.tum.hackatum.hellofresh.persistence.food.ingredient.IngredientEntity;
import de.tum.hackatum.hellofresh.persistence.food.ingredient.IngredientRepository;
import de.tum.hackatum.hellofresh.persistence.food.recipe.RecipeEntity;
import de.tum.hackatum.hellofresh.persistence.food.recipe.RecipeRepository;
import de.tum.hackatum.hellofresh.persistence.food.relationship.RegionEntity;
import de.tum.hackatum.hellofresh.persistence.food.relationship.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class FoodDataLoader {

    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;
    private final RegionRepository regionRepository;
    /*
        TODO Batuhan. Füge die JSON-Datei in die Datenbank hinzu. Hierfür das JSON auslesen und dann
        in die Datenbank mithilfe von save des Repositories. siehe ordner
     */

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        loadIngredients();
        addRecipe();
    }

    private IngredientEntity byName(String name) {
        return ingredientRepository.getIngredientEntityByName(name).get();
    }

    private void addRecipe(){
        RegionEntity mexikanisch = regionRepository.save(RegionEntity.builder().name("Mexikanisch").build());

        RecipeEntity r1 = recipeRepository.save(
                RecipeEntity.builder()
                        .name("Tacos mit Räuchertofu & Mango-Paprika-Salsa")
                        .ingredients(null)
                        .link("https://img.hellofresh.com/c_fit,f_auto,fl_lossy,h_1100,q_30,w_2600/hellofresh_s3/image/HF_Y23_R33_W05_DE_R4484-1_KB_Main_low-99964e18.jpg")
                        .content("https://www.hellofresh.de/recipes/couscous-mit-dukkah-gemuse-and-hirtenkase-thermomix-650819fe270f68660e1ac70b")
                        .workingTimeSeconds(20 * 60)
                        .workingTimeTotalSeconds(30 * 60)
                        .regionEntity(mexikanisch)
                        .kcal(878)
                        .carbs(6.2f)
                        .protein(32.1f)
                        .fat(18f)
                        .build()
        );

        r1.setIngredients(new HashSet<>());

        r1.getIngredients().add(byName("Weizentortillas"));
        r1.getIngredients().add(byName("Mango"));
        r1.getIngredients().add(byName("rote Spitzpaprika"));
        r1.getIngredients().add(byName("rote Zwiebel"));
        r1.getIngredients().add(byName("Gewürzmischung Hello Harissa"));
        r1.getIngredients().add(byName("Sojasoße"));
        r1.getIngredients().add(byName("vegane Mayonnaise"));
        r1.getIngredients().add(byName("Knoblauchzehe"));
        r1.getIngredients().add(byName("Olivenöl"));
        r1.getIngredients().add(byName("Salz"));
        r1.getIngredients().add(byName("Zucker"));
        r1.getIngredients().add(byName("Weißweinessig"));
        r1.getIngredients().add(byName("Pfeffer"));
        r1.getIngredients().add(byName("Öl"));

        recipeRepository.save(r1);

        RegionEntity deutsch = regionRepository.save(RegionEntity.builder().name("Deutsch").build());

        RecipeEntity r2 = recipeRepository.save(
                RecipeEntity.builder()
                        .name("Mexican Torta! Pulled Pork Sandwich")
                        .ingredients(new HashSet<>())
                        .link("https://img.hellofresh.com/c_fit,f_auto,fl_lossy,h_1100,q_30,w_2600/hellofresh_s3/image/HF_Y23_R10_W43_DE_PM4758-1_Main_F2_low-74af93fa.jpg")
                        .content("https://www.hellofresh.de/recipes/couscous-mit-dukkah-gemuse-and-hirtenkase-thermomix-650819fe270f68660e1ac70b")
                        .workingTimeSeconds(20 * 60)
                        .workingTimeTotalSeconds(30 * 60)
                        .regionEntity(deutsch)
                        .kcal(1211)
                        .carbs(15.2f)
                        .protein(25.4f)
                        .fat(18f)
                        .build()
        );

        r2.getIngredients().add(byName("würziger Gouda, gerieben"));
        r2.getIngredients().add(byName("Mini-Fladenbrot"));
        r2.getIngredients().add(byName("Jalapeno"));
        r2.getIngredients().add(byName("Avocado"));
        r2.getIngredients().add(byName("Tomate"));
        r2.getIngredients().add(byName("Aioli"));
        r2.getIngredients().add(byName("Limette, gewachst"));
        r2.getIngredients().add(byName("Koriander"));
        r2.getIngredients().add(byName("Ketchup"));
        r2.getIngredients().add(byName("Gewürzmischung Hello Fiesta"));
        r2.getIngredients().add(byName("Öl"));
        r2.getIngredients().add(byName("Zucker"));
        r2.getIngredients().add(byName("Pfeffer"));
        r2.getIngredients().add(byName("Salz"));

        recipeRepository.save(r2);

        RegionEntity eng = regionRepository.save(RegionEntity.builder().name("Englisch").build());


        RecipeEntity r3 = recipeRepository.save(
                RecipeEntity.builder()
                        .name("BBQ Burritos mit Hackfleisch")
                        .ingredients(new HashSet<>())
                        .link("https://img.hellofresh.com/c_fit,f_auto,fl_lossy,h_1100,q_30,w_2600/hellofresh_s3/image/HF_Y23_R10_W43_DE_PM4758-1_Main_F2_low-74af93fa.jpg")
                        .content("https://www.hellofresh.de/recipes/couscous-mit-dukkah-gemuse-and-hirtenkase-thermomix-650819fe270f68660e1ac70b")
                        .workingTimeSeconds(20 * 60)
                        .workingTimeTotalSeconds(30 * 60)
                        .regionEntity(eng)
                        .kcal(1211)
                        .carbs(15.2f)
                        .protein(25.4f)
                        .fat(18f)
                        .build()
        );

        r3.getIngredients().add(byName("Weizentortillas"));
        r3.getIngredients().add(byName("rote Spitzpaprika"));
        r3.getIngredients().add(byName("Jalapeno"));
        r3.getIngredients().add(byName("würziger Gouda, gerieben"));
        r3.getIngredients().add(byName("Tomate"));
        r3.getIngredients().add(byName("Aioli"));


        recipeRepository.save(r3);
    }

    private void loadIngredients() {
        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Weizentortillas")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da292a796d73553a895e4f-91202737.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Borlotti Bohnen")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/image/57d82b82d804b535138b4567-52fcfe66.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Mango")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29cd796d73553a89678c-d83bda5d.png")
                        .build()
        );


        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("rote Spitzpaprika")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29c5b886d9ac2889dd3c-4e5bbcf1.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("rote Zwiebel")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29bd796d73553a8966aa-cea6f733.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Gewürzmischung Hello Harissa")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2969d3fa192603728b46-6de389c4.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Sojasoße")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2921d3fa19260372871b-bf6f58c5.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("vegane Mayonnaise")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da293eb886d9ac2889d50b-6dfe560b.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Knoblauchzehe")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29e1b886d9ac2889decd-1f443e2e.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Olivenöl")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64dba17beb160db9a3ae4598-e2b95464.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Salz")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64dba15ceb160db9a3ae44f1-4656e7bb.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Zucker")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64dba148f7724a92345a7982-22d7565c.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Weißweinessig")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64dba15ff7724a92345a79cb-50172d9e.png")
                        .build()
        );


        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Pfeffer")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64dba170d57fa39a31ce3261-3f58cb37.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Öl")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64dba157d57fa39a31ce3216-d2c7259f.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("würziger Gouda, gerieben")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29cfd3fa192603729140-1ca69777.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Mini-Fladenbrot")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2907796d73553a895c24-a6e544c5.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Jalapeno")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29e4d3fa192603729279-7d2f0f6f.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Avocado")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2933b886d9ac2889d472-62bb0b86.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Tomate")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2956796d73553a8960f3-f3f361db.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Aioli")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2929b886d9ac2889d3e9-2d10e4fc.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Limette, gewachst")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2984796d73553a8963d5-c9c0eb64.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Koriander")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da28fbd3fa192603728481-53836781.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Ketchup")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29b4b886d9ac2889dc39-5b84880a.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Sükartoffel")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2996b886d9ac2889da5d-8182949e.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Sükartoffel")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2996b886d9ac2889da5d-8182949e.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Gewürzmischung Hello Fiesta")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2905796d73553a895bf7-fb542bb8.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Pulled Pork")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2978b886d9ac2889d854-04c1e2fa.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Pulled Pork")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2978b886d9ac2889d854-04c1e2fa.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Tomatenmark")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29b3b886d9ac2889dc21-15c1bb51.png")
                        .build()
        );


        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("saure Sahne")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2917d3fa192603728655-69ece38b.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Früchlingszwiebel")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2958b886d9ac2889d691-f67e1a62.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("rote Chilischote")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2965796d73553a8961dd-bccbec57.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Gewürzmischung Hello Smoky Paprika")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29e3b886d9ac2889deee-317afa65.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("schwarze Bohnen")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da293f796d73553a895fbf-de4083ad.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Gemüsebrühpulver")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da298bd3fa192603728d73-5b8b29b7.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Mais")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da295b796d73553a896147-cdecdc88.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Butter")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64dba160d57fa39a31ce3231-0de9838d.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("gemischtes Hackfleisch")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29aed3fa192603728f4e-91a4166c.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("BBQ-Soße")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2979d3fa192603728c3f-d129852a.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Gewürzmischung Hello Piri-Piriimg")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2976796d73553a8962d3-eb865f07.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Buttermilch-Zitronen-Dressing")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2924d3fa19260372875c-05fb7cc0.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Salatherz (Romana)")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da294ad3fa192603728976-aeafb14a.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Zwiebel")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29d1796d73553a8967c2-e8468d43.png")
                        .build()
        );


        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Kokosmilch")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29c3796d73553a8966fd-d50dd024.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Sriracha Sauce")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da2959d3fa192603728a64-35613fdd.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("Kokosraspeln")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da297db886d9ac2889d8ac-b0313544.png")
                        .build()
        );

        ingredientRepository.save(
                IngredientEntity.builder()
                        .name("braune Linsen")
                        .link("https://img.hellofresh.com/w_96,q_auto,f_auto,c_limit,fl_lossy/hellofresh_s3/ingredient/64da29d0796d73553a8967bc-78d81222.png")
                        .build()
        );

    }



}
