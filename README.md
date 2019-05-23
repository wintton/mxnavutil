<h1>android 自定义路由 dialog助手</h1>

<p>又有好长一段时间没有更新博客了，最近楼主在写代码的过程，发现了微信小程序的路由和提示窗使用起来特别方便，于是乎，想到了自己最近做的安卓程序，没有路由总是不大方便，今天就抽空写了一个助手:NavAppCompatActivity,这个activity内提供了2个工具，一个navUtil，一个dialogUtil,顾明思议：一个是路由工具，一个是提示窗工具，楼主写好后，觉得使用起来太方便了，不在用担心activity和dialog的管理了，下面我来说说这两个工具的使用方法；</p>
<h2>NavUtil</h2>
<p>它主要提供了4个方法：</p>
<p>1.navTo(Class ClassName)，保留当前页面，跳转到应用内的某个页面</p>
<p>2.navBack()，关闭当前页面，返回上一页面</p>
<p>3.redirectTo(Class ClassName)，关闭当前页面，跳转到应用内的某个页面</p>
<p>4.reLaunch(Class ClassName)，关闭所有页面，打开到应用内的某个页面</p>
<p>还有几个就是他们的重载方法，方便跳转时带参，采用的单例模式</p>
<p>使用起来就特别简单了</p>

```
navUtil.navTo(NavActivity2.class);
navUtil.redirectTo(NavActivity3.class);
navUtil.reLaunch(NavActivity1.class);
navUtil.navBack();
```
<h2>DialogUtil</h2>
<p>它主要提供了11个方法：</p>
<p>1.showTimePickerDialog(TimePickerDialog.OnTimeSetListener lisenter)，显示时间选择器</p>
<p>2.showDatePickerDialog(DatePickerDialog.OnDateSetListener onDateSetListener)，显示日期选择器</p>
<p>3.showLoadding(String msg)，显示加载型提示框</p>
<p>4.showAlertDialogHint(String title, String msg)，弹出对话提示框,仅显示一个button，默认buton文字为我知道了</p>
<p>5.showAlertDialog(String title, String msg, final CallBack callBack, String confirmtext, String canletext)，弹出对话提示框,显示两个按钮</p>
<p>6.showItemAlertDialog(String title, String[] content, DialogInterface.OnClickListener callBack)，显示列表类型的提示窗</p>
<p>7.showToast(String msg)，显示吐司提示</p>
<p>8.hideLoadding()，隐藏加载型提示框</p>
<p>9.hideAlertDialog()，隐藏对话框提示框</p>
<p>采用的单例模式</p> 

<h2>20190523 更新1.0.1版</h2>
<p>更新内容：新增NavActivity,NavFragment,NavFragmentActivity</p>
 
