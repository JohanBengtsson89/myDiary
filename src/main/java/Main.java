import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //ObjectMapper mapper = new ObjectMapper();
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        String usersMenuChoice;
        int entryToRead;
        User tempUser = new User();
        String title;
        String entry;
        LocalDate date = LocalDate.now();
        User activeUser = new User("Ingen");

        do {
            Menus.runFirstMenu(activeUser);
            usersMenuChoice = scString.nextLine();
                /** Använder String för choice för att programmet inte ska krascha om användaren matar in en bokstav */
                if (usersMenuChoice.equals("1")) {
                    User.showListOfUsers();
                    System.out.println("Vilken användare vill du fortsätta med?");
                    tempUser.setUserName(scString.nextLine());

                    if (User.findInListOfUsers(tempUser)) {
                        activeUser.setUserName(tempUser.getUserName());
                    }
                    else if (!User.findInListOfUsers(tempUser)){
                        System.out.println("Användare okänd");
                    }

                    while(!activeUser.getUserName().equalsIgnoreCase("Ingen")) {
                            Menus.runSecondMenu(activeUser);
                            usersMenuChoice = scString.nextLine();

                            if (usersMenuChoice.equals("1")) {
                                System.out.println("Dina inlägg");
                                System.out.println("-------------------");
                                DiaryEntries.listUsersEntries(activeUser);
                                System.out.println("Vilket inlägg vill du läsa?");

                                try {
                                    entryToRead = scInt.nextInt();
                                    DiaryEntries.selectEntry(entryToRead);

                                } catch (InputMismatchException e){
                                    System.out.println("Skriv siffran för inlägget du vill läsa");
                                    scInt.nextLine();
                                }

                            }
                            else if (usersMenuChoice.equals("2")) {
                                System.out.println("Skriv en titel:");
                                title = scString.nextLine();

                                System.out.println("Skriv inlägg här");
                                entry = scString.nextLine();

                                DiaryEntries newEntry = new DiaryEntries(activeUser, title, date.toString(), entry);
                                DiaryEntries.addEntry(newEntry);
                            }
                            else if (usersMenuChoice.equals("3")) {
                                System.out.println("Ses nästa gång " + activeUser.getUserName());
                                usersMenuChoice = "0";
                                activeUser.setUserName("ingen");
                            }
                            else {
                                /** Fångar felinmatning */
                                System.out.println("Felaktig inmatning. Försök igen");
                            }
                        }
                }

                else if (usersMenuChoice.equals("2")) {
                    System.out.println("Skriv in namn på ny användare:");
                    User newUser = new User(scString.nextLine());
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
