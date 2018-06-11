/*
 * Created by JFormDesigner on Sat Jun 09 10:16:30 EDT 2018
 */

package Bones;

import org.dreambot.api.methods.map.Area;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Raymond Walsh
 */
public class BonesGUI extends JFrame {
    private Main ctx;

    Area[] CowArea = new Area[]{
            new Area(3252, 3297, 3265, 3255, 0), // Cow Area
            new Area(3194, 3301, 3211, 3281, 0), //Cow Area 2
            new Area(3171, 3301, 3184, 3291, 0), //Chicken Area
            new Area(3263, 3223, 3241, 3251, 0), //Goblin Area
            new Area(3229, 3617, 3247, 3602, 0), //Wildy Area
    };




    public BonesGUI(Main main) {
        this.ctx = main;
        initComponents();
    }


    private void button1ActionPerformed(ActionEvent e) {
        ctx.setStartScript(true);
        this.setVisible(false);
        ctx.setCowArea(CowArea[comboBox1.getSelectedIndex()]);

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Raymond Walsh
        button1 = new JButton();
        comboBox1 = new JComboBox<>();
        label1 = new JLabel();
        comboBox2 = new JComboBox<>();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        setTitle("Pro Bones Collector & Prayer Booster!");
        setIconImage(new ImageIcon("C:\\Users\\raywa\\Desktop\\rsgold.png").getImage());
        setBackground(Color.white);
        setForeground(new Color(204, 255, 255));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("Start");
        button1.setBackground(Color.white);
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(130, 85, 100, 20);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "Cows 1",
            "Cows 2",
            "Chicken Pin",
            "Goblins ",
            "Wilderness"
        }));
        comboBox1.setToolTipText("Choose Your Loction Please");
        contentPane.add(comboBox1);
        comboBox1.setBounds(20, 15, 265, 20);

        //---- label1 ----
        label1.setText("Please Choose Your Gather Location");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
        label1.setForeground(Color.red);
        label1.setBackground(Color.black);
        contentPane.add(label1);
        label1.setBounds(20, 0, 300, label1.getPreferredSize().height);

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "Bones",
            "Big bones",
            "Dragon bones"
        }));
        contentPane.add(comboBox2);
        comboBox2.setBounds(20, 60, 265, 20);

        //---- label2 ----
        label2.setText("Please Choose Which Item To Gather");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));
        label2.setForeground(Color.red);
        label2.setBackground(Color.black);
        contentPane.add(label2);
        label2.setBounds(20, 45, 300, 16);

        //---- label3 ----
        label3.setText("Script by; ilcanada6");
        contentPane.add(label3);
        label3.setBounds(265, 100, 120, 11);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public String getTreeType() {
        return comboBox2.getSelectedItem().toString();

    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Raymond Walsh
    private JButton button1;
    private JComboBox<String> comboBox1;
    private JLabel label1;
    private JComboBox<String> comboBox2;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
