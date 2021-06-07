## 平台简介

一个基于 Spring Boot 的博客管理系统，为学校毕设项目。前端没有使用 CSS 框架，样式较为简陋。只适用入门开发者学习参考。

备注：搜索目前只支持英文搜索。

- 前端：css + Thymeleaf
- 数据库：MyBatis
- 富文本插件：Editor.md
- 其他：Vue.jsss，Axios.js，ElasticSearch

## 内置功能

1. 文章浏览：文章首页默认是最新发布的十篇文章，各个标签页对应标签页的文章。
2. 文章评论：在文章下方，可留言评论（没有邮箱检验功能）。
3. 文章管理：后台系统可对文章增删改查。
4. 评论管理：后台管理员收到评论后继续查看，`审核`通过评论将被显示，审核不通过可删除。

## 用户体验

==提前==：项目启动之前，请先保证本地的 Elastic Search 有启动。

启动成功后，优先访问 `localhost:8080/import` 将导入 mysql 数据库内容到 es 索引中【访问一次即可，避免数据重复】

启动后可使用 ElasticSearch-head 进行图形界面查看。

```sh
//进入插件目录
cd elasticsearch-head
//启动
npm run start
```

访问地址:

- localhost:9100

若出现 db_article 索引则说明数据导入成功。如图所示。

![](E:\code\boot-workplace\website\image\es-head展示图1.png)

![](E:\code\boot-workplace\website\image\es-head展示图2.png)



- 前台：localhost:8080
- 后台：localhost:8080/admin

管理员账号密码：

- 123@admin.com
- admin

## 演示图

**前台界面**

![](E:\code\boot-workplace\website\image\主页展示图.png)

**后台登录页**

![](E:\code\boot-workplace\website\image\后台登录页.png)

**后台管理首页**

![](E:\code\boot-workplace\website\image\后台管理页.png)

**文章发布页**

![](E:\code\boot-workplace\website\image\添加文章页.png)

##### 文章管理页

![](E:\code\boot-workplace\website\image\文章管理页.png)

**评论管理页**

![](E:\code\boot-workplace\website\image\评论管理页.png)

