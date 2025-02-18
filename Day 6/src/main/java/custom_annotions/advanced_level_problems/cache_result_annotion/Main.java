package custom_annotions.advanced_level_problems.cache_result_annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Define the @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {
    // No need for any attributes, the annotation will simply mark methods to cache results
}

// Cache class to store and retrieve cached results
class Cache {
    private static final Map<String, Object> cacheMap = new HashMap<>();

    public static Object get(String key) {
        return cacheMap.get(key);
    }

    public static void put(String key, Object value) {
        cacheMap.put(key, value);
    }

    public static boolean contains(String key) {
        return cacheMap.containsKey(key);
    }
}

// Service class with computationally expensive methods
class ExpensiveService {

    @CacheResult  // Marking the method to be cached
    public int computeExpensiveOperation(int input) {
        // Simulating a time-consuming computation (e.g., Fibonacci or heavy computation)
        try {
            Thread.sleep(2000);  // Simulating computation delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input * input;  // Simple computation for demonstration
    }
}

// Custom CacheManager class to handle caching logic
class CacheManager {

    public static Object executeWithCache(Object target, Method method, Object[] args) {
        // Check if method is annotated with @CacheResult
        if (method.isAnnotationPresent(CacheResult.class)) {
            // Create a cache key based on method name and parameters
            String cacheKey = generateCacheKey(method, args);

            // Check if result is already cached
            if (Cache.contains(cacheKey)) {
                System.out.println("Returning cached result for key: " + cacheKey);
                return Cache.get(cacheKey);  // Return cached result
            } else {
                try {
                    // If not cached, invoke the method and cache the result
                    Object result = method.invoke(target, args);
                    Cache.put(cacheKey, result);  // Cache the result
                    System.out.println("Computing and caching result for key: " + cacheKey);
                    return result;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        // If method is not annotated, just invoke it normally
        try {
            return method.invoke(target, args);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Generate a cache key based on method name and parameters
    private static String generateCacheKey(Method method, Object[] args) {
        StringBuilder keyBuilder = new StringBuilder(method.getName());
        if (args != null) {
            for (Object arg : args) {
                keyBuilder.append("-").append(arg);
            }
        }
        return keyBuilder.toString();
    }
}

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        ExpensiveService service = new ExpensiveService();

        // Simulate method calls with the same input
        System.out.println("First call (should compute):");
        System.out.println("Result: " + CacheManager.executeWithCache(service, ExpensiveService.class.getMethod("computeExpensiveOperation", int.class), new Object[]{5}));

        System.out.println("\nSecond call with same input (should return cached result):");
        System.out.println("Result: " + CacheManager.executeWithCache(service, ExpensiveService.class.getMethod("computeExpensiveOperation", int.class), new Object[]{5}));

        System.out.println("\nCall with a different input (should compute again):");
        System.out.println("Result: " + CacheManager.executeWithCache(service, ExpensiveService.class.getMethod("computeExpensiveOperation", int.class), new Object[]{10}));
    }
}