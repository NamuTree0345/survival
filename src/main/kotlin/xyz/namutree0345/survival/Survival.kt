package xyz.namutree0345.survival

import io.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

var jeonjangTaskId: Int? = null
val mapMoksum = hashMapOf<UUID, Int>()

fun getInstance() : JavaPlugin {
    return JavaPlugin.getPlugin(Survival::class.java)
}

class Survival : JavaPlugin() {

    override fun onEnable() {

        BossBR.init()
        server.pluginManager.registerEvents(EventHandler(), this)

        kommand {
            SurvivalCommand.init(this)
        }
    }

}