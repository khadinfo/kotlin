import java.time.LocalDate

fun main(args: Array<String>) {
    println("Hello World!")

    //creation etudiant

    val etudiant:Etudiant=Etudiant("khadija","srhir",31,LocalDate.of(90,6,2),"infokhad@gmail.com")
    val resume:String="""
        -${etudiant.nomComplet}
        -${etudiant.age}
        -${etudiant.dateNaiss}
        -${etudiant.matricule}
        
    """.trimMargin("-")
    println(resume)
}