
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo01 {
    public static void main(String[] args) {

        Stream<String> s1;
        List<String> names = List.of("홍길동", "배장화", "임꺽정", "연흥부", "김선달", "황진이");
        s1 = names.stream();
        s1.filter(n->n.charAt(0) < '이').forEach(n-> System.out.print(n + " "));

        

    }
}


