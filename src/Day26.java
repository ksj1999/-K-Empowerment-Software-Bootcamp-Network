
public class Day26 {
    private String secret = "캡슐화된 변수";
    String s = "Day26의 인스턴스 변수";

    class MemberClass {
        String s = "Day26의 MemberClass의 인스턴스 변수";

        public void show1() {
            System.out.println("Inner Class");
            System.out.println(secret);  // Member Class 안에 secret 변수가 존재하지 않아 바깥 스코프의 secret 변수 값을 출력

            System.out.println(s); // Member Class 안에 s 변수가 존재

            System.out.println(Day26.this.s);  // Day26의 인스턴스 변수 s의 값을 출력
        }

        // static String s3 = "정적 멤버 필드";
        // static void show2() {}
    }

    public static void main(String[] args) {
        Day26 m = new Day26();
        Day26.MemberClass m1 = m.new MemberClass();

        System.out.println(m1.s);
        m1.show1();
    }
}