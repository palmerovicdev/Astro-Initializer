package com.palmerovicdev.astroinitializer.view;

import lombok.Getter;

import javax.swing.*;

@Getter
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

}