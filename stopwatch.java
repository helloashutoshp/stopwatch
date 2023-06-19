
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class stopp implements ActionListener {
    JFrame frame = new JFrame();
    JButton startb = new JButton("START");
    JButton resetb = new JButton("RESET");
    JLabel lebel = new JLabel();

    int milisec = 0;
    int hr = 0;
    int sec = 0;
    int min = 0;
    boolean isstart = false;
    String sec_str = String.format("%02d", sec);
    String hr_str = String.format("%02d", hr);
    String min_str = String.format("%02d", min);

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            milisec = milisec + 1000;
            hr = (milisec / 3600000);
            min = (milisec / 60000) % 60;
            sec = (milisec / 1000) % 60;

            sec_str = String.format("%02d", sec);
            hr_str = String.format("%02d", hr);
            min_str = String.format("%02d", min);
            lebel.setText(hr_str + ":" + min_str + ":" + sec_str);

        }
    });

    stopp() {

        lebel.setText(hr_str + ":" + min_str + ":" + sec_str);
        lebel.setBounds(100, 100, 200, 100);
        lebel.setHorizontalAlignment(JTextField.CENTER);
        lebel.setFont(new Font("Verdana", Font.PLAIN, 35));

        startb.setBounds(100, 200, 100, 50);
        startb.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startb.addActionListener(this);

        resetb.setBounds(200, 200, 100, 50);
        resetb.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetb.addActionListener(this);

        frame.add(startb);
        frame.add(resetb);
        frame.add(lebel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startb) {
            if (isstart == false) {
                isstart = true;
                startb.setText("STOP");
                start();
            } else {
                isstart = false;
                startb.setText("start");
                stop();
            }

        }
        if (e.getSource() == resetb) {
            isstart = false;
            reset();
        }
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        hr = 0;
        min = 0;
        sec = 0;
        sec_str = String.format("%02d", sec);
        hr_str = String.format("%02d", hr);
        min_str = String.format("%02d", min);
        lebel.setText(hr_str + ":" + min_str + ":" + sec_str);

    }
}

public class stopwatch {
    public static void main(String a[]) {
        stopp st = new stopp();
    }
}
