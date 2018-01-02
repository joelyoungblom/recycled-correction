package recycledcorrection;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.lang.Math;

public class RecycleCorrectorGUI extends javax.swing.JFrame implements ActionListener {
    
    public RecycleCorrectorGUI(RecycleCorrector r) {
        
        formatter = new DecimalFormat("##0.0");

        initComponents();
        buildAndShowGUI();
        buildResultsPanel();
        buildResultsDialog();
        rc = r;
    }
    
    private void buildResultsPanel() {
        densityTestJTextArea = new JTextArea("Test                     Dry                       Percent                Percent               Proctor                Corrected             Percent              Specified\nNumber              Density (pcf)      Natural                 Recycled            Number               Density (pcf)       Compaction      Compaction       Remarks\n===============================================================================================================\n");
        densityTestJTextArea.setPreferredSize(new Dimension(800,400));
//        densityTestJTextArea.setEditable(false);
        densityTestJTextArea.setBorder(BorderFactory.createTitledBorder("Density Test Results"));

        proctorJTextArea = new JTextArea("Proctor               Max Dry                Percent              Percent                 Proctor                 Type of\nNumber             Density (pcf)       Natural               Recycled              Method                 Sample               Description\n===============================================================================================================\n");
        proctorJTextArea.setPreferredSize(new Dimension(800,200));
//        proctorJTextArea.setEditable(false);
        proctorJTextArea.setBorder(BorderFactory.createTitledBorder("Proctor Information"));
        
        resultsJPanel = new JPanel(new BorderLayout());
        resultsJPanel.add(densityTestJTextArea, BorderLayout.CENTER);
        resultsJPanel.add(proctorJTextArea, BorderLayout.SOUTH);
    }
    
    private void buildAndShowGUI() {
        JLabel numberOfTestLabel = new JLabel("Density Test Number");
        JLabel dryDensityOfTestLabel = new JLabel("Dry Density");
        JLabel percentNaturalGravelOfTestLabel = new JLabel("% Natural Gravel");
        JLabel percentRecycledGravelOfTestLabel = new JLabel("% Recycled Gravel");
        JLabel numberOfProctorLabel = new JLabel("Proctor Test Number");
        JLabel dryDensityOfProctorLabel = new JLabel("Maximum Dry Density");
        JLabel percentNaturalGravelOfProctorLabel = new JLabel("% Natural Gravel");
        JLabel percentRecycledGravelOfProctorLabel = new JLabel("% Recycled Gravel");
        
        JLabel specifiedCompactionLabel = new JLabel("Spec Compaction");
        JLabel proctorMethodLabel = new JLabel("Proctor Method");
        JLabel typeOfSampleLabel = new JLabel("Material Type");
        JLabel classificationOfSampleLabel = new JLabel("Classification");

        JLabel specificGravityOfNaturalGravelLabel = new JLabel("SG of Natural Gravel");
        JLabel specificGravityOfRecycledGravelLabel = new JLabel("SG of Recycled Gravel");

        JPanel southJPanel = new JPanel();
        southJPanel.add(submitJButton);
        southJPanel.add(clearJButton);
        southJPanel.add(showTextJButton);

        JPanel middleJPanel = new JPanel(new GridLayout(0,2));

        JPanel leftJPanel = new JPanel(new GridLayout(2,0));
        JPanel testJPanel = new JPanel(new GridLayout(0,2));
        JPanel proctorJPanel = new JPanel(new GridLayout(0,2));
        testJPanel.setBorder(BorderFactory.createTitledBorder("Density Test Information"));
        proctorJPanel.setBorder(BorderFactory.createTitledBorder("Proctor Test Information"));
        leftJPanel.add(testJPanel);
        leftJPanel.add(proctorJPanel);

        JPanel rightJPanel = new JPanel(new GridLayout(2,0));
        JPanel assumptionJPanel = new JPanel(new GridLayout(0,2));
        JPanel sampleJPanel = new JPanel(new GridLayout(0,2));
        sampleJPanel.setBorder(BorderFactory.createTitledBorder("Sample Information"));
        assumptionJPanel.setBorder(BorderFactory.createTitledBorder("Specific Gravity Information"));
        rightJPanel.add(sampleJPanel);
        rightJPanel.add(assumptionJPanel);
        
        middleJPanel.add(leftJPanel);
        middleJPanel.add(rightJPanel);
        
        testJPanel.add(numberOfTestLabel);
        testJPanel.add(numberOfTest);
        testJPanel.add(dryDensityOfTestLabel);
        testJPanel.add(dryDensityOfTest);
        testJPanel.add(percentNaturalGravelOfTestLabel);
        testJPanel.add(percentNaturalGravelOfTest);
        testJPanel.add(percentRecycledGravelOfTestLabel);
        testJPanel.add(percentRecycledGravelOfTest);

        proctorJPanel.add(numberOfProctorLabel);
        proctorJPanel.add(numberOfProctor);
        proctorJPanel.add(dryDensityOfProctorLabel);
        proctorJPanel.add(dryDensityOfProctor);
        proctorJPanel.add(percentNaturalGravelOfProctorLabel);
        proctorJPanel.add(percentNaturalGravelOfProctor);
        proctorJPanel.add(percentRecycledGravelOfProctorLabel);
        proctorJPanel.add(percentRecycledGravelOfProctor);
        
        sampleJPanel.add(specifiedCompactionLabel);
        sampleJPanel.add(specifiedCompaction);
        sampleJPanel.add(proctorMethodLabel);
        sampleJPanel.add(proctorMethod);
        sampleJPanel.add(typeOfSampleLabel);
        sampleJPanel.add(typeOfSample);
        sampleJPanel.add(classificationOfSampleLabel);
        sampleJPanel.add(classificationOfSample);
        
        assumptionJPanel.add(specificGravityOfNaturalGravelLabel);
        assumptionJPanel.add(specificGravityOfNaturalGravel);
        assumptionJPanel.add(specificGravityOfRecycledGravelLabel);
        assumptionJPanel.add(specificGravityOfRecycledGravel);
        
        this.add(southJPanel,BorderLayout.SOUTH);
        this.add(middleJPanel,BorderLayout.CENTER);
        
        this.setPreferredSize(new Dimension(600,300));        
        this.setVisible(true);
        this.setLocation(200,200);
        this.setTitle("Recycled Corrector");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }
    
    private void buildResultsDialog() {
        JLabel correctedDensityLabel = new JLabel("Corrected Density");
        JLabel percentCompactionLabel = new JLabel("Percent Compaction");
        outputJPanel = new JPanel(new GridLayout(0,2));
        outputJPanel.setBorder(BorderFactory.createTitledBorder("Results"));
        outputJPanel.add(correctedDensityLabel);
        outputJPanel.add(correctedDensity);
        outputJPanel.add(percentCompactionLabel);
        outputJPanel.add(percentCompaction);
        outputJPanel.add(new JLabel());
        outputJPanel.add(passOrFail);
    }
    
    private void initComponents() {
        submitJButton = new JButton("Submit");
        clearJButton = new JButton("Clear & Reset");
        showTextJButton = new JButton("Show Results");
        submitJButton.addActionListener(this);
        clearJButton.addActionListener(this);
        showTextJButton.addActionListener(this);

        numberOfTest = new JTextField();
        dryDensityOfTest = new JTextField();
        percentNaturalGravelOfTest = new JTextField();
        percentRecycledGravelOfTest = new JTextField();
        numberOfProctor = new JTextField();
        dryDensityOfProctor = new JTextField();
        percentNaturalGravelOfProctor = new JTextField();
        percentRecycledGravelOfProctor = new JTextField();
        specifiedCompaction = new JTextField();
        proctorMethod = new JTextField();
        typeOfSample = new JTextField();
        classificationOfSample = new JTextField();
        correctedDensity = new JTextField();
        percentCompaction = new JTextField();
        correctedDensity.setEditable(false);
        percentCompaction.setEditable(false);
        specificGravityOfNaturalGravel = new JTextField("2.70");
        specificGravityOfRecycledGravel = new JTextField("2.30");
        
        passOrFail = new JLabel();
    }
    
    public void actionPerformed( ActionEvent e ) {
        if( e.getSource() == showTextJButton ) {
            JOptionPane.showMessageDialog(this,resultsJPanel);
        } else if( e.getSource() == clearJButton ) {
            clearAndReset();
            rc.clearAndReset();
        } else if( e.getSource() == submitJButton ) {
            try {
                rc.setNumberOfTest(numberOfTest.getText());
                rc.setDryDensityOfTest((double)Double.parseDouble(dryDensityOfTest.getText()));
                rc.setPercentNaturalGravelOfTest((double)Double.parseDouble(percentNaturalGravelOfTest.getText()));
                rc.setPercentRecycledGravelOfTest((double)Double.parseDouble(percentRecycledGravelOfTest.getText()));

                rc.setNumberOfProctor(numberOfProctor.getText());
                rc.setDryDensityOfProctor((double)Double.parseDouble(dryDensityOfProctor.getText()));
                rc.setPercentNaturalGravelOfProctor((double)Double.parseDouble(percentNaturalGravelOfProctor.getText()));
                rc.setPercentRecycledGravelOfProctor((double)Double.parseDouble(percentRecycledGravelOfProctor.getText()));

                rc.setSpecificGravityOfNaturalGravel((double)Double.parseDouble(specificGravityOfNaturalGravel.getText()));
                rc.setSpecificGravityOfRecycledGravel((double)Double.parseDouble(specificGravityOfRecycledGravel.getText()));
                
                rc.calculate();
                
                String output;
                output = formatter.format((double)Double.valueOf(rc.getCorrectedDensity()));
                correctedDensity.setText(output);
                output = formatter.format((double)Double.valueOf(rc.getPercentCompaction()));
                percentCompaction.setText(output);
                
                if( Math.round((double)Double.valueOf(percentCompaction.getText())) >= Math.round((double)Double.valueOf(specifiedCompaction.getText())) ) {
                    passOrFail.setText("Pass");
                } else { 
                    passOrFail.setText("Fail");
                }
                
                JOptionPane.showMessageDialog(this,outputJPanel);

                densityTestJTextArea.append(numberOfTest.getText());
                densityTestJTextArea.append("\t");
                densityTestJTextArea.append(dryDensityOfTest.getText());
                densityTestJTextArea.append("\t");
                densityTestJTextArea.append(percentNaturalGravelOfTest.getText());
                densityTestJTextArea.append("\t");
                densityTestJTextArea.append(percentRecycledGravelOfTest.getText());
                densityTestJTextArea.append("\t");

                densityTestJTextArea.append(numberOfProctor.getText());
                densityTestJTextArea.append("\t");
                
                output = formatter.format((double)Double.valueOf(correctedDensity.getText()));
                densityTestJTextArea.append(output);
                densityTestJTextArea.append("\t");
                output = formatter.format((double)Double.valueOf(percentCompaction.getText()));
                densityTestJTextArea.append(output);
                densityTestJTextArea.append("\t");
                densityTestJTextArea.append(specifiedCompaction.getText());
                densityTestJTextArea.append("\t");
                densityTestJTextArea.append(passOrFail.getText());
                densityTestJTextArea.append("\n");
                
                proctorJTextArea.append(numberOfProctor.getText());
                proctorJTextArea.append("\t");
                proctorJTextArea.append(dryDensityOfProctor.getText());
                proctorJTextArea.append("\t");
                proctorJTextArea.append(percentNaturalGravelOfProctor.getText());
                proctorJTextArea.append("\t");
                proctorJTextArea.append(percentRecycledGravelOfProctor.getText());
                proctorJTextArea.append("\t");
                proctorJTextArea.append(proctorMethod.getText());
                proctorJTextArea.append("\t");
                proctorJTextArea.append(typeOfSample.getText());
                proctorJTextArea.append("\t");
                proctorJTextArea.append(classificationOfSample.getText());
                proctorJTextArea.append("\n");
            } catch( Exception ex ) {
                JOptionPane.showMessageDialog(this,"Please Fill All Fields");
            }
        }
    }
    
    public void clearAndReset() {
        numberOfTest.setText("");
        dryDensityOfTest.setText("");
        percentNaturalGravelOfTest.setText("");
        percentRecycledGravelOfTest.setText("");
        numberOfProctor.setText("");
        dryDensityOfProctor.setText("");
        percentNaturalGravelOfProctor.setText("");
        percentRecycledGravelOfProctor.setText("");
        specificGravityOfNaturalGravel.setText("2.70");
        specificGravityOfRecycledGravel.setText("2.30");
        correctedDensity.setText("");
        percentCompaction.setText("");
        
        specifiedCompaction.setText("");
        proctorMethod.setText("");
        typeOfSample.setText("");
        classificationOfSample.setText("");
    
        passOrFail.setText("");
        
        buildResultsPanel();
    }
    
    private DecimalFormat formatter;
    
    private RecycleCorrector rc;
    
    private JTextField numberOfTest;
    private JTextField dryDensityOfTest;
    private JTextField percentNaturalGravelOfTest;
    private JTextField percentRecycledGravelOfTest;
    
    private JTextField numberOfProctor;
    private JTextField dryDensityOfProctor;
    private JTextField percentNaturalGravelOfProctor;
    private JTextField percentRecycledGravelOfProctor;
    
    private JTextField specificGravityOfNaturalGravel;
    private JTextField specificGravityOfRecycledGravel;
    
    private JTextField specifiedCompaction;
    private JTextField proctorMethod;
    private JTextField typeOfSample;
    private JTextField classificationOfSample;
    
    private JTextField correctedDensity;
    private JTextField percentCompaction;

    private JButton submitJButton;
    private JButton clearJButton;
    private JButton showTextJButton;
    
    private JLabel passOrFail;
    
    private JPanel outputJPanel;
    private JPanel resultsJPanel;    
    private JTextArea densityTestJTextArea;
    private JTextArea proctorJTextArea;
    
}
