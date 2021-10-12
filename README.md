## Java Collection Framework

자바에서 데이터를 저장하는 자료구조들을 한곳에 모아 편리하게 사용하기 위해 제공하는 것이며, 크게 List, Set, Map 으로 
구분할 수 있다. 

아직까지 자료구조의 형태에 있어서 부족한 부분이 느껴지기 때문에, 좀더 정리하고 공부하는 방향으로 공부를 진행하려 한다.

각각이 사용할 수 있는 메소드와 큰 그림을 그리는 공부방향으로 진행할 예정이다.
### JCF

<img src="https://user-images.githubusercontent.com/63331153/136910636-d69e3d1d-75e0-4431-9e75-f155bca427b2.png"/>

컬렉션은 기본 데이터형이 아닌, 참조 데이터형만 저장이 가능하다. 즉, Collection 에서의 데이터는 Object 타입의 객체로서 저장이 되는 것이라 설명할 수 있다.

기본 데이터 형은 Wrapper 클래스를 이용하여 Boxing 시켜주거나, ( autoboxing 으로 저장할 수 있다. () Integer num = new Integer(5); 와 같은 코드로 구현할 수 있다. )

즉, 오토박싱을 통해 기본 데이터형을 컬렉션에 직접 대입하여 저장해도 컴파일러가 자동으로 Wrapper 클래스로 변환해준다.

### List 인터페이스

1. 데이터의 중복을 허용한다.
2. 데이터 저장 순서가 유지된다.
3. 힙 영역 내에서 List는 객체를 일렬로 늘어놓은 구조를 하고 있다. 
4. 객체를 인덱스로 관리하기 때문에 객체를 저장하면 자동으로 인덱스가 부여되고, 인덱스로 객체를 검색, 삭제할 수 있다. 이 때 List 컬렉션은 객체 자체를 저장하여
 인덱스를 부여하는것이 아닌, 해당하는 인덱스에 객체의 주소값을 참조하여 저장한다.
5. List 컬렉션에서 공통적으로 사용가능한 추가, 검색, 삭제 메소드를 가지고 있다.

#### Arraylist

Arraylist 는 List 인터페이스의 구현 클래스로, 객체는 인덱스로 관리된다. Arraylist에 객체를 추가하면 객체가 인덱스로 관리된다는 의미이다.
이 점은 일반 배열과 별 다를바 없지만, 자바에서 배열은 초기화시 그 크기가 고정되어야 하며, 사용중에 크기를 변경할 수 없다는 점에서 Arraylist 는 자주 사용된다.


#### Vector 

Vector 는 ArrayList 와 동일한 내부 구조를 가지고 있다. Vector 를 생성하기 위해서는 지정할 객체 타입을 타입 파라미터로 표기하고, 기본 생성자를 호출하면된다.

ArrayList 와는 다르게, Vector 는 동기화된 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 이 메소드를 실행 할 수 없고, 하나의 스레드가 실행을 완료해야만 다른
스레드가 실행을 할 수 있다. 따라서 멀티 스레드 환경에서 안전하게 객체를 추가, 삭제할 수 있다. 객체를 추가하고 삭제하고 가져오는 메소드는 ArrayList 와 같다.

#### LinkedList 

LinkedList 는 List 구현 클래스 이므로 ArrayList 와 사용하는 메소드는 같지만, 내부 구조는 완전히 다르다. ArrayList는 내부 배열 객체를 저장해서 인덱스로 관리하지만,
LinkedList 는 양방향 포인터 구조로, 각각마다 인접하는 참조를 링크해서 체인처럼 관리한다.

따라서, LinkedList 는 특정 인덱스의 객체를 제거하거나 삽입하면, 앞 뒤 링크만 변경되고 나머지 링크는 변경되지 않는다. 그러므로 중간 삽입/삭제가 빈번할 수록 LinkedList 를 
쓰는 것이 효율적이다. 반대로, 순차적인 삽입/삭제가 빈번하다면 ArrayList를 사용하는것이 효율적이다.

자바에서 LinkedList 클래스는 스택과 큐를 구현하는 데에 자주 쓰인다. 그 중 큐는 자바에서 일반적으로 두가지 방법으로 구현된다.
배열을 사용하여 구현하거나, LinkedList 나 ArrayList 클래스를 사용한다.

LinkedList Queue 구현

```java
        List<E> list = new LinkedList<E>();
        //가 아닌  offer(), poll(), peek() 같은 메소드를 사용하기 위해서
        LinkedList<E> list = new LinkedList<E>();
        //로 선언한다.
        ListIterator<Integer> it = queue.listIterator();
        if(it.hasNext()){
         System.out.println(it.next());
         System.out.println(it.next());
         System.out.println(it.previous());
         System.out.println(it.previous());
        }
```

Queue 는 FIFO, 선입선출 방식을 채택하는데, offer()메소드를 사용하여 Queue에 요소를 삽입하고 출력했을땐, 들어간
순서대로 출력이된다. 

기존에 많이 활용하던 Iterator는 다음 데이터만을 검색할 수 있었고, dataset의 처음부터 끝까지 순차적으로 요소들을 검색하는 기능을 제공하였다.
하지만 ListIterator는 이전에 지나간 요소도 검색할 수 있는 기능을 포함하는 인터페이스이다. 

Stack 또한 마찬가지..

### Set 인터페이스 

1. 데이터의 저장 순서를 유지하지 않는다.
2. 같은 데이터의 중복 저장을 허용하지 않는다. (null 또한 하나의 null 만 저장할 수 있다.)
3. Set 컬렉션은 List 컬렉션 처럼 인덱스로 객체를 검색해서 가져오는 메소드가 없다. 대신 전체 객체를 대상으로 한번씩 다 가져오는 반복자 Iterator 을 제공한다.

3-ex) 
```java
Set<String> setExample = new...;
Iterator<String> iterator = setExample.iterator();

        Set<String> setExample = new...;
        Iterator<String> iterator = setExample.iterator();

        while(iterator.hasNext()){
        String getin = iterator.next();
        }
        Colored by Color Scripter
```

Set 인터페이스를 구현한 주요 클래스는 3개가 있다.

1.HashSet 순서가 필요없는 데이터를 hash table 에 저장 (set 중에 가장 성능이 좋다. ( 별도의 정렬작업이 없기 때문에))
2. TreeSet 저장된 데이터의 값에 따라 정렬되며, red-black tree 타입으로 저장된다.
3. 연결된 목록 타입으로 구현된 hash table에 데이터 저장. 저장된 순서에 따라 값이 정려로디나 셋중 가장 느림


