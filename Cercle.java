import java.awt.*;

public class Cercle extends Ellipse {

    public Cercle(int r) {super(r, r);}

    public Cercle(int px, int py, Color c) {super(px, py, c);}

    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.semiAxysX = hauteurBB / 2;
        this.semiAxysY = hauteurBB / 2;}

    public void setSemiAxysX(int rayon) {
        super.setSemiAxysX(rayon);
        super.setSemiAxysY(rayon);}

    public void setSemiAxysY(int rayon) {
        super.setSemiAxysX(rayon);
        super.setSemiAxysY(rayon);}}
