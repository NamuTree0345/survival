package xyz.namutree0345.survival

import io.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin

fun getInstance() : JavaPlugin {
    return JavaPlugin.getPlugin(Survival::class.java)
}

class Survival : JavaPlugin() {

    override fun onEnable() {
        kommand {
        }
    }

}