import Diablo.Axe;
import Diablo.Barbarian;
import Diablo.Bow;
import Diablo.Sorceress;

public class Day23 {
    public static void main(String[] args) {
        Barbarian b1 = new Barbarian();
        Axe berserkerAxe = new Axe();
        Sorceress s1 = new Sorceress();
        Bow windForce = new Bow();

        s1.setWeapon(windForce);
        b1.setWeapon(berserkerAxe);
        s1.performWeapon();
        b1.performWeapon();
        s1.setWeapon(new Axe());
        s1.performWeapon();
        s1.info();
        b1.setWeapon(()-> System.out.println("신오브로 아이스볼을 발사"));
        b1.performWeapon();

    }
}
