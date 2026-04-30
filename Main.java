import java.io.*;
import java.time.*;
import java.util.*;

public class Main {
    static ArrayList<User> users = new ArrayList<>();

    static void loadAccountsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("accounts.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    String username = data[0];
                    String password = data[1];
                    int streak = Integer.parseInt(data[2]);
                    LocalDate lastPlayed = LocalDate.parse(data[3]);
                    users.add(new User(username, password, streak, lastPlayed));
                }
            } catch (IOException e) {
                System.out.println("No existing file found. Starting fresh.");
            }
    }
    static void saveAccountsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.txt"))) {
            for (User user : users) {
                bw.write(user.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    static User findUser(String username) {
        for (User u : users) {
            if (u.getUname().strip().equals(username.strip())) {
                return u;
            }
        }
        return null;
    }
    public static User login() {
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("1. Login");
            System.out.println("2. Create a user");
            System.out.println("3. Cancel");
            int selection = scan.nextInt();
            scan.nextLine();
            if(selection == 1) {
                while(true) {
                    System.out.println("Please enter username:");
                    String username = scan.nextLine();
                    if(findUser(username) == null) {
                        System.out.println(findUser(username).toFileString());
                        System.out.println("Invalid username");
                    }
                    else {
                        System.out.println("Please enter password:");
                        String password = scan.nextLine().strip();
                        if(findUser(username).getPasswd().equals(password)) {
                            return findUser(username);
                        }
                        else {
                            System.out.println("Invalid password");
                        }
                    }
                }
            }
            else if(selection == 2) {
                System.out.println("Please enter username:\n");
                String username = scan.nextLine();
                System.out.println("Please enter password:\n");
                String password = scan.nextLine();
                User you = new User(username, password);
                users.add(you);
                return you;
            }
            else if(selection == 3) {
                return null;
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException { 
        loadAccountsFromFile();
        int selection;
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Welcome to GameHub");
            System.out.println("Please login or create a user: ");
            User me = login();
            if(me != null) {
                    me.getLastPlayed();
                    while(true) {
                    System.out.println("Please Select your game:");
                    System.out.println("1. Wordle");
                    System.out.println("2. Plinko");
                    System.out.println("3. Logout");
                    selection = scan.nextInt();
                    scan.nextLine();
                    if(selection == 1) {
                        Wordle.main(args);
                        if(me.getLastPlayed() != null && me.getLastPlayed().equals(LocalDate.now().minusDays(1))) {
                            me.incrementStreak();
                        }
                        me.setLastPlayed(LocalDate.now());
                        me.reSetStreak();
                        System.out.println("Congratulations! Your streak is "+me.getstreak()+" days!");
                    }
                    else if(selection == 2) {
                        Plinko.main(args);
                    }
                    else if(selection == 3) {
                        break;
                    }
                }
            }
            else if(me == null) {
                break;
            }
        }
        saveAccountsToFile();
    }
}
