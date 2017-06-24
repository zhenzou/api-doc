## RESTful API Doc generation

RESTful API 标准文档生成，可生成直观的HTML形式、PDF格式的文档，方便API开发者查阅。

## 生成HTML格式的API文档

1. 先通过Swagger Editor编辑API的定义文档，命名为swagger.yaml，放到 `src/main/resources` 目录下面
2. 运行Main.java主类方法
3. 执行 `mvn clean && mvn compile`

成功之后即可在 `docs/asciidoc/1.0.0/` 目录下面找到html格式的API文档。

## 生成PDF格式的API文档

使用`asciidoctor-maven-plugin`插件也能生成pdf格式的文档，但是对于中文支持太差了，很多中文字符是空白。

这里我通过另外的一种方式生成中文PDF文档，
参考：<https://github.com/chloerei/asciidoctor-pdf-cjk-kai_gen_gothic>

### 安装ruby

window上面直接去下载安装包：<https://rubyinstaller.org/downloads/>

更改国内源，参考 <https://gems.ruby-china.org/> ：
```
gem sources --add https://gems.ruby-china.org/ --remove https://rubygems.org/
gem sources -l
```

### 安装cjk依赖

```
gem install asciidoctor-pdf-cjk-kai_gen_gothic
```

### 下载中文字体

```
asciidoctor-pdf-cjk-kai_gen_gothic-install
```

执行这一步超时，解决办法是手动下载字体。

字体文件都在这里：<https://github.com/chloerei/asciidoctor-pdf-cjk-kai_gen_gothic/releases>

CN 主题需要的是 RobotoMono 开头和 KaiGenGothicCN 开头的字体文件，
尝试用其他工具手工下载到 gem 安装目录的 data/fonts 文件夹内。

查看gem安装目录命令：
```
gem environment
```

在返回结果里面找到这句：
```
INSTALLATION DIRECTORY: E:/Ruby24-x64/lib/ruby/gems/2.4.0
```

然后在这个目录下面进入目录 `gems/asciidoctor-pdf-cjk-kai_gen_gothic-0.1.1/data/fonts`，
将下载的字体都放进去。


### 使用方法

首先在`build/swagger.adoc`的顶部加入：

```
:toclevels: 3
:numbered:

```

注意有个空行分割，目的是左边导航菜单是3级，并且自动加序号，然后执行：

```
asciidoctor-pdf -r asciidoctor-pdf-cjk-kai_gen_gothic -a pdf-style=KaiGenGothicCN build/swagger.adoc
```

会在`swagger.adoc`的同级目录生成`swagger.pdf`文件。

![](https://xnstatic-1253397658.file.myqcloud.com/swagger04.png)
