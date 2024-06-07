package commandercortex.candy2.Utils.Components;

import commandercortex.candy2.Utils.PlayerMessages.Messages;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.checkerframework.checker.units.qual.C;


public class BaseTextComponent {
    public static TextComponent LinkBaseTextComponent(String message, String ClickEvent, String HoverEvent){
        TextComponent component = new net.md_5.bungee.api.chat.TextComponent(message);
        component.setClickEvent(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL, ClickEvent));
        component.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new Text(HoverEvent)));
        return component;
    }
}
