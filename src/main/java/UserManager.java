
import java.io.IOException;

public class UserManager {
    private ICollection collection;
    private final String DEFAULT_ROLE = "default";

    public UserManager(ICollection collection){
        this.collection = collection;
    }

    public User getUserByIndex(final long id) throws UserManagerException {
        try {
            return collection.get(id);
        } catch (IOException e) {
            throw new UserManagerException("Cant get user by index", e);
        }
    }

    public void createDefault(final String name) throws UserManagerException {
        try {
            collection.add(new User(name, DEFAULT_ROLE));
        } catch (IOException e) {
            throw new UserManagerException("Cant add user to collection", e);
        }
    }
}
