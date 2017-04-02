package sample_exercise.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by rakeshgupta on 9/23/16.
 */
public class AddOperation {
    public static void main(String args[]){

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(747);
        linkedList.add(new Integer(444));
        linkedList.add(33);
        linkedList.add(1,9);
        linkedList.addFirst(01);


//        Iterator<Integer> integerIterator = linkedList.iterator();
//        while (integerIterator.hasNext()){
//            int i = integerIterator.next();
//            System.out.println(i);
//        }

//
//        Iterator iterator = linkedList.listIterator();
//        while (iterator.hasNext()){
//            System.out.print("\n"+ iterator.next());
//        }


//        Iterator<Integer> integerIterator = linkedList.listIterator(0);
//        while (integerIterator.hasNext()){
//            System.out.println(integerIterator.next());
//        }


//        Collection<Integer> integerCollection = new LinkedList<>();
//        integerCollection.addAll(linkedList);
//
//    Iterator<Integer> integerIterator = integerCollection.iterator();
//    while (integerIterator.hasNext()){
//        System.out.println(integerIterator.next());
//    }

 //   linkedList.clear();

        Iterator iterator = linkedList.listIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

//    LinkedList<Integer> il = ((LinkedList<Integer>) linkedList.clone());
//    Iterator<Integer> ilI = il.listIterator();
//    while (ilI.hasNext()){
//        System.out.println(ilI.next());
//    }


//        System.out.println(linkedList.contains(33));
//        System.out.println(linkedList.element());
//
//        Integer i = linkedList.get(3);
//        System.out.println(i);

//        for (int j = 0; j < linkedList.size(); j++) {
//            System.out.println(linkedList.get(j));
//        }
//
//        System.out.println(linkedList.indexOf(33));
//        System.out.println(linkedList.lastIndexOf(33));

//        System.out.println(linkedList.offer(999));
//        System.out.println(linkedList.offerFirst(1111));
//        System.out.println(linkedList.offerLast(0000));
//        System.out.println(linkedList);

//
//        System.out.println(linkedList.peek());
//        System.out.println(linkedList.peekFirst());
//        System.out.println(linkedList.peekLast());



//        System.out.println(linkedList.poll());
//        System.out.println(linkedList.pollFirst());
//        System.out.println(linkedList.pollLast());


//        System.out.println(linkedList.poll());
//        linkedList.push(555);

//        System.out.println(linkedList.remove());
//        System.out.println(linkedList.removeFirst());
//        System.out.println(linkedList.set(linkedList.size()-1,8888));
//
//        Object[] o = linkedList.toArray();
//        for (Object obj : o){
//            System.out.println(((int) obj));
//        }
//

        System.out.println(linkedList);


    }
}
