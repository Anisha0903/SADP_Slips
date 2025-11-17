import java.util.*;

class EnumerationIterator implements Iterator<Object> {
    Enumeration<?> enumeration;

    EnumerationIterator(Enumeration<?> enumeration) {
        this.enumeration = enumeration;
    }

    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    public Object next() {
        return enumeration.nextElement();
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<String> vector = new Vector<>();

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            vector.add(sc.nextLine());
        }

        Enumeration<String> enumeration = vector.elements();
        Iterator<Object> iterator = new EnumerationIterator(enumeration);

        System.out.println("\nIterating using Iterator (via Adapter):");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        sc.close();
    }
}
