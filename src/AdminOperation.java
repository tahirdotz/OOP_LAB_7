public interface AdminOperation extends UserOperation {
    void modifyUser(User user);
    void deleteUser(String userID);
}
