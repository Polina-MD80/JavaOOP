package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static int bulletsPerBarrel = 50;
    private static int totalBullets = 500;

    public Rifle(String name) {
        super(name, bulletsPerBarrel, totalBullets);
    }

    @Override
    public int fire() {
        if (bulletsPerBarrel < 5) {
            reload();
        }
        bulletsPerBarrel -= 5;
        totalBullets -= 5;
        return 5;
    }

    private void reload() {
        if (totalBullets >= getCapacity()) {
            bulletsPerBarrel = getCapacity();
        } else {
            bulletsPerBarrel = totalBullets;
        }
    }
}