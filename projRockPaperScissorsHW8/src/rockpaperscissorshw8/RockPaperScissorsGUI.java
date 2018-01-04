//Assignment: projRockPaperScissorsHW8
//Program: RockPaperScissorsGUI
//Created: Jul 24, 2016
//Author: Trevor Dick
package rockpaperscissorshw8;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

    public class RockPaperScissorsGUI extends JFrame {

        /**
		 * 
		 */
		private static final long serialVersionUID = 5687019487291050129L;
		private JPanel contentPane;
        private JPanel humanDisplay = new JPanel();
        private JPanel computerDisplay = new JPanel();
        private JPanel choicePanel = new JPanel();
        private JPanel winnerAnnouncementPanel = new JPanel();
        
        private RockPaperScissorsChoice rock = RockPaperScissorsChoice.ROCK;
        private RockPaperScissorsChoice paper = RockPaperScissorsChoice.PAPER;
        private RockPaperScissorsChoice scissors = RockPaperScissorsChoice.SCISSORS;

        private RockPaperScissorsChoice randChoice;

        private final JPanel humanComp = new JPanel();
        private JLabel lblHuman = new JLabel("Human");
        private JLabel lblComputer = new JLabel("Computer");
        private JButton btnScissors = new JButton("Scissors");
        private JButton btnPaper = new JButton("Paper");
        private JButton btnRock = new JButton("Rock");
        private JLabel lblWinnerAnnouncement = new JLabel("Fight!");

        /**
        *Launch the application.
        */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        RockPaperScissorsGUI frame = new RockPaperScissorsGUI();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
        * Create the frame.
        */
        public RockPaperScissorsGUI() {
            setTitle("Rock, Paper, Scissors");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 800, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));
            setContentPane(contentPane);

            JPanel choicePanel = addPanels();

            addButtons(choicePanel, rock, btnRock);
            addButtons(choicePanel, paper, btnPaper);
            addButtons(choicePanel, scissors, btnScissors);
            
            
        }

        private JPanel addPanels() {
            contentPane.add(humanDisplay, BorderLayout.WEST);
            contentPane.add(computerDisplay, BorderLayout.EAST);
            contentPane.add(choicePanel, BorderLayout.NORTH);
            contentPane.add(humanComp, BorderLayout.SOUTH);
            contentPane.add(winnerAnnouncementPanel, BorderLayout.CENTER);
            winnerAnnouncementPanel.setLayout(new GridLayout(0, 1, 0, 0));
            
            lblWinnerAnnouncement.setAlignmentX(Component.CENTER_ALIGNMENT);
            lblWinnerAnnouncement.setHorizontalTextPosition(SwingConstants.CENTER);
            lblWinnerAnnouncement.setHorizontalAlignment(SwingConstants.CENTER);
            
            winnerAnnouncementPanel.add(lblWinnerAnnouncement);
            
            
            humanDisplay.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            humanComp.setLayout(new GridLayout(1, 0, 0, 0));
            
            humanComp.add(lblHuman);
            lblHuman.setHorizontalAlignment(SwingConstants.CENTER);

            humanComp.add(lblComputer);
            lblComputer.setHorizontalAlignment(SwingConstants.CENTER);

            return choicePanel;
        }

        private void addButtons(JPanel choicePanel, RockPaperScissorsChoice choice, JButton button){
            button.addActionListener(new ActionListener() {
            	
                public void actionPerformed(ActionEvent arg0) {
                	
                	humanComp.removeAll();
                	
                	humanDisplay.removeAll();
                	humanDisplay.add(new JLabel(choice.getImageIcon()));
                	JLabel lblHuman = new JLabel("Player chooses: " + choice);
                	lblHuman.setHorizontalAlignment(SwingConstants.CENTER);
                	humanComp.add(lblHuman);
                    
                    computerDisplay.removeAll();
                    randChoice = RockPaperScissorsChoice.randChoice();
                    computerDisplay.add(new JLabel(randChoice.getImageIcon()));
                    JLabel lblComputer = new JLabel("Computer chooses: " + randChoice);
                	lblComputer.setHorizontalAlignment(SwingConstants.CENTER);
                	humanComp.add(lblComputer);
                	
                	winnerAnnouncementPanel.removeAll();     
                	JLabel lblWinnerAnnouncement = new JLabel(RockPaperScissorsChoice.evaluate().toString());
                	lblWinnerAnnouncement.setHorizontalAlignment(SwingConstants.CENTER);
                	winnerAnnouncementPanel.add(lblWinnerAnnouncement, BorderLayout.CENTER);
                	
                	winnerAnnouncementPanel.repaint();
                    choicePanel.repaint();
                    choicePanel.revalidate();
                    
                }
            });
            choicePanel.add(button);
        }
    }