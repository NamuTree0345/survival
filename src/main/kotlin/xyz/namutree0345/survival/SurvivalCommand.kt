package xyz.namutree0345.survival

import io.github.monun.kommand.KommandDispatcherBuilder
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object SurvivalCommand {

    fun init(builder: KommandDispatcherBuilder) {
        builder.register("survival") {
            then("start") {
                require { sender -> sender is Player && sender.isOp }
                executes { ctx ->
                    jeonjangTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(getInstance(), BorderRunnable, 0, 20)
                    ctx.sender.sendMessage(Component.text("Started!", NamedTextColor.RED))
                }
            }
            then("stop") {
                require { sender -> sender is Player && sender.isOp }
                executes { ctx ->
                    Bukkit.getScheduler().cancelTask(jeonjangTaskId!!)
                    ctx.sender.sendMessage(Component.text("Force stopped!", NamedTextColor.RED))
                }
            }
        }

    }

}