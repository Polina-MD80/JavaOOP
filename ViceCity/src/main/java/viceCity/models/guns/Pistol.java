package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static int bulletsPerBarrel = 10;
    private static int totalBullets = 100;

    public Pistol(String name) {
        super(name, bulletsPerBarrel, totalBullets);
    }

    @Override
    public int fire() {
        if (bulletsPerBarrel < 1) {
            reload();
        }
        bulletsPerBarrel -= 1;
        totalBullets -= 1;
        return 1;
    }

    private void reload() {
        if (totalBullets >= getCapacity()) {
            bulletsPerBarrel = getCapacity();
        }else {
            bulletsPerBarrel = totalBullets;
    }


}






}
