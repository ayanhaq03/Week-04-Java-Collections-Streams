package reflection.advanced_level_problems.dependency_injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Custom annotation for dependency injection
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    public void execute() {
        System.out.println("Service executed!");
    }
}

class Client {
    @Inject
    private Service service;

    public void run() {
        service.execute();
    }
}

public class DependencyInjection {
    public static void injectDependencies(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.set(obj, dependency);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        injectDependencies(client);
        client.run();
    }
}