/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinfomationsystem;

import Database.DBAction;
import Database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import main.Globals;
import studentinfomationclass.Admin;
import studentinfomationclass.Department;
import studentinfomationclass.Student;

/**
 *
 * @author PQD
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        setTitle("Quản lí sinh viên");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passTextField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tài khoản");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Mật khẩu");

        loginButton.setText("Đăng nhập");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Thoát");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameTextField)
                    .addComponent(passTextField)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(exitButton))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng nhập");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        String str = usernameTextField.getText();
        String str2 = passTextField.getText();

        if(!DBAction.isExist("sinhvien","mssv", str) && !DBAction.isExist("admin","id", str))
            JOptionPane.showMessageDialog(null, "UserName sai hoặc không tồn tại", "Lỗi đăng nhập", JOptionPane.OK_OPTION);
        else if (str.equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập UserName" + " hoặc Password!", "Lỗi đăng nhập", JOptionPane.OK_OPTION);
        }else{
            if(DBAction.isExist("admin", "id", str)){
                Admin ad1 = DBAction.selectAdmin("id", str);
                if(str2.equals(ad1.getPassword())){
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công.", "Đăng nhập thành công.", JOptionPane.INFORMATION_MESSAGE);

                    setVisible(false);
                    TabbedFrame tf = new TabbedFrame();

                    Admin_addPoint ad = new Admin_addPoint();
                        //ad.setVisible(true);
                    tf.addTab("Admin", ad);
                    ad.query_1();
                        //dk.setVisible(true);
                    tf.show();
                }else
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc tài khoản", "Lỗi đăng nhập.", JOptionPane.OK_OPTION);
            }
            
            
            
            if(DBAction.isExist("sinhvien", "mssv", str)){
                Student std1 = DBAction.selectStudent("mssv", str);
                if(str2.equals(std1.getPassStu())){
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công.", "Đăng nhập thành công.", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    TabbedFrame tf = new TabbedFrame();

                    DangKiHocPhan dk = new DangKiHocPhan();
                    TraCuuHocPhan tchp = new TraCuuHocPhan();
                    ThongTinSinhVien ttsv = new ThongTinSinhVien();
                    XemDiemSinhVien xdsv = new XemDiemSinhVien();
                    
                    

                    tf.addTab("Đăng ký học phần", dk);
                    tf.addTab("Tra cứu học phần", tchp);
                    tf.addTab("Thông tin sinh viên", ttsv);
                    tf.addTab("Điểm Thi", xdsv);
                    
                    tchp.setId(usernameTextField.getText());
                    dk.setID(usernameTextField.getText());
                    dk.setTypeTS(std1.getTrainningSys());
                    dk.query_2();
                    ttsv.setInformation(std1.getNameStu(), std1.getIdStu(), std1.getBirthday(), std1.getDpm().getNameDpm(), std1.getCourse(), std1.getTrainningSys(), std1.getAddresStu());
                    ttsv.getPass(std1.getPassStu(), std1.getIdStu());
                    xdsv.setMssv(std1.getIdStu());
                    xdsv.setInformation();
                    
                    tf.show();
            }else
                JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc tài khoản", "Lỗi đăng nhập.", JOptionPane.OK_OPTION);
            
            }
            
            
        }
                                    
    }//GEN-LAST:event_loginButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    
    protected Student std;
    private String txt_Type;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passTextField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
