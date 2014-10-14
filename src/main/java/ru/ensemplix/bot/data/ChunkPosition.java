package ru.ensemplix.bot.data;

/**
 * Координаты на которых расположен чанк.
 */
public class ChunkPosition {

    /**
     * Координата чанка по оси X.
     */
    private int x;

    /**
     * Координата чанка по оси Z.
     */
    private int z;

    public ChunkPosition(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public int hashCode() {
        return 31 * x + z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass())  {
            return false;
        }

        ChunkPosition other = (ChunkPosition) obj;

        return x == other.x && z == other.z;
    }

}
