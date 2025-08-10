package BTVN_Phone_Comparable_Comparator;

import java.util.Comparator;

public class SortPriceDescending implements Comparator<Phone> {
    @Override
    public int compare(Phone p1, Phone p2) {
        return Double.compare(p2.getPrice(), p1.getPrice());
    }
}
