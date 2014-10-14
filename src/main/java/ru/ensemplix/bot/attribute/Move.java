package ru.ensemplix.bot.attribute;


import org.spacehq.mc.protocol.packet.ingame.server.entity.ServerEntityPositionPacket;
import org.spacehq.mc.protocol.packet.ingame.server.entity.ServerEntityPositionRotationPacket;
import org.spacehq.mc.protocol.packet.ingame.server.entity.ServerEntityRotationPacket;
import org.spacehq.mc.protocol.packet.ingame.server.entity.player.ServerPlayerPositionRotationPacket;
import org.spacehq.packetlib.event.session.PacketReceivedEvent;
import org.spacehq.packetlib.event.session.SessionAdapter;
import org.spacehq.packetlib.packet.Packet;
import ru.ensemplix.bot.data.Location;

/**
 * Обработчик движений бота.
 */
public class Move extends SessionAdapter {

    /**
     * Расположение бота на карте.
     */
    private Location location = new Location();

    /**
     * Обработчик входящих пакетов.
     */
    public void packetReceived(PacketReceivedEvent event) {
        Packet packet = event.getPacket();

        if(packet instanceof ServerPlayerPositionRotationPacket) {
            ServerPlayerPositionRotationPacket move = event.getPacket();

            location.setX(move.getX());
            location.setX(move.getY());
            location.setX(move.getZ());

            location.setYaw(move.getYaw());
            location.setPitch(move.getPitch());
        } else if(packet instanceof ServerEntityPositionRotationPacket) {
            ServerEntityPositionRotationPacket move = event.getPacket();

            location.setX(move.getMovementX());
            location.setX(move.getMovementY());
            location.setX(move.getMovementZ());

            location.setYaw(move.getYaw());
            location.setPitch(move.getPitch());
        } else if(packet instanceof ServerEntityPositionPacket) {
            ServerEntityPositionPacket move = event.getPacket();

            location.setX(move.getMovementX());
            location.setX(move.getMovementY());
            location.setX(move.getMovementZ());
        } else if(packet instanceof ServerEntityRotationPacket) {
            ServerEntityRotationPacket move = event.getPacket();

            location.setYaw(move.getYaw());
            location.setPitch(move.getPitch());
        }
    }

    /**
     * Переместить игрока на указанные координаты.
     */
    public void move(int x, int y, int z) {
        throw new UnsupportedOperationException();
    }

}
