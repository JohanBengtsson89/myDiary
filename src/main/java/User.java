import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class User{
    private String userName;

    private static List<User> listOfUsers = new ArrayList<>();
    private static List<User> temp = new ArrayList<>();

    // metod för att visa listOfUsers
    public static void showListOfUsers(){
        ObjectMapper mapper = new ObjectMapper();
        //List<User> userListFromJson = List.of(Paths.get("src/main/resources/users.json").toFile(), List<User>.class);

        for (User i : listOfUsers){
            System.out.println(i.getUserName());
        }
    }
    // Metod för att lägga till users till listOfUsers
    public static void addToListOfUsers(User newUser) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File filePath = new File("src/main/resources/users.json");

        Path paths = Paths.get("src/main/resources/users.json");
            // todo programmet skapar samma användare varje gång metoden körs
        // json-filen får inte returnera null
        temp = List.of(mapper.readValue(paths.toFile(), User[].class ));
        listOfUsers.addAll(temp);
        listOfUsers.add(newUser);

        mapper.writeValue(paths.toFile(), listOfUsers);
    }

    // Metod för att jämföra activeUser med listOfUsers
    public static boolean findInListOfUsers(User activeUser){
        for(int i = 0; i < listOfUsers.size(); i++) {

            // todo kan inte jämföra objekt i listOfUsers
            if (listOfUsers.get(i).equals(activeUser)) {
                return true;
            }

        }
        // todo sätter denna till true för att kunna testa programmet
        return true;
    }



    // Konstruktor
    public User(String userName) {
        this.userName = userName;
    }
    // en tom konsruktor
    public User() {
    }

    // Getters och setters
    public static List<User> getListOfUsers() {
        return listOfUsers;
    }

    public static void setListOfUsers(List<User> listOfUsers) {
        User.listOfUsers = listOfUsers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
