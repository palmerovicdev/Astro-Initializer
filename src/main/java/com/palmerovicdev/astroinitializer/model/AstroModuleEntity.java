package com.palmerovicdev.astroinitializer.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AstroModuleEntity {
    private String templateName;
    private String packageManager;
    private boolean installDependencies;
    private boolean createGitRepo;
    private boolean useTypescript;
    private String typescriptMode;
    private boolean useTemplate;
    private boolean unicodeSupport;

}