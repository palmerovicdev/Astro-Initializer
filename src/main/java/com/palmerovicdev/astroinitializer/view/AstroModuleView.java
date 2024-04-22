package com.palmerovicdev.astroinitializer.view;

import javax.swing.*;

public class AstroModuleView {
    private JPanel panel;
    private JTextField templateNameTextField;
    private JCheckBox installDependenciesCheckBox;
    private JCheckBox createGitRepoCheckBox;
    private JComboBox<String> packageManagerComboBox;
    private JComboBox<String> typescriptModeComboBox;
    private JCheckBox useTypescriptCheckBox;
    private JLabel packageManagerlabel;
    private JCheckBox useTemplateComboBox;
    private JLabel templateNameLabel;
    private JCheckBox unicodeSupportCheckBox;
    private JLabel typescriptModeLabel;

    public AstroModuleView() {
        packageManagerComboBox.addItem("npm");
        packageManagerComboBox.addItem("pnpm");
        packageManagerComboBox.addItem("yarn");
        typescriptModeComboBox.addItem("strict");
        typescriptModeComboBox.addItem("strictest");
        typescriptModeComboBox.addItem("relaxed");
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTemplateNameTextField() {
        return templateNameTextField;
    }

    public JCheckBox getInstallDependenciesCheckBox() {
        return installDependenciesCheckBox;
    }


    public JCheckBox getCreateGitRepoCheckBox() {
        return createGitRepoCheckBox;
    }

    public JComboBox<String> getPackageManagerComboBox() {
        return packageManagerComboBox;
    }

    public JComboBox<String> getTypescriptModeComboBox() {
        return typescriptModeComboBox;
    }

    public JCheckBox getUseTypescriptCheckBox() {
        return useTypescriptCheckBox;
    }

    public JLabel getPackageManagerlabel() {
        return packageManagerlabel;
    }


    public JCheckBox getUseTemplateComboBox() {
        return useTemplateComboBox;
    }

    public JLabel getTemplateNameLabel() {
        return templateNameLabel;
    }


    public JCheckBox getUnicodeSupportCheckBox() {
        return unicodeSupportCheckBox;
    }

    public JLabel getTypescriptModeLabel() {
        return typescriptModeLabel;
    }

}