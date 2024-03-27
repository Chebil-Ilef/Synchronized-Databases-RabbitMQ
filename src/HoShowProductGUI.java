import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;


public class HoShowProductGUI {

    public HoShowProductGUI(String dbName) {
        JFrame f = new JFrame(dbName);
        JTextField t1, t2, t3,  t5, t6, t7;
        f.setSize(600, 1200);
        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        p.setBackground(new Color(216, 191, 216));

        p.setLayout(new GridLayout(9, 1, 15, 10));
        f.add(p, BorderLayout.CENTER);

        JButton showBtn = new JButton("Show Products");
        showBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new VisualiseData(dbName);
            }
        });

        p.add(showBtn);

        f.add(p);
        f.setSize(450,550);
        f.setVisible(true);
    }
}

