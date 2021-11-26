import java.awt.*;

public class Ellipse extends Figure {

    protected int semiAxysX;
    protected int semiAxysY;

    public Ellipse(int x, int y) {
        super(new Point());
        this.semiAxysX = x;
        this.semiAxysY = y;
    }

    public Ellipse(int px, int py, Color c) {
        super(new Point(px, py), c);
        this.semiAxysX = 0;
        this.semiAxysY = 0;
    }

    public void draw(Graphics g) {
        int realX, realY;
        if (semiAxysX < 0) {
            realX = origin.getX() + semiAxysX * 2;
        } else {
            realX = origin.getX();
        }
        if (semiAxysY < 0) {
            realY = origin.getY() + semiAxysY * 2;
        } else {
            realY = origin.getY();
        }
        g.setColor(c);
        g.fillOval(realX, realY, Math.abs(semiAxysX * 2), Math.abs(semiAxysY * 2));
    }


    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.semiAxysY = largeurBB / 2;
        this.semiAxysX = hauteurBB / 2;
    }

    public void setSemiAxysX(int x) {
        this.semiAxysX = x;
    }

    public void setSemiAxysY(int y) {
        this.semiAxysY = y;
    }

    public String toString() {
        return ("An Ellipse with semi-length on axys X : " + this.semiAxysX + " and Y : " + this.semiAxysY);
    }

    public int getPerimeter() {
        return (int) (2 * Math.PI * Math.sqrt(((this.semiAxysX * this.semiAxysX) +
                (this.semiAxysY * this.semiAxysY)) / 2));
    }

    public int getSurface() {
        return (int) (Math.PI * this.semiAxysX * this.semiAxysY);
    }

}
