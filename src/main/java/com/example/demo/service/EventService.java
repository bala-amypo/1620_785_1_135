import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event updateEvent(Long id, Event event);

    Event getEventById(Long id);

    List<Event> getActiveEvents();

    void deactivateEvent(Long id);
}
