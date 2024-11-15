import java.util.List;

public class PowerUsersOperationImpl implements PowerUsersOperation {
    private UserWriter userWriter;
    private UserReader userReader;
    public PowerUsersOperationImpl(UserWriter userWriter, UserReader userReader)
    {
        this.userWriter = userWriter;
        this.userReader = userReader;
    }

    @Override
    public void viewUsers() {
        List<User> users = userReader.readUsers();
        users.forEach(user -> System.out.println(user));
    }


    @Override
    public void addUsers(User user)
    {
        userWriter.writeUser(user);
    }
}
