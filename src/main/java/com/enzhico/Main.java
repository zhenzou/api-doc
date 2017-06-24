package com.enzhico;


import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Homepage
 */
public class Main {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) throws Exception {
        Path localSwaggerFile = Paths.get("src/main/resources/swagger.yaml");
        Path outputFile = Paths.get("build/swagger");

        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
        Swagger2MarkupConverter converter = Swagger2MarkupConverter.from(localSwaggerFile)
                .withConfig(config)
                .build();
        converter.toFile(outputFile);
    }
}
