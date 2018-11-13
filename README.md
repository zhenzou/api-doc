## RESTful API Doc generation

## 生成HTML格式的API文档

1. 先通过Swagger Editor编辑API的定义文档
2. mvn clean && maven package
3. java -jar target\api-doc-1.0.0-jar-with-dependencies.jar swagger.swagger ./doc.html

## License

(The Apache License)

Copyright (c) 2017 [Xiong Neng](https://www.xncoding.com/) and other contributors

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at

    <http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, 
software distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and limitations under the License.
