    import java.time.LocalDate

    class Etudiant (var prenom:String, var nom:String,var age:Int, var dateNaiss:LocalDate,email:String,nomComplet:String?=null, matricule:String?=null) {

        var email: String = email
            set(value) {
                val regexEmail = Regex("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")

                if (!regexEmail.matches(value)) throw Throwable("Email incorrect")
                field = value
            }

        var nomComplet: String? = nomComplet
            get() = "$nom $prenom"


        var matricule: String? = matricule
            get() = "${nom[0]}${nom[1]}${prenom[0]}${prenom[1]}${dateNaiss.year}${dateNaiss.monthValue}${dateNaiss.dayOfMonth}"



        fun SuivreUnCours(cours:String){
          println("je suis le cours de $cours")
        }
        fun Etudier(cours:String){
            println("j'etudie le cours de $cours")

        }
        fun Guindailler(){
            println("je guindaille")
        }
         fun EnvoyerMail(prof:Professeur){
             println("envoyer email à ${prof.email}")
         }
    }