package at.htl.poolnotifier.service;

import javax.enterprise.context.ApplicationScoped;
import java.util.Timer;
import java.util.TimerTask;

@ApplicationScoped
public class DeactivationService {

    private boolean isDeactivated;

    public boolean isDeactivated() {
        return isDeactivated;
    }

    public void setDeactivated(boolean deactivated) {
        isDeactivated = deactivated;
    }

    public void deactivate(int seconds) {
        Timer timer = new Timer();
        isDeactivated = true;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isDeactivated = false;
            }
        }, seconds * 1000);
    }
}
