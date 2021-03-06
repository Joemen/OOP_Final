import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JTextPane;
import javax.swing.JSpinner;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import java.text.*;


public class FightFrame extends JPanel implements PropertyChangeListener  {
    public static JFrame fightframe;
    public static JFormattedTextField amount_Off;
    public static JFormattedTextField amount_Def;
    private int amount_1 = 0;
    private int amount_2 = 0;
    private NumberFormat amountFormat;
    public static JButton btnReady;
    public static JLabel lblIncorrectInput;
    
    public static JLabel lblalarm;
    
    public FightFrame(){
        fightframe = new JFrame();
        fightframe.setResizable(false);
        fightframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fightframe.setBounds(new Rectangle(100, 0, 550, 400));
        fightframe.setTitle("Prepare your fight");
        fightframe.getContentPane().setLayout(null);
        
        String roundplayer = new String("");
        String armyblood = new String("");
        roundplayer += "round : " + Game.round + "    player : " + Game.player[(Game.turn+1)%2].getPlayerName() ;
        armyblood = "     Army : "  + Game.player[(Game.turn+1)%2].getNumSoldier() +"     Tower : "+Game.tower[Game.player[(Game.turn+1)%2].getCampNum()-1].getBlood();
        JLabel label_roundplayer = new JLabel(roundplayer);
        JLabel label_moneyarmyblood = new JLabel(armyblood);
        label_roundplayer.setForeground(Color.BLUE);
        label_roundplayer.setBounds(21, 6, 262, 16);
        fightframe.add(label_roundplayer);
        label_moneyarmyblood.setForeground(Color.BLUE);
        label_moneyarmyblood.setBounds(230, 6, 300, 16);
        fightframe.add(label_moneyarmyblood);
        
        
        JLabel lblSetYourOffense = new JLabel("Set your offense soldier");
        lblSetYourOffense.setBounds(53, 51, 160, 34);
        fightframe.getContentPane().add(lblSetYourOffense);
        
        JLabel lblSetYourDefense = new JLabel("Set your defense soldier");
        lblSetYourDefense.setBounds(272, 51, 160, 34);
        fightframe.getContentPane().add(lblSetYourDefense);
        
        
        amount_Off = new JFormattedTextField(
                                             new InternationalFormatter(NumberFormat.getIntegerInstance()) {
            protected DocumentFilter getDocumentFilter() {
                return filter;
            }
            private DocumentFilter filter = new IntFilter();
        });
        amount_Off.setValue(amount_1);
        amount_Off.setBounds(53, 109, 96, 21);
        amount_Off.setColumns(10);
        amount_Off.addPropertyChangeListener("value", this);
        
        fightframe.getContentPane().add(amount_Off);
        
        amount_Def = new JFormattedTextField(
                                             new InternationalFormatter(NumberFormat.getIntegerInstance()) {
            protected DocumentFilter getDocumentFilter() {
                return filter;
            }
            private DocumentFilter filter = new IntFilter();
        });
        amount_Def.setValue(amount_2);
        amount_Def.setBounds(272, 109, 96, 21);
        amount_Def.setColumns(10);
        amount_Def.addPropertyChangeListener("value", this);
        
        fightframe.getContentPane().add(amount_Def);
        
        lblalarm = new JLabel("Not enough Soldiers");
        lblalarm.setForeground(Color.RED);
        lblalarm.setBounds(400, 107, 291, 27);
        lblalarm.setVisible(false);
        fightframe.add(lblalarm);
        
        btnReady = new JButton("Ready");
        btnReady.setBounds(53, 304, 87, 23);
        fightframe.getContentPane().add(btnReady);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(272, 304, 87, 23);
        fightframe.getContentPane().add(btnCancel);
        
        lblIncorrectInput = new JLabel("Incorrect Input!   Please check again!");
        lblIncorrectInput.setForeground(Color.RED);
        lblIncorrectInput.setBounds(88, 274, 300, 27);
        lblIncorrectInput.setVisible(false);
        fightframe.getContentPane().add(lblIncorrectInput);
        
        
        
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fightframe.dispose();
            }
        });
        
        btnReady.addActionListener(MainFrame.scrollPane);
        
        fightframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fightframe.getRootPane().setDefaultButton(btnReady);
    }
    
    
    
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        // TODO Auto-generated method stub
        
        Object source = e.getSource();
        if (source == amount_Off) {
            amount_1 = ((Number)amount_Off.getValue()).intValue();
        } else if (source == amount_Def) {
            amount_2 = ((Number)amount_Def.getValue()).intValue();
        }
        int i = -1;
        int j = -1;
        
        try{
            i = Integer.parseInt(amount_Off.getText());
            j = Integer.parseInt(amount_Def.getText());
        } catch (Exception ex){
            
        }
        if( i>=0 && j>=0){
            lblIncorrectInput.setVisible(false);
        }
        
        if(Game.player[(Game.turn+1)%2].getNumSoldier()-((Number)amount_Off.getValue()).intValue()-((Number)amount_Def.getValue()).intValue()>=0){
            lblalarm.setVisible(false);
        }
    }
}

class IntFilter extends DocumentFilter {
    //重載insertString方法
    public void insertString(FilterBypass fb, int offset, String string,
                             AttributeSet attr) throws BadLocationException {
        StringBuilder builder = new StringBuilder(string);
        for (int i = builder.length() - 1; i >= 0; i--) {
            int cp = builder.codePointAt(i);
            if (!Character.isDigit(cp) && cp != '-') {
                builder.deleteCharAt(i);
                if (Character.isSupplementaryCodePoint(cp)) {
                    i--;
                    builder.deleteCharAt(i);
                }
            }
        }
        super.insertString(fb, offset, builder.toString(), attr);
    }
    //重載replace方法
    public void replace(FilterBypass fb, int offset, int length, String string,
                        AttributeSet attr) throws BadLocationException {
        if (string != null) {
            StringBuilder builder = new StringBuilder(string);
            for (int i = builder.length() - 1; i >= 0; i--) {
                int cp = builder.codePointAt(i);
                if (!Character.isDigit(cp) && cp != '-') {
                    builder.deleteCharAt(i);
                    if (Character.isSupplementaryCodePoint(cp)) {
                        i--;
                        builder.deleteCharAt(i);
                    }
                }
            }
            string = builder.toString();
        }
        super.replace(fb, offset, length, string, attr);
    }
}