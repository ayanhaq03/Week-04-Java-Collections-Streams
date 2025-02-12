package personalized_meal_plan_generator;


// Utility for generating meal plans
class MealGenerator {
    static <T extends mealPlan> void generateMeal(T meal) {
        meal.displayMeal();
        System.out.println("Meal plan successfully generated.");
    }
}