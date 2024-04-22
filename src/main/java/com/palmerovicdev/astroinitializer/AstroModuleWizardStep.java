package com.palmerovicdev.astroinitializer;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.ui.ComboBox;

import javax.swing.*;
import java.awt.*;

public class AstroModuleWizardStep extends ModuleWizardStep {

  private JPanel panel;
  private JComboBox<String> packageManager;
  private JTextField templateName;
  private JCheckBox installDependencies;
  private JCheckBox createGitRepo;
  private JCheckBox alwaysSkipYes;
  private JCheckBox alwaysSkipHuston;
  private JCheckBox fullUnicodeSupport;
  private JComboBox<String> useTypescript;

  public AstroModuleWizardStep() {
    panel = new JPanel();
    panel.setLayout(new GridLayout(9, 1));

    packageManager = new ComboBox<>(new String[]{"npm", "pnpm", "yarn"});
    templateName = new JTextField();
    installDependencies = new JCheckBox("Install dependencies");
    createGitRepo = new JCheckBox("Create git repo");
    alwaysSkipYes = new JCheckBox("Always skip with yes to all");
    alwaysSkipHuston = new JCheckBox("Always skip Huston");
    fullUnicodeSupport = new JCheckBox("Full unicode support for windows");
    useTypescript = new ComboBox<>(new String[]{"strict", "strictest", "relaxed"});

    panel.add(new JLabel("Package Manager"));
    panel.add(packageManager);
    panel.add(new JLabel("Template Name"));
    panel.add(templateName);
    panel.add(installDependencies);
    panel.add(createGitRepo);
    panel.add(alwaysSkipYes);
    panel.add(alwaysSkipHuston);
    panel.add(fullUnicodeSupport);
    panel.add(new JLabel("Use TypeScript"));
    panel.add(useTypescript);
  }

  @Override
  public JComponent getComponent() {
    return panel;
  }

  @Override
  public void updateDataModel() {
    // Aquí puedes actualizar tu modelo de datos según la interfaz de usuario
    // Por ejemplo:
    // model.setPackageManager(packageManager.getSelectedItem().toString());
    // model.setTemplateName(templateName.getText());
    // model.setInstallDependencies(installDependencies.isSelected());
    // model.setCreateGitRepo(createGitRepo.isSelected());
    // model.setAlwaysSkipYes(alwaysSkipYes.isSelected());
    // model.setAlwaysSkipHuston(alwaysSkipHuston.isSelected());
    // model.setFullUnicodeSupport(fullUnicodeSupport.isSelected());
    // model.setUseTypescript(useTypescript.getSelectedItem().toString());
  }
}