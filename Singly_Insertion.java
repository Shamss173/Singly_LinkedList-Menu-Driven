import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Singly_Insertion {
    Node head = null;

    void beg(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            node.next = temp;
            head = node;
        }
    }

    void middle_ins(int data, int index) {
        int count = 1;
        Node temp2;

        Node node = new Node(data);
        if (head == null) {
            head = node;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
            if ((count + 1) == index) {
                temp2 = temp.next;
                temp.next = node;
                node.next = temp2;
                System.out.println(node.data + "inserted at " + index);

            }
        }
    }

    void end(int data) {
        Node temp = head;
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    void delbeg() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        } else if (head.next == null) {
            head = null;
            System.out.println("Deleted Successfully");
        }

        else if (head.next != null) {
            head = head.next;
            System.out.println("Deleted");
        } else {
            head = null;
        }
    }

    void delmid(int index) {
        int count = 1;
        Node temp = head;
        if (head == null) {
            System.out.println("List Empty");
            return;
        } else if ((count + 1) != index) {
            System.out.println("index not found");
            return;
        } else {
            temp.next = temp.next.next;
        }
    }

    void delend() {
        Node temp = head;
        if (head == null) {
            System.out.println("List Empty");
            return;
        } else if (temp.next == null) {
            head = null;
            System.out.println("List has been made empty");
        }

        else
            while (temp.next.next != null) {
                temp = temp.next;
            }
        temp.next = null;
        return;
    }

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Singly_Insertion s = new Singly_Insertion();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Insert at the Beginning");
            System.out.println("2. Insert at the End");
            System.out.println("3. Insert at Middle");
            System.out.println("4. Deletion at the Beginning");
            System.out.println("5. Deletion at the Middle");
            System.out.println("6. Deletion at the Ending");
            System.out.println("7. Display the List");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int value = scanner.nextInt();
                    s.beg(value);
                    break;
                case 2:
                    System.out.print("Enter the value to insert: ");
                    value = scanner.nextInt();
                    s.end(value);
                    break;
                case 3:
                    System.out.print("Enter the value to insert: ");

                    value = scanner.nextInt();
                    System.out.print("Enter Index for insertion: ");
                    int index = scanner.nextInt();
                    s.middle_ins(value, index);
                    break;
                case 4:
                    s.delbeg();
                    break;

                case 5:
                    System.out.print("Enter index for to delete: ");
                    int dex = scanner.nextInt();
                    s.delmid(dex);
                    break;
                case 6:
                    s.delend();
                    break;
                case 7:
                    s.show();
                    break;

                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }

        System.out.println("Program exited.");
        scanner.close();
    }
}