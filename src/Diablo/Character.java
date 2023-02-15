package Diablo;

import Diablo.WeaponBehavior;

public abstract class Character {

    protected int hp;
    protected int mp;
    // ...

    WeaponBehavior weapon; // Association (Aggregation)

    public abstract void info();

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
    public final void performWeapon(){
        weapon.useWeapon();
    }

}
