import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Windows extends JFrame implements ActionListener {
    private Drawing drawing;
    {  drawing = new Drawing();  }

    public Windows(String Title, int x, int y) {
        super(Title);
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane();

        JMenuBar m = new JMenuBar();

        JMenu menu1 = new JMenu("Fichier");
        JMenuItem open = new JMenuItem("Ouvrir");
        menu1.add(open);
        open.addActionListener(this);

        JMenuItem newFile = new JMenuItem("Nouveau");
        menu1.add(newFile);
        newFile.addActionListener(this);

        JMenuItem save = new JMenuItem("Enregistrer");
        menu1.add(save);
        save.addActionListener(this);

        JMenuItem exit = new JMenuItem("Quitter");
        menu1.add(exit);
        exit.addActionListener(this);

        m.add(menu1);

        JMenu menu2 = new JMenu("À propos");
        JMenuItem author = new JMenuItem("Auteur");
        menu2.add(author);
        author.addActionListener(this);

        m.add(menu2);

        setJMenuBar(m);

        String ColorName[] = {"Noir", "Rouge","Vert", "Bleu", "Jaune", "Rose","Magenta", "Orange"};
        Color colorRealName[] = {Color.black, Color.red, Color.green, Color.blue, Color.yellow, Color.pink, Color.magenta, Color.orange};

        JButton buttonColor[] = new JButton[8];

        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(2, 4));
        for (int i = 0; i < 8; i++) {
            buttonColor[i] = new JButton(ColorName[i]);
            (buttonColor[i]).setBackground(colorRealName[i]);
            colorPanel.add(buttonColor[i]);
            buttonColor[i].addActionListener(this);
        }
        JPanel shapePanel = new JPanel();
        shapePanel.setLayout(new GridLayout(2, 2));

        String shapeName[] = {"Ellipse", "Cercle", "Rectangle", "Carré"};
        JButton shapeButton[] = new JButton[4];

        for (int i = 0; i < 4; i++) {
            shapeButton[i] = new JButton(shapeName[i]);
            shapePanel.add(shapeButton[i]);
            shapeButton[i].addActionListener(this);
        }

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 2));

        southPanel.add(colorPanel, "South");
        southPanel.add(shapePanel, "South");

        contentPanel.add(southPanel, "South");
        contentPanel.add(drawing, "Center");


        this.setVisible(true);

    }
    public static void main(String args[]) {

        Windows win = new Windows("Let's Paint", 800, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choix = e.getActionCommand();

        switch (choix) {
            
            //Couleurs
            case "Noir":
                drawing.setC(Color.black);
                break;
            case "Rouge":
                drawing.setC(Color.red);
                break;
            case "Vert":
                drawing.setC(Color.green);
                break;
            case "Bleu":
                drawing.setC(Color.blue);
                break;
            case "Jaune":
                drawing.setC(Color.yellow);
                break;
            case "Rose":
                drawing.setC(Color.pink);
                break;
            case "Orange":
                drawing.setC(Color.orange);
                break;
            case "Magenta":
                drawing.setC(Color.magenta);
                break;
           
                //Figures
            case "Ellipse":
                drawing.setNameFigure("Ellipse");
                break;
            case "Cercle":
                drawing.setNameFigure("Cercle");
                break;
            case "Rectangle":
                drawing.setNameFigure("Rectangle");
                break;
            case "Carré":
                drawing.setNameFigure("Carré");
                break;
           
                //Commandes
            case "Quitter":
                System.exit(0);
                break;
            case "Nouveau":
                drawing.reset();
                break;
            case "Auteur":
                JOptionPane info = new JOptionPane();
                JOptionPane.showInternalMessageDialog(info, "Auteur : Sacha Lehmany", "Informations", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Enregistrer":
                JFileChooser jfs = new JFileChooser();
                int x = jfs.showOpenDialog(this);
                if (x == JFileChooser.CANCEL_OPTION) {
                    System.out.println("Annulé");
                    break;
                } else {
                    String nameFile = jfs.getSelectedFile().getAbsolutePath();
                    drawing.saveDrawing(nameFile);
                }
                break;
            case "Ouvrir":
                JFileChooser jfo = new JFileChooser();
                int y = jfo.showOpenDialog(this);
                if (y == JFileChooser.CANCEL_OPTION) {
                    System.out.println("Opération annulée");
                    break;
                }
                String nameFileOpen = jfo.getSelectedFile().getAbsolutePath();
                drawing.recallDrawing(nameFileOpen);
                break;
            default:
                System.out.println("Je comprends pas ta commande : " + choix);
                break;
        }

    }

}

