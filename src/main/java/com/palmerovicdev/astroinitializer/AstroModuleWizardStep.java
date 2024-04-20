package com.palmerovicdev.astroinitializer;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;

import javax.swing.*;

public class AstroModuleWizardStep extends ModuleWizardStep {

  @Override
  public JComponent getComponent() {
    return new JLabel("Provide some setting here");
  }

  @Override
  public void updateDataModel() {
    //todo update model according to UI
  }

}