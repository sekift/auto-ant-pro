# auto-ant
自动蚂蚁，自动游走者，乃最大者。

# 开始使用<br />
1.从git拉Maven项目到本地（或者直接下载zip包），然后导入eclipse。<br />
2.下载相匹配的driver（可将项目driver文件里的解压，也可以到https://www.seleniumhq.org/ 选择下面的版本下载）和浏览器（到各自浏览器网址下载），版本不要相差太大，避免不兼容。<br />
2.1 chrome<br />
 chrome版本：67.0.3396.99；driver版本：2.36.540470 <br />
2.2 firefox<br />
 firefox版本：49.0.2；geckodriver版本：0.18.0<br />
2.3 opera<br />
 opera版本：54.0.2952.51；operadriver版本：2.37<br />
3.修改配置<br />
3.1 修改日志路径配置（可改可不改）<br />
log4j.properties中的log4j.appender.fileout.File=D:/www/application/auto-ant-pro.log；<br />
3.2 修改浏览器的位置配置<br />
位于config/client.xml中，下面的各路径必须与刚才下载的driver和浏览器的路径一致，否则出错：<br />
	<browser_dir><br />
		<chrome_dir>D:/selenium/chromedriver.exe</chrome_dir><br />
		<firefox_gecko_dir>D:/selenium/geckodriver.exe</firefox_gecko_dir><br />
		<firefox_browser_dir>D:/Program Files (x86)/Mozilla Firefox/firefox.exe</firefox_browser_dir><br />
		<firefox_old_browser_dir>D:/Program Files/Mozilla Firefox/firefox.exe</firefox_old_browser_dir><br />
		<opera_driver_dir>D:/selenium/operadriver.exe</opera_driver_dir><br />
		<opera_browser_dir>D:/Program Files/Opera/launcher.exe</opera_browser_dir><br />
	</browser_dir><br />
4.浏览器自动选择配置<br />
config/client.xml的driver是选择启动哪一个浏览器的配置，use为true表示选择他，false为不选择，多个为true以靠前的为准；chrome.mobile表示以手机界面启动（在百度登录时需要），如果不想以手机界面启动则置空。<br />
5.其他配置<br />
5.1 baidu配置：account中填账号密码，使用----分隔；<br />
5.2 weibo配置：account中填账号密码，使用----分隔；<br />
5.3 qq配置：account中填账号密码，使用----分隔；<br />
5.4 weibo_target配置：account中填用户名和超话，使用----分隔；<br />
5.5 toutiao_target配置：account表示头条的目标账号，无密码；<br />
5.6 baidu_flower配置：url中填写送花地址和送花个数，使用----分隔。<br />
6.启动<br />
6.1 百度(必须使用chrome而且带mobile的配置)：BaiduMain；BaiduSignUp.signUpRun()方法为签到；BaiduFlower.sendFlower()为送花；<br />
6.2 头条：ToutiaoMain；直接运行；<br />
6.3 微博：WeiboMain：WeiboSend.sendTweet()为发博。<br />

# 更新<br />
2018/07/26 更新 <br />
1.修复超话签到因滚动而失败的BUG，并添加刷新本页查看签到结果。<br />
2.集中控制停留时间，控制点击的快慢速度。<br />

2018/07/17 更新 <br />
1.修复今日头条使用QQ登录BUG。<br />
2.微博操作增加搜索用户，关注用户，搜索超话，关注超话，签到超话功能。<br />

2018/07/13 更新 <br />
1.从auto-ant(https://github.com/sekift/auto-ant )升级到自由蚂蚁专业版，使用Maven构建项目。<br />
2.使用phantomjsdriver-1.4.3，selenium退回到3.5.1版本（再升高将可能不兼容）。<br />
3.其他jar包连带升级。<br />
4.修改装配firefox浏览器方法。<br />
5.升级opera浏览器到54版本（54.0.2952.51），同时operadriver升级到2.37版本，修复打开opera的配置问题。<br />
6.今日头条已经取消微博授权，同时QQ授权也改版，择日修复。<br />

2018/04/26 更新 <br />
1.修复获取url参数bug。<br />

2018/04/17 更新 <br />
1.升级依赖的jar包。<br />

2018/04/12 更新 <br />
1.修复百度登录入口链接，以跳过登录检查。<br />

2018/04/08 更新 <br />
1.修复因百度改版而送花出错的bug。<br />

2018/04/04 更新 <br />
1.修改浏览器的选择、装配，移到了配置。<br />
2.优化窗口、获取元素操作。<br />

2018/03/19 更新 <br />
1.添加送花对象配置。<br />
2.百度送花，实现按需分配送给多位小偶像。 <br />

2018/03/16 更新 <br />
1.升级chrome到65.0.3325.162版本（最新版本）。<br />
2.升级chromedriver到2.36版本（最新版本）。<br />
3.添加百度送花功能。<br />
4.修复chrome模拟手机端bug。<br />
5.修复头条改版引起的登录bug。<br />
6.修复浏览器退出而driver仍然驻守的bug。<br />

2017/9/1 更新 <br />
1.更新selenium到3.5.3，jar包更新。<br />
2.添加opera浏览器，添加firefox加载配置启动，实现自动翻墙<br />
3.修复头条登录bug，分享bug。<br />

2017/3/1 初始版<br />
1.实现百度自动登录、自动签到功能。<br />
2.实现微博自动登录、自动发微博功能。<br />
3.实现头条号自动登录、自动搜索关注、自动收藏和点赞、自动转发到微博和QQ空间功能。<br />
4.实现自动收发短信功能。<br />

# 功能计划
 1.百度<br />
 [1期] 自动登录（实现） ，自动签到（实现），自动送花（实现）<br />
 [2期] 自动回复，自动发帖，自动注册<br />
 [3期] 自动游走，收集内容<br />
 2.微博<br />
 [1期] 自动登录（实现），自动发微博（实现）<br />
 [2期] 自动加好友（实现），自动注册<br />
 [3期] 自动游走，收集内容<br />
 3.头条号<br />
 [1期] 自动登录(包括微博、qq、手机)（实现），自动发头条（不打算实现）<br />
 [2期] 自动（搜索）关注、收藏、点赞等（实现），自动转发到微博（实现）、QQ空间（实现）、贴吧<br />
 [3期] 自动加好友，自动搜索排名<br />
 [4期] 自动游走，收集内容<br />
# 附属功能
 1.自动识别验证码（未能实现，可以接打码机）<br />
 2.自动收、发短信（已实现）<br />
 3.自动收、发邮件（发已实现，收已实现一半）<br />
# 要求
 1.切换浏览器User-Agent（没有实现）<br />
 2.切换代理IP（没有实现）<br />
# 技术
 1.Java 1.8.0<br />
 2.Selenium 3.5.1、WebDriver 2<br />
 3.phantomjsdriver 1.4.0 <br />
 4.eclipse:Neon.3 Release (4.6.3) <br />
# 展望
 1.添加其他网站<br />
 2.TimeSleep可以实现嵌入，非入侵代码<br />
 3.可以使用cucumber-jvm进行驱动开发<br />