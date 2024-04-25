package com.palmerovicdev.astroinitializer.module;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import icons.AstroIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

final class AstroModuleType extends ModuleType<AstroModuleBuilder> {

    private static final String ID = "DEMO_MODULE_TYPE";

    AstroModuleType() {
        super(ID);
    }

    public static AstroModuleType getInstance() {
        return (AstroModuleType) ModuleTypeManager.getInstance().findByID(ID);
    }

    @NotNull
    @Override
    public AstroModuleBuilder createModuleBuilder() {
        return new AstroModuleBuilder();
    }

    @NotNull
    @Override
    public String getName() {
        return "Astro";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Example custom astroinitializer type";
    }

    @NotNull
    @Override
    public Icon getNodeIcon(@Deprecated boolean b) {
        return AstroIcons.ICON;
    }

    @Override
    public ModuleWizardStep[] createWizardSteps(
            @NotNull WizardContext wizardContext,
            @NotNull AstroModuleBuilder moduleBuilder,
            @NotNull ModulesProvider modulesProvider) {
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider);
    }

}