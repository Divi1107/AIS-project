import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;

//!AIVDM,1,1,,B,177KQJ5000G?tO`K>RA1wUbN0TKH,0*5C
public class socgui {
    public static void main(String[] args) throws Exception {
        try {
            Socket sock = new Socket("127.0.01", 3456);
            InputStreamReader istream = new InputStreamReader(sock.getInputStream());
            OutputStreamWriter ostream = new OutputStreamWriter(sock.getOutputStream());
            Scanner sc = new Scanner(System.in);
            BufferedReader br = new BufferedReader(istream);
            BufferedWriter bw = new BufferedWriter(ostream);
            JFrame frame = new JFrame("Event Handling Example");
            JPanel panel = new JPanel();
            JLabel enterMessageLabel = new JLabel("Enter AIS Message:");
            JTextField textField = new JTextField(40);
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = textField.getText();
                    try {
                        String msgtoser = text;
                        bw.write(msgtoser);
                        bw.newLine();
                        bw.flush();
                    } catch (Exception ae) {
                        System.out.println("error " + ae);
                    }
                    JOptionPane.showMessageDialog(frame, "Message sent");
                }
            });
            panel.add(enterMessageLabel);
            panel.add(textField);
            panel.add(submitButton);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 200); // Set the size of the window
            frame.setVisible(true); // Make the window visible
        } catch (Exception ex) {
            System.out.println("error " + ex);
        }
    }
}