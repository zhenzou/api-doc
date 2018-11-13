package com.enzhico;


import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.asciidoctor.*;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


/**
 * Homepage
 */
public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("need input file and output file");
            System.out.println("example: ./swagger.yml ./doc.html");
            System.exit(-1);
        }
        String formFilePath = args[0];
        String toFilePath = args[1];

        System.out.printf("convert %s to %s \n", formFilePath, toFilePath);
        Path fromFile = null;
        Path toFile = null;
        try {
            fromFile = Paths.get(formFilePath);
            toFile = Paths.get(toFilePath);
        } catch (InvalidPathException e) {
            System.out.println("invalid arguments,please input correct arguments");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        try {
            Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                    .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                    .withOutputLanguage(Language.ZH)
                    .withGeneratedExamples()
                    .withoutInlineSchema()
                    .build();
            Swagger2MarkupConverter converter = Swagger2MarkupConverter.from(fromFile)
                    .withConfig(config)
                    .build();

            Attributes attributes = AttributesBuilder.attributes().dataUri(true).get();

            OptionsBuilder optionsBuilder = OptionsBuilder.options().headerFooter(true).safe(SafeMode.UNSAFE).backend("html5").attributes(attributes);
            Map<String, Object> m = optionsBuilder.asMap();
            Asciidoctor asciidoctor = Asciidoctor.Factory.create();
            String html = asciidoctor.convert(converter.toString(), m);
            Files.write(toFile, html.getBytes(Charset.forName("utf-8")));
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
            System.exit(-1);
        }
    }
}
