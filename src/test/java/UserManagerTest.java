import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserManagerTest {

    UserManager um;

    @Test
    void getUserByIndex1() throws UserManagerException {
        ICollection m = mock(ICollection.class);
        try {
            when(m.get(0)).thenReturn(new User("a", "b"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        um = new UserManager(m);
        assertEquals("a", um.getUserByIndex(0).getName());
        assertEquals("b", um.getUserByIndex(0).getRole());
    }

    @Test
    void getUserByIndex2() {
        ICollection m = mock(ICollection.class);
        try {
            when(m.get(5)).thenThrow(new IOException("fuuu"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        um = new UserManager(m);
        Throwable exception = assertThrows(UserManagerException.class, () -> um.getUserByIndex(5));
        assertEquals("Cant get user by index", exception.getMessage());
    }

    @Test
    void createDefault1() throws IOException {
        ICollection m = mock(ICollection.class);
        um = new UserManager(m);
        String t = "default";
        User u = new User("ABC", t);
        doThrow(IOException.class).when(m).add(any());
        Throwable exception = assertThrows(UserManagerException.class, () -> um.createDefault("ABC"));
        assertEquals("Cant add user to collection", exception.getMessage());
    }

    @Test
    void createDefault2() throws UserManagerException {
        ICollection m = mock(ICollection.class);
        um = new UserManager(m);
        um.createDefault("ABC");

    }

}