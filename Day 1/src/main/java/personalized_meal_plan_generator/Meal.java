package personalized_meal_plan_generator;

// Generic Meal class
class Meal<T extends mealPlan> {
    T meal;

    Meal(T meal) {
        this.meal = meal;
    }

    void showMealPlan() {
        meal.displayMeal();
    }
}