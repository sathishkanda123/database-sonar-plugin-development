package org.dds.sonar;

import org.sonar.api.rule.RuleKey;
import org.sonar.api.rule.Severity;
import org.sonar.api.server.rule.RulesDefinition;

public class MybatisRulesDefinition implements RulesDefinition {

    public static final String REPOSITORY = "java-example";
    public static final String JAVA_LANGUAGE = "java";
    public static final RuleKey RULE_ON_SELECT = RuleKey.of(REPOSITORY, "select-star-rule");

    @Override
    public void define(Context context) {
        NewRepository repository = context.createRepository("mybatis", "java")
                .setName("MyBatis Lint Rules");

        // Define your custom rule
        NewRule mybatisRule = repository.createRule(RULE_ON_SELECT.rule())
                .setName("Avoid SELECT * in MyBatis Mapper")
                .setHtmlDescription("Avoid using SELECT * in MyBatis Mapper queries.");

        // Assign default severity
        mybatisRule.setSeverity(Severity.MAJOR);

        repository.done();
    }
}
