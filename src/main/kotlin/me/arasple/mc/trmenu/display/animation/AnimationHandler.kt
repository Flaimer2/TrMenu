package me.arasple.mc.trmenu.display.animation

import org.bukkit.entity.Player
import java.util.*

/**
 * @author Arasple
 * @date 2020/5/30 14:15
 */
object AnimationHandler {

    private var id = 0L
    private val indexs = mutableMapOf<UUID, MutableMap<Long, Int>>()

    fun frame(player: Player, id: Long, size: Int): Int {
        if (size == 0) return -1

        val index = indexs.computeIfAbsent(player.uniqueId) { mutableMapOf() }
        if (index.computeIfAbsent(id) { 0 } >= size - 1) index[id] = 0
        else index[id] = index[id] ?: 0 + 1
        return index[id] ?: 0
    }

    fun getIndex(player: Player, id: Long) = indexs.computeIfAbsent(player.uniqueId) { mutableMapOf() }[id] ?: 0

    fun reset(player: Player) {
        indexs[player.uniqueId]?.clear()
    }

    fun nextId() = id++

}