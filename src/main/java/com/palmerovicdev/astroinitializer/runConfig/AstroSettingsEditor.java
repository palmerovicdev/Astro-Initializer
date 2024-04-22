// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AstroSettingsEditor extends SettingsEditor<AstroRunConfiguration> {

  private final JPanel myPanel;
  private final TextFieldWithBrowseButton scriptPathField;

  public AstroSettingsEditor() {
    scriptPathField = new TextFieldWithBrowseButton();
    scriptPathField.addBrowseFolderListener("Select Script File", null, null,
        FileChooserDescriptorFactory.createSingleFileDescriptor());
    myPanel = FormBuilder.createFormBuilder()
        .addLabeledComponent("Script file", scriptPathField)
        .getPanel();
  }

  @Override
  protected void resetEditorFrom(AstroRunConfiguration astroRunConfiguration) {
    scriptPathField.setText(astroRunConfiguration.getScriptName());
  }

  @Override
  protected void applyEditorTo(@NotNull AstroRunConfiguration astroRunConfiguration) {
    astroRunConfiguration.setScriptName(scriptPathField.getText());
  }

  @NotNull
  @Override
  protected JComponent createEditor() {
    return myPanel;
  }

}