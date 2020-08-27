# nyaabot API 定义

## 数据模型
- Channel
- Message
- Credential
- MessageEventObject

### Channel
频道类，应当从某个特定的驱动实例中通过`getChannel`方法获取。

它类似于Telegram的一个频道或群组，或QQ的一个会话或群聊，或xmpp中的一个muc，或电子邮件中和一个特定收件人的邮件会话等等......

它会维护一个事件通知机制，在收到消息时向订阅了它的处理器发送事件。

### Message
消息类，它和`Message`和`Credential`类不同，它不是一个抽象类，驱动无需扩展它。

它是一个包装，作为一个泛型消息而存在，在驱动的内部应当实现自己的消息数据结构并使用`Message<T>`进行包装。

它的所有数据在初始化后便已经确定而不应当进一步修改，如果要创建一个不同的消息，请直接构造一个新的。

### Credential
凭据类，它是用于存储登录凭据的抽象类，驱动应当扩展它以实现自己的凭据存储。

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
