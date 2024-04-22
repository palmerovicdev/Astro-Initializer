package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.openapi.util.NotNullLazyValue;
import icons.AstroIcons;

final class AstroRunConfigurationType extends ConfigurationTypeBase {

  static final String ID = "AstroRunConfiguration";

  AstroRunConfigurationType() {
    super(ID, "Astro", "Demo run configuration type",
        NotNullLazyValue.createValue(() -> AstroIcons.ICON));
    addFactory(new AstroConfigurationFactory(this));
  }

}