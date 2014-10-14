package ru.ensemplix.bot.attribute;

import org.spacehq.mc.protocol.data.game.Chunk;
import org.spacehq.mc.protocol.packet.ingame.server.world.ServerChunkDataPacket;
import org.spacehq.mc.protocol.packet.ingame.server.world.ServerMultiChunkDataPacket;
import org.spacehq.packetlib.event.session.PacketReceivedEvent;
import org.spacehq.packetlib.event.session.SessionAdapter;
import org.spacehq.packetlib.packet.Packet;
import ru.ensemplix.bot.data.ChunkPosition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Обработчик чанков бота.
 */
public class Chunks extends SessionAdapter {

    /**
     * Чанки которые находятся в памяти бота.
     */
    private Map<ChunkPosition, List<Chunk>> chunks = new HashMap<>();

    /**
     * Обработчик входящих пакетов.
     */
    public void packetReceived(PacketReceivedEvent event) {
        Packet packet = event.getPacket();

        if(packet instanceof ServerChunkDataPacket) {
            ServerChunkDataPacket chunkDataPacket = (ServerChunkDataPacket) packet;

            chunks.put(new ChunkPosition(chunkDataPacket.getX(), chunkDataPacket.getZ()),
                    Arrays.asList(chunkDataPacket.getChunks()));
        } else if(packet instanceof ServerMultiChunkDataPacket) {
            ServerMultiChunkDataPacket multiChunkDataPacket = (ServerMultiChunkDataPacket) packet;

            for(int i = 0; i < multiChunkDataPacket.getColumns(); i++) {
                chunks.put(new ChunkPosition(multiChunkDataPacket.getX(i), multiChunkDataPacket.getZ(i)),
                        Arrays.asList(multiChunkDataPacket.getChunks(i)));
            }
        }
    }

    /**
     * Получить чанк в указанных координатах.
     */
    public List<Chunk> getChunkAt(int x, int z) {
        return chunks.get(new ChunkPosition(x, z));
    }

    /**
     * Чанки которые находятся в памяти бота.
     */
    public Map<ChunkPosition, List<Chunk>> getChunks() {
        return chunks;
    }

}
