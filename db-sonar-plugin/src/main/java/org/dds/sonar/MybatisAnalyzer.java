package org.dds.sonar;

import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
    import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import java.io.IOException;

public class MybatisAnalyzer implements org.sonar.api.batch.sensor.Sensor {

    private static final Logger LOGGER = Loggers.get(MybatisAnalyzer.class);
    private static final double ARBITRARY_GAP = 2.0;
    private static final int LINE_1 = 1;

    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor.name("MyBatis Lint Sensor");
        descriptor.onlyOnLanguage("java");
    }

    @Override
    public void execute(SensorContext context) {
        FileSystem fs = context.fileSystem();
        Iterable<InputFile> javaFiles = fs.inputFiles(fs.predicates().hasLanguage("java"));

        for (InputFile inputFile : javaFiles) {
            try {

                String fileContent = inputFile.contents();

                // Implement your logic to analyze MyBatis Mapper interface content
//                if (fileContent.contains("SELECT *")) {
//                    context.newIssue()
//                            .forRule(RuleKey.of("mybatis", MybatisRulesDefinition.RULE_ON_SELECT.rule()))
//                            .at(inputFile.selectLine(1))
//                            .withMessage("Avoid using SELECT * in MyBatis Mapper queries.")
//                            .save();
//                }

            } catch (IOException e) {
                LOGGER.error("Error reading file: " + inputFile.toString(), e);
            }
        }
    }
}
