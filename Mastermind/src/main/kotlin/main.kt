        import com.sun.org.apache.xpath.internal.operations.Bool

        fun main(args: Array<String>) {
            bienvenue()
            val sizeList = readLine()!!.toInt()
            val valRange: IntRange = 1..9
            var proposition: Int
            var nbMalPlace: Int = 0
            var nbBienplace: Int = 0
            var tentative: Int = 1
            var gagner: Boolean = false
            if (sizeList < 3) {
                println("Fin du jeu taille trop petite")
            } else {
                val listRandom: List<Int> = generateListRandom(sizeList, valRange)
                while (tentative < 13 && !gagner) {
                    println("Entrez votre premiere proposition en separant chaque chiffre par la touche enter")
                    println("\n*** tentative $tentative ***")
                    for (i in 1..sizeList) {
                        print(">")
                        proposition = readLine()!!.toInt()
                        if (listRandom.contains(proposition) && listRandom.indexOf(proposition) != i)
                            nbMalPlace++
                        else if (listRandom.contains(proposition) && listRandom.indexOf(proposition) == i)
                            nbBienplace++

                    }
                    if (nbBienplace == sizeList)
                        gagner = true
                    afficherMessage(nbBienplace, nbMalPlace, gagner)
                    nbBienplace = 0
                    nbMalPlace = 0
                    tentative++


                }
                if (!gagner)
                    println("Perdu Fin du jeu nombre de tentative échoué")
            }
        }

        fun bienvenue(){
            println("MasterMind!")
            print("Entrez la taille de la combinaison souhaité entre 3 et 9\n ->")
        }
        fun generateListRandom(sizeList:Int,valRange:IntRange):List<Int>{
            val listRandom:MutableList<Int> = mutableListOf()
            for(i in 1..sizeList)
                listRandom.add(valRange.random())
            return listRandom.toList()
        }

        fun afficherMessage(nbBienPlace:Int,nbMalPlace:Int,gagner:Boolean) {
            if (gagner)
                println("Bravo vous avez gagne ! ")
            else
                println("Il y a $nbBienPlace éléments bien placé et $nbMalPlace élément mal placé")
        }