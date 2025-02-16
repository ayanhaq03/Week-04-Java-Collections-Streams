package junit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class DatabaseConnectionTest {

    DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnection() {
        assertNotNull(db);
    }
}