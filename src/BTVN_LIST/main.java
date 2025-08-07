package BTVN_LIST;

public class main {
    public static void main(String[] args){
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.addLast(40);
        myArrayList.addLast(20);
        myArrayList.addLast(10);
        System.out.println(myArrayList);
        Integer a = myArrayList.get(0);
        System.out.println(a);
//        myArrayList.addLast(40);
//        myArrayList.addLast(70);
////        myArrayList.addLast(60);
////        System.out.println(myArrayList);
////        myArrayList.add(2,50);
//        System.out.println(myArrayList);
//        myArrayList.set(7,100);
//        System.out.println(myArrayList);
//        int n = myArrayList.lastIndexOf(10);
//        myArrayList.removeElement(3);
//        myArrayList.removeElement(40);
//        System.out.println(myArrayList);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(50);
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(40);
        myLinkedList.addFirst(60);
        myLinkedList.addFirst(80);
        System.out.println(myLinkedList);
        int n = myLinkedList.getFirst();
        System.out.println(n);
        int m = myLinkedList.getLast();
        System.out.println(m);
        myLinkedList.set(2,40);
        myLinkedList.removeIndex(1);
        System.out.println(myLinkedList);
        Integer k = myLinkedList.lastIndexOf(40);
        System.out.println(k);
    }
}
