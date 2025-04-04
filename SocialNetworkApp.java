import java.util.*;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    void addFriend(int friendId) {
        FriendNode newNode = new FriendNode(friendId);
        newNode.next = friends;
        friends = newNode;
    }

    void removeFriend(int friendId) {
        FriendNode curr = friends, prev = null;
        while (curr != null) {
            if (curr.friendId == friendId) {
                if (prev == null) friends = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    int countFriends() {
        int count = 0;
        FriendNode temp = friends;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    List<Integer> getFriends() {
        List<Integer> list = new ArrayList<>();
        FriendNode temp = friends;
        while (temp != null) {
            list.add(temp.friendId);
            temp = temp.next;
        }
        return list;
    }
}

class SocialNetwork {
    UserNode head = null;

    void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        newNode.next = head;
        head = newNode;
    }

    UserNode findUser(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriend(int uid1, int uid2) {
        UserNode u1 = findUser(uid1);
        UserNode u2 = findUser(uid2);
        if (u1 != null && u2 != null) {
            u1.addFriend(uid2);
            u2.addFriend(uid1);
        }
    }

    void removeFriend(int uid1, int uid2) {
        UserNode u1 = findUser(uid1);
        UserNode u2 = findUser(uid2);
        if (u1 != null && u2 != null) {
            u1.removeFriend(uid2);
            u2.removeFriend(uid1);
        }
    }

    void mutualFriends(int uid1, int uid2) {
        UserNode u1 = findUser(uid1);
        UserNode u2 = findUser(uid2);
        if (u1 != null && u2 != null) {
            List<Integer> f1 = u1.getFriends();
            List<Integer> f2 = u2.getFriends();
            System.out.print("Mutual Friends: ");
            for (int id : f1) if (f2.contains(id)) System.out.print(id + " ");
            System.out.println();
        }
    }

    void displayFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) {
            System.out.print("Friends of " + user.name + ": ");
            FriendNode temp = user.friends;
            while (temp != null) {
                System.out.print(temp.friendId + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    void searchUserById(int userId) {
        UserNode user = findUser(userId);
        if (user != null) System.out.println(user.userId + " | " + user.name + " | " + user.age);
    }

    void searchUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.userId + " | " + temp.name + " | " + temp.age);
            }
            temp = temp.next;
        }
    }

    void countFriendsForEachUser() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.countFriends() + " friends.");
            temp = temp.next;
        }
    }
}

public class SocialNetworkApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork sn = new SocialNetwork();
        while (true) {
            System.out.println("\n1. Add User");
            System.out.println("2. Add Friend");
            System.out.println("3. Remove Friend");
            System.out.println("4. Mutual Friends");
            System.out.println("5. Display Friends");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Count Friends");
            System.out.println("9. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.print("User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sn.addUser(uid, name, age);
                    break;
                case 2:
                    System.out.print("User ID 1: ");
                    int a = sc.nextInt();
                    System.out.print("User ID 2: ");
                    int b = sc.nextInt();
                    sn.addFriend(a, b);
                    break;
                case 3:
                    System.out.print("User ID 1: ");
                    int c = sc.nextInt();
                    System.out.print("User ID 2: ");
                    int d = sc.nextInt();
                    sn.removeFriend(c, d);
                    break;
                case 4:
                    System.out.print("User ID 1: ");
                    int e = sc.nextInt();
                    System.out.print("User ID 2: ");
                    int f = sc.nextInt();
                    sn.mutualFriends(e, f);
                    break;
                case 5:
                    System.out.print("User ID: ");
                    sn.displayFriends(sc.nextInt());
                    break;
                case 6:
                    System.out.print("User ID: ");
                    sn.searchUserById(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Name: ");
                    sn.searchUserByName(sc.nextLine());
                    break;
                case 8:
                    sn.countFriendsForEachUser();
                    break;
                case 9:
                    return;
            }
        }
    }
}
