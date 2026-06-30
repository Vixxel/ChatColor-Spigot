package me.vixxel.chatcolor.commands;
import me.vixxel.chatcolor.gui.ChatColorGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatColorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof org.bukkit.entity.Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
    }

        if (args.length == 0) {
            player.sendMessage("Usage: /chatcolor gui");
            return true;
    }

        if (args[0].equalsIgnoreCase("gui")) {
            ChatColorGUI.open(player);
            return true;
    }

         player.sendMessage("Unknown subcommand.");
        return true;
    }
}
