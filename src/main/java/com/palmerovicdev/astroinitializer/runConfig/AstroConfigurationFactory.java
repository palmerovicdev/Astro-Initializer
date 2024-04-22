package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.execution.BeforeRunTask;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AstroConfigurationFactory extends ConfigurationFactory {

  protected AstroConfigurationFactory(ConfigurationType type) {
    super(type);
  }

  @Override
  public @NotNull String getId() {
    return AstroRunConfigurationType.ID;
  }

  @NotNull
  @Override
  public RunConfiguration createTemplateConfiguration(
          @NotNull Project project) {
    return new AstroRunConfiguration(project, this, "Astro");
  }

  @Nullable
  @Override
  public Class<? extends BaseState> getOptionsClass() {
    return AstroRunConfigurationOptions.class;
  }

}