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
        int count = 0;
        Node temp2;

        Node node = new Node(data);
        if (head == null && index == 0) {
            head = node;
            count++;
        } else if (head.next == null && head.data == index) {
            head.next = node;
            count++;
        }

        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            // System.out.println("node shifted onece"); these statemens were for testing of
            // particular lines of code
            count++;
            // System.out.println("After count++"); these statemens were for testing of
            // particular lines of code
            if ((count + 1) == index) {
                System.out.println("Inside countif");
                temp2 = temp.next;
                temp.next = node;
                node.next = temp2;
                System.out.println(node.data + "inserted at " + index);
                break;

            } else if (index != count + 1) {
                System.out.println("index not foundd");
                return;
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

        else {
            head = head.next;
            System.out.println("Deleted");
        }

    }

    // this method is under implentation
    void delmid(int index) {
        int count = 0;
        Node temp = head;
        if (head == null) {
            System.out.println("List Empty");
            return;
        } else if (head.next == null) {
            head = null;
        } else if (index < 0) {
            System.out.println("Invalid index");
        }

        else {
            while ((count + 1) != index) {
                temp = temp.next;
                count++;
            }
            if (count + 1 == index) {
                temp.next = temp.next.next;
                System.out.println("value deleted");
            }
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

    void search(int data) {
        Node temp = head;
        if (head == null) {
            System.out.println("List Empty");
        } else if (temp.data == data) {
            System.out.println("Matched at first node");
        } else {
            while (temp.data != data && temp.next != null) {
                temp = temp.next;
                if (temp.data == data) {
                    System.out.println(data + "  is Matched");
                } else {
                    System.out.println("value not found");
                    break;
                }
            }

        }
    }

    void mcircular() {
        Node temp = head;
        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        else if (head.next == null) {
            temp.next = head;
            System.out.println("List is now circular with sinngle node");
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = head;
            System.out.println("List is now circular with more than one node");
        }
    }

    void dCircular() {
        Node temp = head;
        if (head == null) {
            System.out.println("List Empty");
            return;

        } else if (temp.next == head) {
            System.out.println("Circular having one node");
        } else {

            while (temp.next != null && temp.next != head) {
                temp = temp.next;
            }

            if (temp.next == head)
                System.out.println("List is Circular");

            else {
                System.out.println("Not Circular");
            }

        }

    }

    void show() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }
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
            System.out.println("9. Make Circular");
            System.out.println("10. Detect Circular");
            System.out.println("11. Search Data");
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
                case 9:
                    s.mcircular();
                    break;
                case 10:
                    s.dCircular();
                    break;
                case 11:
                    System.out.print("Enter value to Search: ");
                    int search = scanner.nextInt();
                    s.search(search);
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
