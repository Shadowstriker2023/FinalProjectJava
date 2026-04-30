import java.time.*;


public class User {
        String uname;
        String passwd;
        LocalDate lastPlayed;
        int streak;

        public User() {
            uname = "";
            passwd = "";
            streak = 1;
            lastPlayed = null;
        }

        public User(String user,  String password) {
            uname = user;
            passwd = password;
            streak = 1;
            lastPlayed = LocalDate.now();
        }

        public User(String user,  String password, int streak, LocalDate lastplayed) {
            uname = user;
            passwd = password;
            this.streak = streak;
            this.lastPlayed = lastplayed;
        }

    public String getUname() {
        return uname;
    }

    public String getPasswd() {
        return passwd;
    }

    public LocalDate getLastPlayed() {
        return lastPlayed;
    }

    public int getstreak() {
        return streak;
    }

    public void incrementStreak() {
        streak++;
    }

    public void setLastPlayed(LocalDate lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public void reSetStreak() {
        streak = 1;
    }

    public String toFileString() {

        return uname + "," + passwd + "," + streak+","+lastPlayed.toString();
    }


    
    public static void main(String[] args) {
        // Get today's date
        LocalDate today = LocalDate.now();

        // Subtract one day
        LocalDate yesterday = today.minusDays(1);

        System.out.println("Yesterday's date: " + yesterday);
    }
}
