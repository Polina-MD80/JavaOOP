package HotelReservation;

public
class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Season season;
    private DiscountType discountType;

    public
    PriceCalculator (double pricePerDay, int days, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discountType = discountType;
    }

   public void getPrice(){
        double result = this.pricePerDay * this.days * this.season.getMultiplier () * (1 - this.discountType.getDiscount ()/100.00);
        System.out.printf ("%.2f",result);
    }
}
