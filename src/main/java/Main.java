import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String usersMenuChoice;
        User tempUser = new User();
        String title;
        String entry;
        LocalDate date = LocalDate.now();
        User activeUser = new User("Ingen");


        // todo Programmet fungerar men skriver in användare dubbelt. Slutar här för idag


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
                    else {
                        System.out.println("Användare okänd");
                    }

                    while(!activeUser.getUserName().equalsIgnoreCase("Ingen")) {
                            Menus.runSecondMenu(activeUser);
                            usersMenuChoice = sc.nextLine();
                            if (usersMenuChoice.equals("1")) {
                                System.out.println("Dina inlägg");
                            }
                            else if (usersMenuChoice.equals("2")) {
                                System.out.println("Skriv en titel:");
                                title = sc.nextLine();
                                System.out.println("Skriv inlägg här");
                                entry = sc.nextLine();
                                DiaryEntries newEntry = new DiaryEntries(activeUser, title, date, entry);
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
