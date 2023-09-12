import java.time.LocalDateTime

class TaskManager {
//include all tasks
    List <Task> tasks =[]
    Long counter=0

    def createTask(String name, LocalDateTime start, LocalDateTime end, List actions){
        Task task = new Task(id:0,name:name,startTime:start,endTime:end,actions:actions)
        //сделал проверку на пересечение задач
        if(tasks.size()==0 || taskCreateCheck(task)){
            counter++
            task.id=counter
            tasks.add(task)
        }
        else {
            println(task.name+' : Время занято')
        }
    }

    def taskCreateCheck (Task task){
        Integer checkError = 0
        tasks.each {t->
            if((t.startTime<=task.startTime && task.startTime<=t.endTime)||(t.startTime<=task.endTime && task.endTime<=t.endTime)) {
                checkError++
            }
        }
        return checkError==0
    }

    def showTasks(){
        tasks.each {println("id ${it.id} : ${it.name}")}
    }

    def deleteTask(Long id){
        Integer ind
        tasks.eachWithIndex {it, index ->
            if(it.id==id){
                ind=index
                println("Удалена задача ${id} : ${it.name}")
            }
        }
        if(ind){tasks.remove(ind)}
        else {println("id=${id} Нет такой задачи для удаления")}
    }

    def showCntDayTasks(LocalDateTime date){
        String dt = String.format('%tF', date)
        def cnt = tasks.collect{
            ['date' : String.format('%tF', it.startTime)].groupBy {dt}.collect {it==dt}.size()
        }
        println("на дату ${String.format('%tF', date)} запланировано ${cnt[0]} дел")
    }

    def showDayTasks(LocalDateTime date){
        List result=[]
        tasks.each {
            if(date>=it.startTime && date<=it.endTime){result+=it.name}
        }
        println("на дату ${String.format('%tF', date)} запланированы ${result.join(',')} дела")
    }

    def showBusyTime(LocalDateTime date){
        List start=[]
        List end=[]
        List bookedList=[]
        tasks.each {
            if(date>=it.startTime && date<=it.endTime){
                start+=(it.startTime.getHour() + ":" + it.startTime.getMinute())
                end+=(it.endTime.getHour() + ":" + it.endTime.getMinute()) }
        }
        for(i in 0..start.size()-1){
            String booked = start[i] + ' - ' + end[i]
            bookedList+=booked
        }
        println("на дату ${String.format('%tF', date)} забукированы интервалы ${bookedList.join(',')}")
    }

}

