## RESTful API Doc generation

RESTful API 标准文档生成，可生成直观的HTML形式、PDF格式的文档，方便API开发者查阅。

生成步骤：

1. 先通过Swagger Editor编辑API的定义文档，命名为swagger.yaml，放到 `src/main/resources` 目录下面
2. 运行Main.java主类方法
3. 执行 `mvn clean && mvn compile`

成功之后即可在 `docs/asciidoc/1.0.0/` 目录下面找到html格式和pdf格式的文档了。

