package apcs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// the actual game, controls the visuals and the checks if the board is alright and such.

public class Conway {
    //the varibles are mostly the board size and visuals with the expetion of the gen which is of the generator class of which runs the calculations of Conways game of life to simplfy things.
    private JFrame Board;
    private ImageIcon test = new ImageIcon(getClass().getResource("test_cells.png"));
    private ImageIcon Alive = new ImageIcon(getClass().getResource("Alive.png"));
    private ImageIcon Dead = new ImageIcon(getClass().getResource("dead.png"));
    private JLabel[][] squares;
    private JPanel Cells;
    private boolean[][] alive;
    private Generator gen;
    private int R;
    private int C;
    //creats the board and the x and y size as well as adds all the cells and preps it to start.
    public Conway(int x, int y){
        Board = new JFrame();
        Board.setLayout(new GridLayout(2,1));
        Board.setSize(x * 100,y * 100);
        Board.setLocation(0,0);
        Board.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        R = x;
        C = y;
        squares = new JLabel[R][C];
        Cells = new JPanel(new GridLayout(x,y,0,0));
        Cells.setSize(R,C);

        for (JLabel[] arr : squares) {
            for (JLabel lab : arr) {
                lab = new JLabel(test);
                Cells.add(lab);
                Cells.repaint();
            }
        }
        Board.add(Cells).setLocation(1,0);
    }
    //displays a preview of the board as asks to confirm if its okay if so it generates the board if not well it closes.
    public void Check(){
        JButton check = new JButton("Is this okay? click here to confirm if not exit the window");
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board.setVisible(false);
                Generate();
            }
        });
        JPanel temp = new JPanel();
        temp.add(check);
        Board.add(temp).setLocation(2,0);
        Board.setVisible(true);
    }
    //this is where the game begins it asks you for a percentage chance of living and if repeats if it dosent fit the critera , then it draws the squars and officaly starts.
    public void Generate(){
        alive = new boolean[R][C];
        int chance = 0;
        gen = new Generator(alive);
        int a = 1;
        while(a == 1) {
             chance = Integer.parseInt(JOptionPane.showInputDialog("what are the chances a cell is alive?, MIN 1 percent, Max 80 percent"));
            if (chance > 80 || chance < 1){
                    JOptionPane.showMessageDialog(null,"sorry thats below the limt or above it please try again");
            }
            else {
                a =0;
            }
        }
        alive =  gen.GenAlive(chance);
        Drawsquares();
        Start();





    }
    //the game it runs constanly and asks if you wish to continue if you do it does another round and plays conways game of life thats about it.
    public void Start(){
        int a = 1;
        Board.dispose();
        Board = new JFrame();
        Board.setLayout(new GridLayout(1, 1));
        Board.setSize(R * 100, C * 100);
        Board.setLocation(0, 0);
        Board.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Board.setResizable(false);
        Cells = new JPanel(new GridLayout(R, C, 0, 0));
        Cells.setSize(R, C);
        while (a == 1) {


            Board.remove(Cells);
            Cells = new JPanel(new GridLayout(R, C, 0, 0));
            Cells.setSize(R, C);



            for (JLabel[] arr : squares) {
                for (JLabel lab : arr) {
                    Cells.add(lab);
                    Cells.repaint();
                }
            }

            Board.add(Cells).setLocation(1, 0);
            Board.setVisible(true);
            alive = gen.Gengame();
            Drawsquares();
           int b = display.yN("continue?","choice");
            if(b == 1 ){
                a = 2;
            }


        }
        Board.dispose();





    }


    //it marks the squares as either white or black siginifing if there alive or dead.
    public void Drawsquares(){
        for(int R = 0; R < squares.length; R++){
            for (int C = 0; C < squares[R].length; C++){
                if(alive[R][C]){
                    squares[R][C] = new JLabel(Alive);
                }
                else {
                    squares[R][C] = new JLabel(Dead);
                }
            }
        }


    }




}
