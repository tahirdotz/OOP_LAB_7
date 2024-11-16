import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AdminUserOperation implements AdminOperation {
    private UserReader userReader;
    private UserWriter userWriter;

    public AdminUserOperation(UserReader userReader, UserWriter userWriter) {
        this.userReader = userReader;
        this.userWriter = userWriter;
    }

    @Override
    public void viewUsers() {
        List<User> users = userReader.readUsers();
        users.forEach(System.out::println);
    }

    @Override
    public void modifyUser(User user)
    {
        List<User> users = userReader.readUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserID().equals(user.getUserID()))
            {
                users.set(i, user);
                break;
            }
        }
        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userWriter.getFileName()));
            for(User u : users)
            {
                bufferedWriter.write(user.toString());
                bufferedWriter.newLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        }

    @Override
    public void deleteUser(String userId)
    {
        List<User> users = userReader.readUsers();
        users.removeIf(user -> user.getUserID().equals(userId));
        try
        {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(userWriter.getFileName()));
            for (User remainingUser: users)
            {
                bufferedWriter.write(remainingUser.toString());
                bufferedWriter.newLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
