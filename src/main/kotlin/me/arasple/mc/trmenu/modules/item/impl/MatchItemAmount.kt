package me.arasple.mc.trmenu.modules.item.impl

import io.izzel.taboolib.internal.apache.lang3.math.NumberUtils
import me.arasple.mc.trmenu.modules.item.base.MatchItemIdentifier
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

/**
 * @author Arasple
 * @date 2020/3/20 22:57
 */
class MatchItemAmount : MatchItemIdentifier("(amount|amt)(s)?") {

	override fun match(player: Player, itemStack: ItemStack): Boolean = itemStack.amount >= NumberUtils.toInt(getContent(player), 1)

}