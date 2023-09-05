Cell cellRub500 = new Cell(currency: 'RUB', value: 500)
Cell cellRub1000 = new Cell(currency: 'RUB', value: 1000)
Cell cellUsd50 = new Cell(currency: 'USD', value: 50)
Cell cellUsd100 = new Cell(currency: 'USD', value: 100)

Banknote b1 = new Banknote(currency: 'RUB', value: 500)
Banknote b2 = new Banknote(currency: 'RUB', value: 1000)
Banknote b3 = new Banknote(currency: 'USD', value: 50)
Banknote b4 = new Banknote(currency: 'USD', value: 100)

// create ATM
Atm myAtm = new Atm(cells: [cellRub500,cellRub1000,cellUsd50,cellUsd100])

// add banknotes to Atm
myAtm+b1 //+500 RUB
myAtm+b2 //+1000 RUB
myAtm+b2 //+1000 RUB
myAtm+b2 //+1000 RUB
myAtm+b3 //+50 USD
myAtm+b4 //+100 USD
myAtm+b4 //+100 USD

// show ATM balance and storage
myAtm.displayBalance()
println(myAtm.calcCells())

// ATM gives money
print(myAtm.giveSumRub(500))
print(myAtm.giveSumUsd(200))

//check balance after giveOut
myAtm.displayBalance()
println(myAtm.calcCells())
