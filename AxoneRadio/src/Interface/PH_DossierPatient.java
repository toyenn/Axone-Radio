// A FAIRE ici : 

// rajouter un bouton modifier pour les infos administratives ? et du coup une interface pour ca

// rajouter un bouton modifier pour les examens selectionnées

//creer une méthode qui permet de mettre a jour l'affichage du tableau des examens comme ca a chaque fois quil y a une modif comme un ajout dexam on apelle cete méthode ou encore quand on clic sur le bouton "examssans compte rendu"

// ajouter des boutons retour la et dans les autres pages
package Interface;

import FC.Patient;
import FC.Professionnel;
import FC.Services;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ndeyeawagaye
 */
public class PH_DossierPatient extends javax.swing.JFrame {

    /**
     * Creates new form PagePH
     */
    public PH_DossierPatient() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);// PERMET DE CENTRER LA FENETRE
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
        jPanel3 = new javax.swing.JPanel();
        prenompatient = new javax.swing.JLabel();
        numeropatient = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        datepatient = new javax.swing.JLabel();
        genrepatient = new javax.swing.JLabel();
        nompatient = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        servicepatient = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        adressepatient = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableExamens = new javax.swing.JTable();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonCreerExam = new javax.swing.JButton();
        buttonDMR = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textnom = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        textprenom = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        textfonction = new javax.swing.JLabel();
        buttonDeco = new javax.swing.JButton();
        buttonPara = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        buttonRetour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 204)));
        jPanel3.setForeground(new java.awt.Color(0, 51, 255));

        prenompatient.setBackground(new java.awt.Color(255, 255, 255));
        prenompatient.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 13)); // NOI18N
        prenompatient.setText("Nathan");

        numeropatient.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 13)); // NOI18N
        numeropatient.setText("N°13456789");

        jLabel9.setBackground(new java.awt.Color(0, 51, 255));
        jLabel9.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("Infos administratives");

        datepatient.setBackground(new java.awt.Color(255, 255, 255));
        datepatient.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 13)); // NOI18N
        datepatient.setText("12/12/97");

        genrepatient.setBackground(new java.awt.Color(255, 255, 255));
        genrepatient.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 13)); // NOI18N
        genrepatient.setText("M");

        nompatient.setBackground(new java.awt.Color(255, 255, 255));
        nompatient.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 13)); // NOI18N
        nompatient.setText("Toyen");

        jLabel3.setText("Prénom :");

        jLabel6.setText("Nom : ");

        jLabel13.setText("Date de naissance :");

        jLabel15.setText("Genre : ");

        jLabel16.setText("Service actuel :");

        servicepatient.setBackground(new java.awt.Color(255, 255, 255));
        servicepatient.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 13)); // NOI18N
        servicepatient.setText("Cardiologie, Aile B");

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel29.setText("adresse");

        adressepatient.setBackground(new java.awt.Color(255, 255, 255));
        adressepatient.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        adressepatient.setText("10 avenue de valmy");

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel25.setText("Id :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(servicepatient, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datepatient, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(genrepatient, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adressepatient, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prenompatient, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nompatient, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(numeropatient, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(153, 153, 153)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 119, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeropatient, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(prenompatient, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(nompatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(datepatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(genrepatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(adressepatient))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicepatient)
                    .addComponent(jLabel16))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 51, 255)));

        jScrollPane3.setBorder(null);

        tableExamens.setAutoCreateRowSorter(true);
        tableExamens.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tableExamens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"000001", "IRM", "12/02/2019 20:00", "Foucher", null, "non"},
                {"000002", "IRM", "11/02/2019 20:00", "Foucher", "Point au niveau du cortex", ""},
                {"000003", "Scanner", "11/02/2019 17:00", "Gina", "Agravation de la tumeur", "oui"},
                {"000004", "IRM", "08/02/2019 18:00", "Foucher", null, "oui"},
                {"000005", "IRM", "05/02/2019 15:00", "Foucher", null, "oui"},
                {"000006", "Scanner", "05/02/2019 13:00", "Gina", null, "oui"}
            },
            new String [] {
                "Numéro archivage", "Type d'examen", "Date et heure", "Nom du PH", "Commentaires", "Compte rendu ?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableExamens.setGridColor(new java.awt.Color(234, 239, 249));
        tableExamens.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tableExamensAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tableExamens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableExamensMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableExamens);

        jCheckBox2.setText("Afficher uniquement les Examens sans compte rendu");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(0, 51, 255));
        jLabel14.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 204));
        jLabel14.setText("Liste Examens");

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Dossier médical radiologique");

        buttonCreerExam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DMR.png"))); // NOI18N
        buttonCreerExam.setText("Créer Examen");

        buttonDMR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/valider.png"))); // NOI18N
        buttonDMR.setText("Valider ");
        buttonDMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDMRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCreerExam, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonDMR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(jCheckBox2)
                        .addGap(8, 8, 8)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCreerExam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDMR))
                        .addGap(2, 2, 2)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonCreerExam, buttonDMR});

        jLabel1.setText("Nom :");

        textnom.setText("jLabel7");

        jLabel19.setText("Prénom :");

        textprenom.setText("jLabel14");

        jLabel21.setText("Fonction :");

        textfonction.setText("jLabel16");

        buttonDeco.setText("Déconnection");

        buttonPara.setText("Parametres");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/medecin.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textnom, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(textprenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textfonction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(buttonPara)
                        .addGap(32, 32, 32)
                        .addComponent(buttonDeco)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textnom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(textprenom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfonction)))
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPara)
                    .addComponent(buttonDeco))
                .addContainerGap())
        );

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icone.jpg"))); // NOI18N
        jLabel24.setText("jLabel8");

        buttonRetour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logoRetour.png"))); // NOI18N
        buttonRetour.setText("Retour");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonRetour)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableExamensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableExamensMouseClicked
        // TODO add your handling code here:
        //setbtableExamens.getSelectedRow()
    }//GEN-LAST:event_tableExamensMouseClicked

    private void tableExamensAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tableExamensAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tableExamensAncestorAdded

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void buttonDMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDMRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDMRActionPerformed

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
            java.util.logging.Logger.getLogger(PH_DossierPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PH_DossierPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PH_DossierPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PH_DossierPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PH_DossierPatient().setVisible(true);
            }
        });
    }
    
  

     
   public javax.swing.JButton getButtonCreerExamen() { // bouton recherche par service
        return getButtonCreerExam();
    }

   public javax.swing.JTable getTableExamens() { // bouton recherche par service
        return tableExamens;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adressepatient;
    private javax.swing.JButton buttonCreerExam;
    private javax.swing.JButton buttonDMR;
    private javax.swing.JButton buttonDeco;
    private javax.swing.JButton buttonPara;
    private javax.swing.JButton buttonRetour;
    private javax.swing.JLabel datepatient;
    private javax.swing.JLabel genrepatient;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nompatient;
    private javax.swing.JLabel numeropatient;
    private javax.swing.JLabel prenompatient;
    private javax.swing.JLabel servicepatient;
    private javax.swing.JTable tableExamens;
    private javax.swing.JLabel textfonction;
    private javax.swing.JLabel textnom;
    private javax.swing.JLabel textprenom;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the buttonCreerExam
     */
    public javax.swing.JButton getButtonCreerExam() {
        return buttonCreerExam;
    }


    /**
     * @return the buttonVal
     */
    public javax.swing.JButton getButtonVal() {
        return buttonDMR;
    }

    /**
     * @return the buttonRetour
     */
//    public javax.swing.JButton getButtonRetour() {
//        return buttonRetour;
//    }

    public JCheckBox getButtoncocher() {
        return jCheckBox2;
    }
    
    
    public void ActualiserInfosPatient(Services S,Patient p){
        numeropatient.setText(String.valueOf(p.getid()));
        nompatient.setText(p.getNom());
        prenompatient.setText(p.getPrénom());
        datepatient.setText(p.getDate().toString_DateNaissance());
        genrepatient.setText(p.getGenre());
        adressepatient.setText(S.getNomService(p.getService()));
        ActualiserDMRPatient(S,p);
        
    }
    public void ActualiserDMRPatient(Services S,Patient p){
        DefaultTableModel dtm = new DefaultTableModel(0, 6);

        for (int i = 0; i < p.getDMR().getListeExamens().size(); i++) {
            if(jCheckBox2.isSelected()){
                if(p.getDMR().getListeExamens().get(i).getCr().getEtat().toString().equals("nonecrit")){
                    Object[] data = new Object[6];
                    data[0] = p.getDMR().getListeExamens().get(i).getIdExamen();
                    data[1] = p.getDMR().getListeExamens().get(i).getType().getName();
                   data[2] = p.getDMR().getListeExamens().get(i).getDate().toString();
                   data[3] = p.getDMR().getListeExamens().get(i).getPHresponsable().toString();
                  data[4] = p.getDMR().getListeExamens().get(i).getCr().getEtat().toString();
                  data[5] = S.getNomService(p.getDMR().getListeExamens().get(i).getService());
                  dtm.addRow(data);
                }
            }
            else{
            Object[] data = new Object[6];
            data[0] = p.getDMR().getListeExamens().get(i).getIdExamen();
            data[1] = p.getDMR().getListeExamens().get(i).getType().getName();
            data[2] = p.getDMR().getListeExamens().get(i).getDate().toString();
            data[3] = p.getDMR().getListeExamens().get(i).getPHresponsable().toString();
            data[4] = p.getDMR().getListeExamens().get(i).getCr().getEtat().toString();
            data[5] = S.getNomService(p.getDMR().getListeExamens().get(i).getService());
            dtm.addRow(data);
            }
            

        }

        tableExamens.setModel(dtm);
        for (int i = 0; i < tableExamens.getColumnCount(); i++) {
            Class<?> col_class = tableExamens.getColumnClass(i);
            tableExamens.setDefaultEditor(col_class, null);
        }
        tableExamens.getColumnModel().getColumn(0).setHeaderValue("ID");
        tableExamens.getColumnModel().getColumn(1).setHeaderValue("Type");
        tableExamens.getColumnModel().getColumn(2).setHeaderValue("Date");
        tableExamens.getColumnModel().getColumn(3).setHeaderValue("PH");
        tableExamens.getColumnModel().getColumn(4).setHeaderValue("Compte rendu");
        tableExamens.getColumnModel().getColumn(5).setHeaderValue("Service demandeur");
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm);
        tableExamens.setRowSorter(sorter);
    }
    
    public void ActualiserInfosPro(Professionnel pro){
        textnom.setText(pro.getNom());
        textprenom.setText(pro.getPrenom());
        textfonction.setText(pro.getService());
        
    }

    /**
     * @return the buttonPara
     */
    public javax.swing.JButton getButtonPara() {
        return buttonPara;
    }

    /**
     * @return the buttonDeco
     */
    public javax.swing.JButton getButtonDeco() {
        return buttonDeco;
    }

    /**
     * @return the buttonRetour
     */
    public javax.swing.JButton getButtonRetour() {
        return buttonRetour;
    }
}
