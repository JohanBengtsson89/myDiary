public class Menus {

        /** första menyn */
        private static String[] firstMenu = {"1. Välj användare", "2. Skapa ny användare", "3. Avsluta programmet"};

        /** andra menyn */
        private static String[] secondMenu = {"1. Läs dagbok", "2. Skriv inlägg", "3. Gå tillbaka"};

        /** metod för att lista första menyn */
        public static void runFirstMenu(User user){
            System.out.println("--------------------------");
            System.out.println("Aktiv användare: " + user.getUserName());
            for (String s : firstMenu){
                System.out.println(s);
            }
        }
        /**metod för att lista andra menyn */
        public static void runSecondMenu(User user){
            System.out.println("--------------------------");
            System.out.println("Aktiv användare: " + user.getUserName());
            for (String s : secondMenu){
                System.out.println(s);
            }
        }






}
