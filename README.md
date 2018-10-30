这是一个预读文件。
我进行了修改！123
vo全称:view object 封装pojo的类，还可以封装bo类 controller层用，若业务简单controller和service层可以合在一起用。
pojo:实体类  dao层用
bo全称：business object 封装pojo的类  service层用（bo是抽象对象）
common：存放公共类和常量等
controller.portal是controller的子包，是留给前端整合时看的

pojo与bo交互，bo将其转换为实际需要的业务对象（service层）
bo与vo交互,vo将bo转换为供前端显示的业务对象（controller层）