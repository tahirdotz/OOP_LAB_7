import java.util.List;

public class RegularUsersOperationImpl implements RegularUsersOperation {
    private UserReader userReader;
    public RegularUsersOperationImpl(UserReader userReader)
    {
        this.userReader = userReader;
    }

    @Override
    public void viewUsers() {
        List<User> users = userReader.readUsers();
        users.forEach(user -> System.out.println(user));
    }
}
