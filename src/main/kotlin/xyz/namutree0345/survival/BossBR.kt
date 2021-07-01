package xyz.namutree0345.survival

import net.kyori.adventure.bossbar.BossBar
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor

object BossBR {

    lateinit var bossBar: BossBar

    fun init() {
        bossBar = BossBar.bossBar(Component.text("", NamedTextColor.RED), 1.0F, BossBar.Color.GREEN, BossBar.Overlay.NOTCHED_10)
    }

}