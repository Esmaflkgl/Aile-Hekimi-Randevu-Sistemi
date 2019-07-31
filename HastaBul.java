public class HastaBul {
    public JPanel panel1;
    private JTable table1;
    private JTextField tc;
    private JButton button1;
    private JTextField ilac;
    private JButton button2;
    private JButton kişiyiSilButton;
    public static Connection c;

        public HastaBul() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs;
                Statement statement;
                int sutun;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String bag = "jdbc:mysql://localhost:3306/otomasyon";
                    String kul = "koray";
                    String sif = "123";
                    c = DriverManager.getConnection(bag, kul, sif);
                    System.out.println("baglandi");
                    statement = c.createStatement();

                    rs = statement.executeQuery("Select * from hasta where TC= '"+tc.getText()+"'");

                    sutun = rs.getMetaData().getColumnCount();

                    //Table tipinde model olusturuyoruz.
                    DefaultTableModel table = new DefaultTableModel();
                    for (int i = 1; i <= sutun; i++)
                        table.addColumn(rs.getMetaData().getColumnName(i));

                    //Veritabanindaki tum satir ve sutunlari tarayip Table'a ekliyoruz.
                    while (rs.next()) {
                        Object[] row = new Object[sutun];
                        for (int i = 1; i <= sutun; i++)
                            row[i - 1] = rs.getObject(i);
                        table.addRow(row);

                    }

                    table1.setModel(table);
                    rs.close();
                    c.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
                }
            }});
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sql="UPDATE hasta SET Ilac='"+ilac.getText()+"' WHERE TC='"+tc.getText()+"'";
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        String bag="jdbc:mysql://localhost:3306/otomasyon";
                        String kul="koray";
                        String sif="123";
                        c=DriverManager.getConnection(bag,kul,sif);
                        System.out.println("baglandi");
                    }catch (ClassNotFoundException e1) {
                        JOptionPane.showMessageDialog(null, e1.toString());
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.toString());
                    }
                    try
                    {
                        Statement sta =c.createStatement();
                        sta.execute(sql);
                        c.close();
                    }catch(SQLException x){System.out.println(x.toString());}
                    ResultSet rs;
                    Statement statement;
                    int sutun;
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String bag = "jdbc:mysql://localhost:3306/otomasyon";
                        String kul = "koray";
                        String sif = "123";
                        c = DriverManager.getConnection(bag, kul, sif);
                        System.out.println("baglandi");
                        statement = c.createStatement();

                        rs = statement.executeQuery("Select * from hasta where TC= '"+tc.getText()+"'");

                        sutun = rs.getMetaData().getColumnCount();

                        //Table tipinde model olusturuyoruz.
                        DefaultTableModel table = new DefaultTableModel();
                        for (int i = 1; i <= sutun; i++)
                            table.addColumn(rs.getMetaData().getColumnName(i));

                        //Veritabanindaki tum satir ve sutunlari tarayip Table'a ekliyoruz.
                        while (rs.next()) {
                            Object[] row = new Object[sutun];
                            for (int i = 1; i <= sutun; i++)
                                row[i - 1] = rs.getObject(i);
                            table.addRow(row);

                        }

                        table1.setModel(table);
                        rs.close();
                        c.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
                    }
                }
            });
            kişiyiSilButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sql="delete from hasta where TC='"+tc.getText()+"'";
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
                        c.close();
                    }catch(SQLException x){JOptionPane.showMessageDialog(null, x.toString());}
                    ResultSet rs;
                    Statement statement;
                    int sutun;
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String bag = "jdbc:mysql://localhost:3306/otomasyon";
                        String kul = "koray";
                        String sif = "123";
                        c = DriverManager.getConnection(bag, kul, sif);
                        System.out.println("baglandi");
                        statement = c.createStatement();

                        rs = statement.executeQuery("Select * from hasta where TC= '"+tc.getText()+"'");

                        sutun = rs.getMetaData().getColumnCount();

                        //Table tipinde model olusturuyoruz.
                        DefaultTableModel table = new DefaultTableModel();
                        for (int i = 1; i <= sutun; i++)
                            table.addColumn(rs.getMetaData().getColumnName(i));

                        //Veritabanindaki tum satir ve sutunlari tarayip Table'a ekliyoruz.
                        while (rs.next()) {
                            Object[] row = new Object[sutun];
                            for (int i = 1; i <= sutun; i++)
                                row[i - 1] = rs.getObject(i);
                            table.addRow(row);

                        }

                        table1.setModel(table);
                        rs.close();
                        c.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
                    }

                }
            });
        }
}
