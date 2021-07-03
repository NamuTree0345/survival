package xyz.namutree0345.survival

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit

object BorderRunnable : Runnable {

    var phase = 0
    var jeonjang = false
    var time = 300

    override fun run() {

        time--
        BossBR.bossBar.name(Component.text("${if(!jeonjang) "전장 축소로부터" else "전장 축소중"}: ${time}초", if(!jeonjang) NamedTextColor.GREEN else NamedTextColor.RED))
        for (onlinePlayer in Bukkit.getOnlinePlayers()) {
            onlinePlayer.hideBossBar(BossBR.bossBar)
            onlinePlayer.showBossBar(BossBR.bossBar)
        }

        if(time <= 0) {
            phase++
            when(phase) {
                0 -> {
                    jeonjang = false
                    time = 300
                    BossBR.bossBar.name(Component.text("전장 축소로부터: ${time}초", NamedTextColor.GREEN))
                }
                1 -> {
                    jeonjang = true
                    time = 10
                    Bukkit.getWorld("world")?.worldBorder?.setSize(200.0, 10)
                    BossBR.bossBar.name(Component.text("전장 축소중: ${time}초", NamedTextColor.RED))
                }
                2 -> {
                    jeonjang = false
                    time = 240
                    BossBR.bossBar.name(Component.text("전장 축소로부터: ${time}초", NamedTextColor.GREEN))
                }
                3 -> {
                    jeonjang = true
                    time = 10
                    Bukkit.getWorld("world")?.worldBorder?.setSize(150.0, 10)
                    BossBR.bossBar.name(Component.text("전장 축소중: ${time}초", NamedTextColor.RED))
                }
                4 -> {
                    jeonjang = false
                    time = 180
                    BossBR.bossBar.name(Component.text("전장 축소로부터: ${time}초", NamedTextColor.GREEN))
                }
                5 -> {
                    jeonjang = true
                    time = 10
                    Bukkit.getWorld("world")?.worldBorder?.setSize(50.0, 10)
                    BossBR.bossBar.name(Component.text("전장 축소중: ${time}초", NamedTextColor.GREEN))
                    Bukkit.getServer().sendMessage(Component.text("이제 모든 플레이어가 발광을 얻습니다! 버티기 ㄴㄴ!!", NamedTextColor.RED))
                    for (onlinePlayer in Bukkit.getOnlinePlayers()) {
                        onlinePlayer.isGlowing = true
                    }
                }
                6 -> {
                    jeonjang = false
                    time = 10
                    BossBR.bossBar.name(Component.text("전장 축소로부터: ${time}초", NamedTextColor.GREEN))
                }
                7 -> {
                    jeonjang = true
                    time = 10
                    Bukkit.getWorld("world")?.worldBorder?.setSize(16.0, 10)
                    BossBR.bossBar.name(Component.text("전장 축소중: ${time}초", NamedTextColor.GREEN))
                }
                else -> {
                    for (onlinePlayer in Bukkit.getOnlinePlayers()) {
                        onlinePlayer.isGlowing = false
                    }
                    BossBR.bossBar.name(Component.text("전장 축소로부터: ${time}초", NamedTextColor.GREEN))
                }
            }
        }

    }
}