import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Players {
    private String name;
    private int age;
    private String role;

    public Players(String name, int age, String role) {
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

class UsingHashmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Players> players = new ArrayList<>();
        Map<String, List<Players>> iplTeams = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        iplTeams.put("Sunrisers Hyderabad", new ArrayList<>());
        iplTeams.put("Royal Challengers Bangalore", new ArrayList<>());
        iplTeams.put("Mumbai Indians", new ArrayList<>());

        int choice;

        while (true) {
            /*System.out.println("1. Add a cricketer");
            System.out.println("2. Assign a cricketer to a team");
            System.out.println("3. Display Team Squads");
            System.out.println("4. Display All list of Cricketers");
            System.out.println("5. Display List of Teams");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");*/

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    //System.out.print("Enter cricketer name: ");
                    String cricketerName = scanner.nextLine();
                   // System.out.print("Enter cricketer age: ");
                    int cricketerAge = scanner.nextInt();
                    scanner.nextLine();
                    //System.out.print("Enter cricketer role: ");
                    String cricketerRole = scanner.nextLine();

                    Players cr = new Players(cricketerName, cricketerAge, cricketerRole);
                    players.add(cr);
                    System.out.println("Cricketer added.");
                    break;

                case 2:
                    scanner.nextLine();
                    //System.out.print("Enter the name of the cricketer you want to assign to a team: ");
                    String cricketerToAssign = scanner.nextLine();
                    Players assignCr = null;

                    // Check if the cricketer is already assigned to a team
                    boolean alreadyAssigned = false;
                    for (List<Players> squad : iplTeams.values()) {
                        for (Players c : squad) {
                            if (c.getName().equalsIgnoreCase(cricketerToAssign)) {
                                alreadyAssigned = true;
                                break;
                            }
                        }
                        if (alreadyAssigned) {
                            break;
                        }
                    }
                    if (alreadyAssigned) {
                        System.out.println("Cricketer is already assigned to a team. Cannot assign to another team.");
                        break;
                    }
                    for (Players i : players) {
                        if (i.getName().equalsIgnoreCase(cricketerToAssign)) {
                            assignCr = i;
                            break;
                        }
                    }
                    if (assignCr == null) {
                        System.out.println("Cricketer not found.");
                        break;
                    }
                    //System.out.print("Enter the name of the team to assign the cricketer: ");
                    String teamStr = scanner.nextLine();

                    if (!iplTeams.containsKey(teamStr)) {
                        System.out.println("Invalid IPL Team.");
                        break;
                    }
                    iplTeams.get(teamStr).add(assignCr);
                    System.out.println("Cricketer assigned to " + teamStr);
                    break;

                case 3:
                    System.out.println("Team Squads:");
                    for (Map.Entry<String, List<Players>> entry : iplTeams.entrySet()) {
                        System.out.println(entry.getKey() + " Squad:");
                        List<Players> squad = entry.getValue();
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
                    System.out.println("List of Teams:");
                    for (String i : iplTeams.keySet()) {
                        System.out.println(i);
                    }
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
