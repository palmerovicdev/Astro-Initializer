package com.palmerovicdev.astroinitializer;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.wizard.CommitStepException;
import com.palmerovicdev.astroinitializer.model.AstroModuleEntity;
import com.palmerovicdev.astroinitializer.view.AstroModuleView;

import javax.swing.*;
import java.util.Objects;

public class AstroModuleWizardStep extends ModuleWizardStep {

  private final AstroModuleView view;
  private final AstroModuleEntity moduleEntity;


  public AstroModuleWizardStep() {
    view = new AstroModuleView();
    moduleEntity = new AstroModuleEntity();
  }

  @Override
  public JComponent getComponent() {
    return view.getPanel();
  }

  @Override
  public void updateDataModel() {
    moduleEntity.setTemplateName(view.getTemplateNameTextField().getText());
    moduleEntity.setPackageManager(Objects.requireNonNullElse(view.getPackageManagerComboBox().getSelectedItem(), "npm").toString());
    moduleEntity.setInstallDependencies(view.getInstallDependenciesCheckBox().isSelected());
    moduleEntity.setCreateGitRepo(view.getCreateGitRepoCheckBox().isSelected());
    moduleEntity.setUseTypescript(view.getUseTypescriptCheckBox().isSelected());
    moduleEntity.setTypescriptMode(Objects.requireNonNullElse(view.getTypescriptModeComboBox().getSelectedItem(), "relaxed").toString());
    moduleEntity.setUseTemplate(view.getUseTemplateComboBox().isSelected());
    moduleEntity.setUnicodeSupport(view.getUnicodeSupportCheckBox().isSelected());
}

  @Override
  public void onWizardFinished() throws CommitStepException {
    super.onWizardFinished();
  }
}