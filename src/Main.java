import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Cricketer {
    private String name;
    private int age;
    private String role;

    public Cricketer(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

class IPLTeam {
    private String teamName;
    private List<Players> squad;

    public IPLTeam(String teamName) {
        this.teamName = teamName;
        squad = new ArrayList<>();
    }

    public void addCricketer(Players players) {
        squad.add(players);
    }

    public List<Players> getSquad() {
        return squad;
    }

    public String getTeamName() {
        return teamName;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Players> players = new ArrayList<>();
        HashMap<String, IPLTeam> iplTeams = new HashMap<>();

        iplTeams.put("RCB", new IPLTeam("Royal Challengers Bangalore"));
        iplTeams.put("SRH", new IPLTeam("Sunrisers Hyderabad"));
        iplTeams.put("MI", new IPLTeam("Mumbai Indians"));


        int choice;

        while (true) {
            /*System.out.println("1. Add a cricketer");
            System.out.println("2. Assign a cricketer to an IPL team");
            System.out.println("3. Display IPL Team Squads");
            System.out.println("4. Display All list of Cricketers");
            System.out.println("5. Display List of IPL Teams");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");*/

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter cricketer name: ");
                    String cricketerName = sc.nextLine();
                    //System.out.print("Enter cricketer age: ");
                    int cricketerAge = sc.nextInt();
                    sc.nextLine();
                    //System.out.print("Enter cricketer role: ");
                    String cricketerRole = sc.nextLine();

                    Players cr = new Players(cricketerName, cricketerAge, cricketerRole);
                    players.add(cr);
                    System.out.println("Cricketer added.");
                    break;

                case 2:
                    sc.nextLine();
                    if (players.isEmpty() || iplTeams.isEmpty()) {
                        System.out.println("Please add cricketers and IPL teams first.");
                        break;
                    }

                    //System.out.print("Enter the name of the cricketer you want to assign to a team: ");
                    String nameStr = sc.nextLine();
                    Players assignCr = null;
                    for (Players i : players) {
                        if (i.getName().equalsIgnoreCase(nameStr)) {
                            assignCr = i;
                            break;
                        }
                    }
                    if (assignCr == null) {
                        System.out.println("Cricketer not found.");
                        break;
                    }

                   // System.out.print("Enter the name of the IPL team to assign the cricketer: ");
                    String teamStr = sc.nextLine();
                    IPLTeam getTeam = iplTeams.get(teamStr);
                    if (getTeam!= null) {
                        getTeam.addCricketer(assignCr);
                        System.out.println("Cricketer assigned to " + getTeam.getTeamName());
                    } else {
                        System.out.println("Invalid IPL team.");
                    }
                    break;

                case 3:
                    System.out.println("IPL Team Squads:");
                    for (IPLTeam i : iplTeams.values()) {
                        System.out.println(i.getTeamName() + " Squad:");
                        List<Players> squad = i.getSquad();
                        if (squad.isEmpty()) {
                            System.out.println("No cricketers in this squad.");
                        } else {
                            for (Players c : squad) {
                                System.out.println("Name: " + c.getName() + ", Role: " + c.getRole());
                            }
                        }
                    }
                    break;

                case 4:
                    if (players.isEmpty()) {
                        System.out.println("No cricketers available.");
                        break;
                    }
                    System.out.println("List of Cricketers:");
                    for (Players i : players) {
                        System.out.println("Name: " + i.getName() + ", Role: " + i.getRole());
                    }
                    break;

                case 5:
                    System.out.println("List of IPL Teams:");
                    for (String i : iplTeams.keySet()) {
                        System.out.println(i);
                    }
                    break;

                case 6:
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
