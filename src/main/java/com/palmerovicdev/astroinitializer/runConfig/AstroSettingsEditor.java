package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.util.ui.FormBuilder;
import com.palmerovicdev.astroinitializer.model.AstroModuleEntity;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class AstroSettingsEditor extends SettingsEditor<AstroRunConfiguration> {

  private final JPanel myPanel;
  private final JTextField scriptTextField;
  private final JComboBox<String> packageManagerComboBox; // Add this field

  public AstroSettingsEditor() {
    scriptTextField = new JTextField();
    packageManagerComboBox = new ComboBox<>(new String[]{"npm", "pnpm", "yarn"}); // Initialize the field
    myPanel = FormBuilder.createFormBuilder()
                         .addLabeledComponent("Script Text:", scriptTextField)
                         .addLabeledComponent("Package Manager:", packageManagerComboBox) // Add the field to the form
                         .getPanel();

    packageManagerComboBox.addActionListener(e -> {
        scriptTextField.setText(packageManagerComboBox.getSelectedItem() + " run dev");
    });
  }

  @Override
  protected void resetEditorFrom(@NotNull AstroRunConfiguration astroRunConfiguration) {
    scriptTextField.setText("npm run dev");
    packageManagerComboBox.setSelectedItem("npm");
  }

  @Override
  protected void applyEditorTo(@NotNull AstroRunConfiguration astroRunConfiguration) {
    astroRunConfiguration.setScriptText(packageManagerComboBox.getSelectedItem() + " run dev");
  }

  @NotNull
  @Override
  protected JComponent createEditor() {
    return myPanel;
  }

}