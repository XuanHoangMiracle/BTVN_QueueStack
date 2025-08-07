package Stack_Queue;

/// Hãy tự tạo MyLinkedList với kiểu generic
public class MyLinkedList<E> {
        private class Node<E> {
            private E value;
            private Node next;

            public Node(E value) {
                this.value = value;
            }
        }

        private Node<E> head;
        private Node<E> tail;
        private int size;

        public void addFirst(E element) {
            Node<E> newNode = new Node(element);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        public void addLast(E element) {
            if (head == null) {
                addFirst(element);
            } else {
                Node<E> newNode = new Node(element);
                tail.next = newNode;
                tail = newNode;
                size++;
            }
        }

        public void add(int index, E value) {
            if (index < 0 || index > size) {
                System.out.println("Lỗi: Ngoài phạm vi!");
            } else if (index == 0) {
                addFirst(value);
            } else if (index == size) {
                addLast(value);
            } else {
                Node<E> temp = head;

                for (int i = 1; i < index; i++) {
                    temp = temp.next;
                }

                Node<E> newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
            }
        }

        public E removeFirst() {
            if (head == null) {
                return null;
            }

            if (size == 1) {
                head = null;
                tail = null;
            }

            Node<E> temp = head;
            head = head.next;
            size--;
            return temp.value;
        }

        public E removeLast() {
            if (head == null) {
                return null;
            }

            if (size == 1) {
                head = null;
                tail = null;
            }

            Node<E> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }

            E value = tail.value;
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
                Node<E> temp = head;

                // Duyệt đến phần tử đứng trước index cần xóa
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }

                // Bỏ qua node tại index
                Node<E> delete = temp.next;       // Node cần xóa
                temp.next = delete.next;       // Gắn node trước trỏ đến node sau
                delete.next = null;            // Cắt liên kết của node bị xóa (tùy chọn)

                size--;
            }
        }

        public E getFirst() {
            if (head == null) {
                System.out.println("Danh sách rỗng!");
            }
            return head.value;
        }
        public E getLast(){
            if (head == null){
                System.out.println("Danh sách rỗng!");
            }
            return tail.value;
        }
        public E get(int index){
            if (head == null) {
                System.out.println("Danh sách rỗng!");
                return null;
            }
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            return temp.value;
        }
        public void set(int index, E element){
            if (head == null) {
                System.out.println("Danh sách rỗng!");
            }
            if (index < 0 || index >size){
                System.out.println("Index vượt quá danh sách");
            }
            else {
                Node<E> temp = head;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
                temp.value = element;
            }
        }
    public Integer indexOf(E element) {
        if (head == null) {
            System.out.println("Danh sách rỗng!");
            return null;
        }

        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value.equals(element)) {
                return i; // Trả về chỉ số tìm thấy
            }
            temp = temp.next;
        }

        System.out.println("Không tìm thấy: " + element);
        return null;
    }

    public Integer lastIndexOf(E element){
            Integer n = null;
            if (head == null){
                System.out.println("Danh sách rỗng!");
                return null;
            }
            Node<E> temp = head;
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
            Node<E> temp = head;
            for (int i = 0; i < size; i++) {
                stringBuilder.append(temp.value).append("\t");
                temp = temp.next;
            }
            return stringBuilder.toString();
        }
    }
