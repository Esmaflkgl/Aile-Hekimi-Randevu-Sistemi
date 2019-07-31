 */
public class HastaEkle {
    public JPanel panel1;
    public JTextField tc;
    public JTextField ad;
    public JTextField soyad;
    public JTextField adres;
    public JTextField telefon;
    public JButton ekleButton;
    public static Connection c;

    public HastaEkle() {
        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql="INSERT INTO hasta(TC,Ad,Soyad,Adres,Tel,Ilac) VALUES('"+tc.getText()+"','"+ad.getText()+"','"+soyad.getText()+"','"+adres.getText()+"','"+telefon.getText()+"',' ')";
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    String bag="jdbc:mysql://localhost:3306/otomasyon";
                    String kul="koray";
                    String sif="123";
                    c=DriverManager.getConnection(bag,kul,sif);
                    System.out.println("baglandi");
                }catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                try
                {
                    Statement sta =c.createStatement();
                    sta.execute(sql);
                    JOptionPane.showMessageDialog(null,"Hasta Eklendi");
                    ad.setText("");
                    soyad.setText("");
                    tc.setText("");
                    adres.setText("");
                    telefon.setText("");
                    c.close();
                }catch(SQLException x){JOptionPane.showMessageDialog(null, x.toString());}


            }
        });
    }
