import java.io.*;
import java.util.*;
public class UserReader {
    private String fileName;
    public UserReader(String fileName)
    {
        this.fileName = fileName;
    }
    public List<User>readUsers()
    {
        List<User> users = new ArrayList<>();
        try
        {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName));
            String line = null;
            while (bufferedReader.readLine()!=null)
            {
                String[] details=line.split(",");
                users.add(new User(details[0],details[1],details[2], details[3], UserType.valueOf(details[3].toUpperCase())));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return users;
    }
}
