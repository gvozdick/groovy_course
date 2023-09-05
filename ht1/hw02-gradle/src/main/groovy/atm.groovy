class Atm {
    ArrayList <Cell> cells

    def plus(Banknote){
        for(cell in cells){
            if(cell.currency==Banknote.currency & cell.value==Banknote.value){
                cell+Banknote
            }
        }
    }
    def minus(String cur, Integer val, Integer cnt){
        for(cell in cells){
            if(cell.currency==cur & cell.value==val){
                cell-cnt
                }
            }
    }
    def calcBalance(){
        def balanceRub=0
        def balanceUsd = 0
        for(cell in cells){
            if(cell.currency=='RUB'){
                balanceRub+=cell.value*cell.quantity
            }
            if(cell.currency=='USD'){
                balanceUsd+=cell.value*cell.quantity
            }
        }
        return [balanceRub,balanceUsd]
    }
    def displayBalance(){
        def balance = calcBalance()
        println('RUB: '+ balance[0])
        println('USD: '+balance[1])
    }
    def calcCells(){
        ArrayList storage=[]
        for(cell in cells){
            storage.add(cell.getCell())
        }
        return storage
    }
    def giveSumRub(Integer sum){
        Integer banknotesOut=0
        def balanceRub = calcBalance()[0]
        def storage = calcCells().findAll{it[0]=='RUB'}.sort{it[1]}.reverse()
        //println storage
        if(balanceRub>=sum){
            for(val in storage){
                if(sum%val[1]==0 & val[1]*val[2]>=sum){
                    banknotesOut = sum/val[1]
                    minus(val[0],val[1],banknotesOut)
                    println("gived out ${sum} ${val[0]}")
                    break}
            }
        }
        else
        {println('не хватает банкнот в ATM')}
    }
    def giveSumUsd(Integer sum){
        Integer banknotesOut=0
        def balanceUsd = calcBalance()[1]
        def storage = calcCells().findAll{it[0]=='USD'}.sort{it[1]}.reverse()
        //println storage
        if(balanceUsd>=sum){
            for(val in storage){
                if(sum%val[1]==0 & val[1]*val[2]>=sum){
                    banknotesOut = sum/val[1]
                    minus(val[0],val[1],banknotesOut)
                    println("gived out ${sum} ${val[0]}")
                    break}
            }
        }
        else
        {println('не хватает банкнот в ATM')}
    }
}
