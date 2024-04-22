// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.NotNullLazyValue;

final class AstroRunConfigurationType extends ConfigurationTypeBase {

  static final String ID = "AstroRunConfiguration";

  AstroRunConfigurationType() {
    super(ID, "Demo", "Demo run configuration type",
        NotNullLazyValue.createValue(() -> AllIcons.Nodes.Console));
    addFactory(new AstroConfigurationFactory(this));
  }

}