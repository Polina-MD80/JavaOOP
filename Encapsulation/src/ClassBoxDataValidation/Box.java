package ClassBoxDataValidation;

public
class Box {
    private double length;
    private double width;
    private double height;

    public
    Box (double length, double width, double height) {
      this.setLength (length);
        this.setWidth (width);
        this.setHeight (height);
    }
    private void validateParameter(String prefix, double parameter){
        if (parameter<=0){
            throw new IllegalArgumentException (prefix + " cannot be zero or negative.");
        }
    }

    private
    void setLength (double length) {
        validateParameter ("Length", length);
        this.length = length;
    }

    private
    void setWidth (double width) {
        validateParameter ("Width", width);
        this.width = width;
    }

    public
    void setHeight (double height) {
        validateParameter ("Height", height);
        this.height = height;
    }

    public double calculateSurfaceArea (){
        return this.calculateLateralSurfaceArea () + 2 * this.length * this.width;
    }
    public double calculateLateralSurfaceArea (){
        return 2*(this.height * this.width + this.height * this.length);
    }
    public double calculateVolume (){
        return this.length * this.width * this.height;
    }

    @Override
    public
    String toString () {
        return String.format ("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume – %.2f",
                this.calculateSurfaceArea (),
                this.calculateLateralSurfaceArea (),this.calculateVolume ());
    }
}
