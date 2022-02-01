//Noah Anderson
fun main() {
    //Initialize arrays and variables
    val itemsArray = arrayOf("Buns", "Beef", "Lettuce", "Cheese", "Tomato",
        "Onion", "Pickles", "Condiments")
    val qtyArray = arrayOf("1", "2", "3", "4", "5", "6", "7", "8")
    var item: String
    var qty: String
    var bothArray = arrayOf<Array<String>>()

    bothArray+=itemsArray
    bothArray+=qtyArray

    val rows = bothArray[0].size-1
    var userInput: String
    //initial printing of list so user can see what options there are
    for(i in 0..rows) {
        item = bothArray[0][i]
        qty = bothArray[1][i]
        println("Item: $item..... Quantity: $qty")

    }

    //loop that breaks upon user inputting "quit" or "0"
    while (true){
        println("Enter the name of the item you wish to modify, type \"list\" for a list of all items" +
                "and quantities or type \"quit\" or \"0\" to exit")
        userInput = readLine()!!.toString().lowercase()

        if (userInput == "quit" || userInput == "0") {
            break
        }


        //if statement that checks if the user input is in the list of items, regardless of capitalization
        if(bothArray[0].contains(userInput.replaceFirstChar{ it.uppercase()})) {
            val i = bothArray[0].indexOf(userInput.replaceFirstChar{ it.uppercase()})
            qty = bothArray[1][i]
            println("Item: $userInput..... Quantity: $qty")
            println("Enter the quantity of the item you would like to adjust (to add, put a positive integer, " +
                    "to remove, put a negative integer")

            //asks the user to change quantity of item, and checks if it is valid
            try{
                val userInputChangeQty = readLine()!!.toInt()
                var tempInt = bothArray[1][i].toInt()
                tempInt += userInputChangeQty
                //checks if input value would put item into a negative value, then sets it to 0
                if(tempInt < 0){
                    println("Not enough item to remove inputted amount, removing item until quantity is 0")
                    tempInt = 0
                }
                bothArray[1][i] = tempInt.toString()
            }
            catch(e: Exception){
                println("Error! Invalid value input! Please enter a positive or negative integer!")
                println("Default value set to 0")
            }
        }
        //prints out a list of available items if user requests it
        else if(userInput == "list"){
            for(i in 0..rows) {
                item = bothArray[0][i]
                qty = bothArray[1][i]
                println("Item: $item..... Quantity: $qty")
            }
        }
        //prints an error message if the item is not found, or if it is an invalid menu option
        else{
            println("Error! Item not found! Please check your spelling or look for a different item!\n")
        }

    }
}