package com.palmerovicdev.astroinitializer;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
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
        moduleEntity.setUseTemplate(view.getUseTemplateComboBox().isSelected());
        if (moduleEntity.isUseTemplate()) moduleEntity.setTemplateName(view.getTemplateNameTextField().getText());
        moduleEntity.setPackageManager(Objects.requireNonNullElse(view.getPackageManagerComboBox().getSelectedItem(), "npm").toString());
        moduleEntity.setInstallDependencies(view.getInstallDependenciesCheckBox().isSelected());
        moduleEntity.setCreateGitRepo(view.getCreateGitRepoCheckBox().isSelected());
        moduleEntity.setUseTypescript(view.getUseTypescriptCheckBox().isSelected());
        if (moduleEntity.isUseTypescript())
            moduleEntity.setTypescriptMode(Objects.requireNonNullElse(view.getTypescriptModeComboBox().getSelectedItem(), "relaxed").toString());
        moduleEntity.setUnicodeSupport(view.getUnicodeSupportCheckBox().isSelected());
        var script = generateScript();
        moduleEntity.setScript(script);
    }

    private String generateScript() {
        var script = new StringBuilder();
        var secondPartofTheScript = new StringBuilder();
        switch (moduleEntity.getPackageManager()) {
            case "npm":
                script.append("npm create astro@latest | ");
                break;
            case "pnpm":
                script.append("pnpm create astro | ");
                break;
            case "yarn":
                script.append("yarn create astro | ");
        }
        if (script.substring(0, 3).contains("npm")) secondPartofTheScript.append(" --");
        secondPartofTheScript.append(" --yes --skip-huston");
        var a = moduleEntity.isInstallDependencies() ?
                secondPartofTheScript.append(" --install") :
                secondPartofTheScript.append(" --no-install");

        var b = moduleEntity.isCreateGitRepo() ?
                secondPartofTheScript.append(" --git") :
                secondPartofTheScript.append(" --no-git");

        if (moduleEntity.isUseTypescript()) {
            secondPartofTheScript.append(" --typescript ");
            secondPartofTheScript.append(moduleEntity.getTypescriptMode());
        }
        if (moduleEntity.isUseTemplate()) {
            secondPartofTheScript.append(" --template ");
            secondPartofTheScript.append(moduleEntity.getTemplateName());
        }
        if (moduleEntity.isUnicodeSupport()) {
            secondPartofTheScript.append(" --unicode");
        }
        script.append(secondPartofTheScript);
        return script.toString();
    }

    public AstroModuleView getView() {
        return view;
    }

    public AstroModuleEntity getModuleEntity() {
        return moduleEntity;
    }
}