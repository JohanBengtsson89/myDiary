import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String usersMenuChoice;
        User tempUser = new User();
        String title;
        String entry;
        LocalDate date = LocalDate.now();
        User activeUser = new User("Ingen");
        File file = new File("src/main/resources/users.json");
        file.createNewFile();
        File entryFile = new File("src/main/resources/entries.json");
        entryFile.createNewFile();
        /*List.of(mapper.readValue(Paths.get("src/main/resources/users.json").toFile(), User[].class));
        List.of(mapper.readValue(Paths.get("src/main/resources/entries.json").toFile(),
                DiaryEntries[].class));*/

        // todo måste köra json-metoderna en gång för att listorna ska skapas i konsolen 2022-10-19


        do {
            Menus.runFirstMenu(activeUser);
            usersMenuChoice = sc.nextLine();
                // Använder String för choice för att programmet inte ska krascha om användaren matar in en bokstav
                if (usersMenuChoice.equals("1")) {
                    User.showListOfUsers();
                    System.out.println("Vilken användare vill du fortsätta med?");
                    tempUser.setUserName(sc.nextLine());

                    if (User.findInListOfUsers(tempUser)) {
                        activeUser.setUserName(tempUser.getUserName());
                    }
                    else if (!User.findInListOfUsers(tempUser)){
                        System.out.println("Användare okänd");
                    }

                    while(!activeUser.getUserName().equalsIgnoreCase("Ingen")) {
                            Menus.runSecondMenu(activeUser);
                            usersMenuChoice = sc.nextLine();
                            if (usersMenuChoice.equals("1")) {
                                System.out.println("Dina inlägg");
                                System.out.println("-------------------");
                                DiaryEntries.listUsersEntries(activeUser);
                                System.out.println("Vilket inlägg vill du läsa?");
                                DiaryEntries.selectEntry(sc2.nextInt());


                            }
                            else if (usersMenuChoice.equals("2")) {
                                System.out.println("Skriv en titel:");
                                title = sc.nextLine();
                                System.out.println("Skriv inlägg här");
                                entry = sc.nextLine();
                                DiaryEntries newEntry = new DiaryEntries(activeUser, title, date.toString(), entry);
                                DiaryEntries.addEntry(newEntry);
                            }
                            else if (usersMenuChoice.equals("3")) {
                                System.out.println("Ses nästa gång " + activeUser.getUserName());
                                usersMenuChoice = "0";
                                activeUser.setUserName("ingen");
                            }
                            else {
                                // Fångar felinmatning
                                System.out.println("Felaktig inmatning. Försök igen");
                            }
                        }
                }

                else if (usersMenuChoice.equals("2")) {
                    System.out.println("Skriv in namn på ny användare:");
                    User newUser = new User(sc.nextLine());
                    User.addToListOfUsers(newUser);

                }
                else if (usersMenuChoice.equals("3")) {
                    System.out.println("Hej då!");
                }
                else {
                    System.out.println("Felaktig inmatning. Försök igen");
                }
        } while(usersMenuChoice.equals("0") || !usersMenuChoice.equals("3"));


    }


}
