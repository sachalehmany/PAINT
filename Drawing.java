import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseMotionListener, MouseListener {
    //Attributs
    private Color c;
    private ArrayList<Figure> list;
    private String figureName;
    private int x, y;

    //Constructeur
    public Drawing() {
        super();
        this.setBackground(Color.white);
        this.c = Color.black;
        this.figureName = "Rectangle";
        this.list = new ArrayList<Figure>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);}

    //Méthode
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).draw(g);}}

    //Sauvegarde
    public void saveDrawing(String fileName) {
        try {
            FileOutputStream ops = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(ops);

            oos.writeInt(list.size());
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Ouvrir
    public void recallDrawing(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            reset();
            int numOfFigure = ois.readInt();
            for (int i = 0; i < numOfFigure; i++) {
                Figure figure = (Figure) ois.readObject();
                list.add(figure);
            }
            ois.close();
            paintComponent(this.getGraphics());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Nouveau
    public void reset() {
        this.list.clear();
        paintComponent(this.getGraphics());
    }

    //getter et setter
    public void setC(Color c) {
        this.c = c;
    }

    public void setNameFigure(String figureName) {
        this.figureName = figureName;
    }

    public ArrayList<Figure> getList() {
        return list;
    }

    //Override
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();

        switch (figureName) {
            case "Rectangle":
                list.add(new Rectangle(this.x, this.y, c));
                break;
            case "Carré":
                list.add(new Carré(this.x, this.y, c));
                break;
            case "Cercle":
                list.add(new Cercle(this.x, this.y, c));
                break;
            case "Ellipse":
                list.add(new Ellipse(this.x, this.y, c));
                break;
            }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Figure terminée");
        (list.get(list.size() - 1)).setBoundingBox(e.getX() - this.x, e.getY() - this.y);
        paintComponent(this.getGraphics());
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        list.get(list.size() - 1).setBoundingBox(e.getX() - this.x, e.getY() - this.y);
        paintComponent(this.getGraphics());
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
