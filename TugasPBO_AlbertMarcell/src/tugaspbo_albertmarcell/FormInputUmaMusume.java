

package tugaspbo_albertmarcell;

import javax.swing.*;

public class FormInputUmaMusume extends JFrame {
    private ButtonGroup buttonGroupType;
    private JButton btnTampil;
    private JComboBox<String> cmbSpeciality;
    
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
    private JRadioButton rbMile;
    private JRadioButton rbMedium;
    private JRadioButton rbLong;
    private JRadioButton rbSprint;
    
    private JTextField tfHarga;
    private JTextField tfNama;
    private JTextField tfTotalJuara;
    private JTextField tfUmur;
    
    public FormInputUmaMusume() {
        componentUmaMusume();
        setLocationRelativeTo(null);
    }
    
    private void componentUmaMusume(){
    buttonGroupType = new ButtonGroup();
    
    jLabel1 = new JLabel("Nama Uma Musume");
    jLabel2 = new JLabel("Umur Uma Musume");
    jLabel3 = new JLabel("Harga Uma Musume");
    jLabel4 = new JLabel("Total Juara");
    jLabel5 = new JLabel("Tipe Uma Musume");
    jLabel6 = new JLabel("Speciality Uma Musume");
    jLabel7 = new JLabel("Form Input Data Uma Musume");
    
    tfNama = new JTextField();
    tfHarga = new JTextField();
    tfUmur = new JTextField();
    tfTotalJuara = new JTextField();
    
    rbMile = new JRadioButton("Mile");
    rbLong = new JRadioButton("Long");
    rbMedium = new JRadioButton("Medium");
    rbSprint = new JRadioButton("Sprint");
    
    rbMile.setSelected(true);
    
    buttonGroupType.add(rbMile);
    buttonGroupType.add(rbLong);
    buttonGroupType.add(rbMedium);
    buttonGroupType.add(rbSprint);
    
    cmbSpeciality = new JComboBox<>(
            new String[]{"Speed", "Stamina", "Power", "Guts", "Wit"}
    );
    
    btnTampil = new JButton("Tampil");
    btnTampil.addActionListener(evt -> btnTampilActionPerformed());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Input Data Uma Musume");
    setSize(500, 380);

    JPanel panel = new JPanel();
    panel.setLayout(null);
    
    jLabel1.setBounds(20, 50, 150, 25);
    jLabel2.setBounds(20, 80, 150, 25);
    jLabel3.setBounds(20, 110, 150, 25);
    jLabel4.setBounds(20, 140, 150, 25);
    jLabel5.setBounds(20, 170, 150, 25);
    jLabel6.setBounds(20, 240, 150, 25);
    jLabel7.setBounds(120, 10, 250, 30);
    
    tfNama.setBounds(180, 50, 200, 25);
    tfUmur.setBounds(180, 80, 200, 25);
    tfHarga.setBounds(180, 110, 200, 25);
    tfTotalJuara.setBounds(180, 140, 200, 25);
    
    rbMile.setBounds(180, 170, 80, 25);
    rbSprint.setBounds(270, 170, 80, 25);
    rbLong.setBounds(180, 200, 80, 25);
    rbMedium.setBounds(270, 200, 100, 25);
    
    cmbSpeciality.setBounds(180, 240, 200, 25);
    btnTampil.setBounds(180, 290, 100, 30);
    
    panel.add(jLabel1);
    panel.add(jLabel2);
    panel.add(jLabel3);
    panel.add(jLabel4);
    panel.add(jLabel5);
    panel.add(jLabel6);
    panel.add(jLabel7);
    
    panel.add(tfNama);
    panel.add(tfUmur);
    panel.add(tfHarga);
    panel.add(tfTotalJuara);
    
    panel.add(rbMile);
    panel.add(rbSprint);
    panel.add(rbLong);
    panel.add(rbMedium);
    
    panel.add(cmbSpeciality);
    panel.add(btnTampil);
    
    add(panel);
}

private void btnTampilActionPerformed() {             
    try {
    UmaMusume uma = new UmaMusume();
    uma.setNamaUmaMusume(tfNama.getText());
    uma.setUmurUmaMusume(Integer.parseInt(tfUmur.getText()));
    uma.setHargaUmaMusume(Integer.parseInt(tfHarga.getText()));
    uma.setTotalJuara(Integer.parseInt(tfTotalJuara.getText()));

    String tipe;
     if (rbMile.isSelected()) {
         tipe = "Mile";
    } else if (rbSprint.isSelected()) {
        tipe = "Sprint";
    } else if (rbLong.isSelected()) {
        tipe = "Long";
    } else {
         tipe = "Medium";
    }

    uma.setTipeUmaMusume(tipe);
    uma.setSpecialityUmaMusume(
    cmbSpeciality.getSelectedItem().toString()
    );

    String output =
        "Nama Uma Musume : " + uma.getNamaUmaMusume() + "\n" +
        "Umur            : " + uma.getUmurUmaMusume() + " Tahun\n" +
        "Harga           : " + uma.getHargaUmaMusume() + " Carrat\n" +
        "Total Juara : " + uma.getTotalJuara() + "\n" +
        "Tipe Race    : " + uma.getTipeUmaMusume() + "\n" +
        "Speciality    : " + uma.getSpecialityUmaMusume();

    JOptionPane.showMessageDialog(
        this,
        output,
        "Keterangan",
        JOptionPane.INFORMATION_MESSAGE
    );

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
                this,
                "Umur, Harga, dan Total Juara harus berupa angka!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new FormInputUmaMusume().setVisible(true);
        });
    }
    
}
