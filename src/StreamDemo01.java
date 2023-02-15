import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StreamDemo01 {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "서울", "부산", "광주", "대구", "부산", "서울", "대전", "대구", "서울", "경기");
        Iterator<String> it = cities.iterator();
        while(it.hasNext()){
            String city = it.next();
            System.out.print(city + " ");
         }
    }

}
