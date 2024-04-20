package com.palmerovicdev.astroinitializer;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AstroModuleBuilder extends ModuleBuilder {

  @Override
  public void setupRootModel(@NotNull ModifiableRootModel model) {
  }

  @Override
  public ModuleType<AstroModuleBuilder> getModuleType() {
    return AstroModuleType.getInstance();
  }

  @Nullable
  @Override
  public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
    return new AstroModuleWizardStep();
  }

}