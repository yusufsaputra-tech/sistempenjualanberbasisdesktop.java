/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import DBO.FungsiQuery;
import DBO.koneksi;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Image;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yusuf
 */
public class homeutama extends javax.swing.JFrame {
    private void userLogin(){
    lblUserLogin.setText(UserSession.getUserLogin());
    }
    
    private void hakakses() {
    String user=lblUserLogin.getText();
        if(user.equals("Admin")){
        btnUser.setEnabled(false);
        btnTransaksi.setEnabled(true);
        btnHome.setEnabled(true);
        jmLaporan.setEnabled(true);
        jmPengaturan.setEnabled(true);
        jmFile.setEnabled(true);
        }
        else {
        btnUser.setEnabled(false);
        btnTransaksi.setEnabled(true);
        btnHome.setEnabled(true);
        jmLaporan.setEnabled(true);
        jmPengaturan.setEnabled(true);
        jmFile.setEnabled(true);
        }
        }
    
       
    String[] data = new String[5];
    private DefaultTableModel tblModel;
    FungsiQuery query = new FungsiQuery();
    String [] kolom = new String [5];
    String [] isi = new String [5];
    
    public String [] kolom() {
        kolom[0] = "username";
        kolom[1] = "email";
        kolom[2] = "jenkel";
        kolom[3] = "password";
        kolom[4] = "hak_akses";
        return kolom;
    }
    
    public String[] Data() 
    {
        String jenkel="";
        if(rbPria.isSelected()){
            jenkel="Laki-laki";
        }else if (rbWanita.isSelected()){
            jenkel="Perempuan";
        }else{
            jenkel="";
        }
        
        String hk="";
        if(rbManager.isSelected()){
            hk="Manager";
        }else if (rbAdmin.isSelected()){
            hk="Admin";
        }else{
            hk="";
        }
        isi[0] = txtNama.getText();
        isi[1] = txtEmail.getText();
        isi[2] = jenkel;
        isi[3] = txtPassword.getText();
        isi[4] = hk;
        return isi;
    }
    
    
    /**
     * Creates new form home
     */
    
    public homeutama() {
        initComponents();
        setLocationRelativeTo(this);
        setWaktu();
        set1();
        userLogin();
        hakakses();
        
        tblModel = new DefaultTableModel();
        Table.setModel(tblModel);
        tblModel.addColumn("Nama");
        tblModel.addColumn("Email");
        tblModel.addColumn("Jenis Kelamin");
        tblModel.addColumn("Password");
        tblModel.addColumn("hak_akses");
        setDefaultTableModel();
    }
    public void setWaktu(){
    Calendar kalender = Calendar.getInstance();
    SimpleDateFormat tgl = new SimpleDateFormat("FFFF, d MMMM YYYY");
    SimpleDateFormat wkt = new SimpleDateFormat("HH:mm:ss");
    String Tanggal = tgl.format(kalender.getTime());
    String Waktu = wkt.format(kalender.getTime());
    lblTanggal.setText("Hari/Tanggal  : "+Tanggal);
    lblWaktu.setText("Pukul  : "+Waktu);
    }
    
     private void bersih()
    {
     txtNama.setText("");
     txtEmail.setText("");
     txtPassword.setText("");
    }
    
    private void set1(){
        txtNama.setEditable(true);
        btnTambah.setEnabled(true);
        btnUbah.setEnabled(true);
        btnHapus.setEnabled(true);
        btnTransaksi.setEnabled(false);
        btnUser.setEnabled(false);
    }
    
     public void setDefaultTableModel(){
        tblModel.getDataVector().removeAllElements();
        tblModel.fireTableDataChanged();
        
        try{
            koneksi knks = new koneksi();
            Connection con = knks.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM login";
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
                data[0] = res.getString("username");
                data[1] = res.getString("email");
                data[2] = res.getString("jenkel");
                data[3] = res.getString("password");
                data[4] = res.getString("hak_akses");
                tblModel.addRow(data);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
    }
    }
     
     
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlSidebar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnUser = new rojerusan.RSButtonIconI();
        btnTransaksi = new rojerusan.RSButtonIconI();
        btnHome = new rojerusan.RSButtonIconI();
        parentPanel = new javax.swing.JPanel();
        CardLayOutHome = new javax.swing.JPanel();
        lblTanggal = new javax.swing.JLabel();
        lblWaktu = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblUserLogin = new javax.swing.JLabel();
        CardLayOutUser = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        rbPria = new javax.swing.JRadioButton();
        rbWanita = new javax.swing.JRadioButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        btnBatal = new javax.swing.JButton();
        rbManager = new javax.swing.JRadioButton();
        rbAdmin = new javax.swing.JRadioButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/background.jpg"));
        Image image = icon.getImage();
        jDesktopTransaksi = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        JPanel1 = new javax.swing.JPanel();
        pnlBarang = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pnlCustomer = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        akunperkiraan = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        pnlLaporan = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        pnlKas = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        pnlPenjualan = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        btnPengiriman = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        pnlPenerimakas = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        pnlJurnal = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        btnCalculator = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        chekbokBarang = new javax.swing.JCheckBoxMenuItem();
        chekbokCustomer = new javax.swing.JCheckBoxMenuItem();
        cbxMasterAkun = new javax.swing.JCheckBoxMenuItem();
        cbxPesanan = new javax.swing.JCheckBoxMenuItem();
        cbxPenjualan = new javax.swing.JCheckBoxMenuItem();
        cbxPengiriman = new javax.swing.JCheckBoxMenuItem();
        jmLaporan = new javax.swing.JMenu();
        cbxLaporan = new javax.swing.JCheckBoxMenuItem();
        cbxKas = new javax.swing.JCheckBoxMenuItem();
        jmPengaturan = new javax.swing.JMenu();
        cbKeluar = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Penjualan - PT. Sugimoto Presisi Technologi");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/image/icon sugimoto.png")).getImage());

        pnlSidebar.setBackground(new java.awt.Color(72, 126, 176));
        pnlSidebar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(72, 126, 176));

        btnUser.setBackground(new java.awt.Color(204, 204, 204));
        btnUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_add_user_group_man_man_30px.png"))); // NOI18N
        btnUser.setText("Add User");
        btnUser.setColorHover(new java.awt.Color(204, 204, 204));
        btnUser.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnTransaksi.setBackground(new java.awt.Color(72, 126, 176));
        btnTransaksi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_transaction_list_30px.png"))); // NOI18N
        btnTransaksi.setText("Menu");
        btnTransaksi.setColorHover(new java.awt.Color(204, 204, 204));
        btnTransaksi.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnTransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(72, 126, 176));
        btnHome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_home_filled_30px_1.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.setColorHover(new java.awt.Color(204, 204, 204));
        btnHome.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnHome.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(479, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        parentPanel.setBackground(new java.awt.Color(51, 255, 255));
        parentPanel.setLayout(new java.awt.CardLayout());

        CardLayOutHome.setBackground(new java.awt.Color(72, 126, 176));

        lblTanggal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTanggal.setText("Day/Date :");

        lblWaktu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblWaktu.setText("Time :");

        jPanel11.setBackground(new java.awt.Color(72, 126, 176));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/11111.png"))); // NOI18N
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 130));

        jPanel12.setBackground(new java.awt.Color(72, 126, 176));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel3.setBackground(new java.awt.Color(51, 255, 204));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PT. Sugimoto Presisi Technologi");

        jLabel4.setBackground(new java.awt.Color(51, 255, 204));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manufacturing, Dies, Jig, Fixtures, Machining, Fabrication, Specialist Precision Parts and Plating Proccess");

        jLabel5.setBackground(new java.awt.Color(51, 255, 204));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Jl. Raya Perumahan Villa Mutiara Cikarang, Kp. Kukun, Ciantra, Cikarang Selatan Bekasi 17550");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 0, -1, -1));

        jPanel5.setBackground(new java.awt.Color(72, 126, 176));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Produk-4 (1).png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 160, 162));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Produk-1.png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 160, 162));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Produk-2.png"))); // NOI18N
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 160, -1));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Produk-3.png"))); // NOI18N
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 170, 162));

        jPanel11.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, 190));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel11.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 150, 760, 230));

        lblUserLogin.setText("Manager");

        javax.swing.GroupLayout CardLayOutHomeLayout = new javax.swing.GroupLayout(CardLayOutHome);
        CardLayOutHome.setLayout(CardLayOutHomeLayout);
        CardLayOutHomeLayout.setHorizontalGroup(
            CardLayOutHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardLayOutHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CardLayOutHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CardLayOutHomeLayout.createSequentialGroup()
                        .addComponent(lblUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CardLayOutHomeLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 71, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CardLayOutHomeLayout.setVerticalGroup(
            CardLayOutHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardLayOutHomeLayout.createSequentialGroup()
                .addGroup(CardLayOutHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        parentPanel.add(CardLayOutHome, "card2");

        CardLayOutUser.setBackground(new java.awt.Color(72, 126, 176));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "From User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("Nama");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Alamat");

        lblPassword.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblPassword.setText("Password");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel16.setText("Email");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel17.setText("Jenis Kelamin");

        rbPria.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(rbPria);
        rbPria.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rbPria.setText("Laki-laki");

        rbWanita.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(rbWanita);
        rbWanita.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rbWanita.setText("Perempuan");

        btnTambah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama", "Email", "Jenis Kelamin", "Password", "Hak Akses"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        btnBatal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        rbManager.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup2.add(rbManager);
        rbManager.setText("Manager");

        rbAdmin.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup2.add(rbAdmin);
        rbAdmin.setText("Admin");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbPria)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbWanita))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbManager, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rbAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbPria)
                            .addComponent(rbWanita))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbManager)
                            .addComponent(rbAdmin))))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CardLayOutUserLayout = new javax.swing.GroupLayout(CardLayOutUser);
        CardLayOutUser.setLayout(CardLayOutUserLayout);
        CardLayOutUserLayout.setHorizontalGroup(
            CardLayOutUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardLayOutUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CardLayOutUserLayout.setVerticalGroup(
            CardLayOutUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardLayOutUserLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        parentPanel.add(CardLayOutUser, "card4");

        JPanel1.setBackground(new java.awt.Color(38, 224, 174));
        JPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray), "Data Master", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        JPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        pnlBarang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        pnlBarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBarangMouseClicked(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/product_documents_100px.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Barang");

        javax.swing.GroupLayout pnlBarangLayout = new javax.swing.GroupLayout(pnlBarang);
        pnlBarang.setLayout(pnlBarangLayout);
        pnlBarangLayout.setHorizontalGroup(
            pnlBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBarangLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBarangLayout.setVerticalGroup(
            pnlBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarangLayout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JPanel1.add(pnlBarang);

        pnlCustomer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        pnlCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCustomerMouseClicked(evt);
            }
        });

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_customer_insight_100px.png"))); // NOI18N

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Customer");

        javax.swing.GroupLayout pnlCustomerLayout = new javax.swing.GroupLayout(pnlCustomer);
        pnlCustomer.setLayout(pnlCustomerLayout);
        pnlCustomerLayout.setHorizontalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCustomerLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel47))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCustomerLayout.setVerticalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerLayout.createSequentialGroup()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JPanel1.add(pnlCustomer);

        akunperkiraan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        akunperkiraan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        akunperkiraan.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                akunperkiraanAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        akunperkiraan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                akunperkiraanMouseClicked(evt);
            }
        });

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_checklist_100px.png"))); // NOI18N

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Akun Perkiraan");

        javax.swing.GroupLayout akunperkiraanLayout = new javax.swing.GroupLayout(akunperkiraan);
        akunperkiraan.setLayout(akunperkiraanLayout);
        akunperkiraanLayout.setHorizontalGroup(
            akunperkiraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(akunperkiraanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(akunperkiraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        akunperkiraanLayout.setVerticalGroup(
            akunperkiraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, akunperkiraanLayout.createSequentialGroup()
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JPanel1.add(akunperkiraan);

        pnlLaporan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        pnlLaporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLaporanMouseClicked(evt);
            }
        });

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_accounting_100px_3.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Lap. Penjualan");

        javax.swing.GroupLayout pnlLaporanLayout = new javax.swing.GroupLayout(pnlLaporan);
        pnlLaporan.setLayout(pnlLaporanLayout);
        pnlLaporanLayout.setHorizontalGroup(
            pnlLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLaporanLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLaporanLayout.setVerticalGroup(
            pnlLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLaporanLayout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JPanel1.add(pnlLaporan);

        pnlKas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        pnlKas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlKas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlKasMouseClicked(evt);
            }
        });

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cashflow_100px.png"))); // NOI18N

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Laporan Kas");

        javax.swing.GroupLayout pnlKasLayout = new javax.swing.GroupLayout(pnlKas);
        pnlKas.setLayout(pnlKasLayout);
        pnlKasLayout.setHorizontalGroup(
            pnlKasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlKasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlKasLayout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlKasLayout.setVerticalGroup(
            pnlKasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKasLayout.createSequentialGroup()
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JPanel1.add(pnlKas);

        jPanel15.setBackground(new java.awt.Color(38, 224, 174));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray), "Data Transaksi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        pnlPenjualan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        pnlPenjualan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlPenjualan.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlPenjualanAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        pnlPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPenjualanMouseClicked(evt);
            }
        });

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_sales_performance_100px_1.png"))); // NOI18N

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Penjualan");

        javax.swing.GroupLayout pnlPenjualanLayout = new javax.swing.GroupLayout(pnlPenjualan);
        pnlPenjualan.setLayout(pnlPenjualanLayout);
        pnlPenjualanLayout.setHorizontalGroup(
            pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel41))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPenjualanLayout.setVerticalGroup(
            pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPenjualanLayout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel15.add(pnlPenjualan);

        btnPengiriman.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnPengiriman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPengiriman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPengirimanMouseClicked(evt);
            }
        });

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_delivery_100px.png"))); // NOI18N

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Pengiriman");

        javax.swing.GroupLayout btnPengirimanLayout = new javax.swing.GroupLayout(btnPengiriman);
        btnPengiriman.setLayout(btnPengirimanLayout);
        btnPengirimanLayout.setHorizontalGroup(
            btnPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPengirimanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnPengirimanLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel37))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPengirimanLayout.setVerticalGroup(
            btnPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPengirimanLayout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel15.add(btnPengiriman);

        pnlPenerimakas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        pnlPenerimakas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlPenerimakas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPenerimakasMouseClicked(evt);
            }
        });

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cash_in_hand_100px.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Penerimaan Kas");

        javax.swing.GroupLayout pnlPenerimakasLayout = new javax.swing.GroupLayout(pnlPenerimakas);
        pnlPenerimakas.setLayout(pnlPenerimakasLayout);
        pnlPenerimakasLayout.setHorizontalGroup(
            pnlPenerimakasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPenerimakasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPenerimakasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPenerimakasLayout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPenerimakasLayout.setVerticalGroup(
            pnlPenerimakasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPenerimakasLayout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel15.add(pnlPenerimakas);

        pnlJurnal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        pnlJurnal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlJurnal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlJurnalMouseClicked(evt);
            }
        });

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_journal_100px_1.png"))); // NOI18N

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Jurnal");

        javax.swing.GroupLayout pnlJurnalLayout = new javax.swing.GroupLayout(pnlJurnal);
        pnlJurnal.setLayout(pnlJurnalLayout);
        pnlJurnalLayout.setHorizontalGroup(
            pnlJurnalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJurnalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJurnalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlJurnalLayout.setVerticalGroup(
            pnlJurnalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJurnalLayout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel15.add(pnlJurnal);

        btnCalculator.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnCalculator.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalculator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCalculatorMouseClicked(evt);
            }
        });

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_calculator_100px.png"))); // NOI18N

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Calculator");

        javax.swing.GroupLayout btnCalculatorLayout = new javax.swing.GroupLayout(btnCalculator);
        btnCalculator.setLayout(btnCalculatorLayout);
        btnCalculatorLayout.setHorizontalGroup(
            btnCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCalculatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnCalculatorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel59))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnCalculatorLayout.setVerticalGroup(
            btnCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCalculatorLayout.createSequentialGroup()
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel15.add(btnCalculator);

        jDesktopTransaksi.setLayer(JPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopTransaksi.setLayer(jPanel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopTransaksiLayout = new javax.swing.GroupLayout(jDesktopTransaksi);
        jDesktopTransaksi.setLayout(jDesktopTransaksiLayout);
        jDesktopTransaksiLayout.setHorizontalGroup(
            jDesktopTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopTransaksiLayout.setVerticalGroup(
            jDesktopTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopTransaksiLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        parentPanel.add(jDesktopTransaksi, "card5");

        jMenuBar1.setBackground(new java.awt.Color(102, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jMenuBar1.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jmFile.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jmFile.setText("Master Data");

        chekbokBarang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        chekbokBarang.setSelected(true);
        chekbokBarang.setText("Barang");
        chekbokBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_commodity_30px_1.png"))); // NOI18N
        chekbokBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chekbokBarangActionPerformed(evt);
            }
        });
        jmFile.add(chekbokBarang);

        chekbokCustomer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        chekbokCustomer.setSelected(true);
        chekbokCustomer.setText("Customer");
        chekbokCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_customer_insight_30px.png"))); // NOI18N
        chekbokCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chekbokCustomerActionPerformed(evt);
            }
        });
        jmFile.add(chekbokCustomer);

        cbxMasterAkun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        cbxMasterAkun.setSelected(true);
        cbxMasterAkun.setText("Master Akun");
        cbxMasterAkun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_checklist_30px.png"))); // NOI18N
        cbxMasterAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMasterAkunActionPerformed(evt);
            }
        });
        jmFile.add(cbxMasterAkun);

        cbxPesanan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        cbxPesanan.setSelected(true);
        cbxPesanan.setText("Pesanan");
        cbxPesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_purchase_order_30px.png"))); // NOI18N
        cbxPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPesananActionPerformed(evt);
            }
        });
        jmFile.add(cbxPesanan);

        cbxPenjualan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        cbxPenjualan.setSelected(true);
        cbxPenjualan.setText("Penjualan");
        cbxPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sales_performance_30px.png"))); // NOI18N
        cbxPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPenjualanActionPerformed(evt);
            }
        });
        jmFile.add(cbxPenjualan);

        cbxPengiriman.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        cbxPengiriman.setSelected(true);
        cbxPengiriman.setText("Pengiriman");
        cbxPengiriman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delivery_30px.png"))); // NOI18N
        cbxPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPengirimanActionPerformed(evt);
            }
        });
        jmFile.add(cbxPengiriman);

        jMenuBar1.add(jmFile);

        jmLaporan.setText("Laporan");

        cbxLaporan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        cbxLaporan.setSelected(true);
        cbxLaporan.setText("Lap. Penjualan");
        cbxLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_report_card_30px_1.png"))); // NOI18N
        cbxLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLaporanActionPerformed(evt);
            }
        });
        jmLaporan.add(cbxLaporan);

        cbxKas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        cbxKas.setSelected(true);
        cbxKas.setText("Lap. Kas");
        cbxKas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_graph_report_30px.png"))); // NOI18N
        cbxKas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxKasActionPerformed(evt);
            }
        });
        jmLaporan.add(cbxKas);

        jMenuBar1.add(jmLaporan);

        jmPengaturan.setText("Pengaturan");

        cbKeluar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        cbKeluar.setSelected(true);
        cbKeluar.setText("Keluar");
        cbKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_login_rounded_right_30px.png"))); // NOI18N
        cbKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbKeluarMouseClicked(evt);
            }
        });
        cbKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKeluarActionPerformed(evt);
            }
        });
        jmPengaturan.add(cbKeluar);

        jMenuBar1.add(jmPengaturan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnlSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
       parentPanel.removeAll();
       parentPanel.add(CardLayOutHome);
       parentPanel.repaint();
       parentPanel.revalidate();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here: 
       parentPanel.removeAll();
       parentPanel.add(CardLayOutUser);
       parentPanel.repaint();
       parentPanel.revalidate();
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
       // TODO add your handling code here:
       parentPanel.removeAll();
       parentPanel.add(jDesktopTransaksi);
       parentPanel.repaint();
       parentPanel.revalidate();
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void cbKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbKeluarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKeluarMouseClicked

    private void cbKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKeluarActionPerformed
        // TODO add your handling code here:
       Login lgn = new Login();
       lgn.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_cbKeluarActionPerformed

    private void pnlPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPenjualanMouseClicked
        // TODO add your handling code here:
        Penjualan pb = null;
        try {
            pb = new Penjualan();
        } catch (SQLException ex) {
            Logger.getLogger(homeutama.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDesktopTransaksi.add(pb);
        pb.setVisible(true);
    }//GEN-LAST:event_pnlPenjualanMouseClicked

    private void pnlPenjualanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlPenjualanAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlPenjualanAncestorAdded

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try{
            Object[] options={"Hapus","Lihat Kembali"};
            int n=JOptionPane.showOptionDialog(null,"<html> Yakin <b><i>"
            +txtNama.getText()+" "+"</i></b> Akan Dihapus? </html>","Konfirmasi",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
            query.Hapus("login","username", txtNama.getText());
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            setDefaultTableModel();
            bersih();
                }
             }
                catch(Exception exc){
                            System.err.println(exc.getMessage());
             }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
         String jenkel="";
        if(rbPria.isSelected()){
            jenkel="Laki-laki";
        }else if (rbWanita.isSelected()){
            jenkel="Perempuan";
        }else{
            jenkel="";
        }
        
         String hk="";
        if(rbManager.isSelected()){
            hk="Manager";
        }else if (rbAdmin.isSelected()){
            hk="Admin";
        }else{
            hk="";
        }
        
        if(txtNama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Name is Still Empety", "Warning", JOptionPane.WARNING_MESSAGE );
            txtEmail.requestFocus();
        }else if(txtEmail.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Email is Sttill Empety", "Warning", JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
        }else if(jenkel.equals("")){
            JOptionPane.showMessageDialog(null, "Jenis Kelamin is Still Empety", "Warning", JOptionPane.WARNING_MESSAGE);
            txtPassword.requestFocus();
        }else if(lblPassword.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Password is Still Empety", "Warning", JOptionPane.WARNING_MESSAGE);
            rbManager.requestFocus();
        }else if(hk.equals("")){
            JOptionPane.showMessageDialog(null, "Hak AKses is Still Empety", "Warning", JOptionPane.WARNING_MESSAGE);
            rbManager.requestFocus();
        }else{
            try{
                Object[] options={"Simpan","Lihat Kembali"};
                int n=JOptionPane.showOptionDialog(null, "<html> Yakin <b><i>"
                    +txtNama.getText()+" "+"</i></b> akan simpan? </html>","Konfirmasi",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(n==javax.swing.JOptionPane.YES_OPTION){
                        query.InputDetail(kolom(), Data(), "login");
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                        setDefaultTableModel();
                        bersih();
                    }
                }catch(Exception exc){
                        System.err.println(exc.getMessage());                    
                }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        String jenkel="";
        if(rbPria.isSelected()){
            jenkel="Pria";
        }else if (rbWanita.isSelected()){
            jenkel="Wanita";
        }else{
            jenkel="";
        }
        
        String hk="";
        if(rbManager.isSelected()){
            hk="Manager";
        }else if (rbAdmin.isSelected()){
            hk="Admin";
        }else{
            hk="";
        }
        
        try{
            Object[] options={"Ubah","Lihat Kembali"};
            int n=JOptionPane.showOptionDialog(null,"<html> Yakin <b><i>"
            +txtNama.getText()+" "+"</i></b> Akan Diubah? </html> ","Konfirmasi",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(n==javax.swing.JOptionPane.YES_OPTION)
            {
            query.Edit(kolom(), Data(), "login","username",txtNama.getText());
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
             bersih();
            setDefaultTableModel();
                }
        }catch(Exception exc){
         System.err.println(exc.getMessage());
                }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        try{
            int row=Table.rowAtPoint(evt.getPoint());
            
            String Nama = Table.getValueAt(row,0).toString();
            String Email = Table.getValueAt(row,1).toString();
            String Password = Table.getValueAt(row,3).toString();
            
            txtNama.setText(String.valueOf(Nama));
            txtEmail.setText(String.valueOf(Email));
            txtPassword.setText(String.valueOf(Password));
            btnTambah.setEnabled(true);
            btnUbah.setEnabled(true);
            btnHapus.setEnabled(true);
           
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_TableMouseClicked

    private void btnPengirimanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengirimanMouseClicked
        // TODO add your handling code here:
        Pengiriman Pr = null;
        Pr = new Pengiriman();
        jDesktopTransaksi.add(Pr);
        Pr.setVisible(true);
    }//GEN-LAST:event_btnPengirimanMouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        bersih();
        set1();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void chekbokCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chekbokCustomerActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
        {
        public void run()
        {
         PopupCustomer dialog=new PopupCustomer(new javax.swing.JFrame(),true);
         dialog.setVisible(true);
         if(dialog.getData()[0].toString().equals(""))
         {
        
         }
        else 
        {
       }
    }
        });
    }//GEN-LAST:event_chekbokCustomerActionPerformed

    private void chekbokBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chekbokBarangActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
        {
        public void run()
        {
         PopupBarang dialog=new PopupBarang(new javax.swing.JFrame(),true);
         dialog.setVisible(true);
         if(dialog.getData()[0].toString().equals(""))
         {
        
         }
        else 
        {
       }
    }
        });
    }//GEN-LAST:event_chekbokBarangActionPerformed

    private void pnlBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarangMouseClicked
        // TODO add your handling code here:
        Barang Br = null;
        Br = new Barang();
        jDesktopTransaksi.add(Br);
        Br.setVisible(true);
    }//GEN-LAST:event_pnlBarangMouseClicked

    private void pnlCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCustomerMouseClicked
        // TODO add your handling code here:
        Customer Br = null;
        Br = new Customer();
        jDesktopTransaksi.add(Br);
        Br.setVisible(true);
    }//GEN-LAST:event_pnlCustomerMouseClicked

    private void akunperkiraanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_akunperkiraanAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_akunperkiraanAncestorAdded

    private void akunperkiraanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_akunperkiraanMouseClicked
        // TODO add your handling code here:
        masterakun Br = null;
        Br = new masterakun();
        jDesktopTransaksi.add(Br);
        Br.setVisible(true);
    }//GEN-LAST:event_akunperkiraanMouseClicked

    private void pnlLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLaporanMouseClicked
        // TODO add your handling code here:
        laporan1 lp = null;
        lp = new laporan1();
        jDesktopTransaksi.add(lp);
        lp.setVisible(true);
    }//GEN-LAST:event_pnlLaporanMouseClicked

    private void btnCalculatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalculatorMouseClicked
        // TODO add your handling code here:
        Calculator cl = null;
        cl = new Calculator();
        jDesktopTransaksi.add(cl);
        cl.setVisible(true);
    }//GEN-LAST:event_btnCalculatorMouseClicked

    private void cbxMasterAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMasterAkunActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
        {
        public void run()
        {
         PopupMasterAkun dialog=new PopupMasterAkun(new javax.swing.JFrame(),true);
         dialog.setVisible(true);
         if(dialog.getData()[0].toString().equals(""))
         {
        
         }
        else 
        {
       }
    }
        });
    }//GEN-LAST:event_cbxMasterAkunActionPerformed

    private void cbxPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPesananActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
        {
        public void run()
        {
         PopupPesanan dialog=new PopupPesanan(new javax.swing.JFrame(),true);
         dialog.setVisible(true);
         if(dialog.getData()[0].toString().equals(""))
         {
        
         }
        else 
        {
       }
    }
        });
    }//GEN-LAST:event_cbxPesananActionPerformed

    private void pnlJurnalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlJurnalMouseClicked
        // TODO add your handling code here:
        Jurnal Br = null;
        Br = new Jurnal();
        jDesktopTransaksi.add(Br);
        Br.setVisible(true);
    }//GEN-LAST:event_pnlJurnalMouseClicked

    private void cbxPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPenjualanActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
        {
        public void run()
        {
         PopupPenjualan dialog = null;
            try {
                dialog = new PopupPenjualan(new javax.swing.JFrame(),true);
            } catch (SQLException ex) {
                Logger.getLogger(homeutama.class.getName()).log(Level.SEVERE, null, ex);
            }
         dialog.setVisible(true);
         if(dialog.getData()[0].toString().equals(""))
         {
        
         }
        else 
        {
       }
    }
        });
    }//GEN-LAST:event_cbxPenjualanActionPerformed

    private void cbxPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPengirimanActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
        {
        public void run()
        {
         PopupPengiriman dialog=new PopupPengiriman(new javax.swing.JFrame(),true);
         dialog.setVisible(true);
         if(dialog.getData()[0].toString().equals(""))
         {
        
         }
        else 
        {
       }
    }
        });
    }//GEN-LAST:event_cbxPengirimanActionPerformed

    private void pnlPenerimakasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPenerimakasMouseClicked
        // TODO add your handling code here:
        PenerimaanKas pk = null;
        pk = new PenerimaanKas();
        jDesktopTransaksi.add(pk);
        pk.setVisible(true);
    }//GEN-LAST:event_pnlPenerimakasMouseClicked

    private void cbxLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLaporanActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
        {
        public void run()
        {
         laporan2 dialog=new laporan2(new javax.swing.JFrame(),true);
         dialog.setVisible(true);
    }
        });
    }//GEN-LAST:event_cbxLaporanActionPerformed

    private void pnlKasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKasMouseClicked
        // TODO add your handling code here:
        kas ks = null;
        ks = new kas();
        jDesktopTransaksi.add(ks);
        ks.setVisible(true);
    }//GEN-LAST:event_pnlKasMouseClicked

    private void cbxKasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxKasActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable()
        {
        public void run()
        {
         kas1 dialog=new kas1(new javax.swing.JFrame(),true);
         dialog.setVisible(true);
    }
        });
    }//GEN-LAST:event_cbxKasActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(homeutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homeutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homeutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homeutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homeutama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardLayOutHome;
    private javax.swing.JPanel CardLayOutUser;
    private javax.swing.JPanel JPanel1;
    private javax.swing.JTable Table;
    private javax.swing.JPanel akunperkiraan;
    private javax.swing.JButton btnBatal;
    private javax.swing.JPanel btnCalculator;
    private javax.swing.JButton btnHapus;
    private rojerusan.RSButtonIconI btnHome;
    private javax.swing.JPanel btnPengiriman;
    private javax.swing.JButton btnTambah;
    private rojerusan.RSButtonIconI btnTransaksi;
    private javax.swing.JButton btnUbah;
    private rojerusan.RSButtonIconI btnUser;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBoxMenuItem cbKeluar;
    private javax.swing.JCheckBoxMenuItem cbxKas;
    private javax.swing.JCheckBoxMenuItem cbxLaporan;
    private javax.swing.JCheckBoxMenuItem cbxMasterAkun;
    private javax.swing.JCheckBoxMenuItem cbxPengiriman;
    private javax.swing.JCheckBoxMenuItem cbxPenjualan;
    private javax.swing.JCheckBoxMenuItem cbxPesanan;
    private javax.swing.JCheckBoxMenuItem chekbokBarang;
    private javax.swing.JCheckBoxMenuItem chekbokCustomer;
    private javax.swing.JDesktopPane jDesktopTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenu jmLaporan;
    private javax.swing.JMenu jmPengaturan;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblUserLogin;
    private javax.swing.JLabel lblWaktu;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel pnlBarang;
    private javax.swing.JPanel pnlCustomer;
    private javax.swing.JPanel pnlJurnal;
    private javax.swing.JPanel pnlKas;
    private javax.swing.JPanel pnlLaporan;
    private javax.swing.JPanel pnlPenerimakas;
    private javax.swing.JPanel pnlPenjualan;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JRadioButton rbAdmin;
    private javax.swing.JRadioButton rbManager;
    private javax.swing.JRadioButton rbPria;
    private javax.swing.JRadioButton rbWanita;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
