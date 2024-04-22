// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;
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
    return new AstroRunConfiguration(project, this, "Demo");
  }

  @Nullable
  @Override
  public Class<? extends BaseState> getOptionsClass() {
    return AstroRunConfigurationOptions.class;
  }

}