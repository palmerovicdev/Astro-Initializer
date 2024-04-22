// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

public class AstroRunConfigurationOptions extends RunConfigurationOptions {

  private final StoredProperty<String> myScriptName =
      string("").provideDelegate(this, "scriptName");

  public String getScriptName() {
    return myScriptName.getValue(this);
  }

  public void setScriptName(String scriptName) {
    myScriptName.setValue(this, scriptName);
  }

}