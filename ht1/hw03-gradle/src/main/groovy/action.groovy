import java.time.LocalDateTime

class Action {
    // relates to 1 event
    Long num
    String name
    LocalDateTime startTime
    LocalDateTime endTime
    Long taskId

    def showEvent(LocalDateTime dt){
        if(dt==endTime){
            Event evt = new Event(message: "action ${name} finished", created: endTime)
            println(evt)
        }
    }
}
