# nyaabot API 定义

## 数据模型
- Channel
- Message
- Credential

### Channel
频道类，应当从某个特定的驱动实例中通过`getChannel`方法获取。

它类似于Telegram的一个频道或群组，或QQ的一个会话或群聊，或xmpp中的一个muc，或电子邮件中和一个特定收件人的邮件会话等等......


## 接口
- IDriver

### IDriver
驱动接口，它提供一个所有的驱动插件都应当实现的接口。

这个接口允许实例化一个用户实体来获取特定频道并对其进行操作。

每个Driver类都表示一个使用确定凭据的“用户”，并应当在nyaabot项目中使用一个连接池对其进行统一管理。