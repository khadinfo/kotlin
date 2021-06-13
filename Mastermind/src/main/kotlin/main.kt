                        import com.sun.org.apache.xpath.internal.operations.Bool

                        fun main(args: Array<String>) {
                            bienvenue()
                            val sizeList = readLine()!!.toInt()
                            val valRange: IntRange = 1..9
                            var tentative: Int = 1
                            var gagner: Boolean = false
                            if (sizeList < 3) {
                                println("Fin du jeu taille trop petite")
                            } else {
                                val listRandom: List<Int> = generateListRandom(sizeList, valRange)
                                while (tentative < 13 && !gagner) {
                                  afficheNbTentative(tentative)
                                  gagner=jouer(sizeList,listRandom)
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
                            println(listRandom)
                            return listRandom.toList()
                        }

                        fun afficherMessage(nbBienPlace:Int,nbMalPlace:Int,gagner:Boolean) {
                            if (gagner)
                                println("Bravo vous avez gagne ! ")
                            else
                                println("Il y a $nbBienPlace éléments bien placé et $nbMalPlace élément mal placé")
                        }
                        fun checkBienPlace(listRandom:List<Int>,saveIndex:MutableList<Int>,propositions:MutableList<Int>):Int{
                            var bienPlace:Int=0
                            for(p in 0 until listRandom.size) {
                                if (listRandom.get(p) == propositions.get(p)) {
                                    bienPlace++
                                    saveIndex.add(p)
                                }
                            }
                            return bienPlace
                        }
                        fun checkMalPlace(listRandom:List<Int>,saveIndex:MutableList<Int>,propositions:MutableList<Int>):Int {
                            var malPlace: Int = 0
                            for (p in 0 until listRandom.size) {
                                if (listRandom.contains(propositions.get(p))  && nbOccurence(listRandom,propositions.get(p),saveIndex)>0 ){
                                     //saveIndex.add(p)
                                    malPlace++
                                }

                            }
                            return malPlace
                        }
                        fun afficheNbTentative(tentative:Int){
                            println("Entrez votre premiere proposition en separant chaque chiffre par la touche enter")
                            println("\n*** tentative $tentative ***")
                        }

                        fun nbOccurence(listRandom:List<Int>,valeur:Int,saveIndex:MutableList<Int>):Int {
                            var cpt: Int = 0
                            if (listRandom.contains(valeur)) {
                                for (i in 0 until listRandom.size) {
                                    if (listRandom.get(i) == valeur && !saveIndex.contains(i)) {
                                        cpt++
                                        saveIndex.add(i)
                                    }
                                }
                            }
                            return cpt
                        }

                        fun aGagner(nbBienPlace:Int,sizeList:Int)=nbBienPlace == sizeList

                        fun jouer(sizeList:Int,listRandom:List<Int>):Boolean{
                            val saveIndex:MutableList<Int> = mutableListOf()
                            var proposition:Int
                            var nbBienplace:Int=0
                            var nbMalPlace:Int=0
                            val propositions:MutableList<Int> = mutableListOf()
                            var gagner:Boolean=false
                            for (i in 0 until sizeList) {
                                print(">")
                                proposition = readLine()!!.toInt()
                                propositions.add(proposition)

                            }
                            nbBienplace=checkBienPlace(listRandom,saveIndex,propositions)
                            nbMalPlace=checkMalPlace(listRandom,saveIndex,propositions)
                            saveIndex.clear()
                            gagner = aGagner(nbBienplace,sizeList)
                            afficherMessage(nbBienplace, nbMalPlace, gagner)
                            return gagner
                        }


