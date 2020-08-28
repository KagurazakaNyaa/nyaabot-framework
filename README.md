# nyaabot-framework
插件化聊天机器人框架

## 说明
此项目由四个部分构成
- nyaabot
- nyaabot-api
- nyaabot-common
- nyaabot-plugin
分别是插件加载器、API接口、工具和插件库

所有的插件应当引用API接口作为依赖，插件分为两类，驱动和处理器

驱动插件负责提供和消息源的交互渠道，它应当实现`IDriver`接口对外提供`Channel`的获取

处理器插件可以对收到的消息进行处理并做出相应的操作，大部分的响应逻辑都应当在这类插件中完成