package ru.ensemplix.bot.attribute;

import org.spacehq.mc.protocol.packet.ingame.server.entity.ServerDestroyEntitiesPacket;
import org.spacehq.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnPlayerPacket;
import org.spacehq.packetlib.event.session.PacketReceivedEvent;
import org.spacehq.packetlib.event.session.SessionAdapter;
import org.spacehq.packetlib.packet.Packet;
import ru.ensemplix.bot.entity.Entity;
import ru.ensemplix.bot.entity.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Обработчик существ которые находятся в зоне видимости бота.
 */
public class Watcher extends SessionAdapter {

    /**
     * Список существ которые находятся в зоне видимости бота.
     */
    private final Map<Integer, Entity> watching = new HashMap<>();

    /**
     * Обработчик входящих пакетов.
     */
    public void packetReceived(PacketReceivedEvent event) {
        Packet packet = event.getPacket();

        if(packet instanceof ServerSpawnPlayerPacket) {
            ServerSpawnPlayerPacket spawnPlayerPacket = (ServerSpawnPlayerPacket) packet;

            Player player = new Player(spawnPlayerPacket.getEntityId(),
                    spawnPlayerPacket.getUUID());

            player.setCurrentItem(spawnPlayerPacket.getCurrentItem());

            Location location = player.getLocation();
            location.setX(spawnPlayerPacket.getX());
            location.setY(spawnPlayerPacket.getY());
            location.setZ(spawnPlayerPacket.getZ());
            location.setYaw(spawnPlayerPacket.getYaw());
            location.setPitch(spawnPlayerPacket.getPitch());

            Collections.addAll(player.getMetadata(), spawnPlayerPacket.getMetadata());

            watching.put(player.getId(), player);
        } else if(packet instanceof ServerDestroyEntitiesPacket) {
            for(int destroyId : ((ServerDestroyEntitiesPacket) packet).getEntityIds()) {
                watching.remove(destroyId);
            }
        }
    }

    /**
     * Список существ которые находятся в зоне видимости бота.
     */
    public Map<Integer, Entity> getWatching() {
        return watching;
    }

}
