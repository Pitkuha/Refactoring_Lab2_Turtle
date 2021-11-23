package app.domain;

public class Line {
    private Coordinates coordinates1;
    private Coordinates coordinates2;
//    private int a = this.coordinates2.getY() - this.coordinates1.getY();
//    private int b = this.coordinates2.getX() - this.coordinates1.getX();
//    private int c = a * this.coordinates1.getX() + b * this.coordinates1.getY();
    private int a;
    private int b;
    private int c;

    public Coordinates getIntersection(Line line){
        if (det(line) != 0){
            int x = line.b * this.c - this.b * line.c / det(line);
            int y = (this.a * line.c - line.a * this.c / det(line));
            return new Coordinates(x,y);
        }
        return null;
    }

    private int det(Line line){
        return this.a * line.b - line.a * this.b;
    }

    public boolean ifPointLiesOnLine(Coordinates point){
        return Math.min(coordinates1.getX(), coordinates2.getX()) <= point.getX() &&
                point.getX() <= Math.max(coordinates1.getX(), coordinates2.getX()) &&
                Math.min(coordinates1.getY(), coordinates2.getY()) <= point.getY() &&
                point.getY() <= Math.max(coordinates1.getY(), coordinates2.getY());
    }

    public Line() {
    }

//    public Line(Coordinates coordinates1, Coordinates coordinates2) {
//        this.coordinates1 = coordinates1;
//        this.coordinates2 = coordinates2;
//    }

    public Line(Coordinates coordinates1, Coordinates coordinates2) {
        this.coordinates1 = coordinates1;
        this.coordinates2 = coordinates2;
        this.a = coordinates2.getY() - coordinates1.getY();;
        this.b = this.coordinates2.getX() - this.coordinates1.getX();;
        this.c = a * this.coordinates1.getX() + b * this.coordinates1.getY();;
    }

    public Coordinates getCoordinates1() {
        return coordinates1;
    }

    public void setCoordinates1(Coordinates coordinates1) {
        this.coordinates1 = coordinates1;
    }

    public Coordinates getCoordinates2() {
        return coordinates2;
    }

    public void setCoordinates2(Coordinates coordinates2) {
        this.coordinates2 = coordinates2;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
