package main.control;

import javax.security.auth.callback.Callback;
import java.io.IOException;

public abstract class start implements Callback {
    public abstract void startService() throws IOException;
}
