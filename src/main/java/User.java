import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;

    private static List<String> listOfUsers = new ArrayList<>();

    public static void showListOfUsers(){
        for (String i : listOfUsers){
            System.out.println(i);
        }
    }
    public static void addToListOfUsers(String newUser){
        listOfUsers.add(newUser);
    }
    public static List<String> getListOfUsers() {
        return listOfUsers;
    }

    public static void setListOfUsers(List<String> listOfUsers) {
        User.listOfUsers = listOfUsers;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
