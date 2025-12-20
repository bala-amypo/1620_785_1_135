import java.util.List;

public interface UserService {

    User registerUser(User user);   // check duplicate email

    User getUserById(Long id);       // throw "User not found"

    List<User> getAllUsers();
}