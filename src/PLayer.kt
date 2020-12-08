class PLayer {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }
    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false

    private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }



    private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
        when (healthPoints) {
            100 -> " is in excellent condition!"
            in 90..99 -> " has a few scratches."
            in 75..89 -> if (isBlessed) {
                " has some minor wounds but is healing quite quickly!"
            } else {
                " has some minor wounds."
            }
            in 15..74 -> " looks pretty hurt."
            else -> " is in awful condition!"


        }







    fun castFireball(numFireballs: Int = 2) =

        println("A glass of Fireball Springs into existence. (x$numFireballs)")

}