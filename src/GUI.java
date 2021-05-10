import javax.swing.*;
import java.awt.event.*;

class GUI extends JFrame implements ActionListener {

    JLabel lluas = new JLabel();
    JLabel lkeliling = new JLabel();
    JLabel lluaspermukaan = new JLabel();
    JLabel lvolume = new JLabel();
    JLabel ltitle = new JLabel("KALKULATOR BALOK");

    final JTextField fpanjang = new JTextField(10);
    JLabel lpanjang = new JLabel("Panjang");
    final JTextField flebar = new JTextField(10);
    JLabel llebar = new JLabel("Lebar");
    final JTextField ftinggi = new JTextField(10);
    JLabel ltinggi = new JLabel("Tinggi");

    JLabel lhasil = new JLabel("Hasil  :");

    JButton btnhitung = new JButton("Hitung");
    JButton btnreset = new JButton("Reset");

    public GUI() {
        setTitle("Kalkulator Balok");
        setSize(400, 400);

        btnhitung.addActionListener(this);
        btnreset.addActionListener(this);

        setLayout(null);
        add(ltitle);
        add(fpanjang);
        add(lpanjang);
        add(flebar);
        add(llebar);
        add(ftinggi);
        add(ltinggi);
        add(lhasil);
        add(btnhitung);
        add(btnreset);

        ltitle.setBounds(135, 20, 200, 20);
        fpanjang.setBounds(130, 65, 200, 20);
        lpanjang.setBounds(50, 65, 150, 20);
        flebar.setBounds(130, 95, 200, 20);
        llebar.setBounds(50, 95, 150, 20);
        ftinggi.setBounds(130, 125, 200, 20);
        ltinggi.setBounds(50, 125, 150, 20);
        lhasil.setBounds(150,160,120,20);
        btnhitung.setBounds(95, 320, 100, 20);
        btnreset.setBounds(205, 320, 100, 20);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnhitung) {
            try {
                //input ulang tanpa reset, agar hasil tidak menimpa satu sama lain
                remove(lluas);
                remove(lkeliling);
                remove(lvolume);
                remove(lluaspermukaan);

                //input kosong
                if (fpanjang.getText().isEmpty() || flebar.getText().isEmpty() || ftinggi.getText().isEmpty()){
                    throw new RuntimeException("empty String");
                }

                double panjang = Double.parseDouble(fpanjang.getText());
                double lebar = Double.parseDouble(flebar.getText());
                double tinggi = Double.parseDouble(ftinggi.getText());
                Balok balok = new Balok(panjang, lebar, tinggi);
                lluas = new JLabel("Luas Persegi                    :   " + balok.luas());
                lkeliling = new JLabel("Keliling Persegi                :   " + balok.keliling());
                lvolume = new JLabel("Volume Balok                   :   " + balok.volume());
                lluaspermukaan = new JLabel("Luas Permukaan Balok :   " + balok.luasPermukaan());

                add(lluas);
                add(lkeliling);
                add(lvolume);
                add(lluaspermukaan);

                lluas.setBounds(50, 190, 350, 20);
                lkeliling.setBounds(50, 220, 350, 20);
                lvolume.setBounds(50, 250, 350, 20);
                lluaspermukaan.setBounds(50, 280, 350, 20);

            } catch (Exception E) {
                JOptionPane optionPane = new JOptionPane(E.getMessage(), JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("Inputan Error!");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            }

        }

        else if (e.getSource() == btnreset) {
            fpanjang.setText("");
            flebar.setText("");
            ftinggi.setText("");
            lluas.setText("");
            lkeliling.setText("");
            lvolume.setText("");
            lluaspermukaan.setText("");
        }
    }

}