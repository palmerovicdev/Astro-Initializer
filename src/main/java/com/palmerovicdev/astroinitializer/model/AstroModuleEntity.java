package com.palmerovicdev.astroinitializer.model;

public class AstroModuleEntity {
    private String script;
    private String projectName;
    private String projectLocation;
    private String templateName;
    private String packageManager;
    private boolean installDependencies;
    private boolean createGitRepo;
    private boolean useTypescript;
    private String typescriptMode;
    private boolean useTemplate;
    private boolean unicodeSupport;

    private static AstroModuleEntity instance;

    public static AstroModuleEntity instance(){
        if(instance == null){
            instance = new AstroModuleEntity();
        }
        return instance;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getPackageManager() {
        return packageManager;
    }

    public void setPackageManager(String packageManager) {
        this.packageManager = packageManager;
    }

    public boolean isInstallDependencies() {
        return installDependencies;
    }

    public void setInstallDependencies(boolean installDependencies) {
        this.installDependencies = installDependencies;
    }

    public boolean isCreateGitRepo() {
        return createGitRepo;
    }

    public void setCreateGitRepo(boolean createGitRepo) {
        this.createGitRepo = createGitRepo;
    }

    public boolean isUseTypescript() {
        return useTypescript;
    }

    public void setUseTypescript(boolean useTypescript) {
        this.useTypescript = useTypescript;
    }

    public String getTypescriptMode() {
        return typescriptMode;
    }

    public void setTypescriptMode(String typescriptMode) {
        this.typescriptMode = typescriptMode;
    }

    public boolean isUseTemplate() {
        return useTemplate;
    }

    public void setUseTemplate(boolean useTemplate) {
        this.useTemplate = useTemplate;
    }

    public boolean isUnicodeSupport() {
        return unicodeSupport;
    }

    public void setUnicodeSupport(boolean unicodeSupport) {
        this.unicodeSupport = unicodeSupport;
    }
}