public class genericClass {
    public static void main(String[] args) {
        //postBox<String> postBox = new postBox<String>();
        postBox<String> postBox1 = new postBox<>();
        //postBox<int> postBox2 = new postBox<>();
        postBox<Integer> postBox2 = new postBox<>();
        postBox1.setItem("소포");
        postBox2.setItem(77);
        System.out.println(postBox1.getItem());
        System.out.println(postBox2.getItem());

    }

}
