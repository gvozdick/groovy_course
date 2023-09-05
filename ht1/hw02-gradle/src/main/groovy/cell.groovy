class Cell {
    String currency
    Integer value
    Integer quantity = 0
    def getCell () {
        return [currency,value,quantity]
    }
    def plus(Banknote){
        quantity=quantity+1
    }
    def minus(cnt){
        quantity=quantity-cnt
    }
}

