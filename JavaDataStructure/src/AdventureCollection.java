
import java.util.*;

public class AdventureCollection {
    public static void main(String[] args) {

        LearningList learningList = new LearningList();
        LearningSet learningSet = new LearningSet();
//        learningList.arrayList();
        learningList.linkedList();


    }
}

class LearningList{

    public void arrayList(){
        int size;
        List<String> list = new ArrayList<String>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add(1, "J");

        size = list.size();

        System.out.println("저장된 객체의 수 : " + size);

        for(int i = 0 ; i < size ; i ++){
            System.out.println(i + "번째 : " + list.get(i) + "\n");
        }

        System.out.println("----- 변경후 -----"+"\n");

        list.remove(1);
        list.remove(1);

        size = list.size();
        String alphabet;

        for(int i = 0 ; i < size ; i ++){
            alphabet = (String)list.get(i);
            System.out.println(i + "번째 : " + alphabet + "\n");
        }
    }

    public void vector(){
        List<String> list = new Vector<>();
        list.add("A");

    }

    public void linkedList(){
//        List<Integer> list = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        queue.offer(11);
        queue.offer(22);
        queue.offer(33);
        queue.offer(44);

        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.peek());

        System.out.println();

        ListIterator<Integer> listIterator = queue.listIterator();
        if(listIterator.hasNext()){
            System.out.println(listIterator.next());
            System.out.println(listIterator.next());
            System.out.println(listIterator.previous());
            System.out.println(listIterator.previous());
        }
    }

}

class LearningSet{
    public void hashSet(){

    }

    public void treeSet(){

    }

    public void linkedHashSet(){

    }


}