import java.io.*;

public class UserWriter {
    private String fileName;

    public UserWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeUser(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(user.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
