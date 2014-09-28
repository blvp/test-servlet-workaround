import freemarker.cache.FileTemplateLoader;
import freemarker.ext.servlet.AllHttpScopesHashModel;
import freemarker.ext.servlet.FreemarkerServlet;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2/27/14.
 */
@Deprecated
public class RootServlet extends FreemarkerServlet {


    @Override
    public void init() throws ServletException {
        super.init();
        Configuration configuration = super.getConfiguration();
        File templateDirectory = null;
        try {
            templateDirectory = new File("C:\\Users\\admin\\javaproj\\ideaproj\\blvp\\test-servlet\\pages\\");
            configuration.setTemplateLoader(new FileTemplateLoader(templateDirectory));
        } catch (IOException e) {
        }
    }

    @Override
    protected String requestUrlToTemplatePath(HttpServletRequest request) {
        String uri = request.getRequestURI();
        if("/city".equals(uri)){
            return "/city.ftl";
        }
        return "/main.ftl";
    }

    @Override
    protected TemplateModel createModel(ObjectWrapper wrapper, ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) throws TemplateModelException {
        AllHttpScopesHashModel model = (AllHttpScopesHashModel) super.createModel(wrapper, servletContext, request, response);
        model.putUnlistedModel(FreemarkerServlet.KEY_INCLUDE, new StaticIncludePage(request, response));
        return model;
    }
}
