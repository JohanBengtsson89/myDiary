import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class User{
    private String userName;

    private static List<String> listOfUsers = new ArrayList<>();

    // metod för att visa listOfUsers
    public static void showListOfUsers(){
        ObjectMapper mapper = new ObjectMapper();
        //List<User> userListFromJson = List.of(Paths.get("src/main/resources/users.json").toFile(), List<User>.class);

        for (String i : listOfUsers){
            System.out.println(i);
        }
    }
    // Metod för att lägga till users till listOfUsers
    public static void addToListOfUsers(User newUser) throws IOException {
        listOfUsers.add(newUser.userName);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(Paths.get("src/main/resources/users.json").toFile(), newUser);
    }

    // Metod för att jämföra activeUser med listOfUsers
    public boolean findInListOfUsers(User activeUser){
        for(int i = 0; i < listOfUsers.size(); i++) {
            if (listOfUsers.get(i).equalsIgnoreCase(activeUser.getUserName())) {
                return true;
            }

        }
        return false;
    }



    // Konstruktor
    public User(String userName) {
        this.userName = userName;
    }

    // Getters och setters
    public static List<String> getListOfUsers() {
        return listOfUsers;
    }

    public static void setListOfUsers(List<String> listOfUsers) {
        User.listOfUsers = listOfUsers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
