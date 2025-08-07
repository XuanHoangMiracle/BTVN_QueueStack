package BTVN_LIST;

public class MyLinkedList {
    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(int element) {
        if (head == null) {
            addFirst(element);
        } else {
            Node newNode = new Node(element);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Lỗi: Ngoài phạm vi!");
        } else if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node temp = head;

            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }

            Node newNode = new Node(value);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    public Integer removeFirst() {
        if (head == null) {
            return null;
        }

        if (size == 1) {
            head = null;
            tail = null;
        }

        Node temp = head;
        head = head.next;
        size--;
        return temp.value;
    }

    public Integer removeLast() {
        if (head == null) {
            return null;
        }

        if (size == 1) {
            head = null;
            tail = null;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        int value = tail.value;
        tail = temp;
        tail.next = null;

        size--;
        return value;
    }
    public void removeIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Lỗi: Ngoài phạm vi!");
            return;
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node temp = head;

            // Duyệt đến phần tử đứng trước index cần xóa
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            // Bỏ qua node tại index
            Node delete = temp.next;       // Node cần xóa
            temp.next = delete.next;       // Gắn node trước trỏ đến node sau
            delete.next = null;            // Cắt liên kết của node bị xóa (tùy chọn)

            size--;
        }
    }

    public Integer getFirst() {
        if (head == null) {
            System.out.println("Danh sách rỗng!");
        }
        return head.value;
    }
    public Integer getLast(){
        if (head == null){
            System.out.println("Danh sách rỗng!");
        }
        return tail.value;
    }
    public Integer get(int index){
        if (head == null) {
            System.out.println("Danh sách rỗng!");
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.value;
    }
    public void set(int index, int element){
        if (head == null) {
            System.out.println("Danh sách rỗng!");
        }
        if (index < 0 || index >size){
            System.out.println("Index vượt quá danh sách");
        }
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.value = element;
        }
    }
    public Integer indexOf(int element) {
        if (head == null) {
            System.out.println("Danh sách rỗng!");
            return null;
        }

        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == element) {
                return i;
            }
            temp = temp.next;
        }

        System.out.println("Không tìm thấy: " + element);
        return null;
    }
    public Integer lastIndexOf(int element){
        Integer n = null;
        if (head == null){
            System.out.println("Danh sách rỗng!");
            return null;
        }
        Node temp = head;
        for (int i = 0;i < size;i++){
            if (temp.value == element){
                n = i;
            }
            temp = temp.next;
        }
        return n;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(temp.value).append("\t");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }
}
