<%@ page pageEncoding="utf-8"%>
<html>
<body>
<h2>Hello IDEA!</h2>
.gitignore文件中可以配置git仓库推送忽略内容。
git init 初始化并生成.git 文件
更改了
添加一些新的信息。

springmvc文件上传
<form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="submit" value="上传文件">
</form>
<hr/>

富文本图片上传
<form name="form2" action="/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="submit" value="上传文件">
</form>

</body>
</html>
