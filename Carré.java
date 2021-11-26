import java.awt.*;

public class Carré extends Rectangle {
    public Carré(int longueur) {super(longueur, longueur);}

    public Carré(int px, int py, Color c) {super(px, py, c);}

    public void setLongueur(int longueur) {
        super.setLongueur(longueur);
        super.setLargeur(longueur);}

    public void setLargeur(int longueur) {
        super.setLongueur(longueur);
        super.setLargeur(longueur);}

    public void setBoundingBox(int hauteurBB, int largeurBB) {
        super.setLargeur(hauteurBB);
        super.setLongueur(hauteurBB);}}
