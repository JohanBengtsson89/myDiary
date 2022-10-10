import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String usersMenuChoice;
        User activeUser = new User("Ingen");



        do {
            Menus.runFirstMenu(activeUser);
            usersMenuChoice = sc.nextLine();
                // Använder String för choice för att programmet inte ska krascha om användaren matar in en bokstav
                if (usersMenuChoice.equals("1")) {
                    User.showListOfUsers();
                    activeUser.setUserName(sc.nextLine());


                    if (activeUser.findInListOfUsers(activeUser)) {
                        Menus.runSecondMenu(activeUser);
                    }  else {
                        System.out.println("Användare okänd");
                    }
                        while(!usersMenuChoice.equals("3")) {
                            //Menus.runSecondMenu(activeUser);
                            usersMenuChoice = sc.nextLine();
                            if (usersMenuChoice.equals("1")) {
                                System.out.println("Dina inlägg");
                            }
                            else if (usersMenuChoice.equals("2")) {
                                System.out.println("Skriv inlägg här");
                            }
                            else if (usersMenuChoice.equals("3")) {
                                System.out.println("Ses nästa gång " + activeUser.getUserName());
                                // Startar om firstMenu
                                //Menus.runFirstMenu(activeUser);
                                //usersMenuChoice = sc.nextLine();
                                //activeUser.setUserName("Ingen");
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
        } while(!usersMenuChoice.equals("3"));


    }

}
