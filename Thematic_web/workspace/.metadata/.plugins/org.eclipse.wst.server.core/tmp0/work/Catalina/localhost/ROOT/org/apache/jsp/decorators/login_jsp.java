/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2022-08-01 08:03:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.decorators;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(9);
    _jspx_dependants.put("jar:file:/E:/XI_2/Thematic_web/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/thematic-web/WEB-INF/lib/spring-webmvc-4.3.13.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1511752906000L));
    _jspx_dependants.put("/common/taglib.jsp", Long.valueOf(1652299611981L));
    _jspx_dependants.put("jar:file:/E:/XI_2/Thematic_web/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/thematic-web/WEB-INF/lib/spring-security-taglibs-3.2.8.RELEASE.jar!/META-INF/security.tld", Long.valueOf(1437576592000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-security-taglibs-3.2.8.RELEASE.jar", Long.valueOf(1659021209435L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1650487322108L));
    _jspx_dependants.put("jar:file:/E:/XI_2/Thematic_web/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/thematic-web/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.3.13.RELEASE.jar", Long.valueOf(1650487310187L));
    _jspx_dependants.put("jar:file:/E:/XI_2/Thematic_web/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/thematic-web/WEB-INF/lib/sitemesh-2.4.2.jar!/META-INF/sitemesh-decorator.tld", Long.valueOf(1123653092000L));
    _jspx_dependants.put("/WEB-INF/lib/sitemesh-2.4.2.jar", Long.valueOf(1648121670695L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdec_005ftitle_0026_005fdefault_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdec_005fbody_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fdec_005ftitle_0026_005fdefault_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdec_005fbody_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fdec_005ftitle_0026_005fdefault_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fdec_005fbody_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n");
      out.write("\r\n");
      out.write("<title>");
      if (_jspx_meth_dec_005ftitle_005f0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("<meta name=\"description\" content=\"User login page\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/template/login/assets/css/bootstrap.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/template/login/assets/font-awesome/4.2.0/css/font-awesome.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/template/login/assets/fonts/fonts.googleapis.com.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/template/login/assets/css/ace.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/template/login/assets/css/ace-rtl.min.css\" />\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"login-layout\" id=\"LoginForm\">\r\n");
      out.write("\t<div class=\"main-container\">\r\n");
      out.write("\t\t<div class=\"main-content\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-10 col-sm-offset-1\">\r\n");
      out.write("\t\t\t\t\t<div class=\"login-container\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-leaf green\"></i> <span class=\"red\">FOOTBALL</span> <span class=\"white\" id=\"id-text2\">For us</span>\r\n");
      out.write("\t\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t\t\t<h4 class=\"blue\" id=\"id-company-text\">&copy;Edu.hcmuaf-Information Technology</h4>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"space-6\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!--alert  -->\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"position-relative\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!--BODY  -->\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_dec_005fbody_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!--/BODY  -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.write(" \r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"navbar-fixed-top align-right\">\r\n");
      out.write("\t\t\t\t\t\t<br /> \r\n");
      out.write("\t\t\t\t\t\t&nbsp; \r\n");
      out.write("\t\t\t\t\t\t<a id=\"btn-login-dark\" href=\"#\">Dark</a> \r\n");
      out.write("\t\t\t\t\t\t&nbsp; \r\n");
      out.write("\t\t\t\t\t\t<span class=\"blue\">/</span>\r\n");
      out.write("\t\t\t\t\t\t &nbsp; \r\n");
      out.write("\t\t\t\t\t\t<a id=\"btn-login-blur\" href=\"#\">Blur</a>\r\n");
      out.write("\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<span class=\"blue\">/</span>\r\n");
      out.write("\t\t\t\t\t\t  &nbsp; \r\n");
      out.write("\t\t\t\t\t\t<a id=\"btn-login-light\" href=\"#\">Light</a> \r\n");
      out.write("\t\t\t\t\t\t&nbsp; &nbsp; &nbsp;\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.main-content -->\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\twindow.jQuery\r\n");
      out.write("\t\t\t\t|| document\r\n");
      out.write("\t\t\t\t\t\t.write(\"<script src='/template/login/assets/js/jquery.min.js'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<\"+\"/script>\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tif ('ontouchstart' in document.documentElement)\r\n");
      out.write("\t\t\tdocument\r\n");
      out.write("\t\t\t\t\t.write(\"<script src='/template/login/assets/js/jquery.mobile.custom.min.js'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<\"+\"/script>\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- inline scripts related to this page -->\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t/* \tjQuery(function($) {\r\n");
      out.write("\t\t\t$(document).on('click', '.toolbar a[data-target]', function(e) {\r\n");
      out.write("\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\tvar target = $(this).data('target');\r\n");
      out.write("\t\t\t\t$('.widget-box.visible').removeClass('visible');//hide others\r\n");
      out.write("\t\t\t\t$(target).addClass('visible');//show target\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}); */\r\n");
      out.write("\r\n");
      out.write("\t\t//you don't need this, just used for changing background\r\n");
      out.write("\t\tjQuery(function($) {\r\n");
      out.write("\t\t\t$('#btn-login-dark').on('click', function(e) {\r\n");
      out.write("\t\t\t\t$('body').attr('class', 'login-layout');\r\n");
      out.write("\t\t\t\t$('#id-text2').attr('class', 'white');\r\n");
      out.write("\t\t\t\t$('#id-company-text').attr('class', 'blue');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$('#btn-login-light').on('click', function(e) {\r\n");
      out.write("\t\t\t\t$('body').attr('class', 'login-layout light-login');\r\n");
      out.write("\t\t\t\t$('#id-text2').attr('class', 'grey');\r\n");
      out.write("\t\t\t\t$('#id-company-text').attr('class', 'blue');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$('#btn-login-blur').on('click', function(e) {\r\n");
      out.write("\t\t\t\t$('body').attr('class', 'login-layout blur-login');\r\n");
      out.write("\t\t\t\t$('#id-text2').attr('class', 'white');\r\n");
      out.write("\t\t\t\t$('#id-company-text').attr('class', 'light-blue');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_dec_005ftitle_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  dec:title
    com.opensymphony.module.sitemesh.taglib.decorator.TitleTag _jspx_th_dec_005ftitle_005f0 = (com.opensymphony.module.sitemesh.taglib.decorator.TitleTag) _005fjspx_005ftagPool_005fdec_005ftitle_0026_005fdefault_005fnobody.get(com.opensymphony.module.sitemesh.taglib.decorator.TitleTag.class);
    boolean _jspx_th_dec_005ftitle_005f0_reused = false;
    try {
      _jspx_th_dec_005ftitle_005f0.setPageContext(_jspx_page_context);
      _jspx_th_dec_005ftitle_005f0.setParent(null);
      // /decorators/login.jsp(9,7) name = default type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_dec_005ftitle_005f0.setDefault("Đăng nhập");
      int _jspx_eval_dec_005ftitle_005f0 = _jspx_th_dec_005ftitle_005f0.doStartTag();
      if (_jspx_th_dec_005ftitle_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fdec_005ftitle_0026_005fdefault_005fnobody.reuse(_jspx_th_dec_005ftitle_005f0);
      _jspx_th_dec_005ftitle_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_dec_005ftitle_005f0, _jsp_getInstanceManager(), _jspx_th_dec_005ftitle_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /decorators/login.jsp(38,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.incorrectAccount != null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"alert alert-danger\">Username or password\r\n");
          out.write("\t\t\t\t\t\t\t\tincorrect!</div>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /decorators/login.jsp(42,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.accessDenied != null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"alert alert-danger\">You not Authorize!</div>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /decorators/login.jsp(46,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty message}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"alert alert-");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${alert}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_dec_005fbody_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  dec:body
    com.opensymphony.module.sitemesh.taglib.decorator.BodyTag _jspx_th_dec_005fbody_005f0 = (com.opensymphony.module.sitemesh.taglib.decorator.BodyTag) _005fjspx_005ftagPool_005fdec_005fbody_005fnobody.get(com.opensymphony.module.sitemesh.taglib.decorator.BodyTag.class);
    boolean _jspx_th_dec_005fbody_005f0_reused = false;
    try {
      _jspx_th_dec_005fbody_005f0.setPageContext(_jspx_page_context);
      _jspx_th_dec_005fbody_005f0.setParent(null);
      int _jspx_eval_dec_005fbody_005f0 = _jspx_th_dec_005fbody_005f0.doStartTag();
      if (_jspx_th_dec_005fbody_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fdec_005fbody_005fnobody.reuse(_jspx_th_dec_005fbody_005f0);
      _jspx_th_dec_005fbody_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_dec_005fbody_005f0, _jsp_getInstanceManager(), _jspx_th_dec_005fbody_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /decorators/login.jsp(82,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/template/login/assets/js/jquery.2.1.1.min.js");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }
}