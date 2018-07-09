/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author SOIN
 */
public class DocManagerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
    /*@Override
    public void onStartup(ServletContext container) throws ServletException {

            AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
            ctx.register(AppConfig.class);
            ctx.setServletContext(container);

            ServletRegistration.Dynamic servlet = container.addServlet(
                            "dispatcher", new DispatcherServlet(ctx));
            servlet.setLoadOnStartup(1);
            servlet.addMapping("/DocManager");
    }
    */
}
