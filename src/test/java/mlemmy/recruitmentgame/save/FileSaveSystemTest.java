package mlemmy.recruitmentgame.save;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class FileSaveSystemTest {

    FileSaveSystem fileSaveSystem;

    @BeforeEach
    public void setUp() {
        fileSaveSystem = new FileSaveSystem("nosuchfile");
    }

    @Test
    public void testFileSaveSystem() {
        assertFalse(fileSaveSystem.saveExists());
    }

}