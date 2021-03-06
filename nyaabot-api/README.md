# nyaabot API 定义

## 数据模型
- Channel
- Configuration
- MessageEventObject

### Channel
频道类，应当从某个特定的驱动实例中通过`getChannel`方法获取。

它类似于Telegram的一个频道或群组，或QQ的一个群聊，或xmpp中的一个muc，或电子邮件中和一个特定收件人的邮件会话等等......

它会维护一个事件通知机制，在收到消息时向订阅了它的处理器发送事件。

### Configuration
配置类，这是一个可以序列化的类，它应当存储各个插件的通用配置，例如基础的登录凭据和插件自己的配置和日志路径。

它应当在载入插件时从文件系统反序列化并提供给插件。

### MessageEventObject
消息事件对象类，它被用于`Channel`的事件通知机制。

## 接口
- IDriver
- IMessageListener

### IDriver
驱动接口，它提供一个所有的驱动插件都应当实现的接口。

这个接口允许实例化一个用户实体来获取特定频道并对其进行操作。

每个Driver类都表示一个使用确定凭据的“用户”，并应当在nyaabot项目中使用一个连接池对其进行统一管理。

### IMessageListener
消息事件监听器接口，它应当在处理器中被实现并注册到相关频道以接收消息。
