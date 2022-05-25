package apcs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this creates the intro class
//its purpose is to get the game started and get all the nesseray information needed.
//in this case being size and percentage chance of being alive.

public class intro {
    // these are all of the varibles created con being the actual game while the rest being the little box you see that allows you to select
    private Conway con;
    private ImageIcon intro;
    private JLabel label;
    private JPanel image;
    private JPanel selector;
    private JFrame frame;
    private JButton Conway;
    private JButton ending;


    public intro(){
        //intalizes all of the varibles
        intro = new ImageIcon(getClass().getResource("intro.png"));
        label = new JLabel(intro);
        image = new JPanel();
        image.add(label);

        // pops up the intro screen which asks what game you want to play
        selector = new JPanel();
        ending = new JButton("Click to exit");
        //when the exist button is touched it closes out of the program.
        ending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        Conway = new JButton("Click to play Conways game of life");
        //when the button that says click to play is pressed it runs this and if the requirments are meet it starts the game if not it shows a pop up
        //telling you the requirments arent meet.
        Conway.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //stores the size of the board of play and then checks if there in the limit and if so  it creates the game
                //if not it tells you to try again.

                int X = Integer.parseInt( JOptionPane.showInputDialog("how wide will the board be ? minum is 5 maximum is 25"));
                int Y = Integer.parseInt( JOptionPane.showInputDialog("how tall will the board be ? minum is 5 maximum is 25"));
                if( X <= 25 && X >= 5 && Y <= 25 && Y >= 5  ){
                    con = new Conway(X,Y);
                    con.Check();

                }
                else{

                    JOptionPane.showMessageDialog(null,"Sorry that is above or below the limit try again");
                }

            }
        });
        selector.add(Conway);
        selector.add(ending);



        //creats the frame and sets up the visuals and such.
        frame = new JFrame();
        frame.setLayout(new GridLayout(2,3,5,0));
        frame.setSize(500,500);
        frame.setLocation(0,0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(image).setLocation(1,2);
        frame.add(selector).setLocation(2,1);






    }
    //begins the code and shows the pop up.
    public void begin(){
        frame.setVisible(true);

    }



}
