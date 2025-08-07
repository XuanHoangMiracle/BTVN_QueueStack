package BTVN_LIST;

import javax.swing.plaf.IconUIResource;

public class MyArrayList {
    private int capacity;
    private int[] arr;
    private final int[] emptyArray = {};
    private int size;

    public int size() {
        return size;
    }

    public MyArrayList() {
        arr = emptyArray;
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }
    public void addLast(int element) {
        if (arr == emptyArray) {
            this.capacity = 10;
            this.arr = new int[this.capacity];
        }

        if (size == capacity) {
            this.capacity *= 1.5;
            if (size == capacity) {
                capacity++;
            }

            int[] brr = new int[this.capacity];

            for (int i = 0; i < size; i++) {
                brr[i] = arr[i];
            }

            arr = brr;
        }

        arr[size] = element;
        size++;
    }
    public void add(int index, int element){
        if(arr == emptyArray){
            this.capacity = 10;
            this.arr = new int[this.capacity];
        }
        if (size == capacity){
            this.capacity *= 1.5;
            if (size == capacity){
                capacity++;
            }
            int[] brr = new int[this.capacity];
            for (int i = 0; i < size; i++) {
                brr[i] = arr[i];
            }

            arr = brr;
        }
        for (int i = size;i >=index;i--){
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
    }
    public void set(int index,int element){
        if (arr == emptyArray){
            System.out.println("Danh sách rỗng phần tử được set vào vị trí đầu tiên");
            this.capacity = 10;
            this.arr = new int[this.capacity];
            size++;
            arr[0] = element;
            return;
        }
        boolean test = false;
        for (int i = 0;i<size;i++){
            if (i == index){
                test = true;
            }
        }
        if (test == false){
            System.out.println("Không có phần tử thứ " + index + " bạn vừa nhập vào");
            return;
        }
        arr[index] = element;
    }
    public Integer get(int index){
        if (arr == emptyArray){
            System.out.println("Danh sách rỗng!");
            return null;
        }
        if (index < 0 || index >= size){
            System.out.println("Không có phần tử thứ " +index+" trong danh sách");
        }
        else {
            return arr[index];
        }
        return 0;
    }
    public Integer indexOf(int element){
        if (arr == emptyArray){
            System.out.println("Danh sách rỗng!");
            return null;
        }
        else {
            for (int i = 0; i < size; i++){
                if(arr[i] == element){
                    return i;
                }
            }
        }
        System.out.println("Không tìm thấy " +element+" trong danh sách");
        return -1;
    }
    public Integer lastIndexOf(int element){
        int test = -1;
        if (arr == emptyArray){
            System.out.println("Danh sách rỗng!");
            return null;
        }
        else {
            for (int i = 0; i < size; i++){
                if(arr[i] == element){
                    test = i;
                }
            }
            if (test == -1){
                System.out.println("Không tìm thấy " +element+" trong danh sách");
            }
        }
        return test;
    }
    public void remove(int index){
        if (arr == emptyArray){
            System.out.println("Danh sách rỗng!");
        }
        else if (index >= size){
            System.out.println("Không tồn tại phần tử thứ "+index);
        }
        else{
        for (int i = index;i < size;i++){
            arr[i] = arr[i+1];
        }
        size--;
        }
    }
    public void removeElement(int element){
        if (arr == emptyArray){
            System.out.println("Danh sách rỗng!");
        }
        for (int i = 0;i < size;i++){
            if (arr[i] == element){
                remove(i);
            }
        }
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size;i++){
            stringBuilder.append(arr[i]).append("\t");
        }
        return stringBuilder.toString();
    }
}
