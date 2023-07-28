import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class TicTacToe implements ActionListener{

	Random r = new Random();
	JFrame f = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel tf = new JLabel();
	JButton[] bt = new JButton[9];
	boolean player1_turn;

	TicTacToe(){
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Tic-Tac-Toe");
		f.setSize(500,500);
		f.getContentPane().setBackground(new Color(0,225,0));
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		
        tf.setBackground(new Color(135,206,236));
		tf.setForeground(new Color(255,165,0));
		tf.setFont(new Font("Times New Roman", Font.BOLD, 60));
		tf.setHorizontalAlignment(JLabel.CENTER);
		tf.setText("Tic-Tac-Toe");
		tf.setOpaque(true);

		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(50,50,800*50,100*50);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(255,253,208));
		
		for(int i=0;i<9;i++) {
            
			bt[i] = new JButton();
			button_panel.add(bt[i]);
			bt[i].setFont(new Font("Ink Free", Font.BOLD, 100));
			bt[i].setFocusable(false);
			bt[i].addActionListener(this);
            bt[i].setBackground(new Color(255, 255, 240));
		}
		
		title_panel.add(tf);
        
		f.add(title_panel,BorderLayout.NORTH);
		f.add(button_panel);
		
		firstTurn();
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==bt[i]) {
				if(player1_turn) {
					if(bt[i].getText()=="") {
						bt[i].setForeground(new Color(135,206,235));
						bt[i].setText("X");
						player1_turn=false;
						tf.setText("O turn");
						check();
					}
				}
				else {
					if(bt[i].getText()=="") {
						bt[i].setForeground(new Color(255,165,0));
						bt[i].setText("O");
						player1_turn=true;
						tf.setText("X turn");
						check();
					}
				}
			}			
		}
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		if(r.nextInt(2)==0) {
			player1_turn=true;
			tf.setText("X turn");
		}
		else {
			player1_turn=false;
			tf.setText("O turn");
		}
	}
	
	public void check() {
		if(
				(bt[0].getText()=="X") &&
				(bt[1].getText()=="X") &&
				(bt[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(bt[3].getText()=="X") &&
				(bt[4].getText()=="X") &&
				(bt[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(bt[6].getText()=="X") &&
				(bt[7].getText()=="X") &&
				(bt[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(bt[0].getText()=="X") &&
				(bt[3].getText()=="X") &&
				(bt[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(bt[1].getText()=="X") &&
				(bt[4].getText()=="X") &&
				(bt[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(bt[2].getText()=="X") &&
				(bt[5].getText()=="X") &&
				(bt[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(bt[0].getText()=="X") &&
				(bt[4].getText()=="X") &&
				(bt[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(bt[2].getText()=="X") &&
				(bt[4].getText()=="X") &&
				(bt[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		
		if(
				(bt[0].getText()=="O") &&
				(bt[1].getText()=="O") &&
				(bt[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(bt[3].getText()=="O") &&
				(bt[4].getText()=="O") &&
				(bt[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(bt[6].getText()=="O") &&
				(bt[7].getText()=="O") &&
				(bt[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(bt[0].getText()=="O") &&
				(bt[3].getText()=="O") &&
				(bt[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(bt[1].getText()=="O") &&
				(bt[4].getText()=="O") &&
				(bt[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(bt[2].getText()=="O") &&
				(bt[5].getText()=="O") &&
				(bt[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(bt[0].getText()=="O") &&
				(bt[4].getText()=="O") &&
				(bt[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(bt[2].getText()=="O") &&
				(bt[4].getText()=="O") &&
				(bt[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
	}
	
	public void xWins(int a,int b,int c) {
		bt[a].setBackground(Color.RED);
		bt[b].setBackground(Color.RED);
		bt[c].setBackground(Color.RED);
		
		for(int i=0;i<9;i++) {
			bt[i].setEnabled(false);
		}
		tf.setText("X is the winner! ");
	}
	public void oWins(int a,int b,int c) {
		bt[a].setBackground(Color.RED);
		bt[b].setBackground(Color.RED);
		bt[c].setBackground(Color.RED);
		
		for(int i=0;i<9;i++) {
			bt[i].setEnabled(false);
		}
		tf.setText("O is the winner!");
	}
}