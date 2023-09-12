import java.time.LocalDateTime

class Task {
    // includes all actions
    Long id
    String name
    LocalDateTime startTime
    LocalDateTime endTime
    ArrayList <Action> actions
    Long counter=0

    def addAction(String name, LocalDateTime start, LocalDateTime end){
        Action action = new Action(num:0,name:name, startTime: start, endTime: end, taskId: id)
        if(action.startTime>startTime && action.endTime<endTime){
            if(actions.size()==0 || actionCreateCheck(action)){
                counter++
                action.num=counter
                actions.add(action)
            }
            else {
                println(action.name+' : Время занято')
            }
        }
        else println(action.name+' : Ошибка. Выходит за рамки задачи')

    }

    def actionCreateCheck (Action action){
        Integer checkError = 0
        actions.each {a->
            if((a.startTime<=action.startTime && action.startTime<=a.endTime)||(a.startTime<=action.endTime && action.endTime<=a.endTime)) {
                checkError++
            }
        }
        return checkError==0
    }

    def showActions(){
        actions.each {println("num ${it.num} : ${it.name}")}
    }

    def deleteAction(Long num){
        Integer ind=-1
        actions.eachWithIndex {it, index ->
            if(it.num==id){
                ind=index
                println("Удалено действие ${num} : ${it.name}")
                actions.remove(ind)
            }
        }
        if(ind==-1){println("id=${num} Нет такого действия для удаления")}
    }
}
