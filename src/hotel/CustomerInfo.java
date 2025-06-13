/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.proteanit.sql.DbUtils;
import java.sql.*;
public class CustomerInfo extends JFrame {
    private JPanel contentPane;
    private JLabel lblId;
    private JLabel lblNewLabel;
    private JLabel lblGender;
    private JTable table;
    private JLabel lblCountry;
    private JLabel lblRoom;
    private JLabel lblStatus;
    private JLabel lblNewLabel_1;
    
    public static void main(String[]args){
            EventQueue.invokeLater(new Runnable(){
                public void run(){
                    try{
                       CustomerInfo frame = new CustomerInfo();
                       frame.setVisible(true);
                        
                    }catch(Exception e){
                      e.printStackTrace();
                    }
                    
                }
            });
        }
      public void close(){
            this.dispose();
        }   
      
       public CustomerInfo() throws Exception{
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(530,200,900,600);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5,5,5,5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            
            JButton btnExit = new JButton("Back");
            btnExit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    new Reception().setVisible(true);
                    setVisible(false);
                }
            });
            btnExit.setBounds(450,510,120,30);
            btnExit.setBackground(Color.BLACK);
            btnExit.setForeground(Color.WHITE);
            contentPane.add(btnExit);
            
            JButton btnLoadData = new JButton("Load Data");
            btnLoadData.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    try{
                        Conn c= new Conn();
                        String displayCustomersql = "select * from customer";
                        ResultSet rs= c.s.executeQuery(displayCustomersql);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                        
                        
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
            btnLoadData.setBounds(300,510,120,30);
            btnLoadData.setBackground(Color.BLACK);
            btnLoadData.setForeground(Color.WHITE);
            contentPane.add(btnLoadData);
            
            lblId = new JLabel("Id");
            lblId.setBounds(31,11,46,14);
            contentPane.add(lblId);
            
            JLabel l1 = new JLabel("Number");
            l1.setBounds(150,11,46,14);
            contentPane.add(l1);
            
            lblNewLabel = new JLabel("Name");
            lblNewLabel.setBounds(270,11,65,14);
            contentPane.add(lblNewLabel);
            
            lblGender = new JLabel("Gender");
            lblGender.setBounds(360,11,46,14);
            contentPane.add(lblGender);
            
            table = new JTable();
            table.setBounds(0,40,900,450);
            contentPane.add(table);
            
            lblCountry = new JLabel("Country");
            lblCountry.setBounds(480,11,46,14);
            contentPane.add(lblCountry);
            
            lblRoom = new JLabel("Room");
            lblRoom.setBounds(600,11,46,14);
            contentPane.add(lblRoom);
            
            lblStatus = new JLabel("Check-in-Status");
            lblStatus.setBounds(680,11,100,14);
            contentPane.add(lblStatus);
            
            lblNewLabel_1 = new JLabel("Deposit");
            lblNewLabel_1.setBounds(800,11,100,14);
            contentPane.add(lblNewLabel_1);
            
            getContentPane().setBackground(Color.WHITE);
            
            
                    }
}
