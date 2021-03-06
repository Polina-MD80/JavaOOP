package Shapes;

public
class Circle extends Shape{
    private Double radius;

    public
    Circle (Double radius) {
        setRadius (radius);
        this.calculateArea ();
        this.calculatePerimeter ();
    }

    private
    void setRadius (Double radius) {
        this.radius = radius;
    }

    public final
    Double getRadius () {
        return radius;
    }

    @Override
    protected
    void calculatePerimeter () {
        setPerimeter (2 * Math.PI * this.radius);
    }

    @Override
    protected
    void calculateArea () {
        setArea (Math.PI * this.radius * this.radius);
    }
}
