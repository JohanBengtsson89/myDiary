import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usersMenuChoice;
        String activeUser = "Ingen";
        String newUser;


        do {
            Menus.runFirstMenu(activeUser);
            usersMenuChoice = sc.nextLine();
                // Använder String för choice för att programmet inte ska krascha om användaren matar in en bokstav
                if (usersMenuChoice.equals("1")) {
                    User.showListOfUsers();
                    activeUser = sc.nextLine();
                    while(!usersMenuChoice.equals("3")) {
                        Menus.runSecondMenu(activeUser);
                        usersMenuChoice = sc.nextLine();
                        if (usersMenuChoice.equals("1")) {
                            System.out.println("Dina inlägg");
                        }
                        else if (usersMenuChoice.equals("2")) {
                            System.out.println("Skriv inlägg här");
                        }
                        else if (usersMenuChoice.equals("3")) {
                            System.out.println("Välkommen tillbaka " + activeUser);
                            usersMenuChoice = "0";
                            Menus.runFirstMenu(activeUser);
                            usersMenuChoice = sc.nextLine();
                            activeUser = "Ingen";
                        }
                        else {
                            System.out.println("Felaktig inmatning. Försök igen");
                        }
                    }


                }
                else if (usersMenuChoice.equals("2")) {
                    System.out.println("Skriv in namn på ny användare:");
                    newUser = sc.nextLine();
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
