package data

sealed class PantallaSealed (val route: String) {
    object pantalla1 : PantallaSealed(route = "pantalla1_pantallaSealed")
    object pantalla2 : PantallaSealed(route = "pantalla2_pantallaSealed/{titulo}/{img}/{precio}")

    fun parametrosProductos (titulo: String, img:String, precio:String):String{
        return "pantalla2_pantallaSealed/$titulo/$img/$precio"
    }
}