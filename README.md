该项目代码生成项目根据《renrenio》 代码改造


## 1.配置说明
- 自定义生成模板
 自定义的生成模板在resources\codeTemplate.
可自定义html、sql、java...等模板，然后在GenUtil代码加入生成的模板配置（具体参考其他模板的代码）

- 配置文件
 位于resource\generator.properties 
 可根据自身情况自定义包名和生成的文件夹
 
- 生成的文件
 生成的文件包含：Controller.java、Service.java、Entity.java,Mapper.java以及Mapper.xml

## 2. 运行说明
> 1.替换配置文件generator.properties 的package（包名和文件路径）和author（作者名称）.此包名是Mapper.xml映射包的指向，若出现错误，请检查Mapper.xml的目录指向 
> 
> 2.在application.xml配置相应的数据库信息
> 
> 3.运行后，会在控制台打印出一个地址，直接打开地址生成代码

 