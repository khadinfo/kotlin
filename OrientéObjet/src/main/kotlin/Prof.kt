import java.time.LocalDate


    class Professeur (var prenom:String, var nom:String, nomComplet:String, var age:Int, var dateNaiss: LocalDate, email:String) {

        var email: String = email
            set(value) {
                val regexEmail = Regex("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")

                if (!regexEmail.matches(value)) throw Throwable("Email incorrect")
                field = value
            }

        var nomComplet: String = nomComplet
            get() = "$nom $prenom"

        fun donnerCours(cours:String){
            println("je donne cours de $cours")
        }
        fun RecevoirMail(){
            println("email reçu")
        }
}