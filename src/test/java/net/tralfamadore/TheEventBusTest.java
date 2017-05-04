package net.tralfamadore;

import com.google.common.eventbus.Subscribe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test TheEventBus.
 * Created by wreh on 5/4/2017.
 */
public class TheEventBusTest {
    private String eventName;

    @Subscribe
    public void catchEvent(Event event) {
        eventName = event.getEventName();
    }

    @Test
    public void testEventBus() throws Exception {
        TheEventBus theEventBus = TheEventBus.getInstance();
        theEventBus.register(this);
        theEventBus.post(new Event("Hello"));
        assertEquals("Hello", eventName);
        theEventBus.unregister(this);
        theEventBus.post(new Event("Hello Again"));
        assertEquals("Hello", eventName);
    }

    class Event {
        private String eventName;

        public Event(String eventName) {
            this.eventName = eventName;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }
    }
}
