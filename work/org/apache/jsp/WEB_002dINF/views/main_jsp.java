/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.45
 * Generated at: 2017-11-06 02:40:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>用户查询</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html, body {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tbackground-color: red;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tflex-direction: column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#headerPanel {\r\n");
      out.write("\tflex-basis: 60px;\r\n");
      out.write("\tflex-shrink: 0;\r\n");
      out.write("\tbackground-color: #2A3542;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\t/* border-bottom: 1px solid red; */\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#contentPanel {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tflex-direction: row;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/**\r\n");
      out.write("top.jsp\r\n");
      out.write("**/\r\n");
      out.write("#headerPanel .logo-panel{\r\n");
      out.write("\tflex-basis: 300px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#headerPanel .logo-panel h5{\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tfont-size: 24px;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tline-height: 60px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tleft: 50px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#headerPanel .menu-panel{\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tjustify-content: flex-end;\r\n");
      out.write("\talign-items: center;\r\n");
      out.write("\tmargin: 0 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(" #headerPanel .menu-panel .userinfo {\r\n");
      out.write("      \t\r\n");
      out.write("        padding: 6px 18px 6px 6px;\r\n");
      out.write("        background:url(../images/userinfoarrow.png) no-repeat right center;\r\n");
      out.write("       /*  border-radius: 2px; */\r\n");
      out.write("       /*  width:43%; \r\n");
      out.write("        position:absolute;\r\n");
      out.write("        right:0;\r\n");
      out.write("        top:10px;    */  \r\n");
      out.write("       /*  border-bottom: 1px solid #445775;  */\r\n");
      out.write("      /*   box-shadow: inset 1px 1px 2px #2b384e; */\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        border: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write(" #headerPanel .menu-panel .changetheme {\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        left: 10px;\r\n");
      out.write("        bottom: 10px;\r\n");
      out.write("        font-size: 11px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("  #headerPanel .menu-panel .changetheme a {\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("        margin-top: 5px;\r\n");
      out.write("        width: 15px;\r\n");
      out.write("        height: 15px;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write(" #headerPanel .menu-panel .changetheme a.default {\r\n");
      out.write("        background: #FB9337;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("  #headerPanel .menu-panel .changetheme a.blueline {\r\n");
      out.write("        background: #319cff;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .changetheme a.greenline {\r\n");
      out.write("        background: #78ce07;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .changetheme a.contrast {\r\n");
      out.write("        background: #ff4800;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .changetheme a.custombg {\r\n");
      out.write("        background: #666;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userinfo:hover {\r\n");
      out.write("        /* background-color: #2d3b53; */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel h4, #top-panel .menu-panel span {\r\n");
      out.write("\r\n");
      out.write("        background: transparent;\r\n");
      out.write("        border: 0;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("        vertical-align: baseline;\r\n");
      out.write("        font-weight: normal;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #headerPanel .menu-panel ul {\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userinfo img {\r\n");
      out.write("        border: 1px solid #b9c1ce;\r\n");
      out.write("        vertical-align: middle;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("  #headerPanel .menu-panel .userinfo span {\r\n");
      out.write("        color: #b9c2cf;\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("        padding: 0 5px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userinfodrop {\r\n");
      out.write("        padding: 10px;\r\n");
      out.write("        min-width: 300px;\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        top: 48px;\r\n");
      out.write("        right: 0;\r\n");
      out.write("        display: none;\r\n");
      out.write("        border-radius: 10px;\r\n");
      out.write("        background: #fff;\r\n");
      out.write("        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);\r\n");
      out.write("        z-index: 200;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userinfodrop .avatar {\r\n");
      out.write("        float: left;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userdata {\r\n");
      out.write("        margin-left: 105px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userdata h4 {\r\n");
      out.write("\r\n");
      out.write("        color: #2d3c54;\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userdata .phone-number {\r\n");
      out.write("        color: #999;\r\n");
      out.write("        font-size: 11px;\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userdata ul {\r\n");
      out.write("        list-style: none;\r\n");
      out.write("        margin-top: 10px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userdata ul li {\r\n");
      out.write("        display: block;\r\n");
      out.write("        margin-bottom: 1px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userdata ul li:last-child {\r\n");
      out.write("        margin-bottom: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userdata ul li a {\r\n");
      out.write("        display: block;\r\n");
      out.write("        padding: 5px;\r\n");
      out.write("        background: #f7f7f7;\r\n");
      out.write("        border-radius: 2px;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        color: black;\r\n");
      out.write("        font-size: 12px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   #headerPanel .menu-panel .userdata ul li a:hover {\r\n");
      out.write("        background: #fb9337;\r\n");
      out.write("        color: #fff;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("/**\r\n");
      out.write("内容区\r\n");
      out.write("**/    \r\n");
      out.write("#contentPanel .left-panel {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tmin-width: 150px;\r\n");
      out.write("\tmax-width: 150px;\r\n");
      out.write("\tbackground-color: #F0F0F0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#contentPanel .right-panel {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tbackground-color: #FFFFFF;\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tflex-direction: column;\r\n");
      out.write("}\r\n");
      out.write("/**\r\n");
      out.write("left.jsp，style代码\r\n");
      out.write("**/\r\n");
      out.write("#contentPanel .left-panel ul {\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#contentPanel .left-panel ul li {\r\n");
      out.write("\theight: 40px;\r\n");
      out.write("\tline-height: 40px;\r\n");
      out.write("\tpadding-left: 30px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tborder-bottom: 1px solid grey;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#contentPanel .left-panel ul li a {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: #000000;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#contentPanel .left-panel ul li:hover, #contentPanel .left-panel ul li.active\r\n");
      out.write("\t{\r\n");
      out.write("\tbackground-color: #CCCCCC;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("/**\r\n");
      out.write("list.jsp，CSS样式\r\n");
      out.write("**/\r\n");
      out.write("#contentPanel .right-panel .search,\r\n");
      out.write("#contentPanel .right-panel .header{\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tmin-height: 60px;\r\n");
      out.write("\tmax-height: 60px;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .user-list,\r\n");
      out.write("#contentPanel .right-panel .user-form{\r\n");
      out.write("flex-grow: 1;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .search .input-group{\r\n");
      out.write("\tmargin: 20px 0 20px 30px;\r\n");
      out.write("\twidth: calc(100%-20px);\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .search .input-group button{\r\n");
      out.write("\tmargin-left: 5px;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("\theight:25px;\r\n");
      out.write("\tbackground-color: #F0F0F0;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .tab,\r\n");
      out.write("#contentPanel .right-panel form{\r\n");
      out.write("\tmargin:15px;\r\n");
      out.write("\twidth: 98%;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .tab thead{\r\n");
      out.write("\tbackground-color: #F1F1F1;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .tab th,\r\n");
      out.write("#contentPanel .right-panel .tab td{\r\n");
      out.write("\tborder: 1px solid #E4E4E4;\r\n");
      out.write("}\r\n");
      out.write("/**\r\n");
      out.write("form.jsp，CSS样式\r\n");
      out.write("**/\r\n");
      out.write("#contentPanel .right-panel .header{\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .user-form .input-group{\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tline-height: 30px;\r\n");
      out.write("\tmargin-bottom: 5%;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .user-form .input-group .input{\r\n");
      out.write("\twidth: 90%;\r\n");
      out.write("\theight: 21px;\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\tpadding-left: 10px;\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .user-form .input-group .input-content{\r\n");
      out.write("\twidth: 70%;\r\n");
      out.write("\t/*对于外部其他元素是行内元素，对于内部是块级元素*/\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .user-form .button-group {\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tmin-height: 45px;\r\n");
      out.write("\tmax-height: 45px;\r\n");
      out.write("\tborder-top: 1px solid red;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#contentPanel .right-panel .user-form .button-group button {\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\tborder: 1px solid grey;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\twidth: 60px;\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .user-list .footer{\r\n");
      out.write("width:-moz-calc(100% - 8px);\r\n");
      out.write("\twidth:-webkit-calc(100% - 8px);\r\n");
      out.write("\twidth:calc(100%-8px);\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("\theight: 80px;\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write("/**\r\n");
      out.write("analyze.jsp（用户分析），CSS样式\r\n");
      out.write("**/\r\n");
      out.write("#contentPanel .right-panel .user-analyze{\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .user-analyze .gender-analyze{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tleft: 20px;\r\n");
      out.write("\ttop:20px;\r\n");
      out.write("}\r\n");
      out.write("#contentPanel .right-panel .user-analyze .date-analyze{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tright: 50px;\r\n");
      out.write("\ttop:20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"headerPanel\">\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"contentPanel\">\r\n");
      out.write("\t\t<div class=\"left-panel\"></div>\r\n");
      out.write("\t\t<div class=\"right-panel\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script src=\"");
      out.print(path);
      out.write("/plugins/jquery2.1.3.min.js\"\r\n");
      out.write("\t\ttype=\"text/javascript\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar $contentPanel = $(\"#contentPanel\");\r\n");
      out.write("\t\tvar $topPanel=$(\"#headerPanel\");\r\n");
      out.write("\t\tvar $leftPanel=$(\".left-panel\");\r\n");
      out.write("\t\tvar $rightPanel=$(\".right-panel\");\r\n");
      out.write("\t\t//加载头部列表\r\n");
      out.write("\t\t$topPanel.load(\"common/top.jsp\");\r\n");
      out.write("\t\t//加载列表\r\n");
      out.write("\t\t$leftPanel.load(\"common/left.jsp\",function(){\r\n");
      out.write("\t\t\tvar $parent = $(this);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//点击\r\n");
      out.write("\t\t\t$parent.find(\".left-item\").on(\"click\", function(e) {\r\n");
      out.write("\t\t\t\tvar $this = $(this);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t//高亮处理\r\n");
      out.write("\t\t\t\t$parent.find(\".left-item\").removeClass(\"active\");\r\n");
      out.write("\t\t\t\t$this.addClass(\"active\");\r\n");
      out.write("\t\t\t\t//使用SPA，在一个URL加载两个界面\r\n");
      out.write("\t\t\t\t//阻止a标签原有的默认事件\r\n");
      out.write("\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\t//得到a标签href属性的值\r\n");
      out.write("\t\t\t\tvar pageRef = $this.find(\"a\").prop(\"href\");\r\n");
      out.write("\t\t\t\t//JQuery load页面\r\n");
      out.write("\t\t\t\t$rightPanel.load(pageRef);\r\n");
      out.write("\t\t\t}).first().click();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
