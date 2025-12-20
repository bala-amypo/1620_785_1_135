public interface SubscriptionService {

    Subscription subscribe(Long userId, Long eventId);

    void unsubscribe(Long userId, Long eventId);
}