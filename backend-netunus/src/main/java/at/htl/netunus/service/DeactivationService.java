package at.htl.netunus.service;

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

    //Pausiert den Alarm für eine bestimmte, angegebene Zeit
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
