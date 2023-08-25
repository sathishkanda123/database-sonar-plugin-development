package org.dds.sonar;

import org.sonar.api.Plugin;

public class MybatisPlugin implements Plugin {

    @Override
    public void define(Context context) {
        context.addExtensions(
                MybatisRulesDefinition.class,
                MybatisAnalyzer.class
        );
    }
}
