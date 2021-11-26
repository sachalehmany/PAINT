import java.awt.*;

public class Rectangle extends Figure {

    protected int longueur;
    protected int largeur;

    public Rectangle(Point p) {
        super(p);}

    public Rectangle(Point p, Color col) {
        super(p, col);}

    public Rectangle(int px, int py) {

        super(new Point());
        this.largeur = px;
        this.longueur = py;}

    public Rectangle(int px, int py, Color c) {
        super(new Point(px, py), c);
        this.longueur = px;
        this.largeur = py;}


    public int getLongueur() {return longueur;}

    public void setLongueur(int longueur) {this.longueur = longueur;}

    public int getLargeur() {return largeur;}

    public void setLargeur(int largeur) {this.largeur = largeur;}

    @Override
    public int getPerimeter() {return (this.longueur + this.largeur) * 2;}

    @Override
    public int getSurface() {return this.longueur * this.largeur;}

    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.largeur = largeurBB;
        this.longueur = hauteurBB;}

    @Override
    public String toString() {
        return "Rectangle{" +
                "longueur=" + longueur +
                ", largeur=" + largeur +
                '}';}

    @Override
    public void draw(Graphics g) {
        int realPx, realPy;
        if (longueur < 0) {
            realPx = origin.getX() + longueur;
        } else {
            realPx = origin.getX();
        }
        if (largeur < 0) {
            realPy = origin.getY() + largeur;
        } else {
            realPy = origin.getY();
        }
        g.setColor(c);
        g.fillRect(realPx, realPy, Math.abs(longueur), Math.abs(largeur));}}
