package xyz.namutree0345.survival

import io.github.monun.tap.fake.invisible
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.block.Chest
import org.bukkit.block.data.BlockData
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack

class EventHandler : Listener {

    @EventHandler
    fun join(event: PlayerJoinEvent) {
        event.player.showBossBar(BossBR.bossBar)
        if(!mapMoksum.contains(event.player.uniqueId)) {
            mapMoksum[event.player.uniqueId] = 2
        }
    }

    @EventHandler
    fun die(event: PlayerDeathEvent) {
        //mapMoksum[event.entity.uniqueId] = mapMoksum[event.entity.uniqueId]!! - 1
        event.entity.sendMessage(Component.text("남은 목숨: " + mapMoksum[event.entity.uniqueId] + "번", NamedTextColor.RED))
        if(mapMoksum[event.entity.uniqueId] == 0) {
            event.entity.sendMessage(Component.text("남은 목숨이 없어 완전히 사망하였습니다.", NamedTextColor.RED))
            event.entity.gameMode = GameMode.SPECTATOR
        }
        val armorStand = event.entity.world.spawnEntity(event.entity.location.add(0.0, 1.5, 0.0), EntityType.ARMOR_STAND)
        armorStand.invisible = true
        armorStand.isInvulnerable = true
        armorStand.isCustomNameVisible = true
        armorStand.setGravity(false)
        armorStand.customName = "${ChatColor.GREEN}${ChatColor.BOLD}${event.entity.name}${ChatColor.RESET}${ChatColor.YELLOW}의 흔적"
        val block = event.entity.world.getBlockAt(event.entity.location.add(0.0, 1.0, 0.0))
        block.type = Material.CHEST
        val chestState = block.state as Chest
        val contents = event.entity.inventory.contents
        event.drops.removeAll { true }
        contents.forEach {
            if(it != null) {
                chestState.inventory.addItem(it)
            }
        }
        block.state.update()
    }

}