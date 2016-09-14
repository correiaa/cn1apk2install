package com.astro_ware.cn1apk2install;


import com.codename1.io.Preferences;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose
 * of building native mobile applications using Java.
 */
public class Main {
    private Form current;
    private Resources theme;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }

    public void start() {

        if (current != null) {
            current.show();
            return;
        }
        current = (Preferences.get("email", "").equals("")) ? new LoginForm() : new HomeForm();
        current.show();
        if (!Preferences.get("email", "").equals(""))
            Display.getInstance().setPreferredBackgroundFetchInterval(10);

    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }

    public void destroy() {
    }

//    @Override
//    public void performBackgroundFetch(long deadline, Callback<Boolean> onComplete) {
//        if (!Preferences.get("email", "").equals("")) {
//            ConnectionRequest request = Requests.pollSync(Preferences.get("email", ""), Preferences.get("password", ""));
//            System.out.println(new String(request.getResponseData()));
//
//
//        }
//    }
}
