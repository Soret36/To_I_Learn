import java.util.*;

class MyCollection <T extends Element> implements Iterable<T> {
    List<T> items;
    
    public MyCollection() {
        this.items = new ArrayList<T>();
    }

    public void add(T item) {
        this.items.add(item);
    }

    public void remove(int count) {
        this.items.remove(count);
    }

    public Iterator<T> iterator() {
        return this.items.iterator();
    }

}   
  

abstract class Element implements Comparable<Element> {
    int number;
    String name;

    public Element(int number, String name) {
        this.number = number;
        this.name = name;
    }
    @Override
    public int compareTo(Element o) {
        return this.number - o.number;
    }

    public String toString() {
        return this.number + ", " + this.name;
    }
}   

class Student extends Element {
    public Student(int number, String name) {
        super(number, name);
    }
}   

class Utilities {
    public static void sort(MyCollection<Student> collection) {  
        
    }
}

