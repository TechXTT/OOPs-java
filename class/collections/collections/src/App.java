import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import javax.lang.model.element.Element;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add(1, "Java");

        for (String s : list) {
            System.out.println(s);
        }

        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        LinkedList<String> list2 = new LinkedList<String>();
        list2.add("Hello");
        list2.add("World");
        list2.add("!");
        list2.add(1, "Java");

        for (String s : list2) {
            System.out.println(s);
        }

        list2.sort(null);

        Iterator<String> it2 = list2.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        Vector<String> list3 = new Vector<String>(); // thread safe
        list3.add("Hello");
        list3.add("World");
        list3.add("!");
        list3.add(1, "Java");

        for (String s : list3) {
            System.out.println(s);
        }

        Iterator<String> it3 = list3.iterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }

        Stack<String> stack = new Stack<String>();
        stack.push("Hello");
        stack.push("World");
        stack.push("!");
        stack.push("Java");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Queue<String> queue = new LinkedList<String>();
        queue.add("Hello");
        queue.add("World");
        queue.add("!");
        queue.add("Java");

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        var list = new List<String>();  
        Comparator<Element> comparator = new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return Element.compare(o1, o2);
            }
        };
        };
    }
}
