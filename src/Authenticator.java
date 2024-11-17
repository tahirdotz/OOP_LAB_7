import java.util.*;

public class Authenticator {
    private List<User> users;
    private List<User> admins;

    public Authenticator(UserReader userReader, UserReader adminReader) {
        this.users = userReader.readUsers();
        this.admins = adminReader.readUsers();
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Authentication successful: " + user.getUsername());
                return user;
            }
        }

        for (User admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                System.out.println("Admin authenticated: " + admin.getUsername());
                return admin;
            }
        }

        System.out.println("Authentication failed for username: " + username);
        return null;
    }

    public boolean isAdmin(User user) {
        return admins.contains(user);
    }
}
