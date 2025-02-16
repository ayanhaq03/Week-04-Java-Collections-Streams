package junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ListManagerTest {
    ListManager manager = new ListManager();
    @Test
    void addElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        assertEquals(1, list.size());
    }

    @Test
    void removeElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        manager.removeElement(list, 5);
        assertEquals(0, list.size());
    }

    @Test
    void getSize() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        assertEquals(2, manager.getSize(list));
    }
}