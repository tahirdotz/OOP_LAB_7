import java.io.*;
import java.util.*;

public class CSVFileHandler {
    private String userFile;
    private String adminFile;

    public CSVFileHandler(String userFile, String adminFile) {
        this.userFile = userFile;
        this.adminFile = adminFile;
    }

    public List<User> readUsers(String fileName) {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                users.add(new User(
                        details[0], details[1], details[2], details[3],
                        UserType.valueOf(details[4].toUpperCase())
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void writeUser(User user, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(user.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> readUsersWithAccessControl(UserType userType) {
        if (userType == UserType.ADMIN) {
            return readUsers(adminFile);
        } else {
            return readUsers(userFile);
        }
    }

    public void writeUserWithAccessControl(User user) {
        if (user.getUsertype() == UserType.ADMIN) {
            writeUser(user, adminFile);
        } else {
            writeUser(user, userFile);
        }
    }
}
