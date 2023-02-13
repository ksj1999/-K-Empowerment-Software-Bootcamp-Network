
class Dp<k, v>{
    private k name;
    private v grade;

    public Dp(k name, v grade) {
        this.name = name;
        this.grade = grade;
    }

    public k getName() {
        return name;
    }

    public v getGrade() {
        return grade;
    }
}

public class genericClass2 {
    public static void main(String[] args) {
        Dp<String, String> s1 = new Dp<>("한호열", "상병");
        Dp<String, Integer> s2 = new Dp<>("한호열", 3);
        Dp<String, String> s3 = new Dp<>("임지섭", "대위");
        Dp<soldier, String> s4 = new Dp<soldier, String>(new soldier(), "일병");


        System.out.println(s1.getName() + "의 계급은" + s1.getGrade() + "입니다.");
        System.out.println(s3.getName() + "의 계급은" + s3.getGrade() + "입니다.");
        System.out.println(s2.getName() + "의 계급은" + s2.getGrade() + "입니다.");
        System.out.println(s4.getName() + "의 계급은" + s4.getGrade() + "입니다.");
    }


}
