package reflection.advanced_level_problems.method_execution_timing;

import java.lang.reflect.Method;

class Task {
    public void longRunningTask() {
        try {
            Thread.sleep(500); // Simulating a long-running task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MethodExecutionTiming {
    public static void measureExecutionTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();
        System.out.println(methodName + " executed in " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) throws Exception {
        Task task = new Task();
        measureExecutionTime(task, "longRunningTask");
    }
}