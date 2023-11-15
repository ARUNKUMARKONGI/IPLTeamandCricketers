
import java.util.ArrayList;
import java.util.List;
import java.util.*;

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
    private List<Cricketer> squad;

    public IPLTeam(String teamName) {
        this.teamName = teamName;
        squad = new ArrayList<>();
    }

    public void addCricketer(Cricketer cricketer) {
        squad.add(cricketer);
    }

    public List<Cricketer> getSquad() {
        return squad;
    }

    public String getTeamName() {
        return teamName;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cricketer> cricketers = new ArrayList<>();
        List<IPLTeam> iplTeams = new ArrayList<>();

        IPLTeam rcb = new IPLTeam("Royal Challengers Bangalore");
        IPLTeam srh = new IPLTeam("Sunrisers Hyderabad");
        IPLTeam mi = new IPLTeam("Mumbai Indians");

        iplTeams.add(mi);
        iplTeams.add(srh);
        iplTeams.add(rcb);

        int choice;

        while(true) {
            /*System.out.println("1. Add a cricketer");
            System.out.println("2. Assign a cricketer to an IPL team");
            System.out.println("3. Display IPL Team Squads");
            System.out.println("4. Display All list of Cricketers");
            System.out.println("5.Exit");*/
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    //System.out.println("Enter cricketer name:");
                    String cricketerName = scanner.nextLine();
                    // System.out.println("Enter cricketer age:");
                    int cricketerAge = scanner.nextInt();
                    scanner.nextLine();
                    //System.out.println("Enter cricketer role:");
                    String cricketerRole = scanner.nextLine();

                    Cricketer cr = new Cricketer(cricketerName, cricketerAge, cricketerRole);
                    cricketers.add(cr);
                    System.out.println("Cricketer added.");
                    break;

                case 2:
                    scanner.nextLine();
                    if (cricketers.isEmpty() || iplTeams.isEmpty()) {
                        System.out.println("Please add cricketers and IPL teams first.");
                        break;
                    }

                    //System.out.println("Enter the name of the cricketer you want to assign to team:");
                    String str1 = scanner.nextLine();
                    Cricketer assignCr = null;
                    for (Cricketer i : cricketers) {
                        if (i.getName().equalsIgnoreCase(str1)) {
                            assignCr = i;
                            break;
                        }
                    }
                    if (assignCr == null) {
                        System.out.println("Cricketer not found.");
                        break;
                    }
                    String str2 = scanner.nextLine();
                    boolean assigned = false;
                    for (IPLTeam i : iplTeams) {
                        if (i.getTeamName().equalsIgnoreCase(str2)) {
                            i.addCricketer(assignCr);
                            System.out.println("Cricketer assigned to " + i.getTeamName());
                            assigned = true;
                            break;
                        }
                    }
                    if (!assigned) {
                        System.out.println("Invalid IPL team.");
                    }
                    break;

                case 3:
                    System.out.println("IPL Team Squads:");
                    for (IPLTeam i : iplTeams) {
                        System.out.println(i.getTeamName() + " Squad:");
                        List<Cricketer> squad = i.getSquad();
                        if (squad.isEmpty()) {
                            System.out.println("No cricketers in this squad.");
                        } else {
                            for (Cricketer c : squad) {
                                System.out.println("Name: " + c.getName() + ", Role: " + c.getRole());
                            }
                        }
                    }
                    break;

                case 4: if (cricketers.isEmpty()) {
                    System.out.println("No cricketers available.");
                    break;
                }
                    System.out.println("List of Cricketers:");
                    for (Cricketer cricketer : cricketers) {
                        System.out.println("Name: " + cricketer.getName() + ", Role: " + cricketer.getRole());
                    }
                    break;

                case 5:
                    System.out.println("List of IPL Teams:");
                    for (IPLTeam iplTeam : iplTeams) {
                        System.out.println(iplTeam.getTeamName());
                    }
                    break;

                case 6:scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}