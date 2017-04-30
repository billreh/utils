package net.tralfamadore;

import com.google.common.eventbus.EventBus;

/**
 * Class: TheEventBus
 * Created by billreh on 4/28/17.
 */
@SuppressWarnings("unused")
public class TheEventBus {
    private EventBus eventBus;

    private static class TheEventBusHelper {
        private static final TheEventBus INSTANCE = new TheEventBus();
    }

    private TheEventBus() {
        eventBus = new EventBus();
    }

    public void register(Object object) {
        eventBus.register(object);
    }

    public static TheEventBus getInstance() {
        return TheEventBusHelper.INSTANCE;
    }

    public void unregister(Object object) {
        eventBus.unregister(object);
    }

    public void post(Object event) {
        eventBus.post(event);
    }
}
