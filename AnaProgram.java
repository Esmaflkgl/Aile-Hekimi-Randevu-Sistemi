public static void main(String []args) throws IOException {
        JFrame frame=new JFrame("Doktor");
        frame.setContentPane(new Ana().panel1);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,1024);
        frame.pack();
        frame.setVisible(true);
        

    }
    private JPanel panel1;
    private JTextField k;
    private JTextField s;
    private JButton girişButton;
    public static Connection c;
    public Ana() {

        girişButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql="SELECT * FROM doktor WHERE kullanici='"+k.getText()+"' AND sifre='"+s.getText()+"'";
                String kullanici=k.getText();
                PreparedStatement preparedStatement;ResultSet resultSet;
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    String bag="jdbc:mysql://localhost:3306/otomasyon";
                    String kul="koray";
                    String sif="123";
                    c= DriverManager.getConnection(bag,kul,sif);

                    preparedStatement= (PreparedStatement) c.prepareStatement(sql);
                    resultSet= (ResultSet) preparedStatement.executeQuery();
                    if(resultSet.next()){
                    JFrame frame=new JFrame("Aile Hekimi");
                    frame.setContentPane(new AileHekimi().panel1);
                    frame.setSize(800,300);
                    frame.setVisible(true);}
                    else JOptionPane.showMessageDialog(null, "Yanlış kullanıcı adı veya şifre!");
                }catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.toString());}

                try
                {
                    Statement sta =c.createStatement();
                    sta.execute(sql);
                    c.close();
                }catch(SQLException x){JOptionPane.showMessageDialog(null, x.toString());}
            }
        });
    }
