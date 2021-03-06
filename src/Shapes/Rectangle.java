package Shapes;

public
class Rectangle extends Shape {
    private Double width;
    private Double height;

    public
    Rectangle (Double width, Double height) {
        setWidth (width);
        setHeight (height);
        calculateArea ();
        calculatePerimeter ();
    }

    private
    void setWidth (Double width) {
        this.width = width;
    }

    private
    void setHeight (Double height) {
        this.height = height;
    }

    public
    Double getWidth () {
        return width;
    }

    public
    Double getHeight () {
        return height;
    }

    @Override
    protected
    void calculatePerimeter () {
      setPerimeter (this.width * 2 + this.height * 2);
    }

    @Override
    protected
    void calculateArea () {
       setArea (this.width * this.height);
    }
}
