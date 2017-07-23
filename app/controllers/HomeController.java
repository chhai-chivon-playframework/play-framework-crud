package controllers;

import com.google.inject.Inject;
import entities.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    @Inject
    private FormFactory formFactory;

    public Result index(Long id) {
        List<User> users = User.finder.all();
        User user = User.finder.byId(id);
        if(user == null)
        {
            user = new User();
            user.id = 0L;
            user.email = "";
            user.password = "";
        }
        return ok(views.html.index.render(users, user));
    }

    public Result saveUpdateUser()
    {
        Form<User> userForm = formFactory.form(User.class);
        User user = userForm.bindFromRequest().get();
        if(user.id == 0L)
        {
            user.save();
        }
        else
        {
            user.update();
        }
        return  redirect("/");
    }
}
