package personalized_meal_plan_generator;

public class Main {
    public static void main(String[] args) {
        vegetarianMeal vegMeal = new vegetarianMeal();
        MealGenerator.generateMeal(vegMeal);

        veganMeal veganMeal = new veganMeal();
        MealGenerator.generateMeal(veganMeal);
    }
}
